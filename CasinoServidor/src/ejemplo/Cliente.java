package ejemplo;

import java.io.*;
import java.net.*;
/**
 * Clase que se conecta al servidor para jugar al juego de la carta mas alta
 * @author
 *
 */
public class Cliente {
	public static void main(String[] args){
		try {
			Socket servidor=new Socket("localhost", 12345);//Me conecto al servidor
			DataInputStream is=new DataInputStream(servidor.getInputStream());//Creo un buffer de salida
			DataOutputStream os=new DataOutputStream(servidor.getOutputStream());//Creo un buffer de entrada
			while(true){//Bucle infinito
				InputStreamReader lee=new InputStreamReader(System.in);//Leo de teclado
				BufferedReader buf=new BufferedReader(lee);//utilizo el buffer para obtener los datos
				os.writeUTF(buf.readLine());//Envio lo leido
				System.out.println(is.readUTF());//Muestro el ganador de la partida
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}