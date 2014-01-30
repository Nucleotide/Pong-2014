package pong2014.logiikka;

import java.util.Random;

/**
 *
 * @author joonaslaakkonen
 */
class Pallo {
    
    private double x;
    private double y;
    private double suunta;
    
    
    public Pallo() {
        this.x = 29.0;
        this.y = 14.0;
        Random random = new Random();
        int alkuSuunta = random.nextInt(2);
        this.alunSuunta(alkuSuunta);
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void liiku() {
        double radiaanit = Math.toRadians(this.suunta);
        double liikeX = Math.cos(radiaanit);
        double liikeY = Math.sin(radiaanit) * -1;
        this.rajatapausLeveys(liikeX);
        this.rajatapausKorkeus(liikeY);
    }
    
    public void setSuunta(double uusiSuunta) {
        this.suunta = uusiSuunta;
    }
    
    public double getSuunta() {
        return this.suunta;
    }
    
    public void uusiPallo(double suunta) {
        this.x = 29.0;
        this.y = 14.0;
        if (suunta == 1.0) {
            this.setSuunta(350.0);
        } else {
            this.setSuunta(190.0);
        }
    }
    
    public void setPaikka(double paikka) {
        this.x = paikka;
    }
    
    public void kimpoaSeinasta(){
        this.setSuunta(this.seinakimmotuksenSuunta());
    }

    private void alunSuunta(int alkuSuunta) {
        if (alkuSuunta == 1) {
            this.setSuunta(350.0);
        } else {
            this.setSuunta(190.0);
        }
    }

    private void rajatapausLeveys(double liikeX) {
        if (this.x + liikeX <= 2.0) {
            this.x = 2.0;
        } else if (this.x + liikeX >= 56.0) {
            this.x = 56.0;
        } else {
            this.x += liikeX;
        }
    }

    private void rajatapausKorkeus(double liikeY) {
        if (this.y + liikeY <= 0.0) {
            this.y = 0.0;
        } else if (this.y + liikeY >= 28.0) {
            this.y = 28.0;
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

    private double seinakimmotuksenSuunta() {
        double uusiSuunta = 0.0;
        double erotus = 0.0;
        if (this.y == 0 && this.suunta < 90.0) {
            erotus = 90.0 - this.suunta;
            uusiSuunta = 270.0 + erotus ;
        } else if (this.y == 0 && this.suunta < 180.0 && this.suunta > 90.0) {
            erotus = 180 - this.suunta;
            uusiSuunta = 180.0 + erotus;
        } else if (this.y == 28.0 && this.suunta > 270.0) {
            erotus = this.suunta - 270.0;
            uusiSuunta = 90.0 - erotus;
        } else {
            erotus = 270.0 - this.suunta;
            uusiSuunta = 90.0 + erotus;
        }
        return uusiSuunta;
    }

    private double pelaajaLyo() {
        double uusiSuunta = 0.0;
        double erotus = 0.0;
        if (this.suunta > 180.0) {
            erotus = 270.0 - this.suunta;
            uusiSuunta = 270.0 + erotus;
        } else {
            erotus = 180.0 - this.suunta;
            uusiSuunta = 0.0 + erotus;
        }
        return uusiSuunta;
    }

    private double vastustajaLyo() {
        double uusiSuunta = 0.0;
        double erotus = 0.0;
        if (this.suunta < 90.0) {
            erotus = 90.0 - this.suunta;
            uusiSuunta = 90.0 + erotus;
        } else {
            erotus = 360.0 - this.suunta;
            uusiSuunta = 180.0 + erotus;
        }
        return uusiSuunta;
    }
    
}
