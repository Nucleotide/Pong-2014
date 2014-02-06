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
        this.korkeus = 350;
        this.leveys = 600;
    }
    
    public Pallo getPallo() {
        return this.pallo;
    }

    public int kenellePiste() {
        int kummalle = 0;
        if (this.pallo.getX() < 100) {
            kummalle = 1;
        } else if (this.pallo.getX() > 700){
            kummalle = 2;
        } else {
            kummalle = 0;
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
