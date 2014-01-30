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
    
    public void liikuEdestakaisin() {
        int suuntain = 1;
        while (true) {
            if (suuntain == 1) {
                for (int i = 0; i < 24; i++) {
                    this.liikuYlos();
                }
                suuntain = 0;
            } else if (suuntain == 0) {
                for (int i = 0; i < 24; i++) {
                    this.liikuAlas();
                }
                suuntain = 1;
            }
        }
    }
}
