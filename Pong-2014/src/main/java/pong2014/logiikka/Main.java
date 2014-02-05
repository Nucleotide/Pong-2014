package pong2014.logiikka;

import javax.swing.SwingUtilities;
import pong2014.ui.PelinPiirtoAlusta;

/**
 *
 * @author joonaslaakkonen
 */
public class Main {
    public static void main( String[] args ){
        SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            PelinPiirtoAlusta peli = new PelinPiirtoAlusta();
            peli.setVisible(true);
            }
        });
    }
}