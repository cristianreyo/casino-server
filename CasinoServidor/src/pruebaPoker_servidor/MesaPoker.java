package pruebaPoker_servidor;

import general.*;

import java.net.*;
import java.util.*;


public class MesaPoker extends Thread {
	
	Vector<Jugador> jugadoress=new Vector<Jugador>();
	private Vector<Carta> mesa=new Vector<Carta>();
	private Vector<Integer> apuestas=new Vector<Integer>();
	private Baraja b=new Baraja();
	private int jugadaMasAlta=0;
	
	public MesaPoker(Socket cliente){
		Jugador jugador=new Jugador(cliente);
		jugadoress.add(jugador);
	}
	
	/**
	 * Este va a ser el metodo que realmente va a jugar al poker. Se encarga de utilizar los metodos de la clase Jugador para
	 * comunicarse con el cliente.
	 */
	public void run(){
		
		int apuesta=0; //Inicialmente la apuesta es 0
		int i=3;//Contador de cartas leidas, lo inicializo a 3 porque obtengo la carta 0, 1 y2
		Vector<Jugador> jugadores=(Vector<Jugador>) jugadoress.clone();	 //Clono el vector de jugadores para poder acceder a el de forma concurrente
		//Cada iteracion de este bucle es una partida de poker
		while(true){//Bucle infinito
			mesa.clear();//Limpio la mesa de cartas
			b.barajar();//Se baraja otra vez la baraja
			apuestas.clear();//Limpio el vector de apuestas
			mesa.add(b.getCarta(0));//Se obtiene la 1� carta
			mesa.add(b.getCarta(1));//Se obtiene la 2� carta
			mesa.add(b.getCarta(2));//Se obtiene la 3� carta
			jugadores.clear();//Se limpia el vector de jugadores
			jugadores=(Vector<Jugador>) jugadoress.clone();	 //Se clona el vector de jugadores
			//Envio las tres cartas de base
			for(Jugador j:jugadores){
				j.enviarCartas(mesa);
			}
			
			//Envio a cada jugador dos cartas, y se las asigno a su objeto jugador
			for(Jugador k:jugadores){
				k.enviarCarta(b.getCarta(i));
				k.setCarta1(b.getCarta(i));
				k.enviarCarta(b.getCarta(i+1));
				k.setCarta2(b.getCarta(i+1));
				i=i+2; //Incremento el contador en +2 porque cada juador recibe dos cartas
			}
			
			//Obtengo todas las apuestas de los jugadores
			for (Jugador l:jugadores){
				apuesta=l.obtenerApuesta();//Este metodo tambian asigna la apuesta con el set
				apuestas.add(apuesta); //Las inserto en el vector de apuestas
			}
			
			//Anado una carta en la mesa
			mesa.add(b.getCarta(i));
			i++;
			//Reenvio las cartas de la mesa
			for(Jugador k:jugadores){
				k.enviarCartas(mesa);
			}
			
			//En este bucle actualizo las apuestas no las a�ado
			for (Jugador l:jugadores){
				apuesta=l.obtenerApuesta();//Este metodo tambian asigna la apuesta con el set
				int pos=jugadores.indexOf(l);//Busco la posicion del jugador que estoy iterando
				int acum=apuestas.get(pos);//Guardo lo que apost� en la jugada anterior
				apuestas.set(pos, acum+apuesta);//Lo cambio, porque la apuesta es acumulativa
			}
			
			//Anado la ultima carta de la mesa
			mesa.add(b.getCarta(i));
			i++;
			//Reenvio las cartas de la mesa
			for(Jugador k:jugadores){
				k.enviarCartas(mesa);
			}
			
			//En este bucle actualizo las apuestas no las a�ado
			for (Jugador l:jugadores){
				apuesta=l.obtenerApuesta();//Este metodo tambian asigna la apuesta con el set
				int pos=jugadores.indexOf(l);//Busco la posicion del jugador que estoy iterando
				int acum=apuestas.get(pos);//Guardo lo que apost� en la jugada anterior
				apuestas.set(pos, acum+apuesta);//Lo cambio, porque la apuesta es acumulativa
			}
			
			//Calculo la puntuacion de la jugada de cada jugador
			for(Jugador h:jugadores){
				calcularMasAlta(h);
			}
			
			//Calculo la posicion en el vector del jugador con la mejor jugada
			int max=calcularMax();
			//Lo guardo
			Jugador ganador=jugadores.get(max);
			
			//Informo a todos los jugadores que ha ganado el jugador X
			for(Jugador t:jugadores){
				t.informarVictoria(jugadoress.get(0).getCliente().getPort());
//				t.informarVictoria(ganador.getCliente().getPort());
			}
			
		}
	}
	
	/**
	 * Metodo que calcula el valor de la jugada de un jugador y lo indica en el atributo del jugador en concreto
	 * @param gamer
	 */
	private void calcularMasAlta(Jugador gamer) {
		//Comprueabo si el jugador tiene escalera real
		if(Poker.escaleraReal(gamer, mesa)){
			gamer.setValorJugada(10);//Cambio el valor de la puntuacion de la jugada
		}
		//Compruebo si tiene escalera de color
		else if(Poker.escaleraColor(gamer, mesa)){
			gamer.setValorJugada(9);//Cambio el valor de la puntuacion de la jugada
		}
		//Compruebo si tiene poker
		else if(Poker.poker(gamer, mesa)){
			gamer.setValorJugada(8);//Cambio el valor de la puntuacion de la jugada
		}
		//Compruebo si tiene full
		else if(Poker.full(gamer, mesa)){
			gamer.setValorJugada(7);//Cambio el valor de la puntuacion de la jugada
		}
		//Compruebo si tiene color
		else if(Poker.color(gamer, mesa)){
			gamer.setValorJugada(6); //Cambio el valor de la puntuacion de la jugada
		}
		//Compruebo si tiene escalera
		else if(Poker.escalera(gamer, mesa)){
			gamer.setValorJugada(5);//Cambio el valor de la puntuacion de la jugada
		}
		//Compruebo si tiene trio
		else if(Poker.trio(gamer, mesa)){
			gamer.setValorJugada(4);//Cambio el valor de la puntuacion de la jugada
		}
		//Compruebo si tiene dobles parejas
		else if(Poker.doblesParejas(gamer, mesa)){
			gamer.setValorJugada(3);//Cambio el valor de la puntuacion de la jugada
		}
		//Compruebo si tiene una pareja
		else if(Poker.pareja(gamer, mesa)){
			gamer.setValorJugada(2); //Cambio el valor de la puntuacion de la jugada
		}
		//Se elige la carta mas alta
		else if(Poker.cartaAlta(gamer, mesa)){
			//gamer.setValorJugada(1);//Cambio el valor de la puntuacion de la jugada
		}
		else{
			gamer.setValorJugada(0);//Cambio el valor de la puntuacion de la jugada
		}
		
	}
	
	/**
	 * Metodo que calcula que jugador tiene la mejor jugada
	 * basandose en los resultados del metodo anterior
	 * @return
	 */
	private int calcularMax() {
		return 0;
	}
	
	/**
	 * Metodo que a�ade un jugador al vector de jugadores
	 * @param cliente. Es el socket del jugador nuevo
	 */
	public void anadir(Socket cliente) {
		jugadoress.add(new Jugador(cliente));
	}
	
	/**
	 * Devuelve el Vector de jugadores
	 * @return
	 */
	public Vector<Jugador> getJugadoress() {
		return jugadoress;
	}
	
}
