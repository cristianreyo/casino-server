/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author miguel 
 */
public class Servidor {

    
    public static void main(String[] args) {
        
        Socket cliente;
        
        try{
            //Reserva el puerto de la maquina
            ServerSocket servidor = new ServerSocket(4444);
            
            while(true){
                //Se detiene la aplicacion a la espera de alguna peticion de algun cliente
                cliente = servidor.accept();

                //Se crea una hebra para manejar la peticion
                (new Despachador(cliente)).start();
            }
            
            
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
