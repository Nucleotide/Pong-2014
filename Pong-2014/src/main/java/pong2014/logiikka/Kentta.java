package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 * Luokka Kentta ilmenee pelin pelilautana. Kentta luo pallon ja määrittää kuka saa pallon
 * päätteeksi pisteen.
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
    /**
     * 
     * @return palauttaa Kentan luoman pallon. 
     */
    public Pallo getPallo() {
        return this.pallo;
    }
    /**
     * 
     * @return palauttaa tiedon kenelle edellisestä pallosta annetaan piste
     */
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
