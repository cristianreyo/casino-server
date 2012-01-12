/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.Ruleta;

import java.net.Socket;
import java.io.*;


/**
 *
 * @author Gonzalo
 */
public class Jugador {
    private float saldo;
    private int cantidadApuesta;
    private int tipoApuesta; //tipo de juego sobre la ruleta
    private int numero; //el número de la ruleta o 0/1
    
    
    public Jugador(float ssaldo){
        saldo = ssaldo;
       
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    public float getSaldo(){
        return saldo;
    }
    public void setCantidadApuesta(int cantidadApuesta){
        this.cantidadApuesta = cantidadApuesta;
    }
    public int getCantidadApuesta(){
        return cantidadApuesta;
    }
    public void setTipoApuesta(int tipoApuesta){
        this.tipoApuesta = tipoApuesta;
    }
    public int getTipoApuesta(){
        return tipoApuesta;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public int getNumero(){
        return numero;
    }
    
}