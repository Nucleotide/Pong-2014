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
public class MailaTest {
    
    private Maila vastustajanMaila;
    private Maila pelaajanMaila;
    
    public MailaTest() {
    }
    
    @Before
    public void setUp() {
        this.pelaajanMaila = new Maila(195);
        this.vastustajanMaila = new Maila(195);
    }

    @Test
    public void onkoPelaajanMailanPaikkaOikeaAlussa() {
        int paikka = this.pelaajanMaila.getPaikka();
        assertEquals(195, paikka);
    }
    
    @Test
    public void onkoVastustajanMailanPaikkaOikeaAlussa() {
        int paikka = this.vastustajanMaila.getPaikka();
        assertEquals(195, paikka); 
    }
    
    @Test
    public void liikutaMailaaYlos() {
        this.pelaajanMaila.liikuYlos();
        int mailanPaikkaLopuksi = this.pelaajanMaila.getPaikka();
        assertEquals(194, mailanPaikkaLopuksi);
    }
    
    @Test
    public void liikutaMailaaAlas() {
        this.pelaajanMaila.liikuAlas();
        int mailanPaikkaLopuksi = this.pelaajanMaila.getPaikka();
        assertEquals(196, mailanPaikkaLopuksi);
    }
    
    @Test
    public void mailaaEiVoiLiikuttaaAlasKentanUlkopuolelle() {
        Maila alas = new Maila(330);
        for (int i=0;i<20; i++) {
            alas.liikuAlas();
        }
        int paikkaLopuksi = alas.getPaikka();
        assertEquals(340, paikkaLopuksi);
    }
    
    @Test
    public void mailaaEiVoiLiikuttaaYlosKentanUlkopuolelle() {
        Maila ylos = new Maila(60);
        for (int i=0;i<20; i++) {
            ylos.liikuYlos();
        }
        int paikkaLopuksi = ylos.getPaikka();
        assertEquals(50, paikkaLopuksi);
    }
    
    @Test
    public void mailanKokoOnHaluttu() {
        int lev = this.pelaajanMaila.getLeveys();
        int kork = this.pelaajanMaila.getKorkeus();
        
        assertEquals(20, lev);
        assertEquals(60, kork);
    } 
}
