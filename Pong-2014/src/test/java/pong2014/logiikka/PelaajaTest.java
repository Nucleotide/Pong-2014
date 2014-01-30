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
        this.pelaaja = new Pelaaja(12.0);
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
    
    @Test
    public void pelaajaLiikuttaaMailaaYlos() {
        Maila pelaajanMaila = this.pelaaja.getMaila();
        double paikka = pelaajanMaila.getPaikka();
        this.pelaaja.liikutaMailaaYlos();
        double uusiPaikka = pelaajanMaila.getPaikka();
        assertEquals(11.0, uusiPaikka, 0);
    }
    
    @Test
    public void pelaajaLiikuttaaMailaaAlas() {
        Maila pelaajanMaila = this.pelaaja.getMaila();
        double paikka = pelaajanMaila.getPaikka();
        this.pelaaja.liikutaMailaaAlas();
        double uusiPaikka = pelaajanMaila.getPaikka();
        assertEquals(13.0, uusiPaikka, 0);
    }
    
    @Test
    public void pelaajaLyoPalloa() {
        Pallo pallo = new Pallo();
        this.pelaaja.lyo(pallo);
        double paikka = pallo.getX();
        assertTrue(paikka != -1.0);
    }
    
    @Test
    public void pelaajaEiOsuPalloon() {
        Pallo pallo = new Pallo();
        pallo.setSuunta(195.0);
        Maila maila = this.pelaaja.getMaila();
        for (int i = 0; i < 15; i++) {
            maila.liikuYlos();
        }
        for (int j = 0; j < 30; j++) {
            pallo.liiku();
        }
        this.pelaaja.lyo(pallo);
        double paikka = pallo.getX();
        assertEquals(-1.0, paikka, 0.0);
        
    }
    
}
