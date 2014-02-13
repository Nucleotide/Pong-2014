package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 * Pelaaja on käyttäjän ilmentymä pelilaudalla. Pelaajalla on oma maila, jota hän liikuttaa pallon eteen.
 */
public class Pelaaja {
    
    private Maila maila;
    private int pisteet;
    
    /**
     * 
     * @param paikka määrittää minne kohtaan pelaajan luonnin yhtedessä hänen maila asetetaan.
     */
    public Pelaaja(int paikka) {
        this.maila = new Maila(paikka);
        this.pisteet = 0;
    }
    
    public int kerroPisteet() {
        return this.pisteet;
    }
    
    /**
     * Metodi lisää pelaajalle pisteen mikäle pisteet ovat alle kymmenen.
     */
    public void lisaaPiste() {
        if (this.pisteet < 10) {
            this.pisteet++;
        }    
    }
    
    /**
     * Liikutetaan pelaajan mailaa ylöspäin pelilaudalla.
     */
    public void liikutaMailaaYlos() {
        this.maila.liikuYlos();
        this.maila.liikuYlos();
        this.maila.liikuYlos();
        this.maila.liikuYlos();
        this.maila.liikuYlos();
    }
    
    /**
     * Liikutetaan pelaajan mailaa alaspäin pelilaudalla.
     */
    public void liikutaMailaaAlas() {
        this.maila.liikuAlas();
        this.maila.liikuAlas();
        this.maila.liikuAlas();
        this.maila.liikuAlas();
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
