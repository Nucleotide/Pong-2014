package pong2014.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pong2014.logiikka.Peli;


/**
 *
 * @author joonaslaakkonen
 * Luokka toteuttaa Javan valmiin KeyListener -luokan. Metodeista tarpeelliset ylikirjoitettu.
 * Konstruktorissa kuuntelijalle annetaan viite Peliin.
 */
public class Nappaimistonkuuntelija implements KeyListener {
    private Peli peli;
    
    public Nappaimistonkuuntelija (Peli peli) {
        this.peli = peli;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            //tähän restart
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.peli.tauko();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.peli.getPelaaja().liikutaMailaaYlos();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.peli.getPelaaja().liikutaMailaaAlas();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}