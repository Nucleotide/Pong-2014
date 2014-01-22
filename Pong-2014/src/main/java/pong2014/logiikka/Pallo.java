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
        this.x = 138;
        this.y = 77;
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
        double liikeY = Math.sin(radiaanit);
        this.x += liikeX;
        this.y += liikeY;
    }
    
    public void setSuunta(double uusiSuunta) {
        this.suunta = uusiSuunta;
    }
    
    public double getSuunta() {
        return this.suunta;
    }
    
    public void uusiPallo() {
        this.x = 138.0;
        this.y = 77.0;
    }
    
    public void kimpoaSeinasta(){
        if (this.y < 1.0) {
            
        } else {
            
        }
    }

    private void alunSuunta(int alkuSuunta) {
        if (alkuSuunta == 1) {
            this.setSuunta(350.0);
        } else {
            this.setSuunta(190.0);
        }
    }
    
}
