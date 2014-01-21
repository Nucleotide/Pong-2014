package pong2014.logiikka;

/**
 *
 * @author joonaslaakkonen
 */
public class Main 
{
    public static void main( String[] args ){
        
        while (true) {
            Peli uusi = new Peli();
            uusi.valikko();
            if (uusi.pelataanko()) {
                uusi.aloita();
            } else {
                break;
            }
        }
    }
}
