package pong2014.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import pong2014.ui.Paivitettava;

/**
 *
 * @author joonaslaakkonen
 */
public class Peli extends Timer implements ActionListener {
    
    private Kentta kentta;
    private Pelaaja pelaaja;
    private Vastustaja vastustaja;
    private boolean pelataanko;
    private Pallo pallo;
    private Paivitettava paivitettava;
    
    public Peli() {
        super(1000, null);
        this.kentta = new Kentta();
        this.vastustaja = new Vastustaja(24);
        this.pelaaja = new Pelaaja(12);
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
        while (this.pallo.getX() > 2 && this.pallo.getX() < 56) {
            this.pallo.liiku();
            this.vastustaja.liikutaMailaa();
            
            if (this.kimpoanko()) {
                this.pallo.kimpoaSeinasta();
            } else if(pallo.getX() == 2) {
                this.pelaaja.lyo(this.pallo);
            } else if (pallo.getX() == 56) {
                this.vastustaja.lyo(this.pallo);
            }
        }
        int kumpiVoitti = this.kentta.kenellePiste();
        this.pallo.uusiPallo(kumpiVoitti);
    }    
    
    private void pelataankoPeli() {
        if (true) {
            this.pelataanko = true;
        } else {
            this.pelataanko = false;
        }
    }
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }    

    private boolean voittaja() {
        if (this.pelaaja.kerroPisteet() > 9 || this.vastustaja.kerroPisteet() > 9) {
            return true;
        }
        return false;
    }

    private boolean kimpoanko() {
        if (this.pallo.getY() == 0 && this.pallo.getX() != 2) {
            return true;
        } else if (this.pallo.getY() == 28 && this.pallo.getX() != 2) {
            return true;
        } else if (this.pallo.getY() == 0 && this.pallo.getX() != 56) {
            return true;
        } else if (this.pallo.getY() == 28 && this.pallo.getX() != 56) {
            return true;
        }
        return false;
    }
    
    public Kentta getKentta() {
        return this.kentta;
    }
    
    public Pelaaja getPelaaja() {
        return this.pelaaja;
    }
    
    public Vastustaja getVastusta() {
        return this.vastustaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void lopeta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void tauko() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
