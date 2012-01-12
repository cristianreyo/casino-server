/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.ruleta;
import java.util.Random;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gonzalo
 */

public class Ruleta {
    static final int CUADRADOS = 38;
    static final int SALDO_INICIAL = 10000;
    static final int SALDO_MINIMO = -10000;
    
    int [] numerosRuleta;
    boolean [] coloresRuleta;
    
    public Ruleta(int [] numerosRuleta, boolean [] coloresRuleta){
        int numero = 0;
        int posicion = 0;
        boolean color = false;
        numerosRuleta[0] = 0;
        
        //Rellena el vector con los numeros del tapete
        for(posicion = 1; posicion < CUADRADOS; posicion++){
            numerosRuleta[posicion] = numero;
            numero++;
        }
       
        //Distribuir los colores de la ruleta altenandolos segun el tapete
        color = false;
        for(posicion = 0; posicion <= 12; posicion++){
            coloresRuleta[posicion] = color;
            color = !color;
        }
        for(posicion = 12; posicion <= 20; posicion++){
            coloresRuleta[posicion] = color;
            color = !color;
        }
        for(posicion = 20; posicion <= 29; posicion++){
            coloresRuleta[posicion] = color;
            color = !color;
        }
        for(posicion = 29; posicion < CUADRADOS; posicion++){
            coloresRuleta[posicion] = color;
        }
    }

    public int giraRuleta (){
        
        int posicion;
        Random random = new Random();
        //Calcular una posicion aleatoria de la ruleta
        posicion = random.nextInt(CUADRADOS);
        return posicion;
    }
    
}
