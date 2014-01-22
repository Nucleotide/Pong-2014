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
        this.pelaaja = new Pelaaja(273.0);
        this.vastustaja = new Pelaaja(2.0);
        this.pallo = new Pallo();
        this.korkeus = 153.0;
        this.leveys = 275.0;
    }
    
    public void pelaaOttelu() {
        while (this.pelaaja.kerroPisteet() < 10 && this.vastustaja.kerroPisteet() < 10) {
            this.pelaaPallo();
        }
    }
    
    private void pelaaPallo() {
        while (this.pallo.getX() > 0.0 && this.pallo.getX() < 275.0) {
            this.pallo.liiku();
        }
        this.pallo.uusiPallo();
        this.pallo.setSuunta(0.0);
    }
    
}
