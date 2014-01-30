package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
public class Vastustaja {
    
    private Maila maila;
    private int pisteet;
    
    public Vastustaja(double paikka) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
