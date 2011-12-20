package ejemplo;

import java.io.IOException;
import java.net.*;
/**
 * Clase que crea un servidor TCP en el puerto 12345 y crea un nuevo hilo para cada cliente.
 * @author 
 *
 */
public class Servidor {
	/**
	 * Constructor del servidor, que inicia una nueva mesa cada 10 jugadores.
	 */
	public Servidor() {
		try{
			ServerSocket servidor=new ServerSocket(12345);//Creo el servidor TCP
			Socket cliente;//Creo el socket cliente
			int i=0;//Contador
			AtenderClientes ac = null; //Clase que hereda de Thread
			while(true){//Bucle infinito
				cliente=servidor.accept();//Aceptamos una conexion
				if(i%10==0){//Si no pasamos del limite de 10 jugadores por mesa
					ac=new AtenderClientes(cliente);//Creamos un nuevo jugador 
					System.out.println("Creo una mesa");
				}
				else{//Si es cualquier otro numero de jugadores lo añadimos a la ultima mesa disponible
					if(ac.isAlive()){//Si el hilo está vivo 
						ac.suspend(); //Lo pauso
					}
					ac.anadir(cliente);//Se añade un cliente
					try{
						ac.start();//Intento iniciar el hilo, esto se ejecutará solo una vez
					}
					catch (Exception e) {
						ac.resume();//Reinicio el hilo despues de añadir
					}
					System.out.println("Añado un jugador");
				}
				i++;//Se incrementa el numero de jugadores
			}
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		new Servidor();
	}
}
