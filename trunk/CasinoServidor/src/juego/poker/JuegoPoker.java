/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.poker;

import general.*;
import java.util.*;
import juego.Juego;
import juego.Jugador;

/**
 *
 * @author Miguel Angel Fuentes Cardenas
 */
public class JuegoPoker extends Juego {

    private ArrayList<Carta> mesa = new ArrayList<Carta>();
    private ArrayList<Integer> apuestas = new ArrayList<Integer>();
    private Baraja b = new Baraja();
//    private int jugadaMasAlta=0;
    private int suma = 0;
    private ArrayList<Jugador> jugadoresC;

    public JuegoPoker() {
        super("poker");
    }

    /**
     * Este va a ser el metodo que realmente va a jugar al poker. Se encarga de utilizar los metodos de la clase Jugador para
     * comunicarse con el cliente.
     */
    public void run() {
        System.out.println("En el run del juegoPoker");
        int apuesta = 0; //Inicialmente la apuesta es 0
        int i = 3;//Contador de cartas leidas, lo inicializo a 3 porque obtengo la carta 0, 1 y2
        jugadoresC = (ArrayList<Jugador>) jugadores.clone();	 //Clono el vector de jugadores para poder acceder a el de forma concurrente
        //Cada iteracion de este bucle es una partida de poker
        while (true) {//Bucle infinito
            System.out.println("En el bucle infinito");
            mesa.clear();//Limpio la mesa de cartas
            b.barajar();//Se baraja otra vez la baraja
            apuestas.clear();//Limpio el vector de apuestas
            mesa.add(b.getCarta(0));//Se obtiene la 1º carta
            mesa.add(b.getCarta(1));//Se obtiene la 2ºcarta
            mesa.add(b.getCarta(2));//Se obtiene la 3º carta
            jugadoresC.clear();//Se limpia el vector de jugadores
            jugadoresC = (ArrayList<Jugador>) jugadores.clone();	 //Se clona el vector de jugadores

            //Envio las tres cartas de base
//            for(int t=0; t<jugadoresC.size();t++){
//                jugadoresC.get(t).enviarCartas(mesa);
//            }
            System.out.println("Antes de enviar cartas 3");
            for (Jugador j : jugadoresC) {
                ((JugadorPoker) j).enviarCartas(mesa);
            }
            System.out.println("Enviando dos cartas");
            //Envio a cada jugador dos cartas, y se las asigno a su objeto jugador
            for (Jugador j : jugadoresC) {
                ((JugadorPoker) j).enviarCarta(b.getCarta(i));
                ((JugadorPoker) j).setCarta1(b.getCarta(i));
                ((JugadorPoker) j).enviarCarta(b.getCarta(i + 1));
                ((JugadorPoker) j).setCarta2(b.getCarta(i + 1));
                i = i + 2; //Incremento el contador en +2 porque cada juador recibe dos cartas
            }
            System.out.println("Leyendo apuestas");
            //Obtengo todas las apuestas de los jugadores
            for (Jugador j : jugadoresC) {
                apuesta = ((JugadorPoker) j).obtenerApuesta();//Este metodo tambian asigna la apuesta con el set
                apuestas.add(apuesta); //Las inserto en el vector de apuestas
            }
            System.out.println("antes de enviar la suma");
            suma = calcularSuma();
            for (Jugador j : jugadoresC) {
                ((JugadorPoker) j).enviarCantidad(suma);
            }
            //Anado una carta en la mesa
            mesa.add(b.getCarta(i));
            i++;
            //Reenvio las cartas de la mesa
            for (Jugador j : jugadoresC) {
                ((JugadorPoker) j).enviarCartas(mesa);
            }
            System.out.println("leyendo otras apuestas");
            //En este bucle actualizo las apuestas no las añado
            for (Jugador j : jugadoresC) {
                apuesta = ((JugadorPoker) j).obtenerApuesta();//Este metodo tambian asigna la apuesta con el set
                int pos = jugadores.indexOf(((JugadorPoker) j));//Busco la posicion del jugador que estoy iterando
                int acum = apuestas.get(pos);//Guardo lo que aposto en la jugada anterior
                apuestas.set(pos, acum + apuesta);//Lo cambio, porque la apuesta es acumulativa
            }
            suma = calcularSuma();
            System.out.println("Enviando alguna cantidad");
            for (Jugador j : jugadoresC) {
                ((JugadorPoker) j).enviarCantidad(suma);
            }
            //Anado la ultima carta de la mesa
            mesa.add(b.getCarta(i));
            i++;
            System.out.println("Enviando las cartas de la mesa");
            //Reenvio las cartas de la mesa
            for (Jugador j : jugadoresC) {
                ((JugadorPoker) j).enviarCartas(mesa);
            }
            System.out.println("Actualizando apuestas");
            //En este bucle actualizo las apuestas no las a�ado
            for (Jugador j : jugadoresC) {
                apuesta = ((JugadorPoker) j).obtenerApuesta();//Este metodo tambian asigna la apuesta con el set
                int pos = jugadores.indexOf(((JugadorPoker) j));//Busco la posicion del jugador que estoy iterando
                int acum = apuestas.get(pos);//Guardo lo que aposto en la jugada anterior
                apuestas.set(pos, acum + apuesta);//Lo cambio, porque la apuesta es acumulativa
            }
            System.out.println("enviando lo de la mesaa");
            suma = calcularSuma();
            for (Jugador j : jugadoresC) {
                ((JugadorPoker) j).enviarCantidad(suma);
            }
            System.out.println("calculando la jugada mas alta");
            //Calculo la puntuacion de la jugada de cada jugador
            for (Jugador j : jugadoresC) {
                calcularMasAlta(((JugadorPoker) j));
            }

            //Calculo la posicion en el vector del jugador con la mejor jugada
            int max1 = calcularMax();
            //Lo guardo
            Jugador ganador = jugadoresC.get(max1);

            //Informo a todos los jugadores que ha ganado el jugador X
            System.out.println("Antes de informar de la victoria");
            for (Jugador j : jugadoresC) {
                //		t.informarVictoria(jugadoress.get(0).getCliente().getPort());
                ((JugadorPoker) j).informarVictoria(((JugadorPoker) ganador).getCliente().getPort());
            }

        }
    }

