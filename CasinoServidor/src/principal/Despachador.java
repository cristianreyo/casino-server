/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import juego.Casino;
import juego.Jugador;

/**
 *
 * @author miguel
 */
public class Despachador extends Thread{
    private Jugador cliente;
    
    public Despachador(Socket cliente)
    {
        this.cliente = new Jugador(cliente);
    }
    
    @Override
    public void run()
    {
        try{
            String comando;
            String usuario=null;
            String password=null;
            boolean login=false;
            int puntos=-1;
            
            do{
                comando = (String) cliente.readObject();

                if(comando.equalsIgnoreCase("LOGIN")){

                    //LEO USUARIO Y PASSWORD
                    usuario = (String) cliente.readObject();
                    password = (String) cliente.readObject();

                    //DEVUELVO PUNTOS
                    puntos = DataBase.getPuntos(usuario, password);
                    this.cliente.writeObject(puntos);

                }else if(comando.equalsIgnoreCase("REGISTRAR")){
                    
                    System.out.print("registrnadoo");
                    
                    //LEO USUARIO Y PASSWORD
                    usuario = (String) cliente.readObject();
                    password = (String) cliente.readObject();

                    //CREO EL USUARIO EN LA BASE DE DATOS
                    DataBase.newUsuario(usuario, password);

                    //DEVUELVO PUNTOS
                    puntos = DataBase.getPuntos(usuario, password);
                    this.cliente.writeObject(puntos);
                }else{
                    System.out.println("comando desconocido");
                }
                
                login = (puntos!=-1);
                 
            }while(!login);
            
            cliente.setNombre(usuario);
            cliente.setPassword(password);
            
            
            //ENVIO LISTA DE JUEGOS
            ArrayList<String> juegos = new ArrayList<String>();
            juegos.add("carta_alta");
            juegos.add("poker");
            juegos.add("dados");
            cliente.writeObject(juegos);
            
            
            //RECIBO JUEGO SELECCIONADO
            String juego;
            juego = (String) cliente.readObject();
            
            
            //LANZO JUEGO ASOCIADO
            
            if(juego.equals(juegos.get(0))){ //CARTA MAS ALTA
                System.out.println(juego);
                Casino.createJuegoCartaAlta(cliente);
            }
            else if(juego.equals(juegos.get(1))){ //POKER
                System.out.println(juego);
                Casino.createJuegoPoker(cliente);
            }
            else if(juego.equals(juegos.get(2))){ //DADOS
                System.out.println(juego);
                Casino.createJuegoDados(cliente);
            }
            
            
            
            
        }catch (ClassNotFoundException e) {
                    e.printStackTrace();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("Despachador finalizado");
        
    }
}
