/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Vista.InterfazDados;
import general.Casino;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import juego.Dados.ModeloDados;

/**
 *
 * @author Antonio
 */
public class ControladorDados {

    private InterfazDados vista;
    private ModeloDados modelo;
    private int pos;
    private int control;
    private Casino casino;
    private int saldo;
    public ControladorDados(ModeloDados modelo, InterfazDados vista, Casino casino) {
        this.modelo = modelo;
        this.vista = vista;
        this.casino = casino;
        vista.addApuestaListener(new ApuestaListener());
        vista.addTirarListener(new TirarListener());
    }

    class ApuestaListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                modelo.setOis(new DataInputStream(casino.getSocket().getInputStream()));
                modelo.setOos(new DataOutputStream(casino.getSocket().getOutputStream()));

               
                modelo.recibePrimeroDatos();
                vista.setSaldo(saldo);
                                System.out.println("saldo:   " + modelo.getSaldo());
                vista.setVisibleDlg();
                modelo.setApuesta(vista.getApuesta());
                modelo.setTipoApuesta(vista.getTipoApuesta());
               
                modelo.apostar();
                System.out.println("" + vista.getApuesta());
                vista.setTextSaldo(modelo.getSaldo() - vista.getApuesta());
                
                pos = modelo.getPos();
            } catch (Exception ex) {
                Logger.getLogger(ControladorDados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class TirarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                modelo.setOis(new DataInputStream(casino.getSocket().getInputStream()));
                modelo.setOos(new DataOutputStream(casino.getSocket().getOutputStream()));
                String aviso;
                if (pos > 0) {
                    JOptionPane.showMessageDialog(null, "Esperando resultado del juego");
                    modelo.recibirInformacionFinal();

                } else {
                    modelo.tirar();
                    vista.cambiarImagenDados(modelo.getD1(), modelo.getD2());
                }
                vista.setSaldo(modelo.getSaldo());
            } catch (Exception ex) {
                Logger.getLogger(ControladorDados.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
