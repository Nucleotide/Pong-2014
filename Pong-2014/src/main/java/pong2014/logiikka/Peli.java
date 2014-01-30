package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
class Peli {
    
    private Kentta kentta;
    private Pelaaja pelaaja;
    private Vastustaja vastustaja;
    private boolean pelataanko;
    private Pallo pallo;
    
    public Peli() {
        this.kentta = new Kentta();
        this.vastustaja = new Vastustaja(24.0);
        this.pelaaja = new Pelaaja(12.0);
        this.pelataanko = true;
    }
    
    
    public void aloita() {
        this.pelataankoPeli();
        pallo = this.kentta.getPallo();
        
        
        while (this.pelataanko) {
            if (!this.voittaja()) {
                this.pelaaPallo();
            } else {
                break;
            }
        this.pelataankoPeli();
        }
    }
    private void pelaaPallo() {
        while (this.pallo.getX() > 2.0 && this.pallo.getX() < 56.0) {
            this.pallo.liiku();
            
            if (this.kimpoanko()) {
                this.pallo.kimpoaSeinasta();
            } else if(pallo.getX() == 2.0) {
                this.pelaaja.lyo(this.pallo);
            } else if (pallo.getX() == 56.0) {
                this.vastustaja.lyo(this.pallo);
            }
        }
        double kumpiVoitti = this.kentta.kenellePiste();
        this.pallo.uusiPallo(kumpiVoitti);
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

    private boolean voittaja() {
        if (this.pelaaja.kerroPisteet() > 9 || this.vastustaja.kerroPisteet() > 9) {
            return true;
        }
        return false;
    }

    private boolean kimpoanko() {
        if (this.pallo.getY() == 0.0 && this.pallo.getX() != 2.0) {
            return true;
        } else if (this.pallo.getY() == 28.0 && this.pallo.getX() != 2.0) {
            return true;
        } else if (this.pallo.getY() == 0.0 && this.pallo.getX() != 56.0) {
            return true;
        } else if (this.pallo.getY() == 28.0 && this.pallo.getX() != 56.0) {
            return true;
        }
        return false;
    }
    
}
