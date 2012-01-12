package juego.ruleta;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import juego.Juego;
import juego.Jugador; 

/**
 * Clase que gestiona a cada cliente de la mesa de juegos. Al heredar de hilo,
 * para cada mesa de juego se crea un nuevo hilo
 *
 * @author
 *
 */
public class JuegoRuleta extends Juego implements Runnable {

    //Vector<Socket> sockets = new Vector<Socket>(); //Vector con todos los sockets de los clientes.
    Vector<Integer> apuestas = new Vector<Integer>(); //Vector con los datos que lee de los clientes (tipo apuesta)
    Vector<Float> cantidades = new Vector<Float>(); //Vector con las cantidades que se apuesta
    Vector<Integer> tipoApuestas = new Vector<Integer>(); //Vector con los números de tablero o ceros o unos
    float apostado = 0;
    int premio = 0;
    static final int CUADRADOS = 38;
    int numerosRuleta[] = new int[CUADRADOS];
    boolean coloresRuleta[] = new boolean[CUADRADOS];
    Ruleta rula = new Ruleta(numerosRuleta, coloresRuleta);  //inicializar ruleta

    /**
     * Metodo constructor de la clase que anyade el socket al vector e inicia el
     * hilo
     *
     * @param cliente
     */
    public JuegoRuleta() {
        super("ruleta");
    }

    /**
     * Al ser una clase que hereda de Thread, necesita el metodo run, aunque no
     * haga nada
     */
    @Override
    public void run() {
        DataInputStream is; //Creo un buffer de entrada
        DataOutputStream os; //Creo un buffer de salida
        DataOutputStream oss;
        int entrada = 0;
        float apuesta = 0;
        int tipoApuesta = 0;
        ArrayList<Jugador> clon = (ArrayList<Jugador>) jugadores.clone();
        int bola = 0;
        int cont = 0;
        boolean ganador = false;
        int posicion = 0; //ultimo haciendo pruebas
        boolean color; //negro
        String resColor = "";

        while (true) {
            clon.clear();
            clon = (ArrayList<Jugador>) jugadores.clone();  //Clono el vector, esto es porque no puedo iterar sobre un objeto que esta siendo modificado (excepcion de concurrencia)
            for (Jugador c : clon) {//Para cada elemento del vector de sockets
                try {
                    is = new DataInputStream(c.getSocket().getInputStream());//Inicializo el buffer con el socket correspondiente
                   
                    entrada = is.readInt();
                    System.out.println("Apuesta: " + entrada);//Lo muestro por pantalla
                    apuestas.add(entrada);//Lo anyado al vector de entrada

                    tipoApuesta = is.readInt();
                    System.out.println("Números, Rojo/Negro, Par/Impar, Bajos/Altos: " + tipoApuesta);
                    tipoApuestas.add(tipoApuesta);

                    apuesta = is.readFloat();
                    System.out.println("Cantidad apuesta: " + apuesta);
                    cantidades.add(apuesta);

                } catch (IOException e) {
                }

            }
            //Gira la ruleta y la bola cae en un número
            posicion = rula.giraRuleta();
            bola = numerosRuleta[posicion];
            color = coloresRuleta[bola];
            
            //Gestión del resultado de la ruleta
            for (Jugador c : clon ) {
                try {
                    if (bola <= 0) {
                        os = new DataOutputStream(c.getSocket().getOutputStream());
                        oss = new DataOutputStream(c.getSocket().getOutputStream());
                        os.writeUTF("La banca gana,jugadores pierden" + bola);
                        os.writeBoolean(false);
                        os.writeFloat(cantidades.elementAt(cont));
                    } else {
                        os = new DataOutputStream(c.getSocket().getOutputStream());//Creo el buffer para la salida de los datos
                        oss = new DataOutputStream(c.getSocket().getOutputStream());
                        if (apuestas.elementAt(cont) == 1) {
                            int resultado = primeraApuesta(bola);
                            ganador = encontrarGanador(bola, cont);
                            if (ganador) {
                                os.writeUTF("Ha ganado el numero: " + resultado);//Envio una cadena con el ganador
                                os.writeBoolean(ganador); //Enviar al cliente para indicarle al cliente que hacer con lo apostado
                                os.writeFloat(cantidades.elementAt(cont));//devuelve saldo apostado por cada jugador en cliente
                            } else {
                                os.writeUTF("Pierde a numero");//Envio una cadena
                                os.writeBoolean(ganador); //Enviar al cliente para indicarle al cliente que hacer con lo apostado
                                os.writeFloat(cantidades.elementAt(cont));//devuelve saldo apostado por cada jugador en cliente

                            }
                        }
                        if (apuestas.elementAt(cont) == 3) {
                            ganador = terceraApuesta(bola, cont);
                            if (ganador) {
                                os.writeUTF("Gana a par/impar");//Envio una cadena con el ganador
                                os.writeBoolean(ganador); //Enviar al cliente para indicarle al cliente que hacer con lo apostado
                                os.writeFloat(cantidades.elementAt(cont));//devuelve saldo apostado por cada jugador en cliente
                            } else {
                                os.writeUTF("Pierde a par/impar");//Envio una cadena
                                os.writeBoolean(ganador); //Enviar al cliente para indicarle al cliente que hacer con lo apostado
                                os.writeFloat(cantidades.elementAt(cont));//devuelve saldo apostado por cada jugador en cliente


                            }
                        }
                        if (apuestas.elementAt(cont) == 4) {
                            ganador = cuartaApuesta(bola, cont);
                            if (ganador) {
                                os.writeUTF("Gana a bajos/altos");//Envio una cadena con el ganador
                                os.writeBoolean(ganador); //Enviar al cliente para indicarle al cliente que hacer con lo apostado
                                os.writeFloat(cantidades.elementAt(cont));//devuelve saldo apostado por cada jugador en cliente
                            } else {
                                os.writeUTF("Pierde a bajos/altos");//Envio una cadena
                                os.writeBoolean(ganador); //Enviar al cliente para indicarle al cliente que hacer con lo apostado
                                os.writeFloat(cantidades.elementAt(cont));//devuelve saldo apostado por cada jugador en cliente


                            }
                        }
                        if (apuestas.elementAt(cont) == 2) {
                            ganador = segundaApuesta(color, cont);
                            if (ganador) {
                                os.writeUTF("Gana a color");//Envio una cadena con el ganador
                                os.writeBoolean(ganador); //Enviar al cliente para indicarle al cliente que hacer con lo apostado
                                os.writeFloat(cantidades.elementAt(cont));//devuelve saldo apostado por cada jugador en cliente
                                System.out.println("apuesta ganada");
                            } else {
                                os.writeUTF("Pierde a color");//Envio una cadena
                                os.writeBoolean(ganador); //Enviar al cliente para indicarle al cliente que hacer con lo apostado
                                os.writeFloat(cantidades.elementAt(cont));//devuelve saldo apostado por cada jugador en cliente
                                System.out.println("apuesta perdida");


                            }
                        }
                    }
                } catch (IOException e) {
                }
                cont++;
            }
            
            //Mensaje de la bola en el area de texto por color
            if (bola > 0) {
                if (coloresRuleta[bola]) {
                    System.out.println("(negro)");
                    resColor = "(negro)";
                } else {
                    System.out.println("(rojo)");
                    resColor = "(rojo)";
                }
            } else {
                System.out.println("(verde)");
                resColor = "(verde)";
            }
            try {
                for (Jugador d : clon) {
                    os = new DataOutputStream(d.getSocket().getOutputStream());
                    os.writeInt(bola);
                    os.writeUTF(resColor);
                }
            } catch (IOException e) {
            }
            clon.clear();//limpio el vector clon;
            
        }
    }

