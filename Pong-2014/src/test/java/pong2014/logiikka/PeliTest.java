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
    public void pelataankoPalauttaaArvonTruePelinAlussa() {
        assertTrue(this.peli.jatkuu());      
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
    public void peliLiikuttaaVastustajanMailaa() {
        Maila maila = this.vastustaja.getMaila();
        this.pallo.setY(56);
        int a = maila.getPaikka();
        this.vastustaja.liikutaMailaa(this.pallo);
        int b = maila.getPaikka();
        assertFalse(a == b);
    }
    
    @Test
    public void palloEiSaaKimmotaJosSeEiOsuSeinaan() {
        this.pallo.setY(100);
        this.pallo.setSuunta(15);
        this.pallo.liiku();
        assertTrue(this.pallo.getSuunta() == 15);
    }
    
    @Test
    public void peliLoytaaVoittajan() {
        Pelaaja pelaaja = this.peli.getPelaaja();
        for (int i = 0; i < 11; i++) {
            pelaaja.lisaaPiste();
        }    
        assertTrue(this.peli.voittaja());  
    }
    
    @Test
    public void pelissaEiVoittajaaJosPisteetAlleKymmenen() {
        Pelaaja pelaaja = this.peli.getPelaaja();
        Vastustaja vastustaja = this.peli.getVastustaja();
        
        pelaaja.lisaaPiste();
        vastustaja.lisaaPiste();
        
        assertFalse(this.peli.voittaja());
    }
}