    /**
     * Metodo que calcula el valor de la jugada de un jugador y lo indica en el atributo del jugador en concreto
     * @param gamer
     */
    private void calcularMasAlta(JugadorPoker gamer) {
        //Comprueabo si el jugador tiene escalera real
        if (Poker.escaleraReal(gamer, mesa)) {
            gamer.setValorJugada(10);//Cambio el valor de la puntuacion de la jugada
        } //Compruebo si tiene escalera de color
        else if (Poker.escaleraColor(gamer, mesa)) {
            gamer.setValorJugada(9);//Cambio el valor de la puntuacion de la jugada
        } //Compruebo si tiene poker
        else if (Poker.poker(gamer, mesa)) {
            gamer.setValorJugada(8);//Cambio el valor de la puntuacion de la jugada
        } //Compruebo si tiene full
        else if (Poker.full(gamer, mesa)) {
            gamer.setValorJugada(7);//Cambio el valor de la puntuacion de la jugada
        } //Compruebo si tiene color
        else if (Poker.color(gamer, mesa)) {
            gamer.setValorJugada(6); //Cambio el valor de la puntuacion de la jugada
        } //Compruebo si tiene escalera
        else if (Poker.escalera(gamer, mesa)) {
            gamer.setValorJugada(5);//Cambio el valor de la puntuacion de la jugada
        } //Compruebo si tiene trio
        else if (Poker.trio(gamer, mesa)) {
            gamer.setValorJugada(4);//Cambio el valor de la puntuacion de la jugada
        } //Compruebo si tiene dobles parejas
        else if (Poker.doblesParejas(gamer, mesa)) {
            gamer.setValorJugada(3);//Cambio el valor de la puntuacion de la jugada
        } //Compruebo si tiene una pareja
        else if (Poker.pareja(gamer, mesa)) {
            gamer.setValorJugada(2); //Cambio el valor de la puntuacion de la jugada
        } //Se elige la carta mas alta
        else if (Poker.cartaAlta(gamer, mesa)) {
            //gamer.setValorJugada(1);//Cambio el valor de la puntuacion de la jugada
        } else {
            gamer.setValorJugada(0);//Cambio el valor de la puntuacion de la jugada
        }

    }

    /**
     * Metodo que calcula que jugador tiene la mejor jugada
     * basandose en los resultados del metodo anterior
     * @return
     */
    private int calcularMax() {
        int posicion = 0;
        int max = 0;
        for (Jugador j : jugadoresC) {
            System.out.println("jugadorC:"+((JugadorPoker) j).getNombre());
            if (((JugadorPoker) j).getValorJugada() > max) {
                max = ((JugadorPoker) j).getValorJugada();
                posicion = jugadoresC.indexOf(((JugadorPoker) j));
            }
        }
        return posicion;
    }

    /**
     * Devuelve el Vector de jugadores
     * @return
     */
//	public Vector<Jugador> getJugadoress() {
//		return jugadoress;
//	}
    private int calcularSuma() {
        int apuesta = 0;
        for (int j : apuestas) {
            apuesta += j;
        }
        return apuesta;
    }
}
