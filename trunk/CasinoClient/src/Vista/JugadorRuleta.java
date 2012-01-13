/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JugadorRuleta.java
 *
 * Created on 10-ene-2012, 3:41:20
 */
package Vista;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import juego.Ruleta.Jugador;
import general.Casino;



/**
 *
 * @author Gonzalo
 */
public class JugadorRuleta extends JPanel {
    float saldo = 1000;
    int apuesta;
    int tipoApuesta;
    float apostado = 0;
    float resta = 0;
//    DataInputStream is;
//    DataOutputStream os;
    private Casino casino;  
    private Image imagen;

    public JButton getjButton37() {
        return jButton37;
    }

    public void setjButton37(JButton jButton37) {
        this.jButton37 = jButton37;
    }

    public JButton getjButton38() {
        return jButton38;
    }

    public void setjButton38(JButton jButton38) {
        this.jButton38 = jButton38;
    }

    public JButton getjButton39() {
        return jButton39;
    }

    public void setjButton39(JButton jButton39) {
        this.jButton39 = jButton39;
    }

    public JButton getjButton40() {
        return jButton40;
    }

    public void setjButton40(JButton jButton40) {
        this.jButton40 = jButton40;
    }

    public JButton getjButton41() {
        return jButton41;
    }

    public void setjButton41(JButton jButton41) {
        this.jButton41 = jButton41;
    }

    public JButton getjButton42() {
        return jButton42;
    }

