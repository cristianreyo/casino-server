/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author miguel
 */
public class Jugador {
    private String nombre;
    private String password;
    private Socket cliente;
    private ObjectInputStream objectIn;// = new ObjectInputStream(in);
    private ObjectOutputStream objectOut;// = new ObjectOutputStream(out);

    
    public Jugador(Socket cliente){
        this.cliente = cliente;
        try{
            this.objectIn = new ObjectInputStream(cliente.getInputStream());
            this.objectOut = new ObjectOutputStream(cliente.getOutputStream());
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setNombre(String nom){
        this.nombre=nom;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void writeObject(Object obj) throws IOException{
        objectOut.writeObject(obj);
        //objectOut.flush();
    }
    
    public Object readObject() throws ClassNotFoundException, IOException{
        return objectIn.readObject();
    }
    
    public String toString(){
        return this.nombre;
    }
}
