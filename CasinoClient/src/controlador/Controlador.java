/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vista.CasinoView;
import juego.CartaMasAlta.Carta_CartaAlta;
import modelo.Casino;

/**
 * @author Miguel Angel Fuentes Cardenas
 */
public class Controlador {
    
    private Casino casino;
    
    public Controlador(Casino casino){
        this.casino = casino;       
    }
    
    public int entrar(String user, String password, CasinoView cv){
        int p=casino.entrar(user, password);
        if(p!=-1){
            //SELECCIONO PANEL
            cv.showPanel("selectgame");
        }
        return p;
    }
    
    public int registrarse(String user, String password, CasinoView cv){
        int p=casino.registrarse(user, password);
        if(p!=-1){
            //SELECCIONO PANEL
            cv.showPanel("selectgame");
        }
        return p;
    }
    
    public void seleccionaJuego(String juego, CasinoView cv){
        this.casino.seleccionarJuego(juego);
        cv.showPanel(juego);
    }
    
    public void ShowMensaje(String mensaje){
        this.casino.setMensaje(mensaje);
    }
    
    public void CartaAlta(int ap){
        Carta_CartaAlta carta;
        String msj;
        
        //ENVIO APUESTA
        this.casino.setApuesta(ap);                    
        
        //OBTENGO CARTA
        carta = this.casino.getCarta_CartaAlta();
        
        //OBTENGO MENSAJE
        msj = this.casino.readMensaje();
        System.out.println(msj);
        casino.setMensaje(msj);
        
        //OBTENGO PUNTUACION NUEVA
        msj = this.casino.readMensaje();
        System.out.println("Puntuacion total = "+msj);
        
        
        //ACTUALIZO LOS PUNTOS DEL JUGADOR
        casino.getJugador().setPuntos(Integer.parseInt(msj));
        
    }
    
    public void WriteConfiguration(){
        
    }
}
