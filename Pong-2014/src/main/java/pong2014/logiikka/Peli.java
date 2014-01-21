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
        this.valikko();
    }

    private void valikko() {
        System.out.println("Esc lopettaa, Enter pelaa");
    }
    
}
