/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Fernando
 */
import Vista.InterfazPoker;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import juego.Poker.ModeloPoker;
import general.Casino;

public class ControladorPoker {

    private InterfazPoker vista;
    private ModeloPoker modelo;
    private Casino casino;

    public ControladorPoker(ModeloPoker modelo, InterfazPoker vista, Casino casino) {
        this.modelo = modelo;
        this.vista = vista;
        this.casino = casino;
        vista.addApuestaListener(new ApuestaListener());
        vista.addPasoListener(new PasoListener());
        vista.addRestoListener(new RestoListener());
        vista.addConectarListener(new ConectarListener());
    }

    class ApuestaListener extends Thread implements ActionListener {

        public void run() {
            while (true) {
                modelo.setOis(casino.getObjectIn());
                modelo.setOos(casino.getObjectOut());
                modelo.setCantidad(vista.getCantidad());
                modelo.setPuntosAc(vista.getPuntosAcumulados());
                modelo.apostar();
                vista.setCartaMesa1(modelo.getCartaMesa1());
                vista.setCartaMesa2(modelo.getCartaMesa2());
                vista.setCartaMesa3(modelo.getCartaMesa3());
                vista.setCartaMesa4(modelo.getCartaMesa4());
                vista.setCartaMesa5(modelo.getCartaMesa5());
                vista.setCartaMia1(modelo.getCartaMia1());
                vista.setCartaMia2(modelo.getCartaMia2());
                vista.setCantidad(modelo.getCantidad());
                vista.setPuntosAcumulados(modelo.getPuntosAc());
                vista.setTotalMesa(modelo.getTotalMesa());
                suspend();
            }
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                start();
                System.out.println("He hecho un nuevo start()");
            } catch (Exception ek) {
                resume();

            }
        }
    }

    class PasoListener extends Thread implements ActionListener {

        public void run() {
            while(true){
            modelo.setOis(casino.getObjectIn());
            modelo.setOos(casino.getObjectOut());
            modelo.setCantidad(vista.getCantidad());
            modelo.setPuntosAc(vista.getPuntosAcumulados());
            modelo.setTotalMesa(vista.getTotalMesa());
            modelo.paso();
            vista.setCartaMesa1(modelo.getCartaMesa1());
            vista.setCartaMesa2(modelo.getCartaMesa2());
            vista.setCartaMesa3(modelo.getCartaMesa3());
            vista.setCartaMesa4(modelo.getCartaMesa4());
            vista.setCartaMesa5(modelo.getCartaMesa5());
            vista.setCartaMia1(modelo.getCartaMia1());
            vista.setCartaMia2(modelo.getCartaMia2());
            vista.setCantidad(modelo.getCantidad());
            vista.setPuntosAcumulados(modelo.getPuntosAc());
            vista.setTotalMesa(modelo.getTotalMesa());
            suspend();
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
             try {
                start();
                System.out.println("He hecho un nuevo start()");
            } catch (Exception ek) {
                resume();

            }
        }
    }

    class RestoListener extends Thread implements ActionListener {

        public void run() {
            while(true){
            modelo.setOis(casino.getObjectIn());
            modelo.setOos(casino.getObjectOut());
            modelo.setCantidad(vista.getCantidad());
            modelo.setPuntosAc(vista.getPuntosAcumulados());
            modelo.setTotalMesa(vista.getTotalMesa());
            modelo.paso();
            vista.setCartaMesa1(modelo.getCartaMesa1());
            vista.setCartaMesa2(modelo.getCartaMesa2());
            vista.setCartaMesa3(modelo.getCartaMesa3());
            vista.setCartaMesa4(modelo.getCartaMesa4());
            vista.setCartaMesa5(modelo.getCartaMesa5());
            vista.setCartaMia1(modelo.getCartaMia1());
            vista.setCartaMia2(modelo.getCartaMia2());
            vista.setCantidad(modelo.getCantidad());
            vista.setPuntosAcumulados(modelo.getPuntosAc());
            vista.setTotalMesa(modelo.getTotalMesa());
            suspend();
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
             try {
                start();
                System.out.println("He hecho un nuevo start()");
            } catch (Exception ek) {
                resume();

            }
        }
    }

    class ConectarListener extends Thread implements ActionListener {

        public void run() {
            while(true){
                modelo.setOis(casino.getObjectIn());
            modelo.setOos(casino.getObjectOut());
            modelo.conectar();
            vista.setPuntosAcumulados(modelo.getPuntosAc());
            vista.setCartaMesa1(modelo.getCartaMesa1());
            vista.setCartaMesa2(modelo.getCartaMesa2());
            vista.setCartaMesa3(modelo.getCartaMesa3());
            vista.setCartaMesa4(modelo.getCartaMesa4());
            vista.setCartaMesa5(modelo.getCartaMesa5());
            vista.setCartaMia1(modelo.getCartaMia1());
            vista.setCartaMia2(modelo.getCartaMia2());
            suspend();
            }
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
             try {
                start();
                System.out.println("He hecho un nuevo start()");
            } catch (Exception ek) {
                resume();

            }
        }
    }
}
