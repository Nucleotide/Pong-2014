package pong2014.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;
import pong2014.logiikka.Maila;
import pong2014.logiikka.Pallo;
import pong2014.logiikka.Peli;

/**
 *
 * @author joonaslaakkonen
 * Piirtoalusta, joka piirtää pelin pallon, reunat ja mailat.
 * Tarvittavat metodit ylikirjoitettu.
 */
public class Piirtoalusta extends JPanel implements Paivitettava {
    private Peli peli;
    private Maila pelaajanMaila;
    private Maila vastustajanMaila;
    private Pallo pallo;

    public Piirtoalusta(Peli peli) {
        super.setBackground(Color.BLACK);
        this.peli = peli;
        pelaajanMaila = this.peli.getPelaaja().getMaila() ;
        vastustajanMaila = this.peli.getVastustaja().getMaila() ;
        pallo = this.peli.getKentta().getPallo();;
    }
    
    /**
     * 
     * @param g 
     * Ylikirjoitettu metodi, joka piirtää pelin grafiikat sekä pistetilanteen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fillRect(100, pelaajanMaila.getPaikka(), pelaajanMaila.getLeveys(), pelaajanMaila.getKorkeus());
        g.fillRect(680, vastustajanMaila.getPaikka(), vastustajanMaila.getLeveys(), vastustajanMaila.getKorkeus());
        g.fillRect(100, 45, 600, 5);
        g.fillRect(100, 400, 600, 5); 
        g.fillRect(pallo.getX(), pallo.getY(), pallo.getLeveys(), pallo.getKorkeus());
        g.drawString("Pelaajan pisteet: " + this.peli.getPelaaja().kerroPisteet(), 100, 435);
        g.drawString("Vastustajan pisteet: " + this.peli.getVastustaja().kerroPisteet(), 565, 435);
        
        if (this.peli.getVastustaja().kerroPisteet() == 10) {
            g.drawString("HÄVISIT!", 400, 235);
        } else if (this.peli.getPelaaja().kerroPisteet() == 10) {
            g.drawString("VOITIT!", 300, 235);
        }
    }  

    @Override
    public void paivita() {
        this.repaint();
    }
}