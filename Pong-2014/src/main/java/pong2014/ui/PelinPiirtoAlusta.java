package pong2014.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author joonaslaakkonen
 */
public class PelinPiirtoAlusta extends JFrame {


    public PelinPiirtoAlusta() {
    }

    private void teePelilauta(Container container) {
        InputListener kuuntelija = new InputListener();
        container.setLayout(new BorderLayout());

        JButton lopeta = new JButton("Lopeta = Esc");
        lopeta.setBounds(100, 20, 100, 25);
        lopeta.addKeyListener(kuuntelija);
        JButton tauko = new JButton("Tauko = Space");
        tauko.setBounds(250, 20, 100, 25);
        tauko.addKeyListener(kuuntelija);
        JButton uusiPeli = new JButton("Uusi peli = Enter");
        uusiPeli.addKeyListener(kuuntelija);
        uusiPeli.setBounds(400, 20, 100, 25);


        container.add(tauko, BorderLayout.NORTH);
        container.add(lopeta, BorderLayout.NORTH);
        container.add(uusiPeli, BorderLayout.NORTH);

        setTitle("Pong");
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
