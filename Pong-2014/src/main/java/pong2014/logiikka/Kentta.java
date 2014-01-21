package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
class Kentta {
    
    private Pelaaja pelaaja;
    private Pelaaja vastustaja;
    private Pallo pallo;
    private double korkeus;
    private double leveys;
    
    public Kentta() {
        this.pelaaja = new Pelaaja(274.0);
        this.vastustaja = new Pelaaja(1.0);
        this.pallo = new Pallo();
        this.korkeus = 153.0;
        this.leveys = 275.0;
    }
    
}
