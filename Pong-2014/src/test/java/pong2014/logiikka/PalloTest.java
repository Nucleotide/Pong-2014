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
public class PalloTest {
    
    private Pallo pallo;
    
    public PalloTest() {
    }

    @Before
    public void setUp() {
        this.pallo = new Pallo();
    }
    
    @Test
    public void pallonAloitusPaikkaOikea(){
        double x = this.pallo.getX();
        double y = this.pallo.getY();
        
        assertEquals(29.0, x, 0);
        assertEquals(14.0, y, 0);
    }
    
    @Test
    public void pallollaOnAluksiSuunta() {
        double suunta = this.pallo.getSuunta();
        assertTrue("Suunta olemassa", suunta == 350.0 || suunta == 190.0);
    }
    
    @Test
    public void uusiPallonAsettaaPaikanOikein() {
        this.pallo.uusiPallo(1.0);
        double x = this.pallo.getX();
        double y = this.pallo.getY();
        
        assertEquals(29.0, x, 0);
        assertEquals(14.0, y, 0);
    }
    
    @Test
    public void suunnanAsetusMuuttaaSuuntaa() {
        this.pallo.setSuunta(110.0);
        double eka = this.pallo.getSuunta();
        this.pallo.setSuunta(200.0);
        double toka = this.pallo.getSuunta();
        assertTrue(eka != toka);
    }
    
    @Test
    public void pallonSuuntaOikeinJosPelaajaSaiPisteet() {
        this.pallo.uusiPallo(2.0);
        double suunta = this.pallo.getSuunta();
        assertEquals(190.0, suunta, 0.0);
    }
    
    @Test
    public void pallonSuuntaOikeinJosVastustajaSaiPisteen() {
        this.pallo.uusiPallo(1.0);
        double suunta = this.pallo.getSuunta();
        assertEquals(350.0, suunta, 0.0);        
    }
    
    @Test
    public void pallonVoiAsettaaEriPaikkaan() {
        this.pallo.setPaikka(3.0);
        double paikka = this.pallo.getX();
        assertEquals(3.0, paikka, 0.0);
    }
    
    @Test
    public void palloEiLiikuUlosPelaajanPuoleltaIlmanTormaysTarkastusta() {
        this.pallo.setPaikka(4.0);
        this.pallo.setSuunta(180.0);
        for (int i = 0; i < 15; i++) {
            this.pallo.liiku();
        }
        
        double paikka = this.pallo.getX();
        assertEquals(2.0, paikka, 0.0);
    }
    
    @Test
    public void palloEiLiikuUlosVastustajanPuoleltaIlmanTormaysTarkastusta() {
        this.pallo.setPaikka(55.0);
        this.pallo.setSuunta(0.0);
        for (int i = 0; i < 15; i++) {
            this.pallo.liiku();
        }
        
        double paikka = this.pallo.getX();
        assertEquals(56.0, paikka, 0.0);
    }   
    
    @Test
    public void palloEiLiikuYlhaaltaPoisLaudalta() {
        this.pallo.setSuunta(90.0);
        for (int i = 0; i < 16; i++) {
            this.pallo.liiku();
        }
        double paikka = this.pallo.getY();
        assertEquals(0.0, paikka, 0.0);
    }
    
    @Test
    public void palloEiLiikuAlhaaltaPoisLaudalta() {
        this.pallo.setSuunta(270.0);
        for (int i = 0; i < 16; i++) {
            this.pallo.liiku();
        }
        double paikka = this.pallo.getY();
        assertEquals(28.0, paikka, 0.0);
    }    
    
    @Test
    public void seinastaKimpoaminenVaihtaaSuuntaa() {
        double alku = this.pallo.getSuunta();
        this.pallo.kimpoaSeinasta();
        double uusi = this.pallo.getSuunta();
        assertTrue(alku != uusi);
    }
    
    @Test
    public void kimpoaminenPelaajanMailastaVaihtaaSuuntaa() {
        double alku = this.pallo.getSuunta();
        this.pallo.kimpoaMailasta(1);
        double uusi = this.pallo.getSuunta();
        assertTrue(alku != uusi);        
    }
    
    @Test
    public void kimpoaminenVastustajanMailastaVaihtaaSuuntaa() {
        double alku = this.pallo.getSuunta();
        this.pallo.kimpoaMailasta(2);
        double uusi = this.pallo.getSuunta();
        assertTrue(alku != uusi);        
    }    
    
    @Test
    public void pelaajaLyoAlhaaltaTulevaaPalloa() {
        this.pallo.setSuunta(170.0);
        this.pallo.kimpoaMailasta(1);
        double suunta = this.pallo.getSuunta();
        assertEquals(10.0 ,suunta, 0.0);
    }

    @Test
    public void pelaajaLyoYlhaaltaTulevaaPalloa() {
        this.pallo.setSuunta(250.0);
        this.pallo.kimpoaMailasta(1);
        double suunta = this.pallo.getSuunta();
        assertEquals(290.0 ,suunta, 0.0);
    }    
    
    @Test
    public void vastustajaLyoAlhaaltaTulevaaPalloa() {
        this.pallo.setSuunta(80.0);
        this.pallo.kimpoaMailasta(4);
        double suunta = this.pallo.getSuunta();
        assertEquals(100.0 ,suunta, 0.0);
    }

    @Test
    public void vastustajaLyoYlhaaltaTulevaaPalloa() {
        this.pallo.setSuunta(350.0);
        this.pallo.kimpoaMailasta(3);
        double suunta = this.pallo.getSuunta();
        assertEquals(190.0 ,suunta, 0.0);
    }       
    
    @Test
    public void seinaKimmotusYlhaallaVasemmalta() {
        this.pallo.setSuunta(80.0);
        for (int i = 0; i  < 20; i++) {
            this.pallo.liiku();            
        }
        this.pallo.kimpoaSeinasta();
        double suunta = this.pallo.getSuunta();
        assertEquals(280.0, suunta, 0.0);
    }
    
    @Test
    public void seinaKimmotusAlhaallaOikealta() {
        this.pallo.setSuunta(260.0);
        for (int i = 0; i  < 20; i++) {
            this.pallo.liiku();            
        }
        this.pallo.kimpoaSeinasta();
        double suunta = this.pallo.getSuunta();
        assertEquals(100.0, suunta, 0.0);
    }    
    
    @Test
    public void seinaKimmotusAlhaallaVasemmalta() {
        this.pallo.setSuunta(280.0);
        for (int i = 0; i  < 20; i++) {
            this.pallo.liiku();            
        }
        this.pallo.kimpoaSeinasta();
        double suunta = this.pallo.getSuunta();
        assertEquals(80.0, suunta, 0.0);
    }
    
    @Test
    public void seinaKimmotusYlhaallaOikealta() {
        this.pallo.setSuunta(105.0);
        for (int i = 0; i  < 20; i++) {
            this.pallo.liiku();            
        }
        this.pallo.kimpoaSeinasta();
        double suunta = this.pallo.getSuunta();
        assertEquals(255.0, suunta, 0.0);
    }      
}
