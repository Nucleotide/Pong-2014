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
public class KenttaTest {
    
    private Kentta kentta;
    
    public KenttaTest() {
    }
    
    @Before
    public void setUp() {
        this.kentta = new Kentta();
    }
    
    @Test
    public void kenttaLuoPallon() {
        Pallo pallo = this.kentta.getPallo();
        assertNotNull(pallo);
    }
    
    @Test
    public void pisteOikeinVastustajalle() {
        Pallo pallo = this.kentta.getPallo();
        pallo.setPaikka(-1.0);
        double piste = this.kentta.kenellePiste();
        assertEquals(1.0, piste, 0.0);
    }
    
    @Test
    public void pisteOikeinPelaajalle() {
        Pallo pallo = this.kentta.getPallo();
        pallo.setPaikka(61.0);
        double piste = this.kentta.kenellePiste();
        assertEquals(2.0, piste, 0.0);        
    }
    
}
