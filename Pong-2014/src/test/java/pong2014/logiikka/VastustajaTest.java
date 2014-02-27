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
    private Pallo pallo;
    
    public VastustajaTest() {
    }
    
    @Before
    public void setUp() {
        this.vastustaja = new Vastustaja(195);
        this.pallo = new Pallo();
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
        Maila maila = vastustaja.getMaila();
        this.pallo.setSuunta(0);
        this.pallo.setX(670);
        for (int i = 0; i < 15 ; i++) {
            this.pallo.liiku();
        }        
        this.vastustaja.lyo(this.pallo);
        assertTrue(pallo.getSuunta() != 0);
    }
    
    @Test
    public void vastustajaEiOsuPalloon() {
        this.pallo.setSuunta(350);
        Maila maila = this.vastustaja.getMaila();
        for (int i = 0; i < 50; i++) {
            maila.liikuYlos();
        }
        this.pallo.setX(670);
        for (int j = 0; j < 30; j++) {
            this.pallo.liiku();
        }
        this.vastustaja.lyo(this.pallo);
        assertTrue(this.pallo.getX() > 660);        
    }
    
    @Test
    public void vastustajanMailaaHalutaanLiikuttaaYlos() {
        Maila maila = this.vastustaja.getMaila();
        this.pallo.setY(55);
        this.vastustaja.liikutaMailaa(this.pallo); 
        int paikka = maila.getPaikka();
        this.vastustaja.liikutaMailaa(this.pallo);
        
        assertTrue(paikka != maila.getPaikka());
    }
    
    @Test
    public void vastustajanMailaaHalutaanLiikuttaAlas() {
        Maila maila = this.vastustaja.getMaila();
        this.pallo.setY(400);
        maila.setPaikka(50);
        this.vastustaja.liikutaMailaa(this.pallo);
        
        assertTrue(51 == maila.getPaikka());
    }
}