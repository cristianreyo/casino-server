/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import general.Carta;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import javax.imageio.ImageIO;
import juego.Poker.ModeloPoker;
/**
 *
 * @author Fernando
 */
public class InterfazPoker extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JPanel contentPane;
	private JTextField textField_PuntosAc;
	private JTextField textField_Cantidad;
	private JTextField textField_Total;
	private Socket servidor;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Carta carta1; // Carta1 del jugador
	private Carta carta2; // Carta2 del jugador
	private Vector<Carta> cartasMesa = new Vector<Carta>();// Cartas sobre la mesa
	private JButton btnApuesto = new JButton("Apuesto");
	private JButton btnPaso = new JButton("Paso");
	private JButton btnResto = new JButton("Resto");
	private JButton btnConectar = new JButton("Conectar");
	private final JLabel cartaMia1=new JLabel();
	private final JLabel cartaMia2=new JLabel();
	private final JLabel cartaMesa1=new JLabel();
	private final JLabel cartaMesa2=new JLabel();
	private final JLabel cartaMesa3=new JLabel();
	private final JLabel cartaMesa4=new JLabel();
	private final JLabel cartaMesa5=new JLabel();

	private ModeloPoker modelo;

	/**
	 * Create the frame.
	 */
	public InterfazPoker(ModeloPoker modelo) {
		this.modelo=modelo;
		//setTitle("Poker");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1084, 468);
		//contentPane = new JPanel();
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		//setContentPane(contentPane);
            
            
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 719, 408);
		panel.setLayout(null);
		this.add(panel); 
		
		cartaMesa1.setBounds(0,15,114,154);
		cartaMesa1.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		panel.add(cartaMesa1);
		
		final JButton botonAceptar=new JButton();
		botonAceptar.setText("Aceptar");
		
		cartaMesa2.setBounds(124,15,114,154);
		cartaMesa2.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		panel.add(cartaMesa2);
		
		cartaMesa3.setBounds(248,15,114,154);
		cartaMesa3.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		panel.add(cartaMesa3);
		
		cartaMesa4.setBounds(372,15,114,154);
		cartaMesa4.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		panel.add(cartaMesa4);
		
		cartaMesa5.setBounds(496,15,114,154);
		cartaMesa5.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		panel.add(cartaMesa5);
		
		cartaMia1.setVerticalAlignment(SwingConstants.BOTTOM);
		cartaMia1.setBounds(180,250,114,154);
		cartaMia1.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		panel.add(cartaMia1);
		
		cartaMia2.setVerticalAlignment(SwingConstants.BOTTOM);
		cartaMia2.setBounds(304,250,114,154);
		cartaMia2.setIcon(new ImageIcon("imagenes/trasera.jpg"));
		panel.add(cartaMia2);
		
		JLabel lblPuntos = new JLabel("Puntos Acumulados");
		lblPuntos.setBounds(739, 103, 126, 14);
		this.add(lblPuntos);
		
		textField_PuntosAc = new JTextField();
		textField_PuntosAc.setBounds(875, 100, 183, 20);
		
		this.add(textField_PuntosAc);
		textField_PuntosAc.setColumns(10);
		
		JLabel lblCantidadAApostar = new JLabel("Cantidad a Apostar:");
		lblCantidadAApostar.setBounds(739, 148, 126, 14);
		this.add(lblCantidadAApostar);
		
		textField_Cantidad = new JTextField();
		textField_Cantidad.setBounds(875, 145, 183, 20);
		
		this.add(textField_Cantidad);
		textField_Cantidad.setColumns(10);
		
		JLabel lblTotalEnLa = new JLabel("Total en la mesa:");
		lblTotalEnLa.setBounds(739, 190, 126, 14);
		this.add(lblTotalEnLa);
		
		textField_Total = new JTextField();
		textField_Total.setBounds(875, 187, 183, 20);
		this.add(textField_Total);
		textField_Total.setColumns(10);
		
		btnApuesto.setBounds(758, 240, 89, 23);
		this.add(btnApuesto);
		
		btnPaso.setBounds(853, 240, 89, 23);
		this.add(btnPaso);
	
		btnResto.setBounds(947, 240, 89, 23);
		this.add(btnResto);
	
		btnConectar.setBounds(866, 290, 89, 23);
		this.add(btnConectar);
	}
	
	public void addApuestaListener(ActionListener mal){
		btnApuesto.addActionListener(mal);
	}
	
	public void addRestoListener(ActionListener mal){
		btnResto.addActionListener(mal);
	}
	public void addPasoListener(ActionListener mal){
		btnPaso.addActionListener(mal);
	}
	
	public void addConectarListener(ActionListener mal){
		btnConectar.addActionListener(mal);
	}
	
	public void cambiarImagenCartas(Carta c1, Carta c2){
		cartaMia1.setIcon(c1.getImagen());
		cartaMia2.setIcon(c2.getImagen());
	}
	
	public String getCantidad(){
		return textField_Cantidad.getText();
	}
	
	public String getPuntosAcumulados(){
		return textField_PuntosAc.getText();
	}
	
	public String getTotalMesa(){
		return textField_Total.getText();
	}
	
	public void setCantidad(String texto){
		textField_Cantidad.setText(texto);
	}
	
	public void setPuntosAcumulados(String texto){
		textField_PuntosAc.setText(texto);
	}
	
	public void setTotalMesa(String texto){
		textField_Total.setText(texto);
	}
	
	public void setCartaMesa1(ImageIcon icono){
		cartaMesa1.setIcon(icono);
	}
	public void setCartaMesa2(ImageIcon icono){
		cartaMesa2.setIcon(icono);
	}
	public void setCartaMesa3(ImageIcon icono){
		cartaMesa3.setIcon(icono);
	}
	public void setCartaMesa4(ImageIcon icono){
		cartaMesa4.setIcon(icono);
	}
	public void setCartaMesa5(ImageIcon icono){
		cartaMesa5.setIcon(icono);
	}
	public void setCartaMia1(ImageIcon icono){
		cartaMia1.setIcon(icono);
	}
	public void setCartaMia2(ImageIcon icono){
		cartaMia2.setIcon(icono);
	}
        

}


