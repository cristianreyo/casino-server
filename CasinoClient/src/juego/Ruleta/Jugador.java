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
    
    private Socket cliente;
    private DataInputStream ois; //Buffer de entrada
    private DataOutputStream oos;
    
    public Jugador(float ssaldo){
        saldo = ssaldo;
        /*this.cliente = cliente; //asignar un socket
        saldo = 0;
        cantidadApuesta = 0;
        tipoApuesta = 0;
        numero = 0;
        
        try {
		oos=new DataOutputStream(cliente.getOutputStream());//Inicializo el buffer de salida
		ois=new DataInputStream(cliente.getInputStream()); //Inicializo el buffer de entrada
	} catch (IOException e) {
		e.printStackTrace();
	}*/
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