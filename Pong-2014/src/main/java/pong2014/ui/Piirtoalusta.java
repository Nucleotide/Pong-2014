package pong2014.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;
import pong2014.logiikka.Peli;

/**
 *
 * @author joonaslaakkonen
 */
public class Piirtoalusta extends JPanel implements Paivitettava {
    private Peli peli;
    
    public Piirtoalusta(Peli peli) {
        this.peli = peli;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, this.peli.getPelaaja().getMaila().getPaikka(), 2*10, 6*10);
        g.setColor(Color.GREEN);
        g.fillRect(58, this.peli.getVastusta().getMaila().getPaikka(), 2*10, 6*10);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 60, 1);
        g.fillRect(0, 60, 60, 1);

        g.setColor(Color.RED);
        g.fillOval(this.peli.getKentta().getPallo().getX(), this.peli.getKentta().getPallo().getY(), 2*10, 2*10);
    }    

    @Override
    public void paivita() {
        this.repaint();
    }
}