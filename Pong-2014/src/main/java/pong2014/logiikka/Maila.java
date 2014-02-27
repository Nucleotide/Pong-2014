package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 * Maila on pelaajan ja vastustajan ilmentymä pelilaudalla. Mailaa voi liikuttaa y-akselin suunnassa. Tavoite on liikuttaa maila
 * pallon eteen pelin aikana.
 */
public class Maila {
    
    private int paikka;
    private int korkeus;
    private int leveys;
    
    /**
     * Luodaan maila,
     * @param paikka kertoo minne kohtaan pelilautaa maila luodaan. Mailalla on myös korkeus ja leveys.
     */
    public Maila(int paikka) {
        this.paikka = paikka;
        this.korkeus = 60;
        this.leveys = 20;
    }
    
    /**
     * Getterit ja setterit
     */
          
    public int getPaikka() {
        return this.paikka;
    }
    
    public int getLeveys() {
        return this.leveys;
    }
    
    public int getKorkeus() {
        return this.korkeus;
    }  
    
    public void setPaikka(int paikka) {
        this.paikka = paikka;
    }
    
    /**
     * Mailan liikuttaminen ylöspäin. Mailaa ei voi liikuttaa pois pelilaudalta. Parametrina annetaan nopeus
     * joka määrittää kuinka paljon maila liikkuu.
     */
    public void liikuAlas(int nopeus) {
        for (int i = 0; i < nopeus; i++) {
            if (this.paikka < 340) {
                this.paikka++;
            }
        }
    }
    /**
     * Mailan liikuttaminen alaspäin. Mailaa ei voi liikuttaa pois pelilaudalta. Parametrina annetaan nopeus
     * joka määrittää kuinka paljon maila liikkuu.
     */
    public void liikuYlos(int nopeus) {
        for (int i = 0; i < nopeus; i++) {
            if (this.paikka > 50) {
                this.paikka--;
            }
        }
    }
}