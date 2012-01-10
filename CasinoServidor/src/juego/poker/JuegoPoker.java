/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.poker;

import general.*;
import java.util.Vector;
import juego.Juego;

/**
 *
 * @author Miguel Angel Fuentes Cardenas
 */
public class JuegoPoker extends Juego{
    
    
    private Vector<Carta> mesa=new Vector<Carta>();
    private Vector<Integer> apuestas=new Vector<Integer>();
    private Baraja b=new Baraja();
    private int jugadaMasAlta=0;
    private int suma=0;
    private Vector<JugadorPoker> jugadoresC;
    
    
    public JuegoPoker(){
        super("poker");
    }
    
    
    	/**
	 * Este va a ser el metodo que realmente va a jugar al poker. Se encarga de utilizar los metodos de la clase Jugador para
	 * comunicarse con el cliente.
	 */
	public void run(){
		
		int apuesta=0; //Inicialmente la apuesta es 0
		int i=3;//Contador de cartas leidas, lo inicializo a 3 porque obtengo la carta 0, 1 y2
		jugadoresC=(Vector<JugadorPoker>) jugadores.clone();	 //Clono el vector de jugadores para poder acceder a el de forma concurrente
		//Cada iteracion de este bucle es una partida de poker
		while(true){//Bucle infinito
			mesa.clear();//Limpio la mesa de cartas
			b.barajar();//Se baraja otra vez la baraja
			apuestas.clear();//Limpio el vector de apuestas
			mesa.add(b.getCarta(0));//Se obtiene la 1º carta
			mesa.add(b.getCarta(1));//Se obtiene la 2ºcarta
			mesa.add(b.getCarta(2));//Se obtiene la 3º carta
			jugadores.clear();//Se limpia el vector de jugadores
			jugadoresC=(Vector<JugadorPoker>) jugadores.clone();	 //Se clona el vector de jugadores
			
			//Envio las tres cartas de base
			for(JugadorPoker j:jugadoresC){
				j.enviarCartas(mesa);
			}
			
			//Envio a cada jugador dos cartas, y se las asigno a su objeto jugador
			for(JugadorPoker k:jugadoresC){
				k.enviarCarta(b.getCarta(i));
				k.setCarta1(b.getCarta(i));
				k.enviarCarta(b.getCarta(i+1));
				k.setCarta2(b.getCarta(i+1));
				i=i+2; //Incremento el contador en +2 porque cada juador recibe dos cartas
			}
			
			//Obtengo todas las apuestas de los jugadores
			for (JugadorPoker l:jugadoresC){
				apuesta=l.obtenerApuesta();//Este metodo tambian asigna la apuesta con el set
				apuestas.add(apuesta); //Las inserto en el vector de apuestas
			}
			suma=calcularSuma();
			for(JugadorPoker j:jugadoresC){
				j.enviarCantidad(suma);
			}
			//Anado una carta en la mesa
			mesa.add(b.getCarta(i));
			i++;
			//Reenvio las cartas de la mesa
			for(JugadorPoker k:jugadoresC){
				k.enviarCartas(mesa);
			}
			
			//En este bucle actualizo las apuestas no las añado
			for (JugadorPoker l:jugadoresC){
				apuesta=l.obtenerApuesta();//Este metodo tambian asigna la apuesta con el set
				int pos=jugadores.indexOf(l);//Busco la posicion del jugador que estoy iterando
				int acum=apuestas.get(pos);//Guardo lo que aposto en la jugada anterior
				apuestas.set(pos, acum+apuesta);//Lo cambio, porque la apuesta es acumulativa
			}
			suma=calcularSuma();
			for(JugadorPoker j:jugadoresC){
				j.enviarCantidad(suma);
			}
			//Anado la ultima carta de la mesa
			mesa.add(b.getCarta(i));
			i++;
			//Reenvio las cartas de la mesa
			for(JugadorPoker k:jugadoresC){
				k.enviarCartas(mesa);
			}
			
			//En este bucle actualizo las apuestas no las a�ado
			for (JugadorPoker l:jugadoresC){
				apuesta=l.obtenerApuesta();//Este metodo tambian asigna la apuesta con el set
				int pos=jugadores.indexOf(l);//Busco la posicion del jugador que estoy iterando
				int acum=apuestas.get(pos);//Guardo lo que aposto en la jugada anterior
				apuestas.set(pos, acum+apuesta);//Lo cambio, porque la apuesta es acumulativa
			}
			suma=calcularSuma();
			for(JugadorPoker j:jugadoresC){
				j.enviarCantidad(suma);
			}
			//Calculo la puntuacion de la jugada de cada jugador
			for(JugadorPoker h:jugadoresC){
				calcularMasAlta(h);
			}
			
			//Calculo la posicion en el vector del jugador con la mejor jugada
			int max=calcularMax();
			//Lo guardo
			JugadorPoker ganador=jugadoresC.get(max);
			
			//Informo a todos los jugadores que ha ganado el jugador X
			for(JugadorPoker t:jugadoresC){
		//		t.informarVictoria(jugadoress.get(0).getCliente().getPort());
				t.informarVictoria(ganador.getCliente().getPort());
			}
			
		}
	}
	
	/**
	 * Metodo que calcula el valor de la jugada de un jugador y lo indica en el atributo del jugador en concreto
	 * @param gamer
	 */
	private void calcularMasAlta(JugadorPoker gamer) {
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
        int posicion=0;
        int max=0;
        for(JugadorPoker i:jugadoresC){
            if(i.getValorJugada()>max){
                posicion=jugadoresC.indexOf(i);
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
		int apuesta=0;
		for(int  j:apuestas){
			apuesta+=j;
		}
		return apuesta;
	}
}
