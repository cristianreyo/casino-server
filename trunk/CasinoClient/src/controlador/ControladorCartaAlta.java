/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vista.CasinoView;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import juego.CartaMasAlta.Carta_CartaAlta;
import modelo.Casino;

/**
 * @author Miguel Angel Fuentes Cardenas
 */
public class ControladorCartaAlta {
    
    private Casino casino;
    
    public ControladorCartaAlta(Casino casino){
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
        
        //SI ES POKER CAMBIO TAMANIO DE VENTANA
        if(juego.compareToIgnoreCase("poker")==0){
            cv.setSize(1084, 468);
            cv.setLocationRelativeTo(null);
        }
        
        if(juego.compareToIgnoreCase("ruleta")==0){
            cv.setSize(427,530);
            cv.setLocationRelativeTo(null);
        }
    }
    
    public void ShowMensaje(String mensaje){
        this.casino.setMensaje(mensaje);
    }
    
    public void CartaAlta(int ap, JLabel carta_usuario, JLabel carta_crupier){
        Carta_CartaAlta carta;
        String msj;
        
        
        
        //ENVIO APUESTA
        this.casino.setApuesta(ap);                    
        
        //OBTENGO CARTA
        carta = this.casino.getCarta_CartaAlta();
        carta_usuario.setIcon(new ImageIcon(carta.getRutaImage()) );
        
        //OBTENGO CARTA DEL CRUPIER
        carta = this.casino.getCarta_CartaAlta();
        carta_crupier.setIcon(new ImageIcon(carta.getRutaImage()) );
        
        
        //OBTENGO MENSAJE
        msj = this.casino.readMensaje();
        System.out.println(msj);
        casino.setMensaje(msj);
        
        //OBTENGO PUNTUACION NUEVA
        msj = this.casino.readMensaje();
        System.out.println("Puntuacion total = "+msj);
        
        
        //ACTUALIZO LOS PUNTOS DEL JUGADOR
        casino.getJugador().setPuntos(Integer.parseInt(msj));
        //imagen_carta.setIcon(new ImageIcon("Recursos/trasera.jpg") );
        
    }
    
    public void WriteConfiguration(){
        
    }
}