    /**
     * Metodo
     *
     * @return
     */
    private int primeraApuesta(int bola) { 
        int resultado = 0;
        for (int numero : tipoApuestas) {
            if (numero == bola) {
                resultado = numero;
            }
        }

        return resultado;
    }

    private boolean segundaApuesta(boolean color, int cont) {
        boolean resultado = false;      
        if (tipoApuestas.elementAt(cont) == 0 && color == false) {
            resultado = true;
        } else if (tipoApuestas.elementAt(cont) == 1 && color == true) {
            resultado = true;
        } 
        return resultado;
    }

    private boolean terceraApuesta(int bola, int cont) {
        boolean resultado = false;
        if (tipoApuestas.elementAt(cont) == 0 && bola % 2 == 0) {
            resultado = true;  
        } else if (tipoApuestas.elementAt(cont) == 1 && bola % 2 != 0) {
            resultado = true;
        }
        return resultado;
    }

    private boolean cuartaApuesta(int bola, int cont) {
        boolean resultado = false;
        if (tipoApuestas.elementAt(cont) == 0 && bola < 18) {
            resultado = true;
        } else if (tipoApuestas.elementAt(cont) == 1 && bola >= 18) {
            resultado = true;
        }
        return resultado;
    }

    private boolean encontrarGanador(int bola, int cont) {
        boolean ganador = false;
        if (tipoApuestas.elementAt(cont) == bola) {
            ganador = true;
        }
        return ganador;
    }

//    /**
//     * Metodo que anyade un socket al vector y ejecuta el juego
//     *
//     * @param conexion
//     */
//    public void anadir(Socket conexion) {
//        sockets.add(conexion);//Anyade el socket al vector
//    }
}
