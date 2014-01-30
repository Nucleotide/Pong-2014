package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
class Kentta {
    
    private Pallo pallo;
    private double korkeus;
    private double leveys;
    
    public Kentta() {
        this.pallo = new Pallo();
        this.korkeus = 30.0;
        this.leveys = 60.0;
    }
    
    public Pallo getPallo() {
        return this.pallo;
    }

    public double kenellePiste() {
        double kummalle = 0.0;
        if (this.pallo.getX() < 2.0) {
            kummalle = 1.0;
        } else if (this.pallo.getX() > 58.0){
            kummalle = 2.0;
        }
        return kummalle;
    }
    
}
