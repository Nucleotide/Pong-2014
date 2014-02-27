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
    private Pallo pallo;
    private Maila maila;
    
    public PelaajaTest() {
    }
    
    @Before
    public void setUp() {
        this.pelaaja = new Pelaaja(195);
        this.pallo = new Pallo();
        this.maila = this.pelaaja.getMaila();
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
        int paikka = this.maila.getPaikka();
        this.pelaaja.liikutaMailaaYlos();
        int uusiPaikka = this.maila.getPaikka();
        assertEquals(194, uusiPaikka);
        assertFalse(uusiPaikka == paikka);
    }
    
    @Test
    public void pelaajaLiikuttaaMailaaAlas() {
        int paikka = this.maila.getPaikka();
        this.pelaaja.liikutaMailaaAlas();
        int uusiPaikka = this.maila.getPaikka();
        assertEquals(196, uusiPaikka);
        assertFalse(uusiPaikka == paikka);
    }
    
    @Test
    public void pelaajaLyoPalloa() {
        this.pallo.setX(120);
        this.pallo.setSuunta(170);
        this.pelaaja.lyo(this.pallo);
        this.pallo.liiku();
        int paikka = this.pallo.getX();
        assertTrue(paikka > 120);
        assertTrue(10 == this.pallo.getSuunta());
    }
    
    @Test
    public void pelaajaEiOsuPalloon() {
        this.pallo.setSuunta(195);
        this.maila.setPaikka(51);
        pallo.setX(120);
        this.pelaaja.lyo(pallo);
        this.pallo.liiku();
        assertTrue(pallo.getX() < 120);       
    }
    
    @Test
    public void palloJatkaaLiikettaJosPelaajaEiOsuSiihen() {
        this.pallo.setX(121);
        this.pallo.setSuunta(180);
        this.maila.setPaikka(51);
        this.pelaaja.lyo(pallo);
        assertTrue(this.pallo.getX() < 120);
    }
    
    @Test
    public void tapahtuuReunaLyontiYlhaalla() {
        this.pallo.setX(120);
        this.pallo.setY(100);
        this.pallo.setSuunta(190);
        this.maila.setPaikka(110);
        this.pelaaja.lyo(this.pallo);
        assertTrue(this.pallo.getSuunta() != 190);
    }
}