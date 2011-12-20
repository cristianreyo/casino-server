/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.IOException;
import java.net.Socket;
import juego.Casino;
import juego.Juego;
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
    
    public void run()
    {
        try{
            
            
            //ofrece posibilidades
            cliente.writeObject("Elija opcion");
            cliente.writeObject("1.- Unirse a partida");
            cliente.writeObject("2.- partida nueva");
            
            try {
                    String d;
                    boolean terminar_desp=false;
                    do{
                        d = (String) cliente.readObject();
                        System.out.println(d);
                        
                        if(d.equals("1"))
                        {
                            cliente.writeObject("Elije juego");
                            cliente.writeObject(Casino.listarJuegos());
                            
                            d = (String) cliente.readObject();                            
                            terminar_desp = Casino.addGamerToJuego(Integer.parseInt(d), cliente);
                            
                            
                        }else if(d.equals("2"))
                        {
                            Juego j;
                            cliente.writeObject("Creas Juego Carta Alta");
                            terminar_desp = Casino.createJuegoCartaAlta(cliente);
                            
                            
                        }
                        
                    }while(!terminar_desp);
                   
                    
                    
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            
            //Cuando se de por finalizada la comunicacion se cierran los canales y el socket
            //out.close();
            //in.close();
            //cliente.close();
            
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("Despachador finalizado");
        
    }
}
