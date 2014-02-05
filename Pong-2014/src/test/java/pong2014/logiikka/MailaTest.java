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
        this.pelaajanMaila = new Maila(12);
        this.vastustajanMaila = new Maila(24);
    }

    @Test
    public void onkoPelaajanMailanPaikkaOikeaAlussa() {
        int paikka = this.pelaajanMaila.getPaikka();
        assertEquals(12, paikka);
    }
    
    @Test
    public void onkoVastustajanMailanPaikkaOikeaAlussa() {
        int paikka = this.vastustajanMaila.getPaikka();
        assertEquals(24, paikka); 
    }
    
    @Test
    public void liikutaMailaaYlos() {
        this.pelaajanMaila.liikuYlos();
        int mailanPaikkaLopuksi = this.pelaajanMaila.getPaikka();
        assertEquals(11, mailanPaikkaLopuksi);
    }
    
    @Test
    public void liikutaMailaaAlas() {
        this.pelaajanMaila.liikuAlas();
        int mailanPaikkaLopuksi = this.pelaajanMaila.getPaikka();
        assertEquals(13, mailanPaikkaLopuksi);
    }
    
    @Test
    public void mailaaEiVoiLiikuttaaAlasKentanUlkopuolelle() {
        Maila alas = new Maila(12);
        for (int i=0;i<20; i++) {
            alas.liikuAlas();
        }
        int paikkaLopuksi = alas.getPaikka();
        assertEquals(24, paikkaLopuksi);
    }
    
    @Test
    public void mailaaEiVoiLiikuttaaYlosKentanUlkopuolelle() {
        Maila ylos = new Maila(12);
        for (int i=0;i<20; i++) {
            ylos.liikuYlos();
        }
        int paikkaLopuksi = ylos.getPaikka();
        assertEquals(0, paikkaLopuksi);
    }
    
}
