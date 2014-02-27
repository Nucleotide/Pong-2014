package pong2014.ui;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

        frame.setPreferredSize(new Dimension(800, 500));
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
        container.setLayout(new BorderLayout());
        container.add(this.luoValikko(), BorderLayout.PAGE_END);     
        container.add(this.alusta, BorderLayout.CENTER);      
    }
    
    private JPanel luoValikko() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Esc = lopeta ohjelma, Space = tauko, Enter = pelaa uudelleen"));

        
        return panel;
    }    
 
    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * Lisätään kuuntelija näyttöön.
     */
    private void lisaaKuuntelijat() {
        frame.addKeyListener(new Nappaimistonkuuntelija(this.peli, this.frame));
    }   
    
    public Paivitettava getPaivitettava(){
        return this.alusta;
    }
}