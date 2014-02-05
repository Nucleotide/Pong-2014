package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
public class Pelaaja {
    
    private Maila maila;
    private int pisteet;
    
    public Pelaaja(double paikka) {
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

    void lyo(Pallo pallo) {
        double korkeus = pallo.getY();
        double mailanSijainti = this.maila.getPaikka();
        if (korkeus >= mailanSijainti && korkeus <= mailanSijainti + 6.0) {
            pallo.kimpoaMailasta(1);
        } else {
            pallo.setPaikka(-1.0);
        }
    }
    
    public Maila getMaila() {
        return this.maila;
    }
}
