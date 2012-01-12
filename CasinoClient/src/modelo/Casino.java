/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import juego.CartaMasAlta.Carta_CartaAlta;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Properties;

/**
 *
 * @author Miguel Angel Fuentes Cardenas
 */
public class Casino extends Observable{
    
    private String mensaje;
    private Socket servidor;
    private ArrayList<String> juegos;

    
    private ObjectOutputStream objectOut;
    private ObjectInputStream objectIn;
    
    private Jugador jugador;
    
    
    public Casino(){
      super();
      juegos=null;    
      jugador = new Jugador();
    }
    
    /**
     * Funcion que inicializa la conexion con el servidor
     * 
     * @param user
     * @param password
     * @return 
     */
    public int entrar(String user, String password){
        String server =null;
        int port = -1;
        int puntos;
        
        
        try{
            
            if(this.servidor==null || !(this.servidor.isConnected()))
            {
                //SE CARGA CONFIGURACION DE CONEXION
                Properties defProps = new Properties();
                InputStream f = new FileInputStream("Recursos/config.properties");
                defProps.load(f);

                server = defProps.getProperty("server");
                port = (Integer.parseInt(defProps.getProperty("port")));

                f.close();

                //CONECTO CON EL SERVIDOR
                this.servidor = new Socket(server,port);
                
                //CREO FLUJO DE SALIDA
                this.objectOut = new ObjectOutputStream(servidor.getOutputStream());
                
                //CREO FLUJO DE ENTRADA
                this.objectIn = new ObjectInputStream(servidor.getInputStream());
            }
            

            
            //ENVIO ORDEN DE LOGUEO Y JUGADOR
            this.objectOut.writeObject("LOGIN");
            this.objectOut.writeObject(user);
            this.objectOut.writeObject(password);
            
            //OBTENGO LOS PUNTOS DEL JUGADOR            
            puntos = (Integer) objectIn.readObject();        
            
            //CARGO LA LISTA DE JUEGOS
            if(puntos!=-1) cargarJuegos();
            
            jugador.setNombre(user);
            jugador.setPuntos(puntos);
            
            
            return puntos;
            
            
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(UnknownHostException e){
            System.out.println("No puedo encontrar el host");
        }catch(IOException e){
            this.setMensaje("ERROR AL CONECTAR CON EL SERVIDOR");
            e.printStackTrace();
        }
        
        return -1;
    }
    
    
    public int registrarse(String user, String password){
        String server =null;
        int port = -1;
        int puntos;
        
        
        try{
            
            if(this.servidor==null || !(this.servidor.isConnected()))
            {
                //SE CARGA CONFIGURACION DE CONEXION
                Properties defProps = new Properties();
                InputStream f = new FileInputStream("Recursos/config.properties");
                defProps.load(f);

                server = defProps.getProperty("server");
                port = (Integer.parseInt(defProps.getProperty("port")));

                f.close();

                //CONECTO CON EL SERVIRO
                this.servidor = new Socket(server,port);
                
                //CREO FLUJO DE SALIDA
                this.objectOut = new ObjectOutputStream(servidor.getOutputStream());
                
                //CREO FLUJO DE ENTRADA
                this.objectIn = new ObjectInputStream(servidor.getInputStream());
            }
            

            
            //ENVIO ORDEN DE LOGUEO Y JUGADOR
            this.objectOut.writeObject("REGISTRAR");
            this.objectOut.writeObject(user);
            this.objectOut.writeObject(password);
            
            //OBTENGO LOS PUNTOS DEL JUGADOR 
            puntos = (Integer) objectIn.readObject();
            
            //CARGO LA LISTA DE JUEGOS
            if(puntos!=-1) cargarJuegos();
            
            
            jugador.setNombre(user);
            jugador.setPuntos(puntos);
            
                       
            return puntos;        
            
            
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(UnknownHostException e){
            System.out.println("No puedo encontrar el host");
        }catch(IOException e){
            this.setMensaje("ERROR AL CONECTAR CON EL SERVIDOR");
            e.printStackTrace();
        }
        
        return -1;
    }
    
    
    /**
     * Cargo los juegos y notifico a los observadores
     */
    public void cargarJuegos(){
        
        try{
            this.juegos = (ArrayList<String>) objectIn.readObject();
            setChanged();
            notifyObservers();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
    
    /**
     * Envia al servidor el juego seleccionado
     * 
     * @param juego 
     */
    public void seleccionarJuego(String juego){
        try{
            this.objectOut.writeObject(juego);
        }catch(IOException e ){
            e.printStackTrace();
        }
    }
    
    
    /**
     * Envia la apuesta
     * @param ap 
     */
    public void setApuesta(int ap){
        try{
            this.objectOut.writeObject(ap);
        }catch(IOException e ){
            e.printStackTrace();
        }
    }
    
    
    
    
    /**
     * Establece el mensaje y notifica a los observadores de esta variable
     * que se producido un cambio.
     * 
     * @param msj 
     */
    public void setMensaje(String msj)
    {
        mensaje=msj;
        
        setChanged();
        notifyObservers();
    }
    
    
    public String getMensaje(){
        return this.mensaje;
    }

    public ArrayList<String> getJuegos() {
        return juegos;
    }

    public Jugador getJugador() {
        return jugador;
    }
    
    public Carta_CartaAlta getCarta_CartaAlta(){
        
        Carta_CartaAlta carta=null;
        
        try{
            carta = (Carta_CartaAlta)objectIn.readObject();
            
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return carta;
    }
    
    public String readMensaje(){
        
        String mensaje=null;
        
        try{
            mensaje = (String) this.objectIn.readObject();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return mensaje;
    }
    
    public void jugarDeNuevo(){       
        
        try{
            this.objectOut.writeObject("jugar");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public Socket getSocket(){
        return this.servidor;
    }

    public ObjectInputStream getObjectIn() {
        return objectIn;
    }

    public ObjectOutputStream getObjectOut() {
        return objectOut;
    }
    
    
       
}
