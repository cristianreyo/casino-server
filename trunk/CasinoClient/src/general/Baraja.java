package general;

import java.io.Serializable;
import java.util.*;
import javax.swing.ImageIcon;

public class Baraja implements Serializable{
	
	private final Vector<Carta> baraja=new Vector<Carta>();//Baraja de cartas
	/**
	 *  Metodo constructor, que inicializa 52 cartas distintas y las baraja.
	 */
	public Baraja(){
		baraja.add(new Carta("UNO", "PICAS","NEGRO",new ImageIcon("imagenes/1-Picas.jpg")));
		baraja.add(new Carta("DOS", "PICAS","NEGRO",new ImageIcon("imagenes/2-Picas.jpg")));
		baraja.add(new Carta("TRES", "PICAS","NEGRO",new ImageIcon("imagenes/3-Picas.jpg")));
		baraja.add(new Carta("CUATRO", "PICAS","NEGRO",new ImageIcon("imagenes/4-Picas.jpg")));
		baraja.add(new Carta("CINCO", "PICAS","NEGRO",new ImageIcon("imagenes/5-Picas.jpg")));
		baraja.add(new Carta("SEIS", "PICAS","NEGRO",new ImageIcon("imagenes/6-Picas.jpg")));
		baraja.add(new Carta("SIETE", "PICAS","NEGRO",new ImageIcon("imagenes/7-Picas.jpg")));
		baraja.add(new Carta("OCHO", "PICAS","NEGRO",new ImageIcon("imagenes/8-Picas.jpg")));
		baraja.add(new Carta("NUEVE", "PICAS","NEGRO",new ImageIcon("imagenes/9-Picas.jpg")));
		baraja.add(new Carta("DIEZ", "PICAS","NEGRO",new ImageIcon("imagenes/10-Picas.jpg")));
		baraja.add(new Carta("J", "PICAS","NEGRO",new ImageIcon("imagenes/J-Picas.jpg")));
		baraja.add(new Carta("Q", "PICAS","NEGRO",new ImageIcon("imagenes/Q-Picas.jpg")));
		baraja.add(new Carta("K", "PICAS","NEGRO",new ImageIcon("imagenes/K-Picas.jpg")));
		
		baraja.add(new Carta("UNO", "CORAZONES","ROJO",new ImageIcon("imagenes/1-Corazones.jpg")));
		baraja.add(new Carta("DOS", "CORAZONES","ROJO",new ImageIcon("imagenes/2-Corazones.jpg")));
		baraja.add(new Carta("TRES", "CORAZONES","ROJO",new ImageIcon("imagenes/3-Corazones.jpg")));
		baraja.add(new Carta("CUATRO", "CORAZONES","ROJO",new ImageIcon("imagenes/4-Corazones.jpg")));
		baraja.add(new Carta("CINCO", "CORAZONES","ROJO",new ImageIcon("imagenes/5-Corazones.jpg")));
		baraja.add(new Carta("SEIS", "CORAZONES","ROJO",new ImageIcon("imagenes/6-Corazones.jpg")));
		baraja.add(new Carta("SIETE", "CORAZONES","ROJO",new ImageIcon("imagenes/7-Corazones.jpg")));
		baraja.add(new Carta("OCHO", "CORAZONES","ROJO",new ImageIcon("imagenes/8-Corazones.jpg")));
		baraja.add(new Carta("NUEVE", "CORAZONES","ROJO",new ImageIcon("imagenes/9-Corazones.jpg")));
		baraja.add(new Carta("DIEZ", "CORAZONES","ROJO",new ImageIcon("imagenes/10-Corazones.jpg")));
		baraja.add(new Carta("J", "CORAZONES","ROJO",new ImageIcon("imagenes/J-Corazones.jpg")));
		baraja.add(new Carta("Q", "CORAZONES","ROJO",new ImageIcon("imagenes/Q-Corazones.jpg")));
		baraja.add(new Carta("K", "CORAZONES","ROJO",new ImageIcon("imagenes/K-Corazones.jpg")));
		
		baraja.add(new Carta("UNO", "TREBOLES", "NEGRO",new ImageIcon("imagenes/1-Treboles.jpg")));
		baraja.add(new Carta("DOS", "TREBOLES", "NEGRO",new ImageIcon("imagenes/2-Treboles.jpg")));
		baraja.add(new Carta("TRES", "TREBOLES", "NEGRO",new ImageIcon("imagenes/3-Treboles.jpg")));
		baraja.add(new Carta("CUATRO", "TREBOLES", "NEGRO",new ImageIcon("imagenes/4-Treboles.jpg")));
		baraja.add(new Carta("CINCO", "TREBOLES", "NEGRO",new ImageIcon("imagenes/5-Treboles.jpg")));
		baraja.add(new Carta("SEIS", "TREBOLES", "NEGRO",new ImageIcon("imagenes/6-Treboles.jpg")));
		baraja.add(new Carta("SIETE", "TREBOLES", "NEGRO",new ImageIcon("imagenes/7-Treboles.jpg")));
		baraja.add(new Carta("OCHO", "TREBOLES", "NEGRO",new ImageIcon("imagenes/8-Treboles.jpg")));
		baraja.add(new Carta("NUEVE", "TREBOLES", "NEGRO",new ImageIcon("imagenes/9-Treboles.jpg")));
		baraja.add(new Carta("DIEZ", "TREBOLES", "NEGRO",new ImageIcon("imagenes/10-Treboles.jpg")));
		baraja.add(new Carta("J", "TREBOLES", "NEGRO",new ImageIcon("imagenes/J-Treboles.jpg")));
		baraja.add(new Carta("Q", "TREBOLES", "NEGRO",new ImageIcon("imagenes/Q-Treboles.jpg")));
		baraja.add(new Carta("K", "TREBOLES", "NEGRO",new ImageIcon("imagenes/K-Treboles.jpg")));
		
		baraja.add(new Carta("UNO", "ROMBOS", "ROJO",new ImageIcon("imagenes/1-Rombos.jpg")));
		baraja.add(new Carta("DOS", "ROMBOS", "ROJO",new ImageIcon("imagenes/2-Rombos.jpg")));
		baraja.add(new Carta("TRES", "ROMBOS", "ROJO",new ImageIcon("imagenes/3-Rombos.jpg")));
		baraja.add(new Carta("CUATRO", "ROMBOS", "ROJO",new ImageIcon("imagenes/4-Rombos.jpg")));
		baraja.add(new Carta("CINCO", "ROMBOS", "ROJO",new ImageIcon("imagenes/5-Rombos.jpg")));
		baraja.add(new Carta("SEIS", "ROMBOS", "ROJO",new ImageIcon("imagenes/6-Rombos.jpg")));
		baraja.add(new Carta("SIETE", "ROMBOS", "ROJO",new ImageIcon("imagenes/7-Rombos.jpg")));
		baraja.add(new Carta("OCHO", "ROMBOS", "ROJO",new ImageIcon("imagenes/8-Rombos.jpg")));
		baraja.add(new Carta("NUEVE", "ROMBOS", "ROJO",new ImageIcon("imagenes/9-Rombos.jpg")));
		baraja.add(new Carta("DIEZ", "ROMBOS", "ROJO",new ImageIcon("imagenes/10-Rombos.jpg")));
		baraja.add(new Carta("J", "ROMBOS", "ROJO",new ImageIcon("imagenes/J-Rombos.jpg")));
		baraja.add(new Carta("Q", "ROMBOS", "ROJO",new ImageIcon("imagenes/Q-Rombos.jpg")));
		baraja.add(new Carta("K", "ROMBOS", "ROJO",new ImageIcon("imagenes/K-rombos.jpg")));
		
		//Se mezcla la baraja 3 veces.
		Collections.shuffle(baraja); 
		Collections.shuffle(baraja);
		Collections.shuffle(baraja);
	}
	
	public Vector<Carta> getBaraja() {
		return baraja;
	}
	
	public Carta getCarta(int i){
		return baraja.get(i);
	}

	public void barajar() {
		Collections.shuffle(baraja); 
		Collections.shuffle(baraja);
		Collections.shuffle(baraja);		
	}
	
}
