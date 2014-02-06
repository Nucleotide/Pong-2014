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
        int x = this.pallo.getX();
        int y = this.pallo.getY();
        
        assertEquals(390, x);
        assertEquals(215, y);
    }
    
    @Test
    public void pallollaOnAluksiSuunta() {
        int suunta = this.pallo.getSuunta();
        assertTrue("Suunta olemassa", suunta == 350 || suunta == 190);
    }
    
    @Test
    public void uusiPallonAsettaaPaikanOikein() {
        this.pallo.uusiPallo(1);
        int x = this.pallo.getX();
        int y = this.pallo.getY();
        
        assertEquals(390, x);
        assertEquals(215, y);
    }
    
    @Test
    public void suunnanAsetusMuuttaaSuuntaa() {
        this.pallo.setSuunta(110);
        int eka = this.pallo.getSuunta();
        this.pallo.setSuunta(200);
        int toka = this.pallo.getSuunta();
        assertTrue(eka != toka);
    }
    
    @Test
    public void pallonSuuntaOikeinJosPelaajaSaiPisteet() {
        this.pallo.uusiPallo(2);
        int suunta = this.pallo.getSuunta();
        assertEquals(190, suunta);
    }
    
    @Test
    public void pallonSuuntaOikeinJosVastustajaSaiPisteen() {
        this.pallo.uusiPallo(1);
        int suunta = this.pallo.getSuunta();
        assertEquals(350, suunta);        
    }
    
    @Test
    public void pallonVoiAsettaaEriPaikkaan() {
        this.pallo.setPaikka(50);
        int paikka = this.pallo.getX();
        assertEquals(50, paikka);
    }
    
    @Test
    public void palloEiLiikuUlosPelaajanPuoleltaIlmanTormaysTarkastusta() {
        this.pallo.setPaikka(130);
        this.pallo.setSuunta(180);
        for (int i = 0; i < 15; i++) {
            this.pallo.liiku();
        }
        
        int paikka = this.pallo.getX();
        assertEquals(120, paikka);
    }
    
    @Test
    public void palloEiLiikuUlosVastustajanPuoleltaIlmanTormaysTarkastusta() {
        this.pallo.setPaikka(670);
        this.pallo.setSuunta(0);
        for (int i = 0; i < 15; i++) {
            this.pallo.liiku();
        }
        
        int paikka = this.pallo.getX();
        assertEquals(680, paikka);
    }   
    
    @Test
    public void palloEiLiikuYlhaaltaPoisLaudalta() {
        this.pallo.setSuunta(90);
        for (int i = 0; i < 200; i++) {
            this.pallo.liiku();
        }
        int paikka = this.pallo.getY();
        assertEquals(50, paikka);
    }
    
    @Test
    public void palloEiLiikuAlhaaltaPoisLaudalta() {
        this.pallo.setSuunta(270);
        for (int i = 0; i < 200; i++) {
            this.pallo.liiku();
        }
        int paikka = this.pallo.getY();
        assertEquals(400, paikka);
    }    
    
    @Test
    public void seinastaKimpoaminenVaihtaaSuuntaa() {
        int alku = this.pallo.getSuunta();
        this.pallo.kimpoaSeinasta();
        int uusi = this.pallo.getSuunta();
        assertTrue(alku != uusi);
    }
    
    @Test
    public void kimpoaminenPelaajanMailastaVaihtaaSuuntaa() {
        int alku = this.pallo.getSuunta();
        this.pallo.kimpoaMailasta(1);
        int uusi = this.pallo.getSuunta();
        assertTrue(alku != uusi);        
    }
    
    @Test
    public void kimpoaminenVastustajanMailastaVaihtaaSuuntaa() {
        int alku = this.pallo.getSuunta();
        this.pallo.kimpoaMailasta(2);
        int uusi = this.pallo.getSuunta();
        assertTrue(alku != uusi);        
    }    
    
    @Test
    public void pelaajaLyoAlhaaltaTulevaaPalloa() {
        this.pallo.setSuunta(170);
        this.pallo.kimpoaMailasta(1);
        int suunta = this.pallo.getSuunta();
        assertEquals(10 ,suunta);
    }

    @Test
    public void pelaajaLyoYlhaaltaTulevaaPalloa() {
        this.pallo.setSuunta(250);
        this.pallo.kimpoaMailasta(1);
        int suunta = this.pallo.getSuunta();
        assertEquals(290 ,suunta);
    }    
    
    @Test
    public void vastustajaLyoAlhaaltaTulevaaPalloa() {
        this.pallo.setSuunta(80);
        this.pallo.kimpoaMailasta(4);
        int suunta = this.pallo.getSuunta();
        assertEquals(100 ,suunta);
    }

    @Test
    public void vastustajaLyoYlhaaltaTulevaaPalloa() {
        this.pallo.setSuunta(350);
        this.pallo.kimpoaMailasta(3);
        int suunta = this.pallo.getSuunta();
        assertEquals(190 ,suunta);
    }       
    
    @Test
    public void seinaKimmotusYlhaallaVasemmalta() {
        this.pallo.setSuunta(80);
        for (int i = 0; i  < 20; i++) {
            this.pallo.liiku();            
        }
        this.pallo.kimpoaSeinasta();
        int suunta = this.pallo.getSuunta();
        assertEquals(280, suunta);
    }
    
    @Test
    public void seinaKimmotusAlhaallaOikealta() {
        this.pallo.setSuunta(260);
        for (int i = 0; i  < 20; i++) {
            this.pallo.liiku();            
        }
        this.pallo.kimpoaSeinasta();
        int suunta = this.pallo.getSuunta();
        assertEquals(100, suunta);
    }    
    
    @Test
    public void seinaKimmotusAlhaallaVasemmalta() {
        this.pallo.setSuunta(280);
        for (int i = 0; i  < 20; i++) {
            this.pallo.liiku();            
        }
        this.pallo.kimpoaSeinasta();
        int suunta = this.pallo.getSuunta();
        assertEquals(80, suunta);
    }
    
    @Test
    public void seinaKimmotusYlhaallaOikealta() {
        this.pallo.setSuunta(105);
        for (int i = 0; i  < 20; i++) {
            this.pallo.liiku();            
        }
        this.pallo.kimpoaSeinasta();
        int suunta = this.pallo.getSuunta();
        assertEquals(255, suunta);
    }      
}
