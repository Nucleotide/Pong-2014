package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
public class Kentta {
    
    private Pallo pallo;
    private int korkeus;
    private int leveys;
    
    public Kentta() {
        this.pallo = new Pallo();
        this.korkeus = 30;
        this.leveys = 60;
    }
    
    public Pallo getPallo() {
        return this.pallo;
    }

    public int kenellePiste() {
        int kummalle = 0;
        if (this.pallo.getX() < 2) {
            kummalle = 1;
        } else if (this.pallo.getX() > 58){
            kummalle = 2;
        }
        return kummalle;
    }
    public int getLeveys() {
        return this.leveys;
    }
    
    public int getKorkeus() {
        return this.korkeus;
    }
    
}
