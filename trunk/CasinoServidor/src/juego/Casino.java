/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.net.Socket;
import java.util.ArrayList;
import juego.CartaMasAlta.CartaMasAlta;
import juego.Dados.JuegoDados;
import juego.Dados.JugadorDados;
import juego.poker.JuegoPoker;
import juego.poker.JugadorPoker;


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
        System.out.println("antes del bucle");
        System.out.println(juegos.size());
        
        for(int i=0; i<juegos.size() && j==null ; i++){
            System.out.println("El juego es: "+juegos.get(i));
            if(juegos.get(i).toString().compareToIgnoreCase("dados")==0 
                    && juegos.get(i).getNumGamers()<10){
                 System.out.println("Encontrado");
                j=juegos.get(i);
            }
        }
        
        System.out.println("despues del bucle");
        if(j!=null) //tenemos juego
        {
            System.out.println("en el if");
            j.addGamer(new JugadorDados(cliente));
            try{
                j.start();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("en el else");
            j=new JuegoDados();
            JugadorDados gamer = new JugadorDados(cliente);
            j.addGamer(gamer);
            juegos.add(j);

            //EN ESTE NO SE DA A START
        }
        
        return true;
    }
    
    public static synchronized boolean createJuegoPoker(Jugador cliente){
        System.out.println("antes del bucle");
        Juego j=null;
        System.out.println("antes del bucle");
        System.out.println(juegos.size());
        
        for(int i=0; i<juegos.size() && j==null ; i++){
            System.out.println("El juego es: "+juegos.get(i));
            if(juegos.get(i).toString().compareToIgnoreCase("poker")==0 
                    && juegos.get(i).getNumGamers()<10){
                 System.out.println("Encontrado");
                j=juegos.get(i);
            }
        }
        
        System.out.println("despues del bucle");
        if(j!=null) //tenemos juego
        {
            System.out.println("en el if");
            j.addGamer(new JugadorPoker(cliente));
            try{
                j.start();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("en el else");
            j=new JuegoPoker();
            JugadorPoker gamer = new JugadorPoker(cliente);
            j.addGamer(gamer);
            juegos.add(j);

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
    
    
    public static synchronized boolean deleteJuego(Juego j){
        return juegos.remove(j);
    }
    
    
    public  static synchronized String listarJuegos(){
        String lista = "";
        
        for(int i=0 ; i<juegos.size() ; i++){
            lista += i+" , "+juegos.get(i)+"\n";            
        }        
        
        return lista;
    }
}
