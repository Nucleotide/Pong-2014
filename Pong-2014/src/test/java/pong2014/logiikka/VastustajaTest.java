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
public class VastustajaTest {
    
    private Vastustaja vastustaja;
    
    public VastustajaTest() {
    }
    
    @Before
    public void setUp() {
        this.vastustaja = new Vastustaja(24.0);
    }

    @Test
    public void vastustajanPisteetAluksiNolla() {
        int pisteet = this.vastustaja.kerroPisteet();
        assertEquals(0, pisteet);
    }
    
    @Test
    public void vastustajanPisteetKasvavatOikein() {
        this.vastustaja.lisaaPiste();
        int pisteet = this.vastustaja.kerroPisteet();
        assertEquals(1, pisteet);
    }
    
    @Test
    public void vastustajanPisteetEivatVoiOllaYliKymmenen() {
        for (int i = 1; i < 15; i++) {
            this.vastustaja.lisaaPiste();
        }
        int pisteet = this.vastustaja.kerroPisteet();
        assertEquals(10, pisteet);
    }
    
    @Test
    public void vastustajaLyoPalloa() {
        Pallo pallo = new Pallo();
        Maila maila = vastustaja.getMaila();
        for (int i = 0; i < 12; i++) {
            maila.liikuYlos();
        }        
        this.vastustaja.lyo(pallo);
        double paikka = pallo.getX();
        assertTrue(paikka != 61.0);
    }
    
    @Test
    public void vastustajaEiOsuPalloon() {
        Pallo pallo = new Pallo();
        pallo.setSuunta(350.0);
        Maila maila = this.vastustaja.getMaila();
        for (int i = 0; i < 25; i++) {
            maila.liikuYlos();
        }
        for (int j = 0; j < 30; j++) {
            pallo.liiku();
        }
        this.vastustaja.lyo(pallo);
        double paikka = pallo.getX();
        assertEquals(61.0, paikka, 0.0);
        
    }
    
}
