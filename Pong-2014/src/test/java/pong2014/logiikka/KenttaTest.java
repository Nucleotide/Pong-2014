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
    public void pisteOikeinVastustajalle() {
        Pallo pallo = this.kentta.getPallo();
        pallo.setPaikka(50);
        int piste = this.kentta.kenellePiste();
        assertEquals(1, piste);
    }
    
    @Test
    public void pisteOikeinPelaajalle() {
        Pallo pallo = this.kentta.getPallo();
        pallo.setPaikka(750);
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
    public void alaAnnaPistettaJosPalloOnKentalla() {
        Pallo uusi = new Pallo();
        int paikka = this.kentta.kenellePiste();
        assertEquals(0, paikka);
    }
    
}
