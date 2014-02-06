package pong2014.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joonaslaakkonen
 */
public class PeliTest {
    
    private Peli peli;
    
    public PeliTest() {
    }
    
    @Before
    public void setUp() {
        this.peli = new Peli();
    }
    
    @Test
    public void pelataankoPalauttaaArvonTruePelinAlussa() {
        assertFalse(!this.peli.jatkuu());
        
    }
    
    @Test
    public void peliSaaLiikutettuaPalloa() {
        Pallo pallo = this.peli.getKentta().getPallo();
        int alku = pallo.getX();
        pallo.liiku();
        int loppu = pallo.getX();
        
        assertFalse(alku == loppu);
    }
    
    @Test
    public void peliPalauttaaLuomansaOliot() {
        Kentta a = this.peli.getKentta();
        Pelaaja b = this.peli.getPelaaja();
        Vastustaja c = this.peli.getVastustaja();
        
        assertNotNull(a);
        assertNotNull(b);
        assertNotNull(c);
    }
}
