package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
class Pelaaja {
    
    private Maila maila;
    private int pisteet;
    
    public Pelaaja(double paikka) {
        this.maila = new Maila(paikka);
        this.pisteet = 0;
    }
    
    public int kerroPisteet() {
        return this.pisteet;
    }
    
    public void lisaaPiste() {
        this.pisteet++;
    }
}
