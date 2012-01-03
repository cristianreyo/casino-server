package pruebaPoker_servidor;

import java.io.*;
import java.net.*;

public class Servidor {
	
	private ServerSocket servidor;
	private Socket cliente;
	
	public Servidor(){
		try {
			servidor=new ServerSocket(12125);
			int i=0;//Contador
			MesaPoker mp = null; //Clase que hereda de Thread
			while(true){//Bucle infinito
				cliente=servidor.accept();//Aceptamos una conexion
				if(i%10==0){//Si no pasamos del limite de 10 jugadores por mesa
					mp=new MesaPoker(cliente);//Creamos un nuevo jugador 
					System.out.println("Creo una mesa");
				}
				else{//Si es cualquier otro numero de jugadores lo a�adimos a la ultima mesa disponible
					if(mp.isAlive()){//Si el hilo est� vivo 
						mp.suspend(); //Lo pauso
					}
					mp.anadir(cliente);//Se a�ade un cliente
					try{
						mp.start();//Intento iniciar el hilo, esto se ejecutar� solo una vez
					}
					catch (Exception e) {
						mp.resume();//Reinicio el hilo despues de a�adir
					}
					System.out.println("A�ado un jugador");
				}
				i++;//Se incrementa el numero de jugadores
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new Servidor();
	}
}
