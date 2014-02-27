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
    
    /**
     * Konstruktori luo uuden Kentan ja Pallon, sekä asettaa kentän korkeuden ja leveyden peliä varten.
     */
    public Kentta() {
        this.pallo = new Pallo();
        this.korkeus = 350;
        this.leveys = 600;
    }
    /**
     * Getterit ja setterit 
     */
    public Pallo getPallo() {
        return this.pallo;
    }
    
    public int getLeveys() {
        return this.leveys;
    }
    
    public int getKorkeus() {
        return this.korkeus;
    }
    
    /**
     * 
     * @return palauttaa tiedon kenelle edellisestä pallosta annetaan piste. Piste määritellään
     * pallon sijainnin perusteella. arvolla 1 piste menee vastustajalle ja arvolla 2 psite menee pelaajalle.
     */
    public int kenellePiste() {
        int kummalle = 0;
        if (this.pallo.getX() < 40) {
            kummalle = 1;
        } else if (this.pallo.getX() > 740){
            kummalle = 2;
        } else {
            kummalle = 0;
        }
        return kummalle;
    }
}