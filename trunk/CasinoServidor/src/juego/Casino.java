/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.net.Socket;
import java.util.ArrayList;
import juego.CartaMasAlta.CartaMasAlta;
import juego.Dados.Dados;
import juego.poker.JuegoPoker;


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
        j.start();
        return juegos.add(j);
    }
    
    
    public static synchronized boolean createJuegoDados(Jugador cliente){
        
        Juego j=null;
        
        //Se busca la primera mesa cuyo numero de jugadores no llegue 10
        for(int i=0 ; i<juegos.size() && j==null ; i++){
            if(juegos.get(i).isGame("Dados") && juegos.get(i).getNumGamers()<10)
                j = juegos.get(i);
        }
        
        //Si no se encuentra una mesa con numero de jugadores menor a 10
        if(j==null)
        {
            j = new Dados();        //se crea una nueva mesa
            j.addGamer(cliente);    //se aniade al jugador
            j.start();              //comienza el juego
        }
        //Si se encuentra una mesa con numero de jugadores menor a 10
        else if(j.isAlive())
        {
            j.suspend();            //se suspende el juego
            j.addGamer(cliente);    //se aniade al jugador
            j.resume();             //se continua el juego
        }
        
        
        return true;
    }
    
    public static synchronized boolean createJuegoPoker(Jugador cliente){
        
        Juego j=null;
        
        for(int i=0; i<juegos.size() && j==null ; i++){
            if(juegos.get(i).toString().compareToIgnoreCase("poker")==0 
                    && juegos.get(i).getNumGamers()<10){
                j=juegos.get(i);
            }
        }
        
        if(j!=null) //tenemos juego
        {
            j.addGamer(cliente);
            try{
                j.start();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else
        {
            j=new JuegoPoker();
            j.addGamer(cliente);
            //EN ESTE NO SE DA A START
        }
        
        return true;
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
