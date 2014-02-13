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
    
    public PeliTest() {
    }
    
    @Before
    public void setUp() {
        this.peli = new Peli();
    }
    
    @Test
    public void pelataankoPalauttaaArvonTruePelinAlussa() {
        assertFalse(!this.peli.jatkuu());
        
    }
    
    @Test
    public void peliSaaLiikutettuaPalloa() {
        Pallo pallo = this.peli.getPallo();
        int alku = pallo.getX();
        pallo.liiku();
        int loppu = pallo.getX();
        
        assertFalse(alku == loppu);
    }
    
    @Test
    public void peliPalauttaaLuomansaOliot() {
        Kentta a = this.peli.getKentta();
        Pelaaja b = this.peli.getPelaaja();
        Vastustaja c = this.peli.getVastustaja();
        Pallo d = this.peli.getPallo();
        
        assertNotNull(a);
        assertNotNull(b);
        assertNotNull(c);
        assertNotNull(d);
    }
    
    @Test
    public void kentallaOnPallo() {
        Pallo pallo = this.peli.getKentta().getPallo();
        assertNotNull(pallo);
    }
    
    @Test
    public void peliLiikuttaaVastustajanMailaa() {
        Maila maila = this.peli.getVastustaja().getMaila();
        int a = maila.getPaikka();
        this.peli.getVastustaja().liikutaMailaa();
        int b = maila.getPaikka();
        assertFalse(a == b);
    }
    
    @Test
    public void palloEiSaaKimmotaJosSeEiOsuSeinaan() {
        Pallo pallo = this.peli.getPallo();
        pallo.setY(40);
        assertFalse(this.peli.kimpoanko());
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
