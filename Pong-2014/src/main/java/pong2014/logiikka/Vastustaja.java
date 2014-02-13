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
     * 
     * @return kertoo vastustajan pistemäärän.
     */
    public int kerroPisteet() {
        return this.pisteet;
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
    public void liikutaMailaa() {
        if (suuntain == 1 && this.maila.getPaikka() > 50 ) {
            this.maila.liikuYlos();
        } else if (this.maila.getPaikka() <= 50) {
            suuntain = 0;
            this.maila.liikuAlas();
        } else if (suuntain == 0 && this.maila.getPaikka() < 340) {
            this.maila.liikuAlas();
        } else if (this.maila.getPaikka() >= 340) {
            suuntain = 1;
            this.maila.liikuYlos();      
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
            pallo.kimpoaMailasta(0);
        } else {
            pallo.setPaikka(750);
        }
    }
    
    public Maila getMaila() {
        return this.maila;
    }
    
}
