/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        int alkuSuunta = random.nextInt();
        this.alunSuunta(alkuSuunta);
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void liiku() {
        
    }
    
    public void setSuunta(double suunta) {
        this.suunta = suunta;
    }
    
    public void uusiPallo() {
        this.x = 138.0;
        this.y = 77.0;
    }

    private void alunSuunta(int alkuSuunta) {
        if (alkuSuunta == 1) {
            this.setSuunta(50.0);
        } else {
            this.setSuunta(265.0);
        }
    }
    
}
