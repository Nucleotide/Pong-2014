package pong2014.ui;
 
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import pong2014.logiikka.Peli;
 
public class Kayttoliittyma implements Runnable {
 
    private JFrame frame;
    private Peli peli;    
    private Piirtoalusta alusta;
    
    public Kayttoliittyma(Peli peli) {
        this.peli = peli;
        this.alusta = new Piirtoalusta(this.peli);
    }
 
    @Override
    public void run() {
        frame = new JFrame("Pong");

        frame.setPreferredSize(new Dimension(800, 450));
        frame.setResizable(false);
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
 
        luoKomponentit(frame.getContentPane());
        lisaaKuuntelijat();
 
        frame.pack();
        frame.setVisible(true);
    }
 
    public void luoKomponentit(Container container) {
        container.add(this.alusta);   
    }
 
    public JFrame getFrame() {
        return frame;
    }
    
    private void lisaaKuuntelijat() {
        frame.addKeyListener(new Nappaimistonkuuntelija(this.peli));
    }   
    
    public Paivitettava getPaivitettava(){
        return this.alusta;
    }
}