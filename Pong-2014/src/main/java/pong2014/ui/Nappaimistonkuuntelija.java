package pong2014.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pong2014.logiikka.Peli;


/**
 *
 * @author joonaslaakkonen
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
            this.peli.aloita();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.peli.lopeta();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.peli.tauko();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}