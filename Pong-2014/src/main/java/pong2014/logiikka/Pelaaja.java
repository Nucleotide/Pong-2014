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
     * @param paikka määrittää minne kohtaan pelaajan luonnin yhtedessä hänen maila asetetaan. Pelaajan
     * pisteet ovat aluksi luonnollisesti nolla.
     */
    public Pelaaja(int paikka) {
        this.maila = new Maila(paikka);
        this.pisteet = 0;
    }
    
    /**
     * 
     * Setterit ja getterit
     */
    
    public Maila getMaila() {
        return this.maila;
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
        this.maila.liikuYlos(10);
    }
    
    /**
     * Liikutetaan pelaajan mailaa alaspäin pelilaudalla.
     */
    public void liikutaMailaaAlas() {
        this.maila.liikuAlas(10);
    }
    /**
     * 
     * @param pallo
     * Metodille annetaan parametrina pelin pallo, jota pelaaja yrittää lyödä. Mikäli pelaajan maila on pallon edessä
     * lyönti onnistuu ja pallo kimpoaa takaisin pelilaudalle. Metodissa huomioidaan myös tilanne joissa grafiikan
     * piirtotavasta johtuen maila osuu palloon vaikka pallo olisikin koordinattien perusteella mailan yläpuolella
     * pallon korkeuden verran.
     */
    public void lyo(Pallo pallo) {
        int korkeus = pallo.getY();
        int mailanSijainti = this.maila.getPaikka();
        if (korkeus >= mailanSijainti && korkeus <= mailanSijainti + 60) {
            pallo.kimpoaMailasta(1);
        } else if (korkeus + 19 >= mailanSijainti && korkeus <= mailanSijainti + 60 ) { 
            pallo.kimpoaMailasta(11);
        }else {
            pallo.liiku();
        }
    }
}