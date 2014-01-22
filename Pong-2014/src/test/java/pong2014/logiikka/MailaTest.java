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
        this.pelaajanMaila = new Maila(273.0);
        this.vastustajanMaila = new Maila(2.0);
    }

    @Test
    public void onkoPelaajanMailanPaikkaOikeaAlussa() {
        double mailanY = this.pelaajanMaila.getY();
        double mailanX = this.pelaajanMaila.getX();
        assertEquals(77.0, mailanY, 0);
        assertEquals(273.0, mailanX, 0);
        
    }
    
    @Test
    public void onkoVastustajanMailanPaikkaOikeaAlussa() {
        double mailanY = this.vastustajanMaila.getY();
        double mailanX = this.vastustajanMaila.getX();
        assertEquals(77.0, mailanY, 0);
        assertEquals(2.0, mailanX, 0); 
    }
    
    @Test
    public void liikutaMailaaYlos() {
        this.pelaajanMaila.liikuYlos();
        double mailanPaikkaLopuksi = this.pelaajanMaila.getY();
        assertEquals(76.0, mailanPaikkaLopuksi, 0);
    }
    
    @Test
    public void liikutaMailaaAlas() {
        this.pelaajanMaila.liikuAlas();
        double mailanPaikkaLopuksi = this.pelaajanMaila.getY();
        assertEquals(78.0, mailanPaikkaLopuksi, 0);
    }
    
    @Test
    public void mailaaEiVoiLiikuttaaAlasKentanUlkopuolelle() {
        Maila alas = new Maila(50.0);
        for (int i=0;i<100; i++) {
            alas.liikuAlas();
        }
        double paikkaLopuksi = alas.getY();
        assertEquals(133.0, paikkaLopuksi, 0);
    }
    
    @Test
    public void mailaaEiVoiLiikuttaaYlosKentanUlkopuolelle() {
        Maila ylos = new Maila(50.0);
        for (int i=0;i<100; i++) {
            ylos.liikuYlos();
        }
        double paikkaLopuksi = ylos.getY();
        assertEquals(0.0, paikkaLopuksi, 0);
    }
    
}
