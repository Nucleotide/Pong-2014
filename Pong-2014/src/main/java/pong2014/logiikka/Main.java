package pong2014.logiikka;

import javax.swing.SwingUtilities;
import pong2014.ui.Kayttoliittyma;

/**
 *
 * @author joonaslaakkonen Luokka Main käynnistää pelin ja luo käyttöliittymän.
 */
public class Main {
    public static void main( String[] args ){
        Peli peli = new Peli();

        Kayttoliittyma ui = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(ui);

        while (ui.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }

        peli.setPaivitettava(ui.getPaivitettava());
        peli.start();
    }
}