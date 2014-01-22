package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
class Peli {
    
    private Kentta kentta;
    private boolean pelataanko;
    
    public Peli() {
        this.kentta = new Kentta();
        this.pelataanko = true;
    }
    
    public void aloita() {
        this.pelataankoPeli();
        
        while (this.pelataanko) {
            this.kentta.pelaaOttelu();
            this.pelataankoPeli();
        }
    }
    
    private void valikko() {
        System.out.println("Piirretään alkuvalikko\nEnter pelaa ja Esc lopettaa");
    }
    
    private void pelataankoPeli() {
        this.valikko();
        if (true) {
            this.pelataanko = true;
        } else {
            this.pelataanko = false;
        }
    }
    
}
