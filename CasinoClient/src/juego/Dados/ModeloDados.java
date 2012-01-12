/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.Dados;

import Vista.InterfazDados;
import java.io.*;


import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio
 */
public class ModeloDados {

    private DataInputStream ois;
    private DataOutputStream oos;
    Socket s;
    private int saldo;
    private int d1;
    private int d2;
    private int control;
    int pos;
    int tipoApuesta;
    int apuesta;
    int eleccion;

    public void setOis(DataInputStream ois) {
        this.ois = ois;
    }

    public void setOos(DataOutputStream oos) {
        this.oos = oos;
    }

    public void apostar() {
        try {

            
            System.out.println("Recibiendo posicion...");

            pos = ois.readInt();

            System.out.println("Recibiendo saldo...");

            saldo = ois.readInt();

            System.out.println("Saldo actual: " + saldo);

            oos.writeInt(tipoApuesta);
            oos.writeInt(apuesta);

            System.out.println("Apuesta enviadas...");



        } catch (IOException ex) {
            Logger.getLogger(InterfazDados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void tirar() {
        try {

            d1 = (int) (Math.random() * (0 - 5 + 1) + 5);
            d2 = (int) (Math.random() * (0 - 5 + 1) + 5);

            oos.writeInt(d1 + 1);
            oos.writeInt(d2 + 1);

            control = ois.readInt();//Si lo pongo aqui solo sale en el que esta tirando, en el otro no saldra

            if (control == 1) {
                JOptionPane.showMessageDialog(null, "Lanza de  nuevo!!!");
            } else {
                //Esperando recibir informacion sobre quien gana
                recibirInformacionFinal(); //He ganado perdido
            }

        } catch (Exception e) {
        }
    }

    public void recibirInformacionFinal() {

        try {
            JOptionPane.showMessageDialog(null, ois.readUTF());  //Gana o pierde
        } catch (IOException ex) {
            Logger.getLogger(ModeloDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public void setTipoApuesta(int tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }

    public int getEleccion() {
        return eleccion;
    }

    public int getD1() {
        return d1;
    }

    public int getD2() {
        return d2;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getPos() {
        return pos;
    }

    int getControl() {
        return control;
    }
}
