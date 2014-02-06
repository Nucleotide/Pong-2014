package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 * Pelaaja on käyttäjän ilmentymä pelilaudalla. Pelaajalla on oma maila, jota hän liikuttaa pallon eteen.
 */
public class Pelaaja {
    
    private Maila maila;
    private int pisteet;
    
    public Pelaaja(int paikka) {
        this.maila = new Maila(paikka);
        this.pisteet = 0;
    }
    
    public int kerroPisteet() {
        return this.pisteet;
    }
    
    public void lisaaPiste() {
        if (this.pisteet < 10) {
            this.pisteet++;
        }    
    }
    
    public void liikutaMailaaYlos() {
        this.maila.liikuYlos();
    }
    
    public void liikutaMailaaAlas() {
        this.maila.liikuAlas();
    }
    /**
     * 
     * @param pallo
     * Metodille annetaan parametrina pelin pallo, jota pelaaja yrittää lyödä. Mikäli pelaajan maila on pallon edessä
     * lyönti onnistuu ja pallo kimpoaa takaisin pelilaudalle.
     */
    void lyo(Pallo pallo) {
        int korkeus = pallo.getY();
        int mailanSijainti = this.maila.getPaikka();
        if (korkeus >= mailanSijainti && korkeus <= mailanSijainti + 60) {
            pallo.kimpoaMailasta(1);
        } else {
            pallo.setPaikka(50);
        }
    }
    
    public Maila getMaila() {
        return this.maila;
    }
}
