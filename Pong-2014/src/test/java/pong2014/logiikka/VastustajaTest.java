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
    private Maila maila;
    
    public VastustajaTest() {
    }
    
    @Before
    public void setUp() {
        this.vastustaja = new Vastustaja(195);
        this.pallo = new Pallo();
        this.maila = this.vastustaja.getMaila();
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
        this.pallo.setSuunta(0);
        this.pallo.setX(680);     
        this.vastustaja.lyo(this.pallo);
        assertTrue(pallo.getSuunta() != 0);
    }
    
    @Test
    public void vastustajaEiOsuPalloon() {
        this.pallo.setSuunta(350);
        this.maila.setPaikka(55);
        this.pallo.setX(660);
        this.vastustaja.lyo(this.pallo);
        this.pallo.liiku();
        assertTrue(this.pallo.getSuunta() == 350);
        assertTrue(this.pallo.getX() > 660);        
    }
    
    @Test
    public void vastustajanMailaaHalutaanLiikuttaaYlos() {
        this.pallo.setY(55);
        this.vastustaja.liikutaMailaa(this.pallo); 
        int paikka = this.maila.getPaikka();
        this.vastustaja.liikutaMailaa(this.pallo);
        
        assertTrue(paikka != this.maila.getPaikka());
    }
    
    @Test
    public void vastustajanMailaaHalutaanLiikuttaAlas() {
        this.pallo.setY(400);
        this.maila.setPaikka(50);
        this.vastustaja.liikutaMailaa(this.pallo);
        
        assertTrue(55 == this.maila.getPaikka());
    }
    
    @Test
    public void tapahtuuReunaLyontiYlhaalla() {
        this.pallo.setX(660);
        this.pallo.setY(100);
        this.pallo.setSuunta(355);
        this.maila.setPaikka(110);
        this.vastustaja.lyo(this.pallo);
        assertTrue(this.pallo.getSuunta() != 355);
    }    
    
    @Test
    public void mailaEiLiikuYlosJosPalloEiOleYlempana() {
        this.maila.setPaikka(65);
        this.pallo.setY(70);
        this.pallo.setSuunta(180);
        this.pallo.liiku();
        assertTrue(this.maila.getPaikka() == 65);
    }
    
    @Test
    public void mailaEiLiikuAlasJosPalloEiOleAlempana() {
        this.maila.setPaikka(100);
        this.pallo.setY(155);
        this.pallo.setSuunta(180);
        this.pallo.liiku();
        assertTrue(this.maila.getPaikka() == 100);
    }
    
    @Test
    public void palloLiikkuuJosVastustajaEiOsuSiihen() {
        this.pallo.setX(659);
        this.pallo.setSuunta(0);
        this.maila.setPaikka(51);
        this.vastustaja.lyo(this.pallo);
        assertTrue(this.pallo.getX() > 660);        
    }
}