package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
public class Maila {
    
    private double x;
    private double y;
    private double korkeus;
    private double leveys;

    public Maila(double paikka) {
        this.x = paikka;
        this.y = 77.0;
        this.korkeus = 30.0;
        this.leveys = 4.0;
    }
    
    public void liikuAlas() {
        if (this.y < 133.0) {
            this.y++;
        }
    }
    
    public void liikuYlos() {
        if (this.y > 0.0) {
            this.y--;
        }
    }
    
    public double getY() {
        return this.y;
    }
}
