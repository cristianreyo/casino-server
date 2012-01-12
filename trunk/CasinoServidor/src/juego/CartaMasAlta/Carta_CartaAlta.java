/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.CartaMasAlta;

import java.io.Serializable;

/**
 *
 * @author Miguel Angel Fuentes Cardenas
 */
public class Carta_CartaAlta implements Serializable{
    
    
    private static final long serialVersionUID=5;
    
    
    private String tipo;
    private int numero;
    private String simbolo;
    private int valor;
    
    public Carta_CartaAlta(String tipo, int numero){
        this.tipo = tipo;
        this.numero = numero;
        this.valor = numero;
        
        if(numero <= 10)
            simbolo = Integer.toString(numero);
        else{
            
        }
        
        switch(numero){
            case 11:
                this.simbolo="J";
                break;
            case 12:
                this.simbolo="Q";
                break;
            case 13:
                this.simbolo="K";
                break;    
        }
    }
    
    public int getValor(){
        return this.valor;
    }

    public int getNumero() {
        return numero;
    }    

    public String getSimbolo() {
        return simbolo;
    }    

    public String getTipo() {
        return tipo;
    }    
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
       public String getRutaImage(){
        return "Recursos/"+simbolo+"-"+tipo+".jpg";
    }
    
}
