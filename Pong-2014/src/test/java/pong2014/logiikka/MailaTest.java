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
        this.pelaajanMaila = new Maila(12.0);
        this.vastustajanMaila = new Maila(24.0);
    }

    @Test
    public void onkoPelaajanMailanPaikkaOikeaAlussa() {
        double paikka = this.pelaajanMaila.getPaikka();
        assertEquals(12.0, paikka, 0);
    }
    
    @Test
    public void onkoVastustajanMailanPaikkaOikeaAlussa() {
        double paikka = this.vastustajanMaila.getPaikka();
        assertEquals(24.0, paikka, 0); 
    }
    
    @Test
    public void liikutaMailaaYlos() {
        this.pelaajanMaila.liikuYlos();
        double mailanPaikkaLopuksi = this.pelaajanMaila.getPaikka();
        assertEquals(11.0, mailanPaikkaLopuksi, 0);
    }
    
    @Test
    public void liikutaMailaaAlas() {
        this.pelaajanMaila.liikuAlas();
        double mailanPaikkaLopuksi = this.pelaajanMaila.getPaikka();
        assertEquals(13.0, mailanPaikkaLopuksi, 0);
    }
    
    @Test
    public void mailaaEiVoiLiikuttaaAlasKentanUlkopuolelle() {
        Maila alas = new Maila(12.0);
        for (int i=0;i<20; i++) {
            alas.liikuAlas();
        }
        double paikkaLopuksi = alas.getPaikka();
        assertEquals(24.0, paikkaLopuksi, 0);
    }
    
    @Test
    public void mailaaEiVoiLiikuttaaYlosKentanUlkopuolelle() {
        Maila ylos = new Maila(12.0);
        for (int i=0;i<20; i++) {
            ylos.liikuYlos();
        }
        double paikkaLopuksi = ylos.getPaikka();
        assertEquals(0.0, paikkaLopuksi, 0);
    }
    
}
