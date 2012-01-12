/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.Poker;

/**
 *
 * @author Fernando
 */
import java.io.*;
import java.net.*;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import general.*;

public class ModeloPoker {

    private String cantidad; //Cantidad que apuesto
    private String puntosAc; //Puntos acumulados
    private String totalMesa; //La suma de las apuestas de los jugadores
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Vector<Carta> cartasMesa = new Vector<Carta>();
    private ImageIcon cartaMesa1;
    private ImageIcon cartaMesa2;
    private ImageIcon cartaMesa3;
    private ImageIcon cartaMesa4;
    private ImageIcon cartaMesa5;
    private ImageIcon cartaMia1;
    private ImageIcon cartaMia2;
    private Carta carta1;
    private Carta carta2;

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public void desconectar() {
    }

    public void apostar() {
        int apuesto = Integer.parseInt(cantidad);
        int total = Integer.parseInt(puntosAc);
        puntosAc = Integer.toString(total - apuesto);
        if (Integer.parseInt(puntosAc) - apuesto > 0) {
            try {
                oos.writeObject(cantidad);
                Integer a = (Integer) ois.readObject();
                totalMesa = Integer.toString(a);
                if (cartaMesa5.toString().compareTo("imagenes/trasera.jpg") == 0) {
                    int tamanoMesa = ois.readInt();// Obtengo el tamaño de la mesa (4)
                    // Recibo las cuatro cartas
                    cartasMesa.clear();
                    for (int i = 0; i < tamanoMesa; i++) {
                        cartasMesa.add((Carta) ois.readObject());
                    }
                    System.out.println("Antes del tamaño igual a 4");
                    if (tamanoMesa == 4) {
                        cartaMesa1 = cartasMesa.get(0).getImagen();
                        cartaMesa2 = cartasMesa.get(1).getImagen();
                        cartaMesa3 = cartasMesa.get(2).getImagen();
                        cartaMesa4 = cartasMesa.get(3).getImagen();
                        cartaMesa5 = new ImageIcon("imagenes/trasera.jpg");
                    } else if (tamanoMesa == 5) {
                        cartaMesa1 = cartasMesa.get(0).getImagen();
                        cartaMesa2 = cartasMesa.get(1).getImagen();
                        cartaMesa3 = cartasMesa.get(2).getImagen();
                        cartaMesa4 = cartasMesa.get(3).getImagen();
                        cartaMesa5 = cartasMesa.get(4).getImagen();
                    }
                } else {
                    String ganador = (String) ois.readObject();
                    System.out.println(ganador);
                    puntosAc = Integer.toString((Integer) ois.readObject());
                    cartasMesa.clear();// Limpio las cartas
                    int tamanoMesa = ois.readInt(); // Leo el numero de cartas a recibir
                    // Recibo las cartas (3)
                    for (int i = 0; i < tamanoMesa; i++) {
                        cartasMesa.add((Carta) ois.readObject());
                    }
                    // Muestro por pantalla las cartas
                    cartaMesa1 = cartasMesa.get(0).getImagen();
                    cartaMesa2 = cartasMesa.get(1).getImagen();
                    cartaMesa3 = cartasMesa.get(2).getImagen();
                    cartaMesa4 = new ImageIcon("imagenes/trasera.jpg");
                    cartaMesa5 = new ImageIcon("imagenes/trasera.jpg");
                    carta1 = (Carta) ois.readObject(); // Leo mi carta 1
                    carta2 = (Carta) ois.readObject(); // Leo mi carta 2
                    cartaMia1 = carta1.getImagen();
                    cartaMia2 = carta2.getImagen();
                    totalMesa = "0";
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void resto() {
        try {
            oos.writeObject(puntosAc);
            Integer a = (Integer) ois.readObject();
            totalMesa = Integer.toString(a);
            puntosAc = "0";
            if (cartaMesa5.toString().compareTo("imagenes/trasera.jpg") == 0) {
                int tamanoMesa = ois.readInt();// Obtengo el tamaño de la mesa (4)
                // Recibo las cuatro cartas
                cartasMesa.clear();
                for (int i = 0; i < tamanoMesa; i++) {
                    cartasMesa.add((Carta) ois.readObject());
                }
                System.out.println("Antes del tamaño igual a 4");
                if (tamanoMesa == 4) {
                    cartaMesa1 = cartasMesa.get(0).getImagen();
                    cartaMesa2 = cartasMesa.get(1).getImagen();
                    cartaMesa3 = cartasMesa.get(2).getImagen();
                    cartaMesa4 = cartasMesa.get(3).getImagen();
                    cartaMesa5 = new ImageIcon("imagenes/trasera.jpg");
                } else if (tamanoMesa == 5) {
                    cartaMesa1 = cartasMesa.get(0).getImagen();
                    cartaMesa2 = cartasMesa.get(1).getImagen();
                    cartaMesa3 = cartasMesa.get(2).getImagen();
                    cartaMesa4 = cartasMesa.get(3).getImagen();
                    cartaMesa5 = cartasMesa.get(4).getImagen();
                }
            } else {

                String ganador = (String) ois.readObject();
                System.out.println(ganador);
                puntosAc = Integer.toString((Integer) ois.readObject());
                cartasMesa.clear();// Limpio las cartas
                int tamanoMesa = ois.readInt(); // Leo el numero de cartas a recibir
                // Recibo las cartas (3)
                for (int i = 0; i < tamanoMesa; i++) {
                    cartasMesa.add((Carta) ois.readObject());
                }
                // Muestro por pantalla las cartas
                cartaMesa1 = cartasMesa.get(0).getImagen();
                cartaMesa2 = cartasMesa.get(1).getImagen();
                cartaMesa3 = cartasMesa.get(2).getImagen();
                cartaMesa4 = new ImageIcon("imagenes/trasera.jpg");
                cartaMesa5 = new ImageIcon("imagenes/trasera.jpg");
                carta1 = (Carta) ois.readObject(); // Leo mi carta 1
                carta2 = (Carta) ois.readObject(); // Leo mi carta 2
                cartaMia1 = carta1.getImagen();
                cartaMia2 = carta2.getImagen();
                totalMesa = "0";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void conectar() {
        try {
            puntosAc = Integer.toString((Integer) ois.readObject());
            System.out.println(puntosAc);
            System.out.println("Antes de leer un numero");
            cartasMesa.clear();// Limpio las cartas
            int tamanoMesa = ois.readInt(); // Leo el numero de cartas a recibir
            // Recibo las cartas (3)
            System.out.println("antes de leer las cartas");
            for (int i = 0; i < tamanoMesa; i++) {
                cartasMesa.add((Carta) ois.readObject());
            }
            // Muestro por pantalla las cartas
            cartaMesa1 = cartasMesa.get(0).getImagen();
            cartaMesa2 = cartasMesa.get(1).getImagen();
            cartaMesa3 = cartasMesa.get(2).getImagen();
            cartaMesa4 = new ImageIcon("imagenes/trasera.jpg");
            cartaMesa5 = new ImageIcon("imagenes/trasera.jpg");
            cartasMesa.clear(); // Limpio las cartas de la mesa
            carta1 = (Carta) ois.readObject(); // Leo mi carta 1
            carta2 = (Carta) ois.readObject(); // Leo mi carta 2
            cartaMia1 = carta1.getImagen();
            cartaMia2 = carta2.getImagen();
            totalMesa = "0";

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void paso() {
        try {
            oos.writeObject("0");
            Integer a = (Integer) ois.readObject();
            totalMesa = Integer.toString(a);
            if (cartaMesa5.toString().compareTo("imagenes/trasera.jpg") == 0) {
                int tamanoMesa = ois.readInt();// Obtengo el tamaño de la mesa (4)
                // Recibo las cuatro cartas
                cartasMesa.clear();
                for (int i = 0; i < tamanoMesa; i++) {
                    cartasMesa.add((Carta) ois.readObject());
                }
                System.out.println("Antes del tamaño igual a 4");
                if (tamanoMesa == 4) {
                    cartaMesa1 = cartasMesa.get(0).getImagen();
                    cartaMesa2 = cartasMesa.get(1).getImagen();
                    cartaMesa3 = cartasMesa.get(2).getImagen();
                    cartaMesa4 = cartasMesa.get(3).getImagen();
                    cartaMesa5 = new ImageIcon("imagenes/trasera.jpg");
                } else if (tamanoMesa == 5) {
                    cartaMesa1 = cartasMesa.get(0).getImagen();
                    cartaMesa2 = cartasMesa.get(1).getImagen();
                    cartaMesa3 = cartasMesa.get(2).getImagen();
                    cartaMesa4 = cartasMesa.get(3).getImagen();
                    cartaMesa5 = cartasMesa.get(4).getImagen();
                }
            } else {
                String ganador = (String) ois.readObject();
                System.out.println(ganador);
                cartasMesa.clear();// Limpio las cartas
                int tamanoMesa = ois.readInt(); // Leo el numero de cartas a recibir
                // Recibo las cartas (3)
                for (int i = 0; i < tamanoMesa; i++) {
                    cartasMesa.add((Carta) ois.readObject());
                }
                // Muestro por pantalla las cartas
                cartaMesa1 = cartasMesa.get(0).getImagen();
                cartaMesa2 = cartasMesa.get(1).getImagen();
                cartaMesa3 = cartasMesa.get(2).getImagen();
                cartaMesa4 = new ImageIcon("imagenes/trasera.jpg");
                cartaMesa5 = new ImageIcon("imagenes/trasera.jpg");
                cartasMesa.clear(); // Limpio las cartas de la mesa
                carta1 = (Carta) ois.readObject(); // Leo mi carta 1
                carta2 = (Carta) ois.readObject(); // Leo mi carta 2
                cartaMia1 = carta1.getImagen();
                cartaMia2 = carta2.getImagen();
                totalMesa = "0";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPuntosAc() {
        return puntosAc;
    }

    public void setPuntosAc(String puntosAc) {
        this.puntosAc = puntosAc;
    }

    public String getTotalMesa() {
        return totalMesa;
    }

    public void setTotalMesa(String totalMesa) {
        this.totalMesa = totalMesa;
    }

    public Vector<Carta> getCartasMesa() {
        return cartasMesa;
    }

    public void setCartasMesa(Vector<Carta> cartasMesa) {
        this.cartasMesa = cartasMesa;
    }

    public ImageIcon getCartaMesa1() {
        return cartaMesa1;
    }

    public void setCartaMesa1(ImageIcon cartaMesa1) {
        this.cartaMesa1 = cartaMesa1;
    }

    public ImageIcon getCartaMesa2() {
        return cartaMesa2;
    }

    public void setCartaMesa2(ImageIcon cartaMesa2) {
        this.cartaMesa2 = cartaMesa2;
    }

    public ImageIcon getCartaMesa3() {
        return cartaMesa3;
    }

    public void setCartaMesa3(ImageIcon cartaMesa3) {
        this.cartaMesa3 = cartaMesa3;
    }

    public ImageIcon getCartaMesa4() {
        return cartaMesa4;
    }

    public void setCartaMesa4(ImageIcon cartaMesa4) {
        this.cartaMesa4 = cartaMesa4;
    }

    public ImageIcon getCartaMesa5() {
        return cartaMesa5;
    }

    public void setCartaMesa5(ImageIcon cartaMesa5) {
        this.cartaMesa5 = cartaMesa5;
    }

    public ImageIcon getCartaMia1() {
        return cartaMia1;
    }

    public void setCartaMia1(ImageIcon cartaMia1) {
        this.cartaMia1 = cartaMia1;
    }

    public ImageIcon getCartaMia2() {
        return cartaMia2;
    }

    public void setCartaMia2(ImageIcon cartaMia2) {
        this.cartaMia2 = cartaMia2;
    }
}
