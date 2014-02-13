package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 * Maila on pelaajan ilmentymä pelilaudalla. Mailaa voi liikuttaa y-akselin suunnassa. Tavoite on liikuttaa maila
 * pallon eteen pelin aikana.
 */
public class Maila {
    
    private int paikka;
    private int korkeus;
    private int leveys;
    
    /**
     * Luodaan maila,
     * @param paikka kertoo minne kohtaan pelilautaa maila luodaan.
     */
    public Maila(int paikka) {
        this.paikka = paikka;
        this.korkeus = 60;
        this.leveys = 20;
    }
    /**
     * Mailan liikuttaminen ylöspäin. Mailaa ei voi liikuttaa pois pelilaudalta.
     */
    public void liikuAlas() {
        if (this.paikka < 340) {
            this.paikka++;
        }
    }
    /**
     * Mailan liikuttaminen alaspäin. Mailaa ei voi liikuttaa pois pelilaudalta.
     */
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


