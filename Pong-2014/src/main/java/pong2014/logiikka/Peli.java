package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
class Peli {
    
    private Kentta kentta;
    
    public Peli() {
        this.kentta = new Kentta();
    }
    
    public void aloita() {
        this.kentta.pelaa();
    }
    
    public void valikko() {
        System.out.println("Piirretään alkuvalikko\nEnter pelaa ja Esc lopettaa");
    }
    
    public boolean pelataanko() {
        return true;
    }
    
}
