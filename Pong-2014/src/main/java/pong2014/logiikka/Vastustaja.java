package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
public class Vastustaja {
    
    private Maila maila;
    private int pisteet;
    
    public Vastustaja(int paikka) {
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
    
    public void liikutaMailaa() {
        int suuntain = 1;
        while (true) {
            if (suuntain == 1) {
                for (int i = 0; i < 24; i++) {
                    this.maila.liikuYlos();
                }
                suuntain = 0;
            } else if (suuntain == 0) {
                for (int i = 0; i < 24; i++) {
                    this.maila.liikuAlas();
                }
                suuntain = 1;
            }
        }
    }

    public void lyo(Pallo pallo) {
        int korkeus = pallo.getY();
        int mailanSijainti = this.maila.getPaikka();
        if (korkeus >= mailanSijainti && korkeus <= mailanSijainti + 6) {
            pallo.kimpoaMailasta(0);
        } else {
            pallo.setPaikka(61);
        }
    }
    
    public Maila getMaila() {
        return this.maila;
    }
    
}
