/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.Dados;

/**
 *
 * @author Antonio
 */
public class Dado2 {

    /**
     * @param args the command line arguments
     */
     private int valor;

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public Dado2() {
    }

   public int getValor() {
        return valor;
    }
  
   
    
    public void tirar(){
         valor = (int) (Math.random()*6+1);
    }
}
