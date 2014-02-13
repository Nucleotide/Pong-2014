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
        this.pelaaja = new Pelaaja(195);
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
        int paikka = pelaajanMaila.getPaikka();
        this.pelaaja.liikutaMailaaYlos();
        int uusiPaikka = pelaajanMaila.getPaikka();
        assertEquals(194, uusiPaikka);
        assertFalse(uusiPaikka == paikka);
    }
    
    @Test
    public void pelaajaLiikuttaaMailaaAlas() {
        Maila pelaajanMaila = this.pelaaja.getMaila();
        int paikka = pelaajanMaila.getPaikka();
        this.pelaaja.liikutaMailaaAlas();
        int uusiPaikka = pelaajanMaila.getPaikka();
        assertEquals(196, uusiPaikka);
        assertFalse(uusiPaikka == paikka);
    }
    
    @Test
    public void pelaajaLyoPalloa() {
        Pallo pallo = new Pallo();
        pallo.setPaikka(130);
        for (int j = 0; j < 30; j++) {
            pallo.liiku();
        }
        int suunta = pallo.getSuunta();
        this.pelaaja.lyo(pallo);
        int uusiSuunta = pallo.getSuunta();
        int paikka = pallo.getX();
        assertTrue(paikka != 50);
        assertTrue(suunta != uusiSuunta);
    }
    
    @Test
    public void pelaajaEiOsuPalloon() {
        Pallo pallo = new Pallo();
        pallo.setSuunta(195);
        Maila maila = this.pelaaja.getMaila();
        for (int i = 0; i < 100; i++) {
            maila.liikuYlos();
        }
        pallo.setPaikka(130);
        for (int j = 0; j < 13; j++) {
            pallo.liiku();
        }
        this.pelaaja.lyo(pallo);
        int paikka = pallo.getX();
        assertEquals(50, paikka);
        
    }
    
}
