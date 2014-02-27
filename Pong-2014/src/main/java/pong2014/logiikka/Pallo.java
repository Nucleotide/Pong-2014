package pong2014.logiikka;

import java.util.Random;

/**
 *
 * @author joonaslaakkonen
 * Pallo on pelin keskeinen luokka. Pallo luo pelissä käytettävän pelipallon, joka liikkuu laudalla törmäillen
 * seiniin ja pelaajan mailoihin.
 */
public class Pallo {
    
    private int x;
    private int y;
    private int suunta;
    private int korkeus;
    private int leveys;
    private int lyonti;
    
    /**
     * Konstruktori luo uuden pallon pelilaudan keskelle. Sen lisäksi pallon koko määritellään ja pallolle
     * arvotaan aluksi suunta kohti pelaajaa tai vastustajaa.
     */
    public Pallo() {
        this.x = 390;
        this.y = 215;
        this.korkeus = 20;
        this.leveys = 20;
        this.lyonti = 0;
        Random random = new Random();
        int alkuSuunta = random.nextInt(2);
        this.alunSuunta(alkuSuunta);
    }
    
    /**
     * 
     * Getterit ja setterit
     */
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setX(int minne) {
        this.x = minne;
    }    
    
    public void setY(int minne) {
        this.y = minne;
    } 
        
    public int getLeveys() {
        return this.leveys;
    }
    
    public int getLyonti() {
        return this.lyonti;
    }
    
    public void setLyonti(int arvo) {
        this.lyonti = arvo;
    }
    
    public int getKorkeus() {
        return this.korkeus;
    }
    
    public void setSuunta(int uusiSuunta) {
        this.suunta = uusiSuunta;
    }
    
    public int getSuunta() {
        return this.suunta;
    }
    
    /**
     * Metodi liikuttaa palloa pelin kutsuessa pallon liikettä. Metodi tarkastelee myös mahdolliset liikkumiset
     * seinien ja mailojen lähellä.
     */
    public void liiku() {
        double radiaanit = Math.toRadians(this.suunta);
        int liikeX = (int) (Math.cos(radiaanit) * 10);
        int liikeY = (int) (Math.sin(radiaanit) * -10);
        this.rajatapausLeveys(liikeX);
        this.rajatapausKorkeus(liikeY);
    }

    /**
     * 
     * @param suunta määrää minne suuntaan pallo lähtee. uusiPallo -metodia kutsutaan kun pelaaja tai vastustaja
     * on saanut pisteen ja pallo halutaan palauttaa pelilaudan keskelle.
     */
    public void uusiPallo(int suunta) {
        this.x = 390;
        this.y = 215;
        if (suunta == 2) {
            this.setSuunta(190);
        } else {
            this.setSuunta(350);
        }
    }
    
    /**
     * Pallolle asetetaan suunta kun se kimpoaa seinästä. Uusi suunta saadaan erillisestä metodista.
     */
    public void kimpoaSeinasta(){
        this.setSuunta(this.seinakimmotuksenSuunta());
    }
    
    /**
     * 
     * @param alkuSuunta annetaan konstruktorille ja pallo lähtee aluksi liikkeelle ko. suuntaan.
     */
    private void alunSuunta(int alkuSuunta) {
        if (alkuSuunta == 1) {
            this.setSuunta(350);
        } else {
            this.setSuunta(190);
        }
    }
    
    /**
     * 
     * @param liikeX Mikäli pallo on lähellä liikkua ulos vastustajan puolelta asetetaan paikaksi arvo, jolla
     * tarkastellaan osuuko maila palloon.
     */
    private void rajatapausLeveys(int liikeX) {
        if (this.x + liikeX <= 120 && this.x > 120) {
            this.lyonti = 1;
            this.x += liikeX;;
        } else if (this.x + liikeX >= 660 && this.x <660) {
            this.lyonti = 2;
            this.x += liikeX;
        } else {
            this.x += liikeX;
        }
    }
    
    /**
     * 
     * @param liikeY Metodi asettaa pallon y-paikaksi arvon, jolla suoritetaan kimmotus pelilaudan
     * seinästä.
     */
    private void rajatapausKorkeus(int liikeY) {
        if (this.y + liikeY <= 50) {
            this.y = 50;
        } else if (this.y + liikeY >= 380) {
            this.y = 380;
        } else {
            this.y += liikeY;
        }
    }
    
    /**
     * 
     * @param lyoja Metodi saa parametrina kumpi pelaajista yrittää lyödä palloa. Tämän jälkeen asetetaan
     * pallon suunta lyöntiyrityksen perusteella.
     */
    public void kimpoaMailasta(int miten) {
        if (miten == 1 || miten == 11) {
            this.setSuunta(this.pelaajaLyo(miten));
        } else if (miten == 2 || miten == 12) {
            this.setSuunta(this.vastustajaLyo(miten));
        }
    }
    
    /**
     * 
     * @return kertoo minne suuntaan pallon liike jatkuu kimmotuksen jälkeen.
     */
    private int seinakimmotuksenSuunta() {
        int uusiSuunta = 0;
        int erotus = 0;
        if (this.y == 0 && this.suunta < 90 && this.suunta >= 0) {
            erotus = 90 - this.suunta;
            uusiSuunta = 270 + erotus ;
        } else if (this.y == 0 && this.suunta < 180 && this.suunta > 90) {
            erotus = 180 - this.suunta;
            uusiSuunta = 180 + erotus;
        } else if (this.y == 380 && this.suunta > 270 && this.suunta <= 360 ) {
            erotus = this.suunta - 270;
            uusiSuunta = 90 - erotus;
        } else {
            erotus = 270 - this.suunta;
            uusiSuunta = 90 + erotus;
        }
        return uusiSuunta;
    }
    
    /**
     * 
     * @return palauttaa suunnan jonne pallo liikkuu pelaajan onnistuneen lyönnin jälkeen. Mikäli pallo osuu
     * mailan reunaan saattaa sen suunta muuttua hieman eritavalla.
     */
    private int pelaajaLyo(int miten) {
        int uusiSuunta = 0;
        int erotus = 0;
        if (this.suunta >= 180 && this.suunta <= 360) {
            erotus = 270 - this.suunta;
            uusiSuunta = 270 + erotus;
        } else {
            erotus = 180 - this.suunta;
            uusiSuunta = 0 + erotus;
        }
        return this.suuntaBonus(miten, uusiSuunta);
    }
    
    /**
     * 
     * @return palauttaa tiedon minne suuntaan pallo liikkuu vastustajan lyönnin jälkeen.
     */
    private int vastustajaLyo(int miten) {
        int uusiSuunta = 0;
        int erotus = 0;
        if (this.suunta < 90 && this.suunta >= 0) {
            erotus = 90 - this.suunta;
            uusiSuunta = 90 + erotus;
        } else {
            erotus = 360 - this.suunta;
            uusiSuunta = 180 + erotus;
        }
        return this.suuntaBonus(miten, uusiSuunta);
    }   
    
    /**
     * 
     * @param miten kertoo kuka palloa lyö ja missä tilanteessa
     * @param suunta kertoo pallon suunnan
     * @return palauttaa pallon suunnan, tässä saattaa olla mukana int bonuksen lisäys.
     */
    private int suuntaBonus(int miten, int suunta) {
        int suuntaus = suunta;
        Random arpa = new Random();
        int bonus = arpa.nextInt(25);
        
        if (miten == 11 || miten == 12) {
            return suuntaus + bonus;
        }
        return suuntaus;
    }
}