package pruebaPoker_servidor;

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
		Collections.sort(todasCartas);
		Carta c1=todasCartas.get(0);
		Carta c2=todasCartas.get(1);
		Carta c3=todasCartas.get(2);
		Carta c4=todasCartas.get(3);
		Carta c5=todasCartas.get(4);
		Carta c6=todasCartas.get(5);
		Carta c7=todasCartas.get(6);
		if(c1.getNumero().compareTo("UNO")==0&&c2.getNumero().compareTo("DOS")==0&&c3.getNumero().compareTo("TRES")==0&&c4.getNumero().compareTo("CUATRO")==0&&c5.getNumero().compareTo("CINCO")==0
				&& c1.getPalo().compareTo(c2.getPalo())==0&& c1.getPalo().compareTo(c3.getPalo())==0&& c1.getPalo().compareTo(c4.getPalo())==0&& c1.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c1.getNumero().compareTo("DOS")==0&&c2.getNumero().compareTo("TRES")==0&&c3.getNumero().compareTo("CUATRO")==0&&c4.getNumero().compareTo("CINCO")==0&&c5.getNumero().compareTo("SEIS")==0
				&& c1.getPalo().compareTo(c2.getPalo())==0&& c1.getPalo().compareTo(c3.getPalo())==0&& c1.getPalo().compareTo(c4.getPalo())==0&& c1.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c1.getNumero().compareTo("TRES")==0&&c2.getNumero().compareTo("CUATRO")==0&&c3.getNumero().compareTo("CINCO")==0&&c4.getNumero().compareTo("SEIS")==0&&c5.getNumero().compareTo("SIETE")==0
				&& c1.getPalo().compareTo(c2.getPalo())==0&& c1.getPalo().compareTo(c3.getPalo())==0&& c1.getPalo().compareTo(c4.getPalo())==0&& c1.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c1.getNumero().compareTo("CUATRO")==0&&c2.getNumero().compareTo("CINCO")==0&&c3.getNumero().compareTo("SEIS")==0&&c4.getNumero().compareTo("SIETE")==0&&c5.getNumero().compareTo("OCHO")==0
				&& c1.getPalo().compareTo(c2.getPalo())==0&& c1.getPalo().compareTo(c3.getPalo())==0&& c1.getPalo().compareTo(c4.getPalo())==0&& c1.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c1.getNumero().compareTo("CINCO")==0&&c2.getNumero().compareTo("SEIS")==0&&c3.getNumero().compareTo("SIETE")==0&&c4.getNumero().compareTo("OCHO")==0&&c5.getNumero().compareTo("NUEVE")==0
				&& c1.getPalo().compareTo(c2.getPalo())==0&& c1.getPalo().compareTo(c3.getPalo())==0&& c1.getPalo().compareTo(c4.getPalo())==0&& c1.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c1.getNumero().compareTo("SEIS")==0&&c2.getNumero().compareTo("SIETE")==0&&c3.getNumero().compareTo("OCHO")==0&&c4.getNumero().compareTo("NUEVE")==0&&c5.getNumero().compareTo("DIEZ")==0
				&& c1.getPalo().compareTo(c2.getPalo())==0&& c1.getPalo().compareTo(c3.getPalo())==0&& c1.getPalo().compareTo(c4.getPalo())==0&& c1.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c1.getNumero().compareTo("SIETE")==0&&c2.getNumero().compareTo("OCHO")==0&&c3.getNumero().compareTo("NUEVE")==0&&c4.getNumero().compareTo("DIEZ")==0&&c5.getNumero().compareTo("J")==0
				&& c1.getPalo().compareTo(c2.getPalo())==0&& c1.getPalo().compareTo(c3.getPalo())==0&& c1.getPalo().compareTo(c4.getPalo())==0&& c1.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c1.getNumero().compareTo("OCHO")==0&&c2.getNumero().compareTo("NUEVE")==0&&c3.getNumero().compareTo("DIEZ")==0&&c4.getNumero().compareTo("J")==0&&c5.getNumero().compareTo("Q")==0
				&& c1.getPalo().compareTo(c2.getPalo())==0&& c1.getPalo().compareTo(c3.getPalo())==0&& c1.getPalo().compareTo(c4.getPalo())==0&& c1.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c1.getNumero().compareTo("NUEVE")==0&&c2.getNumero().compareTo("DIEZ")==0&&c3.getNumero().compareTo("J")==0&&c4.getNumero().compareTo("Q")==0&&c5.getNumero().compareTo("K")==0
				&& c1.getPalo().compareTo(c2.getPalo())==0&& c1.getPalo().compareTo(c3.getPalo())==0&& c1.getPalo().compareTo(c4.getPalo())==0&& c1.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		//
		if(c2.getNumero().compareTo("UNO")==0&&c3.getNumero().compareTo("DOS")==0&&c4.getNumero().compareTo("TRES")==0&&c5.getNumero().compareTo("CUATRO")==0&&c6.getNumero().compareTo("CINCO")==0
				&& c2.getPalo().compareTo(c6.getPalo())==0&& c2.getPalo().compareTo(c3.getPalo())==0&& c2.getPalo().compareTo(c4.getPalo())==0&& c2.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c2.getNumero().compareTo("DOS")==0&&c3.getNumero().compareTo("TRES")==0&&c4.getNumero().compareTo("CUATRO")==0&&c5.getNumero().compareTo("CINCO")==0&&c6.getNumero().compareTo("SEIS")==0
				&& c2.getPalo().compareTo(c6.getPalo())==0&& c2.getPalo().compareTo(c3.getPalo())==0&& c2.getPalo().compareTo(c4.getPalo())==0&& c2.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c2.getNumero().compareTo("TRES")==0&&c3.getNumero().compareTo("CUATRO")==0&&c4.getNumero().compareTo("CINCO")==0&&c5.getNumero().compareTo("SEIS")==0&&c6.getNumero().compareTo("SIETE")==0
				&& c2.getPalo().compareTo(c6.getPalo())==0&& c2.getPalo().compareTo(c3.getPalo())==0&& c2.getPalo().compareTo(c4.getPalo())==0&& c2.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c2.getNumero().compareTo("CUATRO")==0&&c3.getNumero().compareTo("CINCO")==0&&c4.getNumero().compareTo("SEIS")==0&&c5.getNumero().compareTo("SIETE")==0&&c6.getNumero().compareTo("OCHO")==0
				&& c2.getPalo().compareTo(c6.getPalo())==0&& c2.getPalo().compareTo(c3.getPalo())==0&& c2.getPalo().compareTo(c4.getPalo())==0&& c2.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c2.getNumero().compareTo("CINCO")==0&&c3.getNumero().compareTo("SEIS")==0&&c4.getNumero().compareTo("SIETE")==0&&c5.getNumero().compareTo("OCHO")==0&&c6.getNumero().compareTo("NUEVE")==0
				&& c2.getPalo().compareTo(c6.getPalo())==0&& c2.getPalo().compareTo(c3.getPalo())==0&& c2.getPalo().compareTo(c4.getPalo())==0&& c2.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c2.getNumero().compareTo("SEIS")==0&&c3.getNumero().compareTo("SIETE")==0&&c4.getNumero().compareTo("OCHO")==0&&c5.getNumero().compareTo("NUEVE")==0&&c6.getNumero().compareTo("DIEZ")==0
				&& c2.getPalo().compareTo(c6.getPalo())==0&& c2.getPalo().compareTo(c3.getPalo())==0&& c2.getPalo().compareTo(c4.getPalo())==0&& c2.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c2.getNumero().compareTo("SIETE")==0&&c3.getNumero().compareTo("OCHO")==0&&c4.getNumero().compareTo("NUEVE")==0&&c5.getNumero().compareTo("DIEZ")==0&&c6.getNumero().compareTo("J")==0
				&& c2.getPalo().compareTo(c6.getPalo())==0&& c2.getPalo().compareTo(c3.getPalo())==0&& c2.getPalo().compareTo(c4.getPalo())==0&& c2.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c2.getNumero().compareTo("OCHO")==0&&c3.getNumero().compareTo("NUEVE")==0&&c4.getNumero().compareTo("DIEZ")==0&&c5.getNumero().compareTo("J")==0&&c6.getNumero().compareTo("Q")==0
				&& c2.getPalo().compareTo(c6.getPalo())==0&& c2.getPalo().compareTo(c3.getPalo())==0&& c2.getPalo().compareTo(c4.getPalo())==0&& c2.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c2.getNumero().compareTo("NUEVE")==0&&c3.getNumero().compareTo("DIEZ")==0&&c4.getNumero().compareTo("J")==0&&c5.getNumero().compareTo("Q")==0&&c6.getNumero().compareTo("K")==0
				&& c2.getPalo().compareTo(c6.getPalo())==0&& c2.getPalo().compareTo(c3.getPalo())==0&& c2.getPalo().compareTo(c4.getPalo())==0&& c2.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		//
		if(c3.getNumero().compareTo("UNO")==0&&c4.getNumero().compareTo("DOS")==0&&c5.getNumero().compareTo("TRES")==0&&c6.getNumero().compareTo("CUATRO")==0&&c7.getNumero().compareTo("CINCO")==0
				&& c3.getPalo().compareTo(c6.getPalo())==0&& c3.getPalo().compareTo(c7.getPalo())==0&& c3.getPalo().compareTo(c4.getPalo())==0&& c3.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c3.getNumero().compareTo("DOS")==0&&c4.getNumero().compareTo("TRES")==0&&c5.getNumero().compareTo("CUATRO")==0&&c6.getNumero().compareTo("CINCO")==0&&c7.getNumero().compareTo("SEIS")==0
				&& c3.getPalo().compareTo(c6.getPalo())==0&& c3.getPalo().compareTo(c7.getPalo())==0&& c3.getPalo().compareTo(c4.getPalo())==0&& c3.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c3.getNumero().compareTo("TRES")==0&&c4.getNumero().compareTo("CUATRO")==0&&c5.getNumero().compareTo("CINCO")==0&&c6.getNumero().compareTo("SEIS")==0&&c7.getNumero().compareTo("SIETE")==0
				&& c3.getPalo().compareTo(c6.getPalo())==0&& c3.getPalo().compareTo(c7.getPalo())==0&& c3.getPalo().compareTo(c4.getPalo())==0&& c3.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c3.getNumero().compareTo("CUATRO")==0&&c4.getNumero().compareTo("CINCO")==0&&c5.getNumero().compareTo("SEIS")==0&&c6.getNumero().compareTo("SIETE")==0&&c7.getNumero().compareTo("OCHO")==0
				&& c3.getPalo().compareTo(c6.getPalo())==0&& c3.getPalo().compareTo(c7.getPalo())==0&& c3.getPalo().compareTo(c4.getPalo())==0&& c3.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c3.getNumero().compareTo("CINCO")==0&&c4.getNumero().compareTo("SEIS")==0&&c5.getNumero().compareTo("SIETE")==0&&c6.getNumero().compareTo("OCHO")==0&&c7.getNumero().compareTo("NUEVE")==0
				&& c3.getPalo().compareTo(c6.getPalo())==0&& c3.getPalo().compareTo(c7.getPalo())==0&& c3.getPalo().compareTo(c4.getPalo())==0&& c3.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c3.getNumero().compareTo("SEIS")==0&&c4.getNumero().compareTo("SIETE")==0&&c5.getNumero().compareTo("OCHO")==0&&c6.getNumero().compareTo("NUEVE")==0&&c7.getNumero().compareTo("DIEZ")==0
				&& c3.getPalo().compareTo(c6.getPalo())==0&& c3.getPalo().compareTo(c7.getPalo())==0&& c3.getPalo().compareTo(c4.getPalo())==0&& c3.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c3.getNumero().compareTo("SIETE")==0&&c4.getNumero().compareTo("OCHO")==0&&c5.getNumero().compareTo("NUEVE")==0&&c6.getNumero().compareTo("DIEZ")==0&&c7.getNumero().compareTo("J")==0
				&& c3.getPalo().compareTo(c6.getPalo())==0&& c3.getPalo().compareTo(c7.getPalo())==0&& c3.getPalo().compareTo(c4.getPalo())==0&& c3.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c3.getNumero().compareTo("OCHO")==0&&c4.getNumero().compareTo("NUEVE")==0&&c5.getNumero().compareTo("DIEZ")==0&&c6.getNumero().compareTo("J")==0&&c7.getNumero().compareTo("Q")==0
				&& c3.getPalo().compareTo(c6.getPalo())==0&& c3.getPalo().compareTo(c7.getPalo())==0&& c3.getPalo().compareTo(c4.getPalo())==0&& c3.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c3.getNumero().compareTo("NUEVE")==0&&c4.getNumero().compareTo("DIEZ")==0&&c5.getNumero().compareTo("J")==0&&c6.getNumero().compareTo("Q")==0&&c7.getNumero().compareTo("K")==0
				&& c3.getPalo().compareTo(c6.getPalo())==0&& c3.getPalo().compareTo(c7.getPalo())==0&& c3.getPalo().compareTo(c4.getPalo())==0&& c3.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else
			return false;
	}

	public static boolean poker(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		Collections.sort(todasCartas);
		Carta c1=todasCartas.get(0);
		Carta c2=todasCartas.get(1);
		Carta c3=todasCartas.get(2);
		Carta c4=todasCartas.get(3);
		Carta c5=todasCartas.get(4);
		Carta c6=todasCartas.get(5);
		Carta c7=todasCartas.get(6);
		if(c1.getNumero().compareTo(c2.getNumero())==0&&c1.getNumero().compareTo(c3.getNumero())==0&&c1.getNumero().compareTo(c4.getNumero())==0){
			return true;
		}
		else if(c2.getNumero().compareTo(c3.getNumero())==0&&c2.getNumero().compareTo(c4.getNumero())==0&&c2.getNumero().compareTo(c5.getNumero())==0){
			return true;
		}
		else if(c3.getNumero().compareTo(c4.getNumero())==0&&c3.getNumero().compareTo(c5.getNumero())==0&&c3.getNumero().compareTo(c6.getNumero())==0){
			return true;
		}
		else if(c4.getNumero().compareTo(c5.getNumero())==0&&c4.getNumero().compareTo(c6.getNumero())==0&&c4.getNumero().compareTo(c7.getNumero())==0){
			return true;
		}
		return false;
	}

	public static boolean full(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		Collections.sort(todasCartas);
		Carta c1=todasCartas.get(0);
		Carta c2=todasCartas.get(1);
		Carta c3=todasCartas.get(2);
		Carta c4=todasCartas.get(3);
		Carta c5=todasCartas.get(4);
		Carta c6=todasCartas.get(5);
		Carta c7=todasCartas.get(6);
		if(c1.getNumero().compareTo(c2.getNumero())==0&&c1.getNumero().compareTo(c3.getNumero())==0 &&(c4.getNumero().compareTo(c5.getNumero())==0||c5.getNumero().compareTo(c6.getNumero())==0||c6.getNumero().compareTo(c7.getNumero())==0)){
			return true;
		}
		else if(c2.getNumero().compareTo(c3.getNumero())==0&&c2.getNumero().compareTo(c4.getNumero())==0 &&(c5.getNumero().compareTo(c6.getNumero())==0||c6.getNumero().compareTo(c7.getNumero())==0)){
			return true;
		}
		else if(c3.getNumero().compareTo(c4.getNumero())==0&&c3.getNumero().compareTo(c5.getNumero())==0&&(c1.getNumero().compareTo(c2.getNumero())==0||c6.getNumero().compareTo(c7.getNumero())==0)){
			return true;
		}
		else if(c4.getNumero().compareTo(c5.getNumero())==0&&c4.getNumero().compareTo(c6.getNumero())==0&&(c1.getNumero().compareTo(c2.getNumero())==0||c2.getNumero().compareTo(c3.getNumero())==0)){
			return true;
		}
		else if(c5.getNumero().compareTo(c6.getNumero())==0&&c5.getNumero().compareTo(c7.getNumero())==0&&(c1.getNumero().compareTo(c2.getNumero())==0||c2.getNumero().compareTo(c3.getNumero())==0||c3.getNumero().compareTo(c4.getNumero())==0)){
			return true;
		}
		return false;
	}

	public static boolean color(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		Collections.sort(todasCartas);
		Carta c1=todasCartas.get(0);
		Carta c2=todasCartas.get(1);
		Carta c3=todasCartas.get(2);
		Carta c4=todasCartas.get(3);
		Carta c5=todasCartas.get(4);
		Carta c6=todasCartas.get(5);
		Carta c7=todasCartas.get(6);
		if(c1.getPalo().compareTo(c2.getPalo())==0&&c1.getPalo().compareTo(c3.getPalo())==0&&c1.getPalo().compareTo(c4.getPalo())==0&&c1.getPalo().compareTo(c5.getPalo())==0){
			return true;
		}
		else if(c1.getPalo().compareTo(c2.getPalo())==0&&c1.getPalo().compareTo(c3.getPalo())==0&&c1.getPalo().compareTo(c4.getPalo())==0&&c1.getPalo().compareTo(c6.getPalo())==0){
			return true;
		}
		else if(c1.getPalo().compareTo(c2.getPalo())==0&&c1.getPalo().compareTo(c3.getPalo())==0&&c1.getPalo().compareTo(c4.getPalo())==0&&c1.getPalo().compareTo(c7.getPalo())==0){
			return true;
		}
		else if(c1.getPalo().compareTo(c2.getPalo())==0&&c1.getPalo().compareTo(c3.getPalo())==0&&c1.getPalo().compareTo(c5.getPalo())==0&&c1.getPalo().compareTo(c6.getPalo())==0){
			return true;
		}
		else if(c1.getPalo().compareTo(c2.getPalo())==0&&c1.getPalo().compareTo(c3.getPalo())==0&&c1.getPalo().compareTo(c5.getPalo())==0&&c1.getPalo().compareTo(c7.getPalo())==0){
			return true;
		}
		else if(c1.getPalo().compareTo(c2.getPalo())==0&&c1.getPalo().compareTo(c4.getPalo())==0&&c1.getPalo().compareTo(c5.getPalo())==0&&c1.getPalo().compareTo(c6.getPalo())==0){
			return true;
		}
		else if(c1.getPalo().compareTo(c2.getPalo())==0&&c1.getPalo().compareTo(c4.getPalo())==0&&c1.getPalo().compareTo(c5.getPalo())==0&&c1.getPalo().compareTo(c7.getPalo())==0){
			return true;
		}
		else if(c1.getPalo().compareTo(c3.getPalo())==0&&c1.getPalo().compareTo(c4.getPalo())==0&&c1.getPalo().compareTo(c5.getPalo())==0&&c1.getPalo().compareTo(c6.getPalo())==0){
			return true;
		}
		else if(c1.getPalo().compareTo(c3.getPalo())==00&&c1.getPalo().compareTo(c4.getPalo())==0&&c1.getPalo().compareTo(c5.getPalo())==0&&c1.getPalo().compareTo(c7.getPalo())==0){
			return true;
		}
		else if(c2.getPalo().compareTo(c3.getPalo())==0&&c2.getPalo().compareTo(c4.getPalo())==0&&c2.getPalo().compareTo(c5.getPalo())==0&&c2.getPalo().compareTo(c6.getPalo())==0){
			return true;
		}
		else if(c2.getPalo().compareTo(c3.getPalo())==0&&c2.getPalo().compareTo(c4.getPalo())==0&&c2.getPalo().compareTo(c5.getPalo())==0&&c2.getPalo().compareTo(c7.getPalo())==0){
			return true;
		}
		return false;
	}

	public static boolean escalera(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		Carta c1=todasCartas.get(0);
		Carta c2=todasCartas.get(1);
		Carta c3=todasCartas.get(2);
		Carta c4=todasCartas.get(3);
		Carta c5=todasCartas.get(4);
		Carta c6=todasCartas.get(5);
		Carta c7=todasCartas.get(6);
		if(c1.getNumero().compareTo("UNO")==0&&c2.getNumero().compareTo("DOS")==0&&c3.getNumero().compareTo("TRES")==0&&c4.getNumero().compareTo("CUATRO")==0&&c5.getNumero().compareTo("CINCO")==0){
			return true;
		}
		else if(c1.getNumero().compareTo("DOS")==0&&c2.getNumero().compareTo("TRES")==0&&c3.getNumero().compareTo("CUATRO")==0&&c4.getNumero().compareTo("CINCO")==0&&c5.getNumero().compareTo("SEIS")==0){
			return true;
		}
		else if(c1.getNumero().compareTo("TRES")==0&&c2.getNumero().compareTo("CUATRO")==0&&c3.getNumero().compareTo("CINCO")==0&&c4.getNumero().compareTo("SEIS")==0&&c5.getNumero().compareTo("SIETE")==0){
			return true;
		}
		else if(c1.getNumero().compareTo("CUATRO")==0&&c2.getNumero().compareTo("CINCO")==0&&c3.getNumero().compareTo("SEIS")==0&&c4.getNumero().compareTo("SIETE")==0&&c5.getNumero().compareTo("OCHO")==0){
			return true;
		}
		else if(c1.getNumero().compareTo("CINCO")==0&&c2.getNumero().compareTo("SEIS")==0&&c3.getNumero().compareTo("SIETE")==0&&c4.getNumero().compareTo("OCHO")==0&&c5.getNumero().compareTo("NUEVE")==0){
			return true;
		}
		else if(c1.getNumero().compareTo("SEIS")==0&&c2.getNumero().compareTo("SIETE")==0&&c3.getNumero().compareTo("OCHO")==0&&c4.getNumero().compareTo("NUEVE")==0&&c5.getNumero().compareTo("DIEZ")==0){
			return true;
		}
		else if(c1.getNumero().compareTo("SIETE")==0&&c2.getNumero().compareTo("OCHO")==0&&c3.getNumero().compareTo("NUEVE")==0&&c4.getNumero().compareTo("DIEZ")==0&&c5.getNumero().compareTo("J")==0){
			return true;
		}
		else if(c1.getNumero().compareTo("OCHO")==0&&c2.getNumero().compareTo("NUEVE")==0&&c3.getNumero().compareTo("DIEZ")==0&&c4.getNumero().compareTo("J")==0&&c5.getNumero().compareTo("Q")==0){
			return true;
		}
		else if(c1.getNumero().compareTo("NUEVE")==0&&c2.getNumero().compareTo("DIEZ")==0&&c3.getNumero().compareTo("J")==0&&c4.getNumero().compareTo("Q")==0&&c5.getNumero().compareTo("K")==0){
			return true;
		}
		else if(c2.getNumero().compareTo("UNO")==0&&c3.getNumero().compareTo("DOS")==0&&c4.getNumero().compareTo("TRES")==0&&c5.getNumero().compareTo("CUATRO")==0&&c6.getNumero().compareTo("CINCO")==0){
			return true;
		}
		else if(c2.getNumero().compareTo("DOS")==0&&c3.getNumero().compareTo("TRES")==0&&c4.getNumero().compareTo("CUATRO")==0&&c5.getNumero().compareTo("CINCO")==0&&c6.getNumero().compareTo("SEIS")==0){
			return true;
		}
		else if(c2.getNumero().compareTo("TRES")==0&&c3.getNumero().compareTo("CUATRO")==0&&c4.getNumero().compareTo("CINCO")==0&&c5.getNumero().compareTo("SEIS")==0&&c6.getNumero().compareTo("SIETE")==0){
			return true;
		}
		else if(c2.getNumero().compareTo("CUATRO")==0&&c3.getNumero().compareTo("CINCO")==0&&c4.getNumero().compareTo("SEIS")==0&&c5.getNumero().compareTo("SIETE")==0&&c6.getNumero().compareTo("OCHO")==0){
			return true;
		}
		else if(c2.getNumero().compareTo("CINCO")==0&&c3.getNumero().compareTo("SEIS")==0&&c4.getNumero().compareTo("SIETE")==0&&c5.getNumero().compareTo("OCHO")==0&&c6.getNumero().compareTo("NUEVE")==0){
			return true;
		}
		else if(c2.getNumero().compareTo("SEIS")==0&&c3.getNumero().compareTo("SIETE")==0&&c4.getNumero().compareTo("OCHO")==0&&c5.getNumero().compareTo("NUEVE")==0&&c6.getNumero().compareTo("DIEZ")==0){
			return true;
		}
		else if(c2.getNumero().compareTo("SIETE")==0&&c3.getNumero().compareTo("OCHO")==0&&c4.getNumero().compareTo("NUEVE")==0&&c5.getNumero().compareTo("DIEZ")==0&&c6.getNumero().compareTo("J")==0){
			return true;
		}
		else if(c2.getNumero().compareTo("OCHO")==0&&c3.getNumero().compareTo("NUEVE")==0&&c4.getNumero().compareTo("DIEZ")==0&&c5.getNumero().compareTo("J")==0&&c6.getNumero().compareTo("Q")==0){
			return true;
		}
		else if(c2.getNumero().compareTo("NUEVE")==0&&c3.getNumero().compareTo("DIEZ")==0&&c4.getNumero().compareTo("J")==0&&c5.getNumero().compareTo("Q")==0&&c6.getNumero().compareTo("K")==0){
			return true;
		}
		else if(c3.getNumero().compareTo("UNO")==0&&c4.getNumero().compareTo("DOS")==0&&c5.getNumero().compareTo("TRES")==0&&c6.getNumero().compareTo("CUATRO")==0&&c7.getNumero().compareTo("CINCO")==0){
			return true;
		}
		else if(c3.getNumero().compareTo("DOS")==0&&c4.getNumero().compareTo("TRES")==0&&c5.getNumero().compareTo("CUATRO")==0&&c6.getNumero().compareTo("CINCO")==0&&c7.getNumero().compareTo("SEIS")==0){
			return true;
		}
		else if(c3.getNumero().compareTo("TRES")==0&&c4.getNumero().compareTo("CUATRO")==0&&c5.getNumero().compareTo("CINCO")==0&&c6.getNumero().compareTo("SEIS")==0&&c7.getNumero().compareTo("SIETE")==0){
			return true;
		}
		else if(c3.getNumero().compareTo("CUATRO")==0&&c4.getNumero().compareTo("CINCO")==0&&c5.getNumero().compareTo("SEIS")==0&&c6.getNumero().compareTo("SIETE")==0&&c7.getNumero().compareTo("OCHO")==0){
			return true;
		}
		else if(c3.getNumero().compareTo("CINCO")==0&&c4.getNumero().compareTo("SEIS")==0&&c5.getNumero().compareTo("SIETE")==0&&c6.getNumero().compareTo("OCHO")==0&&c7.getNumero().compareTo("NUEVE")==0){
			return true;
		}
		else if(c3.getNumero().compareTo("SEIS")==0&&c4.getNumero().compareTo("SIETE")==0&&c5.getNumero().compareTo("OCHO")==0&&c6.getNumero().compareTo("NUEVE")==0&&c7.getNumero().compareTo("DIEZ")==0){
			return true;
		}
		else if(c3.getNumero().compareTo("SIETE")==0&&c4.getNumero().compareTo("OCHO")==0&&c5.getNumero().compareTo("NUEVE")==0&&c6.getNumero().compareTo("DIEZ")==0&&c7.getNumero().compareTo("J")==0){
			return true;
		}
		else if(c3.getNumero().compareTo("OCHO")==0&&c4.getNumero().compareTo("NUEVE")==0&&c5.getNumero().compareTo("DIEZ")==0&&c6.getNumero().compareTo("J")==0&&c7.getNumero().compareTo("Q")==0){
			return true;
		}
		else if(c3.getNumero().compareTo("NUEVE")==0&&c4.getNumero().compareTo("DIEZ")==0&&c5.getNumero().compareTo("J")==0&&c6.getNumero().compareTo("Q")==0&&c7.getNumero().compareTo("K")==0){
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean trio(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		Collections.sort(todasCartas);
		Carta c1=todasCartas.get(0);
		Carta c2=todasCartas.get(1);
		Carta c3=todasCartas.get(2);
		Carta c4=todasCartas.get(3);
		Carta c5=todasCartas.get(4);
		Carta c6=todasCartas.get(5);
		Carta c7=todasCartas.get(6);
		if(c1.getNumero().compareTo(c2.getNumero())==0&&c1.getNumero().compareTo(c3.getNumero())==0){
			return true;
		}
		else if(c2.getNumero().compareTo(c3.getNumero())==0&&c2.getNumero().compareTo(c4.getNumero())==0){
			return true;
		}
		else if(c3.getNumero().compareTo(c4.getNumero())==0&&c3.getNumero().compareTo(c5.getNumero())==0){
			return true;
		}
		else if(c4.getNumero().compareTo(c5.getNumero())==0&&c4.getNumero().compareTo(c6.getNumero())==0){
			return true;
		}
		else if(c5.getNumero().compareTo(c6.getNumero())==0&&c5.getNumero().compareTo(c7.getNumero())==0){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean doblesParejas(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		Collections.sort(todasCartas);
		Carta c1=todasCartas.get(0);
		Carta c2=todasCartas.get(1);
		Carta c3=todasCartas.get(2);
		Carta c4=todasCartas.get(3);
		Carta c5=todasCartas.get(4);
		Carta c6=todasCartas.get(5);
		Carta c7=todasCartas.get(6);
		if(c1.getNumero().compareTo(c2.getNumero())==0&&(c3.getNumero().compareTo(c4.getNumero())==0||c4.getNumero().compareTo(c5.getNumero())==0||c5.getNumero().compareTo(c6.getNumero())==0||c6.getNumero().compareTo(c7.getNumero())==0)){
			return true;
		}
		else if(c2.getNumero().compareTo(c3.getNumero())==0&&(c4.getNumero().compareTo(c5.getNumero())==0||c5.getNumero().compareTo(c6.getNumero())==0||c6.getNumero().compareTo(c7.getNumero())==0)){
			return true;
		}
		else if(c3.getNumero().compareTo(c4.getNumero())==0&&(c1.getNumero().compareTo(c2.getNumero())==0||c5.getNumero().compareTo(c6.getNumero())==0||c6.getNumero().compareTo(c7.getNumero())==0)){
			return true;
		}
		else if(c4.getNumero().compareTo(c5.getNumero())==0&&(c1.getNumero().compareTo(c2.getNumero())==0||c2.getNumero().compareTo(c3.getNumero())==0||c6.getNumero().compareTo(c7.getNumero())==0)){
			return true;
		}
		else if(c5.getNumero().compareTo(c6.getNumero())==0&&(c1.getNumero().compareTo(c2.getNumero())==0||c2.getNumero().compareTo(c3.getNumero())==0||c3.getNumero().compareTo(c4.getNumero())==0)){
			return true;
		}
		else if(c6.getNumero().compareTo(c7.getNumero())==0&&(c1.getNumero().compareTo(c2.getNumero())==0||c2.getNumero().compareTo(c3.getNumero())==0||c3.getNumero().compareTo(c4.getNumero())==0||c4.getNumero().compareTo(c5.getNumero())==0)){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean pareja(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		Collections.sort(todasCartas);
		Carta c1=todasCartas.get(0);
		Carta c2=todasCartas.get(1);
		Carta c3=todasCartas.get(2);
		Carta c4=todasCartas.get(3);
		Carta c5=todasCartas.get(4);
		Carta c6=todasCartas.get(5);
		Carta c7=todasCartas.get(6);
		if(c1.getNumero().compareTo(c2.getNumero())==0){
			return true;
		}
		else if(c2.getNumero().compareTo(c3.getNumero())==0){
			return true;
		}
		else if(c3.getNumero().compareTo(c4.getNumero())==0){
			return true;
		}
		else if(c4.getNumero().compareTo(c5.getNumero())==0){
			return true;
		}
		else if(c5.getNumero().compareTo(c6.getNumero())==0){
			return true;
		}
		else if(c6.getNumero().compareTo(c7.getNumero())==0){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean cartaAlta(Jugador gamer, Vector<Carta> mesa) {
		Vector<Carta> todasCartas=mesa;
		todasCartas.add(gamer.getCarta1());
		todasCartas.add(gamer.getCarta2());
		return false;
	}

}
