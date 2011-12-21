/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.net.Socket;
import java.util.ArrayList;
import juego.CartaMasAlta.CartaMasAlta;

/**
 *
 * @author miguel
 */
public class Casino {
    
    private static ArrayList<Juego> juegos = new ArrayList<Juego>();
    
    /**
     * Crea una instancia del juego Carta Alta junto con el socket del primer
     * jugador
     * 
     * @param cliente socket que se corresponde con el primer jugador
     * @return true si se ha podido creado crear el juego, false en otro caso
     */
    public static synchronized boolean createJuegoCartaAlta(Jugador cliente){
        Juego j = new CartaMasAlta();
        j.addGamer(cliente);
        return juegos.add(j);
    }
    
    
    /**
     * Remueve un jugador de un juego.
     * 
     * @param j juego del que se quiere eliminar al jugador
     * @param gamer socket del jugador
     * @return true si se ha borrado al jugador, false en otro caso
     */
    static synchronized boolean removeGamerOfJuego(Juego j, Jugador gamer){
        boolean borrado = juegos.remove(j);
        if(j.getNumGamers()==0)
            juegos.remove(j);
        return borrado;
    }
    
    
    /**
     * Anade un jugador a un juego
     * 
     * @param j juego al que se quiere anadir jugador
     * @param gamer Socket del jugador que se quiere anadir
     * @return true si se anade el jugador, false en otro caso
     */
    public static synchronized boolean addGamerToJuego(int j, Jugador gamer){
        boolean anadido=false;
        
        if(j>=0 && j<juegos.size()){
            anadido = juegos.get(j).addGamer(gamer);
        }
        
        return anadido;
    }
    
    
    public  static synchronized String listarJuegos(){
        String lista = "";
        
        for(int i=0 ; i<juegos.size() ; i++){
            lista += i+" , "+juegos.get(i)+"\n";            
        }        
        
        return lista;
    }
}
