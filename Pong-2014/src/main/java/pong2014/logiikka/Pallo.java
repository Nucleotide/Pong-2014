package pong2014.logiikka;

import java.util.Random;

/**
 *
 * @author joonaslaakkonen
 */
public class Pallo {
    
    private int x;
    private int y;
    private int suunta;
    private int korkeus;
    private int leveys;
    
    
    public Pallo() {
        this.x = 390;
        this.y = 215;
        this.korkeus = 20;
        this.leveys = 20;
        Random random = new Random();
        int alkuSuunta = random.nextInt(2);
        this.alunSuunta(alkuSuunta);
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void liiku() {
        double radiaanit = Math.toRadians(this.suunta);
        int liikeX = (int) (Math.cos(radiaanit) * 10);
        int liikeY = (int) (Math.sin(radiaanit) * -10);
        this.rajatapausLeveys(liikeX);
        this.rajatapausKorkeus(liikeY);
    }
    
    public void setSuunta(int uusiSuunta) {
        this.suunta = uusiSuunta;
    }
    
    public int getSuunta() {
        return this.suunta;
    }
    
    public void uusiPallo(int suunta) {
        this.x = 390;
        this.y = 215;
        if (suunta == 1) {
            this.setSuunta(350);
        } else {
            this.setSuunta(190);
        }
    }
    
    public void setPaikka(int paikka) {
        this.x = paikka;
    }
    
    public void kimpoaSeinasta(){
        this.setSuunta(this.seinakimmotuksenSuunta());
    }

    private void alunSuunta(int alkuSuunta) {
        if (alkuSuunta == 1) {
            this.setSuunta(350);
        } else {
            this.setSuunta(190);
        }
    }

    private void rajatapausLeveys(int liikeX) {
        if (this.x + liikeX <= 120) {
            this.x = 120;
        } else if (this.x + liikeX >= 680) {
            this.x = 680;
        } else {
            this.x += liikeX;
        }
    }

    private void rajatapausKorkeus(int liikeY) {
        if (this.y + liikeY <= 50) {
            this.y = 50;
        } else if (this.y + liikeY >= 400) {
            this.y = 400;
        } else {
            this.y += liikeY;
        }
    }

    public void kimpoaMailasta(int lyoja) {
        if (lyoja == 1) {
            this.setSuunta(this.pelaajaLyo());
        } else {
            this.setSuunta(this.vastustajaLyo());
        }
    }

    private int seinakimmotuksenSuunta() {
        int uusiSuunta = 0;
        int erotus = 0;
        if (this.y == 0 && this.suunta < 90) {
            erotus = 90 - this.suunta;
            uusiSuunta = 270 + erotus ;
        } else if (this.y == 0 && this.suunta < 180 && this.suunta > 90) {
            erotus = 180 - this.suunta;
            uusiSuunta = 180 + erotus;
        } else if (this.y == 28 && this.suunta > 270) {
            erotus = this.suunta - 270;
            uusiSuunta = 90 - erotus;
        } else {
            erotus = 270 - this.suunta;
            uusiSuunta = 90 + erotus;
        }
        return uusiSuunta;
    }

    private int pelaajaLyo() {
        int uusiSuunta = 0;
        int erotus = 0;
        if (this.suunta > 180) {
            erotus = 270 - this.suunta;
            uusiSuunta = 270 + erotus;
        } else {
            erotus = 180 - this.suunta;
            uusiSuunta = 0 + erotus;
        }
        return uusiSuunta;
    }

    private int vastustajaLyo() {
        int uusiSuunta = 0;
        int erotus = 0;
        if (this.suunta < 90) {
            erotus = 90 - this.suunta;
            uusiSuunta = 90 + erotus;
        } else {
            erotus = 360 - this.suunta;
            uusiSuunta = 180 + erotus;
        }
        return uusiSuunta;
    }   
    
    public int getLeveys() {
        return this.leveys;
    }
    
    public int getKorkeus() {
        return this.korkeus;
    }
}
