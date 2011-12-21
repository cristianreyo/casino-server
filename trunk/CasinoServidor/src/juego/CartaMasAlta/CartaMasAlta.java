/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.CartaMasAlta;

import java.io.IOException;
import juego.Juego;
import juego.Jugador;



/**
 *
 * @author miguel
 */
public class CartaMasAlta extends Juego {
    
    public CartaMasAlta(){
        super("CartaMasAlta");        
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("CartaMasAlta");
            for(Jugador j:jugadores){
                try{
                    j.writeObject(new String("hola"));
                }catch(IOException e){}
            }
        }
    }
    
    
}
