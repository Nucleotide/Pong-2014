package pong2014.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import pong2014.ui.Paivitettava;

/**
 *
 * @author joonaslaakkonen
 * Peli on ohjelman runko. Metodien avulla ohjelman suoritus etenee ja pelin pelaaminen tapahtuu käyttöliittymässä.
 */
public class Peli extends Timer implements ActionListener {
    
    private Kentta kentta;
    private Pelaaja pelaaja;
    private Vastustaja vastustaja;
    private boolean pelataanko;
    private Pallo pallo;
    private Paivitettava paivitettava;
    
    public Peli() {
        super(150, null);
        this.kentta = new Kentta();
        this.vastustaja = new Vastustaja(195);
        this.pelaaja = new Pelaaja(195);
        this.pelataanko = true;
        
        addActionListener(this);
        setInitialDelay(2000);
    }
    
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }     
    
    public boolean jatkuu() {
        return this.pelataanko;
    }      

    @Override
    public void actionPerformed(ActionEvent e) {
        this.pallo = this.kentta.getPallo();
        if (!this.jatkuu()) {
            return;
        }
        
        this.pallo.liiku();
        this.vastustaja.liikutaMailaa();
        
        if (this.kimpoanko()) {
            this.pallo.kimpoaSeinasta();
        } else if(pallo.getX() == 120) {
            this.pelaaja.lyo(this.pallo);
        } else if (pallo.getX() == 680) {
            this.vastustaja.lyo(this.pallo);
        }
        
        if (this.voittaja()) {
            this.pelataanko = false;
        }
        
        if (this.kentta.kenellePiste() != 0) {
            uusiPallojaPiste();
        }

        this.paivitettava.paivita();   
    }
    /**
     * 
     * @return
     * Metodi kertoo onko pelissä voittajaa, eli onko jompikumpi pelaajista saanut 10 pistettä.
     */
    private boolean voittaja() {
        if (this.pelaaja.kerroPisteet() > 9 || this.vastustaja.kerroPisteet() > 9) {
            return true;
        }
        return false;
    }

    private boolean kimpoanko() {
        if (this.pallo.getY() == 50 && this.pallo.getX() != 120) {
            return true;
        } else if (this.pallo.getY() == 400 && this.pallo.getX() != 120) {
            return true;
        } else if (this.pallo.getY() == 50 && this.pallo.getX() != 680) {
            return true;
        } else if (this.pallo.getY() == 400 && this.pallo.getX() != 680) {
            return true;
        }
        return false;
    }    

    public void tauko() {
        
    }
    
    public Kentta getKentta() {
        return this.kentta;
    }
    
    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }
    
    public Vastustaja getVastustaja() {
        return this.vastustaja;
    }      

    private void uusiPallojaPiste() {
        int piste = this.kentta.kenellePiste();
        if (piste == 1) {
            this.vastustaja.lisaaPiste();
        } else if (piste == 2) {
            this.vastustaja.lisaaPiste();
        }
        
        this.pallo.uusiPallo(piste);
    }
}
