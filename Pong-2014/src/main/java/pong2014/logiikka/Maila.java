package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
public class Maila {
    
    private double paikka;
    private double korkeus;
    private double leveys;

    public Maila(double paikka) {
        this.paikka = paikka;
        this.korkeus = 6.0;
        this.leveys = 2.0;
    }
    
    public void liikuAlas() {
        if (this.paikka < 24.0) {
            this.paikka++;
        }
    }
    
    public void liikuYlos() {
        if (this.paikka > 0.0) {
            this.paikka--;
        }
    }
    
    public double getPaikka() {
        return this.paikka;
    }
}
