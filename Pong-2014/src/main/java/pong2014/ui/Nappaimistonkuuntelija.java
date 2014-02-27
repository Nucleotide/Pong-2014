package pong2014.ui;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.SwingUtilities;
import pong2014.logiikka.Peli;


/**
 *
 * @author joonaslaakkonen
 * Luokka toteuttaa Javan valmiin KeyListener -luokan. Metodeista tarpeelliset ylikirjoitettu.
 * Konstruktorissa kuuntelijalle annetaan viite Peliin.
 */
public class Nappaimistonkuuntelija implements KeyListener {
    private Peli peli;
    private Frame frame;
    
    public Nappaimistonkuuntelija (Peli peli, Frame frame) {
        this.peli = peli;
        this.frame = frame;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    /**
     * 
     * @param e kertoo mitä näppäintä pelaaja painaa. Näppäimestä riippuen tapahtuu jotain. Valitettavasti
     * Uuden pelin aloittaminen on varsinainen purkkaratkaisu, aika loppui kesken mutta testatessa toimi.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        this.frame.setVisible(false);
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
        
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (this.peli.pause()) {
                this.peli.stop();
            } else {
                this.peli.start();
            }
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