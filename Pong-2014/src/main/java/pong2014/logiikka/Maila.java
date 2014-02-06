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
        this.korkeus = 60;
        this.leveys = 20;
    }
    
    public void liikuAlas() {
        if (this.paikka < 340) {
            this.paikka++;
        }
    }
    
    public void liikuYlos() {
        if (this.paikka > 50) {
            this.paikka--;
        }
    }
    
    public int getPaikka() {
        return this.paikka;
    }
    
    public int getLeveys() {
        return this.leveys;
    }
    
    public int getKorkeus() {
        return this.korkeus;
    }
}
