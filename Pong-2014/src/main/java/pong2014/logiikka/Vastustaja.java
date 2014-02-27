package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 * Vastustaja on käyttäjän vastustajana pelilaudalla. Vastustajalla on oma maila, jolla yritetään lyödä
 * palloa.
 */
public class Vastustaja {
    
    private Maila maila;
    private int pisteet;
    private int suuntain;
    
    /**
     * 
     * @param paikka asettaa konstruktorissa vastustajan mailan aloituspaikan.
     */
    public Vastustaja(int paikka) {
        this.maila = new Maila(paikka);
        this.pisteet = 0;
        this.suuntain = 1;
    }
    
    /**
     * Getterit ja setterit
     */
    public int kerroPisteet() {
        return this.pisteet;
    }
    
    public Maila getMaila() {
        return this.maila;
    }
    
    /**
     * Lisätään piste vastustajalle jos niitä on alle kymmenen.
     */
    public void lisaaPiste() {
        if (this.pisteet < 10) {
            this.pisteet++;
        }    
    }
    /**
     * Metodi liikuttaa Vastustajan mailaa pelin ohjaamana. Suunta vaihtuu jos maila saavuttaa seinän.
     */
    public void liikutaMailaa(Pallo pallo) {
        if (pallo.getY() < this.maila.getPaikka()) {
            this.maila.liikuYlos();
        } else if (pallo.getY() + 50 > this.maila.getPaikka()) {
            this.maila.liikuAlas();
        }
    }
    
    /**
     * 
     * @param pallo Lyönti onnistuu jos vastustajan maila on pallon tiellä.
     */
    public void lyo(Pallo pallo) {
        int korkeus = pallo.getY();
        int mailanSijainti = this.maila.getPaikka();
        if (korkeus >= mailanSijainti && korkeus <= mailanSijainti + 60) {
            pallo.kimpoaMailasta(2);
        } else if (korkeus + 19 >= mailanSijainti && korkeus -19 <= mailanSijainti) {
            pallo.kimpoaMailasta(12);
        } else {
            pallo.liiku();
        }
    }
}