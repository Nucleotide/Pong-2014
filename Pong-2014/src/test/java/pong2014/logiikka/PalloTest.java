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
public class PalloTest {
    
    private Pallo pallo;
    
    public PalloTest() {
    }

    @Before
    public void setUp() {
        this.pallo = new Pallo();
    }
    
    @Test
    public void pallonAloitusPaikkaOikea(){
        double x = this.pallo.getX();
        double y = this.pallo.getY();
        
        assertEquals(29.0, x, 0);
        assertEquals(14.0, y, 0);
    }
    
    @Test
    public void pallollaOnAluksiSuunta() {
        double suunta = this.pallo.getSuunta();
        assertTrue("Suunta olemassa", suunta == 350.0 || suunta == 190.0);
    }
    
    @Test
    public void uusiPallonAsettaaPaikanOikein() {
        this.pallo.uusiPallo(1.0);
        double x = this.pallo.getX();
        double y = this.pallo.getY();
        
        assertEquals(29.0, x, 0);
        assertEquals(14.0, y, 0);
    }
    
    @Test
    public void suunnanAsetusMuuttaaSuuntaa() {
        this.pallo.setSuunta(110.0);
        double eka = this.pallo.getSuunta();
        this.pallo.setSuunta(200.0);
        double toka = this.pallo.getSuunta();
        assertTrue(eka != toka);
    }
    
}
