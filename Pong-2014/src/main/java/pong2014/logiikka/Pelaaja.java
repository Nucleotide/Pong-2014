package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
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
