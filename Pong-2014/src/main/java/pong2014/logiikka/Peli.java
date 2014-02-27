package pong2014.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import pong2014.ui.Paivitettava;

/**
 *
 * @author joonaslaakkonen
 * Peli on ohjelman runko. Metodien avulla ohjelman suoritus etenee ja pelin pelaaminen tapahtuu käyttöliittymässä.
 * Peli luo suorasti / epäsuorasti kaikki muut ohjelman logiikan oliot.
 */
public class Peli extends Timer implements ActionListener {
    
    private Kentta kentta;
    private Pelaaja pelaaja;
    private Vastustaja vastustaja;
    private Pallo pallo;
    private Paivitettava paivitettava;
    private boolean pause;
    
    /**
     * Konstruktori luo kentän, pelaajan ja vastustajan sekä asettaa aluksi pause -arvon falseksi.
     */
    public Peli() {
        super(40, null);
        this.kentta = new Kentta();
        this.vastustaja = new Vastustaja(195);
        this.pelaaja = new Pelaaja(195);
        this.pause = false;
        
        addActionListener(this);
        setInitialDelay(1000);
        this.pallo = this.kentta.getPallo();
    }
    
    /**
     * 
     * Setterit ja getterit 
     */
    
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
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
     * 
     * @param e Pelin runko joka pyörii ja tutkii pelin eri ehtoja ja suorittaa metodeja sen mukaisesti. Käyttäjän syöte
     * käsitellään Nappaimistonkuuntelijalla, joka tarvittaessa kutsuu pelin logiikkaa.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.pallo.liiku();
        this.vastustaja.liikutaMailaa(this.pallo);

        if (this.kimpoanko()) {
            this.pallo.kimpoaSeinasta();
        } else if(pallo.getLyonti() == 1) {
            this.pelaaja.lyo(this.pallo);
        } else if (pallo.getLyonti() == 2) {
            this.vastustaja.lyo(this.pallo);
        }

        this.pallo.setLyonti(0);

        this.uusiPallojaPiste();

        this.paivitettava.paivita();  
        
        if (this.voittaja()) {
            stop();
        }
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
     * 
     * @return palauttaa arvon, jonka perusteella peli pausetetaan. Itse pausen asettaa Nappaimistonkuuntelija asettamalla
     * pelin Timerin stopille. Kun peliä jatketaan, esiintyy yhden sekunnin viive Timerin asetuksesta johtuen.
     */
    public boolean pause() {
        this.pause = !this.pause;
        return this.pause;
    }
    
    /**
     * Jos jompikumpi kilpalija saa pisteen, asetetaan pallon suunta asianmukaiseksi.
     */
    public void uusiPallojaPiste() {
        int piste = this.kentta.kenellePiste();
        if (piste == 1) {
            this.vastustaja.lisaaPiste();
            this.pallo.uusiPallo(piste);
        } else if (piste == 2) {
            this.pelaaja.lisaaPiste();
            this.pallo.uusiPallo(piste);
        }
    }
    
    /**
     * Metodi tutkii onko pallo sijannissa, jossa sen kuuluu kimmota ja vaihtaa liikkeen suuntaa.
     * @return kertoo kimmotaanko vai ei.
     */
    public boolean kimpoanko() {
        if (this.pallo.getY() == 50 && this.pallo.getX() > 100 && this.pallo.getX() < 680) {
            return true;
        } else if (this.pallo.getY() == 380 && this.pallo.getX() > 100 && this.pallo.getX() < 680) {
            return true;
        }
        return false;
    }       
}