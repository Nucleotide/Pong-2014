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
    private Pallo pallo;
    
    public KenttaTest() {
    }
    
    @Before
    public void setUp() {
        this.kentta = new Kentta();
        this.pallo = this.kentta.getPallo();
    }
    
    @Test
    public void pisteOikeinVastustajalle() {
        this.pallo.setX(30);
        int piste = this.kentta.kenellePiste();
        assertEquals(1, piste);
    }
    
    @Test
    public void pisteOikeinPelaajalle() {
        this.pallo.setX(770);
        int piste = this.kentta.kenellePiste();
        assertEquals(2, piste);        
    }
    
    @Test
    public void saakoKorkeudenOikein () {
        int korkeus = this.kentta.getKorkeus();
        assertEquals(350, korkeus);
    }
    
    @Test
    public void saakoLeveydenOikein() {
        int leveys = this.kentta.getLeveys();
        assertEquals(600, leveys);
    }
    
    @Test
    public void alaAnnaPistettaJosPallonSijaintiEiOleAlleTaiYliRajan() {
        this.pallo.setX(40);
        assertEquals(0, this.kentta.kenellePiste());
        
        this.pallo.setX(740);
        assertEquals(0, this.kentta.kenellePiste());
    }
    
    @Test
    public void kentallaOnPallo() {
        assertNotNull(this.pallo);
    }    
    
}
