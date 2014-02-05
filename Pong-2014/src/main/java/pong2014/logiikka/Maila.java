package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
public class Maila {
    
    private int paikka;
    private int korkeus;
    private int leveys;

    public Maila(int paikka) {
        this.paikka = paikka;
        this.korkeus = 6;
        this.leveys = 2;
    }
    
    public void liikuAlas() {
        if (this.paikka < 24) {
            this.paikka++;
        }
    }
    
    public void liikuYlos() {
        if (this.paikka > 0) {
            this.paikka--;
        }
    }
    
    public int getPaikka() {
        return this.paikka;
    }
}