    public void setjButton42(JButton jButton42) {
        this.jButton42 = jButton42;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }
    
    
    
    
    /** Creates new form JugadorRuleta */
    public JugadorRuleta(final Casino casino) {
        
        
        //setSize(427,530);
        initComponents();
        //getContentPane().setBackground(new java.awt.Color(0,153,0));  
        jButton39.setBackground(new java.awt.Color(153,0,0));
        jButton40.setBackground(new java.awt.Color(0,0,0));
        //JPanelImagenFondo j = new JPanelImagenFondo();
        final Jugador g = new Jugador(saldo);
        //this.add(j);
        this.casino=casino;
        
        
        //LEO LA IMAGEN DE FONDO
        try{
            imagen = ImageIO.read(new File("imagenes/ruleta.jpg"));
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
//        Socket servidor;
//        try {
//            is=new DataInputStream(casino.getSocket().getInputStream());//Creo un buffer de salida
//            os=new DataOutputStream(casino.getSocket().getOutputStream());//Creo un buffer de entrada
//        }catch (UnknownHostException e) {
//			e.printStackTrace();
//	} catch (IOException e) {
//			e.printStackTrace();
//	}
        
        jComboBox1.setEnabled(false);
        jButton43.setText("APOSTAR");
        jButton43.setEnabled(false);
        
        //Botones de los numeros del 1 al 36 y tipo de apuestas
        jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 1;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                    
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 18;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 21;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 22;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 23;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 24;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton7.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 25;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton8.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 36;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton9.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 2;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton10.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 19;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton11.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 20;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton12.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 27;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton13.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 29;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton14.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 28;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton15.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 31;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton16.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 32;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton17.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 33;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton18.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 34;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton19.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 35;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton20.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 30;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton21.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 26;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton22.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 17;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton23.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 16;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton24.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 15;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton25.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 14;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton26.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 13;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton27.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 12;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton28.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 11;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton29.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 10;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton30.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 9;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton31.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 8;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton32.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 7;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton33.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 5;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton34.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 4;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton35.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 6;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton36.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 1;
                    int tipoApuesta = 3;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton37.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 3;
                    int tipoApuesta = 0;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton38.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 3;
                    int tipoApuesta = 1;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton39.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 2;
                    int tipoApuesta = 0;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton40.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 2;
                    int tipoApuesta = 1;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton41.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 4;
                    int tipoApuesta = 0;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
        jButton42.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                try {
                    int apuesta = 4;
                    int tipoApuesta = 1;
                    os.writeInt(apuesta);
                    os.writeInt(tipoApuesta);
                    jComboBox1.setEnabled(true);
                } catch (IOException ex) {
                    Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
                }
                //throw new UnsupportedOperationException("Not supported yet.");
            }
            
        });
      
        jComboBox1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DataInputStream is = casino.getIs();
                DataOutputStream os = casino.getOs();
                int indice = 0, bola = 0;
                String mensaje = "";
                boolean ganado;
                indice = jComboBox1.getSelectedIndex();
                try {
                    switch(indice){
                        case 0: apostado = 5;
                            break;
                        case 1: apostado = 10;
                            break;
                        case 2: apostado = 25;
                            break;
                        case 3: apostado = 50;
                            break;
                        case 4: apostado = 100;
                            break;
                        case 5: apostado = 200;
                            break;
                            }
                //saldo = saldo - apostado;
                //jButton43.setEnabled(true);
                jTextField2.setText("");
                os.writeFloat(apostado);
                mensaje = is.readUTF();
                jTextField2.setText(mensaje);
                
                ganado = is.readBoolean();
                if(ganado){
                    int i =  (int) (g.getSaldo() + 2*(is.readFloat()));
                    g.setSaldo(i);
                    jTextField1.setText(String.valueOf(g.getSaldo()));
                }else{
                    int i =  (int) (g.getSaldo() - (is.readFloat()));
                    g.setSaldo(i);
                    jTextField1.setText(String.valueOf(g.getSaldo()));
                }
                bola = is.readInt();
                mensaje = is.readUTF();
                jTextArea1.append(Integer.toString(bola));
                jTextArea1.append(mensaje+"\n");
                jComboBox1.setEnabled(false);
                //jButton43.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(JugadorRuleta.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
            
        });
        
        
        
    }
   
    
    /**
     * Sobre escribo el metodo pintar para que dibuje el panel con
     * una imagen de fondo.
     * 
     * @param g 
     */
    @Override
    public void paint(Graphics g) 
    {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);
        } else {
            setOpaque(true);
        }

        super.paint(g);
    }
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton43 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SALDO DISPONIBLE:");

        jTextField1.setText(String.valueOf(saldo));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("18");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("21");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("22");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("23");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("24");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("25");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("36");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("2");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("19");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("20");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("27");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("29");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("28");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("31");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("32");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("33");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("34");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("35");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("30");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("26");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setText("17");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText("16");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setText("15");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("14");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("13");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setText("12");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("11");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setText("10");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setText("9");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setText("8");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setText("7");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setText("5");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setText("4");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setText("6");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setText("3");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton37.setText("PAR");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton38.setText("IMPAR");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setText("ROJO");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton40.setForeground(new java.awt.Color(255, 255, 255));
        jButton40.setText("NEGRO");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jButton41.setText("BAJOS");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setText("ALTOS");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "25", "50", "100", "200" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CANTIDAD APUESTA");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton43.setText("jButton43");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jButton40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jButton18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jButton43))
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton36)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton35)
                            .addComponent(jButton33)
                            .addComponent(jButton34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton31)
                            .addComponent(jButton30)
                            .addComponent(jButton32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton28)
                            .addComponent(jButton27)
                            .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton25)
                            .addComponent(jButton24)
                            .addComponent(jButton26)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton37)
                        .addGap(18, 18, 18)
                        .addComponent(jButton38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton22)
                    .addComponent(jButton2)
                    .addComponent(jButton39)
                    .addComponent(jButton23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11)
                            .addComponent(jButton3)
                            .addComponent(jButton10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton6)
                            .addComponent(jButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton21)
                            .addComponent(jButton12)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton13)
                            .addComponent(jButton20)
                            .addComponent(jButton14)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton40)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(jButton41)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jButton17)
                    .addComponent(jButton42)
                    .addComponent(jButton15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jButton8)
                    .addComponent(jButton18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43))
                .addContainerGap())
        );

    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
      
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tipoApuesta = 1;
        apuesta = 1;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        tipoApuesta = 2;
        apuesta = 1;
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        tipoApuesta = 3;
        apuesta = 1;
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        tipoApuesta = 4;
        apuesta = 1;
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        tipoApuesta = 5;
        apuesta = 1;
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        tipoApuesta = 6;
        apuesta = 1;
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        tipoApuesta = 7;
        apuesta = 1;
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        tipoApuesta = 8;
        apuesta = 1;
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        tipoApuesta = 9;
        apuesta = 1;
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        tipoApuesta = 10;
        apuesta = 1;
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        tipoApuesta = 11;
        apuesta = 1;
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        tipoApuesta = 12;
        apuesta = 1;
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        tipoApuesta = 13;
        apuesta = 1;
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        tipoApuesta = 14;
        apuesta = 1;
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        tipoApuesta = 15;
        apuesta = 1;
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        tipoApuesta = 16;
        apuesta = 1;
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        tipoApuesta = 17;
        apuesta = 1;
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tipoApuesta = 18;
        apuesta = 1;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        tipoApuesta = 19;
        apuesta = 1;
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        tipoApuesta = 20;
        apuesta = 1;
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tipoApuesta = 21;
        apuesta = 1;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tipoApuesta = 22;
        apuesta = 1;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        tipoApuesta = 23;
        apuesta = 1;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        tipoApuesta = 24;
        apuesta = 1;
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        tipoApuesta = 25;
        apuesta = 1;
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        tipoApuesta = 26;
        apuesta = 1;
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        tipoApuesta = 27;
        apuesta = 1;
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        tipoApuesta = 28;
        apuesta = 1;
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        tipoApuesta = 29;
        apuesta = 1;
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        tipoApuesta = 30;
        apuesta = 1;
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        tipoApuesta = 31;
        apuesta = 1;
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        tipoApuesta = 32;
        apuesta = 1;
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        tipoApuesta = 33;
        apuesta = 1;
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        tipoApuesta = 34;
        apuesta = 1;
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        tipoApuesta = 35;
        apuesta = 1;
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        tipoApuesta = 36;
        apuesta = 1;
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        tipoApuesta = 0;
        apuesta = 2;
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        tipoApuesta = 1;
        apuesta = 2;
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        tipoApuesta = 0;
        apuesta = 3;
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        tipoApuesta = 1;
        apuesta = 3;
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        tipoApuesta = 0;
        apuesta = 4;
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        tipoApuesta = 1;
        apuesta = 4;
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton43ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

   
}
