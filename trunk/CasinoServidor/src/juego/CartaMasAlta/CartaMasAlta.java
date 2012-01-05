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
import principal.DataBase;



/**
 *
 * @author miguel
 */
public class CartaMasAlta extends Juego {
    
    Jugador jugador;
    boolean jugar = true;
    
    public CartaMasAlta(){
        super("CartaMasAlta");  
    }

    @Override
    public void run() {
        
        
        int apuesta;
        Carta_CartaAlta card_jugador;
        Carta_CartaAlta card_crupier;
        Baraja_CartaAlta baraja = new Baraja_CartaAlta();
        String msj;
        
        System.out.println(this);
        
        jugador = this.jugadores.get(0);
        System.out.println("Juagador: "+jugador);
        
        while(jugar){
            try{
                //LEO APUESTA
                apuesta = (Integer) jugador.readObject();            
                System.out.println("Apuesta: "+apuesta);

                //CREO DOS CARTAS
                card_jugador = baraja.sacarCarta();
                card_crupier = baraja.sacarCarta();


                //ENVIO CARTA A USUARIO
                this.jugador.writeObject(card_jugador);


                //COMPARO CARTAS Y COMPRUEBO GANADOR
                if(card_crupier.getValor() > card_jugador.getValor()) //Jugador pierde
                {
                    //ENVIO INFORMACION
                    this.jugador.writeObject("PIERDES");
                    apuesta = apuesta * (-1);
                    DataBase.addPuntos(jugador.getNombre(), jugador.getPassword(), apuesta);
                }
                else if(card_crupier.getValor() < card_jugador.getValor()) //Jug gna
                {
                    //ENVIO INFORMACION
                    this.jugador.writeObject("GANAS");
                    DataBase.addPuntos(jugador.getNombre(), jugador.getPassword(), apuesta);
                }
                else//EMPATE
                {
                    this.jugador.writeObject("EMPATE");
                }



                //ENVIO NUEVA PUNTUACION
                Integer puntos = DataBase.getPuntos(jugador.getNombre(), jugador.getPassword());
                this.jugador.writeObject(puntos.toString());


                //¿JUGAR DE NUEVO?
                msj = (String)jugador.readObject();
                if(!msj.equalsIgnoreCase("jugar"))
                    jugar=false;
            
            }catch(IOException e){
                e.printStackTrace();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        
        
        
        
        
    }
    
    
}
