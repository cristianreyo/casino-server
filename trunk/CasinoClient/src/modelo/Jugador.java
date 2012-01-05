/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Observable;

/**
 *
 * @author Miguel Angel Fuentes Cardenas
 */
public class Jugador extends Observable {
    private String nombre;
    private int puntos;
    
    public Jugador(){
        this.nombre="";
        this.puntos=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        
        setChanged();
        notifyObservers();
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
        
        setChanged();
        notifyObservers();
    }
    
    
}
