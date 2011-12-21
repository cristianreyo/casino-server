package pruebaPoker_servidor;

import general.Carta;

import java.io.*;
import java.net.*;
import java.util.*;
/**
 * Clase que gestionara el servidor para el juego del poker. Tiene como atributos el socket del cliente
 * lo que apuesta en una jugada en concreto, lo que lleva acumulado y el nombre del jugador
 * @author 
 *
 */
public class Jugador  {
	private Socket cliente; //Gestiona la conexion con el cliente
	private int apuesta; //Apuesta individual
	private int cantidadTotal; //Cantidad acumulada
	private String nombre; //Nombre del jugador
	private Carta carta1; //Carta 1 del jugador
	private Carta carta2; //Carta 2 del jugador
	private ObjectInputStream ois; //Buffer de entrada
	private ObjectOutputStream oos; //Buffer de salida
	private int valorJugada; //Valor de su jugada
	
	/**
	 * Metodo constructor que inicializa los atributos
	 * @param cliente
	 */
	public Jugador(Socket cliente){
		this.cliente=cliente;//Asigno un socket
		apuesta=0; //Inicializo la apuesta
		cantidadTotal=0; //Indico la cantidad total
		nombre=""; //Inicializo el nombre
		try {
			oos=new ObjectOutputStream(cliente.getOutputStream());//Inicializo el buffer de salida
			ois=new ObjectInputStream(cliente.getInputStream()); //Inicializo el buffer de entrada
		} catch (IOException e) {
			e.printStackTrace();
		}
		valorJugada=-1;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que envia las cartas que hay en la mesa, para ello, primero indico el numero de cartas a enviar
	 * y luego las envio una a una
	 * @param mesa
	 */
	public void enviarCartas(Vector<Carta> mesa) {
		try {
			oos.writeInt(mesa.size()); //Envio el numero de cartas
			for(Carta c:mesa){//Para cada carta que haya en el vector
				oos.writeObject(c);//La envio
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
		apuesta=0; //Inicializo a cero
		try {
			String ap=(String) ois.readObject();//Leo el objeto con la apuesta
			apuesta=Integer.parseInt(ap);//Lo convierto a entero y lo guardo
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
			oos.writeObject(carta);//Envio la carta convertida en objeto
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
		if(cliente.getPort()==nombre2){//Comparo si es el jugador ganador, comprobando si el puerto remoto de este jugador coincide con el puerto remoto del ganador
			try {
				oos.writeObject("Has ganado!!"); //Le informo de que ha ganado
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			try {
				oos.writeObject("Ha ganado el jugador: "+nombre2); //Le digo quien ha ganado
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
	
}
