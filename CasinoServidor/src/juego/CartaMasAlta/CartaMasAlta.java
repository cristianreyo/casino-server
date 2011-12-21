/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.CartaMasAlta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import juego.Juego;
import juego.Jugador;



/**
 *
 * @author miguel
 */
public class CartaMasAlta extends Juego {
    
    private Hashtable<Jugador,Integer> mano;
    
    public CartaMasAlta(){
        super("CartaMasAlta"); 
        mano = new Hashtable<Jugador,Integer>();
    }

    @Override
    public void run() {
        
        Random rnd = new Random();
        rnd.setSeed(3816);
        int num;
        
        for(int i=0;i<5;i++){
            System.out.println("CartaMasAlta");
            
            while(jugadores.size()<2)try {
                sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(CartaMasAlta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //reparto numeros aleatoriamente
            for(Jugador j:jugadores){
                num = rnd.nextInt(10);
                mano.put(j, num);
                try{
                    j.writeObject(""+num);
                }catch(IOException e){}
            }
            
            //Busco el ganador
            Jugador ganador=null;
            for(Jugador j:jugadores){
                if(ganador==null)
                {
                    ganador=j;
                }else{
                    if(mano.get(j) > mano.get(ganador))
                        ganador=j;
                }
            }
            
            
            //Informo a los jugadores
            for(Jugador j:jugadores){
                try{
                    if(ganador==j){
                        j.writeObject("Ganas");
                    }else{
                        j.writeObject("pierdes");
                    }
                }catch(IOException e){}
            }
            
            
        }
    }
    
    
}
