/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;



import Vista.CasinoView;
import controlador.ControladorCartaAlta;
import modelo.Casino;

/**
 *
 * @author Miguel Angel Fuentes Cardenas
 */
public class CasinoCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          java.awt.EventQueue.invokeLater(new Runnable() {
            Casino casino = new Casino();         
            ControladorCartaAlta controlador = new ControladorCartaAlta(casino);
            CasinoView view = new CasinoView(casino, controlador);
            public void run() {
                view.setVisible(true);
            }
            
        });
    }
}
