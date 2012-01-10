/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.Dados;

/**
 *
 * @author Antonio
 */
public class Dado {
    

     private int valor;
     

    public void setValor(int valor) {
        this.valor = valor;
    }    
    

    public int getValor() {
        return valor;
    }  
   
    
    public void tirar(){
         valor = (int) (Math.random()*6+1);
    }
}
