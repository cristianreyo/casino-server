/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.CartaMasAlta;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Miguel Angel Fuentes Cardenas
 */
public class Baraja_CartaAlta {
    ArrayList<Carta_CartaAlta> cartas;
    Random aleatorio = new Random(); 
    
    public Baraja_CartaAlta(){
        int i;
        
        cartas = new ArrayList<Carta_CartaAlta>();
        
        for(i=1;i<=13;i++)
            cartas.add(new Carta_CartaAlta("PICAS", i));
        
        for(i=1;i<=13;i++)
            cartas.add(new Carta_CartaAlta("CORAZONES", i));
        
        for(i=1;i<=13;i++)
            cartas.add(new Carta_CartaAlta("TREBOLES", i));
        
        for(i=1;i<=13;i++)
            cartas.add(new Carta_CartaAlta("ROMBOS", i));
    }
    
    /**
     * Saca aleatoriamente una carta de la baraja
     * @return 
     */
    public Carta_CartaAlta sacarCarta(){
        int pos = aleatorio.nextInt(cartas.size());
        Carta_CartaAlta c=cartas.remove(pos);
        return c;
    }
    
}
