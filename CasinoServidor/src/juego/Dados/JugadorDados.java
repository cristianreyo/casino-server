/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.Dados;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import juego.Jugador;

/**
 *
 * @author Antonio
 */
public class JugadorDados extends Jugador {

    public int saldo;
    private int apuesta;
    private int tipoApuesta;
    private DataInputStream dis;
    private DataOutputStream dos;
    public JugadorDados(Socket cliente) {
        super(cliente);
        try {
            apuesta = 0; //Inicializo la apuesta
            saldo = 0;
            apuesta = 0;
            dis=new DataInputStream(cliente.getInputStream());
            dos=new DataOutputStream(cliente.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(JugadorDados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public JugadorDados(Jugador j){
        super(j);
        try {
            apuesta = 0; //Inicializo la apuesta
            saldo = 0;
            apuesta = 0;
            dis=new DataInputStream(cliente.getInputStream());
            dos=new DataOutputStream(cliente.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(JugadorDados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTipoApuesta() {
        return tipoApuesta;
    }

    public void setTipoApuesta(int tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }

    public int obtenerApuesta() {
        apuesta = 0; //Inicializo a cero
        try {
            apuesta = dis.readInt();
            //Leo el objeto con la apuesta

        } catch (IOException e) {
        }

        setApuesta(apuesta);

        return apuesta; //Devuelvo la apuesta
    }

    public int recibirDados() {
        int d = 0;
        try { //Los dados tiene valor

            d = dis.readInt();
        } catch (IOException ex) {
        }

        return d;
    }

    public void enviarControl(int control) {

        try { //Los dados tiene valor

            dos.writeInt(control);

        } catch (IOException ex) {
        }

    }

    public int recibirTipoApuesta() {

        int tipoAp = 0;
        try {
            tipoAp = dis.readInt();

        } catch (IOException ex) {
        }

        setTipoApuesta(tipoAp);
        return tipoAp;
    }

    public void enviarSaldo() {

        try { //Los dados tiene valor

            dos.writeInt(this.saldo);

        } catch (IOException ex) {
        }

    }

    public void enviaGanador(String ganador) {

        System.out.println("" + ganador);
        try {
            dos.writeUTF(ganador);
        } catch (IOException ex) {
        }
    }

    public void enviaAviso(String aviso) {

        System.out.println("" + aviso);
        try {
            dos.writeUTF(aviso);
        } catch (IOException ex) {
        }
    }

//    public int recibirEleccion(){
//        int eleccion = 0;
//        
//         try {
//               eleccion= ois.readInt();
//            } catch (IOException ex) {
//            }
//         return eleccion;
//    }
    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public void incrementaSaldo(int saldoGanado) {
        saldo += saldoGanado;
    }

    public void decrementaSaldo(int saldoApostado) {
        saldo -= saldoApostado;
    }

    public int getApuesta() {
        return apuesta;
    }

    public int getSaldo() {
        return saldo;
    }
}
