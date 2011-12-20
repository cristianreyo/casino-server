/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.util.ArrayList;

/**
 *
 * @author miguel
 */
public class Juego {
    private ArrayList<Jugador> jugadores;
    private String descripcion;
    
    Juego(String descripcion){
        jugadores = new ArrayList<Jugador>();
        this.descripcion = descripcion;
    }
    
    /**
     * Aniade un Jugador al juego
     * 
     * @param gamer juegador a aniadir
     * @return true si se aniade al jugador, false en otro caso
     */
    boolean addGamer(Jugador gamer){
        return this.jugadores.add(gamer);                
    }
    
    
    /**
     * Borra a un jugador del juego
     * 
     * @param gamer jugador a eliminar
     * @return true si se elimina, false en caso otro aso
     */
    boolean removeGamer(Jugador gamer){
        return jugadores.remove(gamer);
    }
    
    int getNumGamers(){
        return jugadores.size();
    }
    
    @Override
    public String toString(){
        return this.descripcion;
    }
}
