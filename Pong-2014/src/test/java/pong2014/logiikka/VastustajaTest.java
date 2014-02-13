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
        this.vastustaja = new Vastustaja(195);
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
        pallo.setSuunta(0);
        pallo.setPaikka(670);
        for (int i = 0; i < 15 ; i++) {
            pallo.liiku();
        }        
        this.vastustaja.lyo(pallo);
        int paikka = pallo.getX();
        assertTrue(paikka != 750);
    }
    
    @Test
    public void vastustajaEiOsuPalloon() {
        Pallo pallo = new Pallo();
        pallo.setSuunta(350);
        Maila maila = this.vastustaja.getMaila();
        for (int i = 0; i < 50; i++) {
            maila.liikuYlos();
        }
        pallo.setPaikka(670);
        for (int j = 0; j < 30; j++) {
            pallo.liiku();
        }
        this.vastustaja.lyo(pallo);
        int paikka = pallo.getX();
        assertEquals(750, paikka);        
    }
    
    @Test
    public void vastustajanMailaaHalutaanLiikuttaaYlos() {
        Maila maila = this.vastustaja.getMaila();
        this.vastustaja.liikutaMailaa();
        
        int paikka = maila.getPaikka();
        this.vastustaja.liikutaMailaa();
        int paikkaLopuksi = maila.getPaikka();
        
        assertTrue(paikka != paikkaLopuksi);
    }
    
    @Test
    public void vastustajanMailaaHalutaanLiikuttaaYlosII() {
        Maila maila = this.vastustaja.getMaila();
        maila.setPaikka(340);
        this.vastustaja.liikutaMailaa();
        int paikkaLopuksi = maila.getPaikka();
        
        assertTrue(339 == paikkaLopuksi);
    }
    
    @Test
    public void vastustajanMailaaHalutaanLiikuttaAlas() {
        Maila maila = this.vastustaja.getMaila();
        maila.setPaikka(50);
        this.vastustaja.liikutaMailaa();
        int paikkaLopuksi = maila.getPaikka();
        
        assertTrue(51 == paikkaLopuksi);
    }
    
}
