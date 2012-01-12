/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.poker;

import general.Carta;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
import juego.Jugador;

/**
 *
 * @author Miguel Angel Fuentes Cardenas
 */
public class JugadorPoker extends Jugador {

    private int apuesta; //Apuesta individual
    private int cantidadTotal; //Cantidad acumulada
    private Carta carta1; //Carta 1 del jugador
    private Carta carta2; //Carta 2 del jugador
    private int valorJugada; //Valor de su jugada

    public JugadorPoker(Socket cliente) {
        super(cliente);

        apuesta = 0; //Inicializo la apuesta
        cantidadTotal = 0; //Indico la cantidad total
        valorJugada = -1;
    }
    
    public JugadorPoker(Jugador j){
        super(j);
        apuesta = 0; //Inicializo la apuesta
        cantidadTotal = 0; //Indico la cantidad total
        valorJugada = -1;
    }
    

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    /**
     * Metodo que envia las cartas que hay en la mesa, para ello, primero indico el numero de cartas a enviar
     * y luego las envio una a una
     * @param mesa
     */
    public void enviarCartas(ArrayList<Carta> mesa) {
        try {
            objectOut.writeInt(mesa.size()); //Envio el numero de cartas
            for (Carta c : mesa) {//Para cada carta que haya en el vector
                objectOut.writeObject(c);//La envio
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Carta getCarta1() {
        return carta1;
    }

    public void setCarta1(Carta carta1) {
        this.carta1 = carta1;
    }

    public Carta getCarta2() {
        return carta2;
    }

    public void setCarta2(Carta carta2) {
        this.carta2 = carta2;
    }

    /**
     * Metodo que devuelve la apuesta de un jugador
     * @return
     */
    public int obtenerApuesta() {
        apuesta = 0; //Inicializo a cero
        try {
            String ap = (String) objectIn.readObject();//Leo el objeto con la apuesta
            apuesta = Integer.parseInt(ap);//Lo convierto a entero y lo guardo
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return apuesta; //Devuelvo la apuesta
    }

    /**
     * Metodo que envia una carta a un jugador, estas son las cartas con las que jugara, y obviamente son distintas para cada jugador
     * @param carta
     */
    public void enviarCarta(Carta carta) {
        try {
            objectOut.writeObject(carta);//Envio la carta convertida en objeto
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getCliente() {
        return cliente;
    }

    /**
     * Metodo que informa de la victoria a un jugador en concreto, y a los demas le dice quien ha ganado,
     * ahora esta implementado asi, pero cuando sea ya sea definitivo utilizare el nombre
     * @param nombre2
     */
    public void informarVictoria(int nombre2) {
        if (cliente.getPort() == nombre2) {//Comparo si es el jugador ganador, comprobando si el puerto remoto de este jugador coincide con el puerto remoto del ganador
            try {
                objectOut.writeObject("Has ganado!!"); //Le informo de que ha ganado
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                objectOut.writeObject("Ha ganado el jugador: " + nombre2); //Le digo quien ha ganado
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getValorJugada() {
        return valorJugada;
    }

    public void setValorJugada(int valorJugada) {
        this.valorJugada = valorJugada;
    }

    public void enviarCantidad(int suma) {
        try {
            objectOut.writeObject(suma); //Le informo de que ha ganado
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviarPuntos() {
        try {
            objectOut.writeObject(cantidadTotal); //Le informo de que ha ganado
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean esGanador(int port) {
        if(port==cliente.getPort()){
            return true;
        }
        return false;
    }
}
