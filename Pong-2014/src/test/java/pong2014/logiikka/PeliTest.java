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
public class PeliTest {
    
    private Peli peli;
    private Pallo pallo;
    private Kentta kentta;
    private Pelaaja pelaaja;
    private Vastustaja vastustaja;
    
    public PeliTest() {
    }
    
    @Before
    public void setUp() {
        this.peli = new Peli();
        this.pallo = this.peli.getPallo();
        this.kentta = this.peli.getKentta();
        this.pelaaja = this.peli.getPelaaja();
        this.vastustaja = this.peli.getVastustaja();
    }
    
    @Test
    public void peliSaaLiikutettuaPalloa() {
        int alku = this.pallo.getX();
        this.pallo.liiku();
        int loppu = this.pallo.getX();
        
        assertFalse(alku == loppu);
    }
    
    @Test
    public void peliPalauttaaLuomansaOliot() {        
        assertNotNull(this.kentta);
        assertNotNull(this.pelaaja);
        assertNotNull(this.vastustaja);
    }
    
    @Test
    public void eiVoittajaaJosPisteetAlleKymmenen() {
        assertTrue(!this.peli.voittaja());
    }
    
    @Test
    public void voittajaJosPisteitaKymmenen() {
        for (int i = 0; i < 10; i++) {
            this.pelaaja.lisaaPiste(); 
        }        
        assertTrue(this.peli.voittaja());
    }
    
    @Test
    public void aluksiPeliEiOlePausella() {
        assertTrue(this.peli.pause());
    }
    
    @Test
    public void peliMeneePauselle() {
        this.peli.pause();
        assertTrue(!this.peli.pause());
    }
    
    @Test
    public void peliKimmottaaPalloa() {
        this.pallo.setY(50);
        assertTrue(this.peli.kimpoanko());
        this.pallo.setX(95);
        assertFalse(this.peli.kimpoanko());
        
        this.pallo.setX(155);
        this.pallo.setY(380);
        assertTrue(this.peli.kimpoanko());
        this.pallo.setX(690);
        assertFalse(this.peli.kimpoanko()); 
    }
    
    @Test
    public void pisteVastustajalle() {
        this.pallo.setX(39);
        assertTrue(this.kentta.kenellePiste() == 1);
        this.peli.uusiPallojaPiste();
        
        assertTrue(this.vastustaja.kerroPisteet() == 1);
        assertTrue(this.pallo.getSuunta() == 350);
    }     
    
    @Test
    public void pistePelaajalle() {
        this.pallo.setX(741);
        assertTrue(this.kentta.kenellePiste() == 2);
        this.peli.uusiPallojaPiste();
        
        assertTrue(this.pelaaja.kerroPisteet() == 1);
        assertTrue(this.pallo.getSuunta() == 190);
    }
}