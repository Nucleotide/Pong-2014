package pong2014.ui;
 
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import pong2014.logiikka.Peli;
 
/**
 *
 * @author joonaslaakkonen
 * Pelin käli.
 */
public class Kayttoliittyma implements Runnable {
 
    private JFrame frame;
    private Peli peli;    
    private Piirtoalusta alusta;
    
    public Kayttoliittyma(Peli peli) {
        this.peli = peli;
        this.alusta = new Piirtoalusta(this.peli);
    }
    
    /**
     * Ylikirjoitettu metodi, joka liittää käliin tarvittavat oliot ja näyttää sen pelaajalle.
     */
    @Override
    public void run() {
        frame = new JFrame("Pong");

        frame.setPreferredSize(new Dimension(800, 550));
        frame.setResizable(false);
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        luoKomponentit(frame.getContentPane());
        lisaaKuuntelijat();
 
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * 
     * @param container 
     * Metodille annetaan container, johon lisätään piirtoalusta.
     */
    public void luoKomponentit(Container container) {
        container.add(this.alusta);   
    }
 
    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * Lisätään kuuntelija näyttöön.
     */
    private void lisaaKuuntelijat() {
        frame.addKeyListener(new Nappaimistonkuuntelija(this.peli));
    }   
    
    public Paivitettava getPaivitettava(){
        return this.alusta;
    }
}