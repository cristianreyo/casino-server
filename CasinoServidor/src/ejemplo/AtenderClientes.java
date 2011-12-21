package ejemplo;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.Vector;
/**
 * Clase que gestiona a cada cliente de la mesa de juegos.
 * Al heredar de hilo, para cada mesa de juego se crea un nuevo hilo
 * @author 
 *
 */
public class AtenderClientes extends Thread{
	Vector<Socket> sockets=new Vector<Socket>(); //Vector con todos los sockets de los clientes.
	Vector<String> cartas=new Vector<String>(); //Vector con los datos que lee de los clientes
	/**
	 * Metodo constructor de la clase que a�ade el socket al vector e inicia el hilo
	 * @param cliente
	 */
	public AtenderClientes(Socket cliente){
		sockets.add(cliente);//A�ade un socket al vector
	}
	/**
	 * Al ser una clase que hereda de Thread, necesita el metodo run, aunque no haga nada
	 */
	public void run(){
			DataInputStream is; //Creo un buffer de entrada
			DataOutputStream os; //Creo un buffer de salida
			String entrada="";
                        Vector<Socket> clon=(Vector<Socket>) sockets.clone();	
			while(true){ //Las partidas van a ser a tres rondas, ma�ana explicar� el porqu� de esto
				clon.clear();
                                clon=(Vector<Socket>) sockets.clone();	//Clono el vector, esto es porque no puedo iterar sobre un objeto que esta siendo modificado (excepcion de concurrencia)
				for(Socket c:clon){//Para cada elemento del vector de sockets
					try {
						is=new DataInputStream(c.getInputStream());//Inicializo el buffer con el socket correspondiente
						entrada=is.readUTF();//Leo el dato del buffer
						System.out.println("Entrada: "+entrada);//Lo muestro por pantalla
						cartas.add(entrada);//Lo a�ado al vector de entrada
					} catch (IOException e) {
					}
				} 
				String ganador=""; //Cadena para elegir la carta mas alta
				ganador=calcularCarta();//Llamo al metodo para calcular la carta mas alta
				for(Socket c:sockets){//Para cada elemento del vector de sockets
					try {
						os=new DataOutputStream(c.getOutputStream());//Creo el buffer para la salida de los datos
						os.writeUTF("Ha ganado el jugador con carta: "+ganador);//Envio una cadena con el ganador
					} catch (IOException e) {
					}
				}
				clon.clear();//limpio el vector clon;
				cartas.clear(); //Limpio el vector de los datos de entrada
			}
	}
	/**
	 * Metodo que calcula el valor mas alto de la carta. Como es un metodo de prueba
	 * y no es el objetivo del ejemplo, devuelve la primera entrada del vector.
	 * @return el valor del vector en su primera posicion
	 */
	private String calcularCarta() {
		return cartas.get(0);
	}
	/**
	 * Metodo que a�ade un socket al vector y ejecuta el juego
	 * @param conexion
	 */
	public void anadir(Socket conexion){
		sockets.add(conexion);//A�ade el socket al vector
	}
}
