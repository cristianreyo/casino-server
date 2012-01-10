package juego.poker;

import general.Carta;

import java.util.*;
import javax.swing.*;

public class Poker {

	public static boolean escaleraReal(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		Carta c1=new Carta("UNO", "PICAS","NEGRO",new ImageIcon("imagenes/1-Picas.jpg"));
		Carta c2=new Carta("DIEZ", "PICAS","NEGRO",new ImageIcon("imagenes/10-Picas.jpg"));
		Carta c3=new Carta("J", "PICAS","NEGRO",new ImageIcon("imagenes/J-Picas.jpg"));
		Carta c4=new Carta("Q", "PICAS","NEGRO",new ImageIcon("imagenes/Q-Picas.jpg"));
		Carta c5=new Carta("K", "PICAS","NEGRO",new ImageIcon("imagenes/K-Picas.jpg"));
		
		Carta c6=new Carta("UNO", "CORAZONES","ROJO",new ImageIcon("imagenes/1-Corazones.jpg"));
		Carta c7=new Carta("DIEZ", "CORAZONES","ROJO",new ImageIcon("imagenes/10-Corazones.jpg"));
		Carta c8=new Carta("J", "CORAZONES","ROJO",new ImageIcon("imagenes/J-Corazones.jpg"));
		Carta c9=new Carta("Q", "CORAZONES","ROJO",new ImageIcon("imagenes/Q-Corazones.jpg"));
		Carta c10=new Carta("K", "CORAZONES","ROJO",new ImageIcon("imagenes/K-Corazones.jpg"));
		
		Carta c11=new Carta("UNO", "TREBOLES", "NEGRO",new ImageIcon("imagenes/1-Treboles.jpg"));
		Carta c12=new Carta("DIEZ", "TREBOLES", "NEGRO",new ImageIcon("imagenes/10-Treboles.jpg"));
		Carta c13=new Carta("J", "TREBOLES", "NEGRO",new ImageIcon("imagenes/J-Treboles.jpg"));
		Carta c14=new Carta("Q", "TREBOLES", "NEGRO",new ImageIcon("imagenes/Q-Treboles.jpg"));
		Carta c15=new Carta("K", "TREBOLES", "NEGRO",new ImageIcon("imagenes/K-Treboles.jpg"));
		
		Carta c16=new Carta("UNO", "ROMBOS", "ROJO",new ImageIcon("imagenes/1-Rombos.jpg"));
		Carta c17=new Carta("DIEZ", "ROMBOS", "ROJO",new ImageIcon("imagenes/10-Rombos.jpg"));
		Carta c18=new Carta("J", "ROMBOS", "ROJO",new ImageIcon("imagenes/J-Rombos.jpg"));
		Carta c19=new Carta("Q", "ROMBOS", "ROJO",new ImageIcon("imagenes/Q-Rombos.jpg"));
		Carta c20=new Carta("K", "ROMBOS", "ROJO",new ImageIcon("imagenes/K-rombos.jpg"));
		
		if(todasCartas.contains(c1)&&todasCartas.contains(c2)&&todasCartas.contains(c3)&&todasCartas.contains(c4)&&todasCartas.contains(c5))
			return true;
		else if(todasCartas.contains(c6)&&todasCartas.contains(c7)&&todasCartas.contains(c8)&&todasCartas.contains(c9)&&todasCartas.contains(c10))
			return true;
		else if(todasCartas.contains(c11)&&todasCartas.contains(c12)&&todasCartas.contains(c13)&&todasCartas.contains(c14)&&todasCartas.contains(c15))
			return true;
		else if(todasCartas.contains(c16)&&todasCartas.contains(c17)&&todasCartas.contains(c18)&&todasCartas.contains(c19)&&todasCartas.contains(c20))
			return true;
		else
			return false;
	}

	public static boolean escaleraColor(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		return false;
	}

	public static boolean poker(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		return false;
	}

	public static boolean full(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		return false;
	}

	public static boolean color(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		return false;
	}

	public static boolean escalera(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		return false;
	}

	public static boolean trio(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		return false;
	}

	public static boolean doblesParejas(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		return false;
	}

	public static boolean pareja(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		return false;
	}

	public static boolean cartaAlta(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		return false;
	}

}
