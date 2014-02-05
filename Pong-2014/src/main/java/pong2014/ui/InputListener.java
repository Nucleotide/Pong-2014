package pong2014.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pong2014.logiikka.Peli;

/**
 *
 * @author joonaslaakkonen
 */
public class InputListener implements KeyListener {

    

    public InputListener() {
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
            new PelinPiirtoAlusta();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {

        }
    }
    
}
