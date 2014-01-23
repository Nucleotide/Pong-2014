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
public class PelaajaTest {
    
    private Pelaaja pelaaja;
    
    public PelaajaTest() {
    }
    
    @Before
    public void setUp() {
        this.pelaaja = new Pelaaja(15.0);
    }
    
    @Test
    public void pelaajanPisteetAluksiNolla() {
        int pisteet = this.pelaaja.kerroPisteet();
        assertEquals(0, pisteet);
    }
    
    @Test
    public void pelaajanPisteetKasvavatOikein() {
        this.pelaaja.lisaaPiste();
        int pisteet = this.pelaaja.kerroPisteet();
        assertEquals(1, pisteet);
    }
    
    @Test
    public void pelaajanPisteetEivatVoiOllaYliKymmenen() {
        for (int i = 1; i < 15; i++) {
            this.pelaaja.lisaaPiste();
        }
        int pisteet = this.pelaaja.kerroPisteet();
        assertEquals(10, pisteet);
    }
    
}
