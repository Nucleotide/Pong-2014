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
    
    /**
     * Konstruktori luo kentän, pelaajan ja vastustajan sekä asettaa aluksi pelataanko -arvon todeksi.
     */
    public Peli() {
        super(100, null);
        this.kentta = new Kentta();
        this.vastustaja = new Vastustaja(195);
        this.pelaaja = new Pelaaja(195);
        this.pelataanko = true;
        
        addActionListener(this);
        setInitialDelay(2000);
        this.pallo = this.kentta.getPallo();
    }
    
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }     
    
    /**
     * 
     * @return kertoo jatkuuko peli.
     */
    public boolean jatkuu() {
        return this.pelataanko;
    }      
    
    /**
     * 
     * @param e Pelin runko joka looppaa ja tutkii pelin eri ehtoja ja suorittaa metodeja sen mukaisesti. Parametrina
     * on käyttäjän syöte.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.jatkuu()) {
            return;
        }
        
        this.pallo.liiku();
        this.vastustaja.liikutaMailaa();
        this.vastustaja.liikutaMailaa();
        
        if (this.kimpoanko()) {
            this.pallo.kimpoaSeinasta();
        } else if(pallo.getX() == 120) {
            this.pelaaja.lyo(this.pallo);
        } else if (pallo.getX() == 660) {
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
    public boolean voittaja() {
        if (this.pelaaja.kerroPisteet() > 9 || this.vastustaja.kerroPisteet() > 9) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodi tutkii onko pallo sijannissa, jossa sen kuuluu kimmota ja vaihtaa liikkeen suuntaa.
     * @return kertoo kimmotaanko vai ei.
     */
    public boolean kimpoanko() {
        if (this.pallo.getY() == 50 && this.pallo.getX() != 120) {
            return true;
        } else if (this.pallo.getY() == 380 && this.pallo.getX() != 120) {
            return true;
        } else if (this.pallo.getY() == 50 && this.pallo.getX() != 660) {
            return true;
        } else if (this.pallo.getY() == 380 && this.pallo.getX() != 660) {
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
    
    public Pallo getPallo() {
        return this.pallo;
    }    
    
    /**
     * Jos jompikumpi kilpalija saa pisteen, asetetaan pallon suunta asianmukaiseksi.
     */
    private void uusiPallojaPiste() {
        int piste = this.kentta.kenellePiste();
        if (piste == 1) {
            this.vastustaja.lisaaPiste();
        } else if (piste == 2) {
            this.pelaaja.lisaaPiste();
        }
        
        this.pallo.uusiPallo(piste);
    }
}
