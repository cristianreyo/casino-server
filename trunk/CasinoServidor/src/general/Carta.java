package general;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class Carta implements Serializable, Comparable {
	private static final long serialVersionUID=1;
	private String numero; //El numero de la carta
	private String palo; //El palo de la carta
	private String color; //El color de la carta
	private ImageIcon imagen; //Imagen de la carta
	


	/**
	 * Metodo constructor en el que se indican los atributos de la carta
	 * @param numero. Numero que tendra la carta. Puede ser del 1 al 10 o j, q, k
	 * @param palo. Indica el palo de la carta, puede ser treboles, rombos, corazones o picas
	 * @param color. Indica el color de la carta. puede ser rojo o negro.
	 */
	public Carta(String numero, String palo, String color, ImageIcon imagen){
		this.numero=numero;
		this.palo=palo;
		this.color=color;
		this.imagen=imagen;
	}
	
	/**
	 * Metodo para obtener el numero de la carta
	 * @return numero. Es el numero de la carta
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Permite asignarle un numero a una carta
	 * @param numero. Es el nuevo numero que tendra la carta.
	 */
	public void setNumero(String numero) {
		if(numero.compareTo("UNO")==0||numero.compareTo("DOS")==0||numero.compareTo("TRES")==0||numero.compareTo("CUATRO")==0||
		   numero.compareTo("CINCO")==0||numero.compareTo("SEIS")==0||numero.compareTo("SIETE")==0||numero.compareTo("OCHO")==0||
		   numero.compareTo("NUEVE")==0||numero.compareTo("DIEZ")==0||numero.compareTo("J")==0||numero.compareTo("Q")==0||numero.compareTo("K")==0){
			this.numero = numero;
		}
	}
	
	/**
	 * Metodo para obtener el palo de una carta
	 * @return palo. Es el palo de la carta
	 */
	public String getPalo() {
		return palo;
	}
	
	/**
	 * Permite modificar el palo de una carta.
	 * @param palo. Es el nuevo valor del palo de la carta
	 */
	public void setPalo(String palo) {
		if(palo.compareTo("PICAS")==0||palo.compareTo("CORAZONES")==0||
		   palo.compareTo("TREBOLES")==0||palo.compareTo("ROMBOS")==0){
			this.palo = palo;
		}
	}
	
	/**
	 * Metodo para obtener el color de una carta
	 * @return color. Es el color de la carta
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * Permite modificar el color de la carta
	 * @param color. Es el nuevo color de la carta
	 */
	public void setColor(String color) {
	if(color.compareTo("ROJO")==0||color.compareTo("NEGRO")==0)
		this.color = color;
	}
	/**
	 * Metodo que devuelve un objeto de tipo imagen
	 * @return imagen. Es la imagen asociada a una carta
	 */
	public ImageIcon getImagen() {
		return imagen;
	}
	
	/**
	 * Metodo que permite asignarle una imagen a una carta.
	 * @param imagen. Es la imagen asociada a la carta
	 */
	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}
	/**
	 * Metodo que devuelve el ID de la clase. Se utiliza para serializar.
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
        @Override
	public int compareTo(Object o) {
		Carta aux=(Carta)o;
		if(this.numero.compareTo("UNO")==0&&aux.numero.compareTo("UNO")!=0){
			return -1;
		}
		else if(this.numero.compareTo("DOS")==0&&aux.numero.compareTo("UNO")==0){
			return 1;
		}
		else if(this.numero.compareTo("DOS")==0&&(aux.numero.compareTo("TRES")==0||aux.numero.compareTo("CUATRO")==0||aux.numero.compareTo("CINCO")==0||aux.numero.compareTo("SEIS")==0||aux.numero.compareTo("SIETE")==0||aux.numero.compareTo("OCHO")==0||aux.numero.compareTo("NUEVE")==0||aux.numero.compareTo("DIEZ")==0||aux.numero.compareTo("J")==0||aux.numero.compareTo("Q")==0||aux.numero.compareTo("K")==0)){
			return -1;
		}
		else if(this.numero.compareTo("TRES")==0&&(aux.numero.compareTo("DOS")==0 ||aux.numero.compareTo("UNO")==0)){
			return 1;
		}
		else if(this.numero.compareTo("TRES")==0&&(aux.numero.compareTo("CUATRO")==0||aux.numero.compareTo("CINCO")==0||aux.numero.compareTo("SEIS")==0||aux.numero.compareTo("SIETE")==0||aux.numero.compareTo("OCHO")==0||aux.numero.compareTo("NUEVE")==0||aux.numero.compareTo("DIEZ")==0||aux.numero.compareTo("J")==0||aux.numero.compareTo("Q")==0||aux.numero.compareTo("K")==0)){
			return -1;
		}
		else if(this.numero.compareTo("CUATRO")==0&&(aux.numero.compareTo("TRES")==0||aux.numero.compareTo("DOS")==0 ||aux.numero.compareTo("UNO")==0)){
			return 1;
		}
		else if(this.numero.compareTo("CUATRO")==0&&(aux.numero.compareTo("CINCO")==0||aux.numero.compareTo("SEIS")==0||aux.numero.compareTo("SIETE")==0||aux.numero.compareTo("OCHO")==0||aux.numero.compareTo("NUEVE")==0||aux.numero.compareTo("DIEZ")==0||aux.numero.compareTo("J")==0||aux.numero.compareTo("Q")==0||aux.numero.compareTo("K")==0)){
			return -1;
		}
		else if(this.numero.compareTo("CINCO")==0&&(aux.numero.compareTo("CUATRO")==0 ||aux.numero.compareTo("TRES")==0 ||aux.numero.compareTo("DOS")==0 ||aux.numero.compareTo("UNO")==0)){
			return 1;
		}
		else if(this.numero.compareTo("CINCO")==0&&(aux.numero.compareTo("SEIS")==0||aux.numero.compareTo("SIETE")==0||aux.numero.compareTo("OCHO")==0||aux.numero.compareTo("NUEVE")==0||aux.numero.compareTo("DIEZ")==0||aux.numero.compareTo("J")==0||aux.numero.compareTo("Q")==0||aux.numero.compareTo("K")==0)){
			return -1;
		}
		else if(this.numero.compareTo("SEIS")==0 && (aux.numero.compareTo("CINCO")==0||aux.numero.compareTo("CUATRO")==0||aux.numero.compareTo("TRES")==0||aux.numero.compareTo("DOS")==0||aux.numero.compareTo("UNO")==0)){
			return 1;
		}
		else if(this.numero.compareTo("SEIS")==0&& (aux.numero.compareTo("SIETE")==0||aux.numero.compareTo("OCHO")==0||aux.numero.compareTo("NUEVE")==0||aux.numero.compareTo("DIEZ")==0||aux.numero.compareTo("J")==0||aux.numero.compareTo("Q")==0||aux.numero.compareTo("K")==0)){
			return -1;
		}
		else if(this.numero.compareTo("SIETE")==0&&(aux.numero.compareTo("UNO")==0||aux.numero.compareTo("DOS")==0||aux.numero.compareTo("TRES")==0||aux.numero.compareTo("CUATRO")==0||aux.numero.compareTo("CINCO")==0||aux.numero.compareTo("SEIS")==0)){
			return 1;
		}
		else if(this.numero.compareTo("SIETE")==0&&(aux.numero.compareTo("K")==0 || aux.numero.compareTo("Q")==0||aux.numero.compareTo("J")==0||aux.numero.compareTo("DIEZ")==0||aux.numero.compareTo("NUEVE")==0||aux.numero.compareTo("OCHO")==0 )){
			return -1;
		}
		else if(this.numero.compareTo("OCHO")==0&&(aux.numero.compareTo("UNO")==0||aux.numero.compareTo("DOS")==0||aux.numero.compareTo("TRES")==0||aux.numero.compareTo("CUATRO")==0||aux.numero.compareTo("CINCO")==0||aux.numero.compareTo("SEIS")==0||aux.numero.compareTo("SIETE")==0)){
			return 1;
		}
		else if(this.numero.compareTo("OCHO")==0&&(aux.numero.compareTo("K")==0 || aux.numero.compareTo("Q")==0||aux.numero.compareTo("J")==0||aux.numero.compareTo("DIEZ")==0||aux.numero.compareTo("NUEVE")==0)){
			return -1;
		}
		else if(this.numero.compareTo("NUEVE")==0&&(aux.numero.compareTo("UNO")==0||aux.numero.compareTo("DOS")==0||aux.numero.compareTo("TRES")==0||aux.numero.compareTo("CUATRO")==0||aux.numero.compareTo("CINCO")==0||aux.numero.compareTo("SEIS")==0||aux.numero.compareTo("SIETE")==0||aux.numero.compareTo("OCHO")==0)){
			return 1;
		}
		else if(this.numero.compareTo("NUEVE")==0&&(aux.numero.compareTo("K")==0 || aux.numero.compareTo("Q")==0||aux.numero.compareTo("J")==0||aux.numero.compareTo("DIEZ")==0 )){
			return -1;
		}
		else if(this.numero.compareTo("DIEZ")==0&&(aux.numero.compareTo("UNO")==0||aux.numero.compareTo("DOS")==0||aux.numero.compareTo("TRES")==0||aux.numero.compareTo("CUATRO")==0||aux.numero.compareTo("CINCO")==0||aux.numero.compareTo("SEIS")==0||aux.numero.compareTo("SIETE")==0||aux.numero.compareTo("OCHO")==0||aux.numero.compareTo("NUEVE")==0)){
			return 1;
		}
		else if(this.numero.compareTo("DIEZ")==0&&(aux.numero.compareTo("K")==0 || aux.numero.compareTo("Q")==0||aux.numero.compareTo("J")==0)){
			return -1;
		}
		else if(this.numero.compareTo("J")==0&&(aux.numero.compareTo("UNO")==0||aux.numero.compareTo("DOS")==0||aux.numero.compareTo("TRES")==0||aux.numero.compareTo("CUATRO")==0||aux.numero.compareTo("CINCO")==0||aux.numero.compareTo("SEIS")==0||aux.numero.compareTo("SIETE")==0||aux.numero.compareTo("OCHO")==0||aux.numero.compareTo("NUEVE")==0||aux.numero.compareTo("DIEZ")==0)){
			return 1;
		}
		else if(this.numero.compareTo("J")==0&&(aux.numero.compareTo("K")==0 || aux.numero.compareTo("Q")==0)){
			return -1;
		}
		else if(this.numero.compareTo("Q")==0&&(aux.numero.compareTo("UNO")==0||aux.numero.compareTo("DOS")==0||aux.numero.compareTo("TRES")==0||aux.numero.compareTo("CUATRO")==0||aux.numero.compareTo("CINCO")==0||aux.numero.compareTo("SEIS")==0||aux.numero.compareTo("SIETE")==0||aux.numero.compareTo("OCHO")==0||aux.numero.compareTo("NUEVE")==0||aux.numero.compareTo("DIEZ")==0||aux.numero.compareTo("J")==0)){
			return 1;
		}
		else if(this.numero.compareTo("Q")==0&&(aux.numero.compareTo("K")==0)){
			return -1;
		}
		else if(this.numero.compareTo("K")==0&&aux.numero.compareTo("K")!=0){
			return 1;
		}
		else if(this.numero.compareTo(aux.numero)==0){
			return 0;
		}
		else
			return 0;
	}
}
