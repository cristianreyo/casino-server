/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConexionView.java
 *
 * Created on 29-dic-2011, 16:46:07
 */
package Vista;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Miguel Angel Fuentes Cardenas
 */
public class ConexionView extends javax.swing.JDialog {

    /** Creates new form ConexionView */
    public ConexionView(java.awt.Frame parent, boolean modal, int idioma) {
        super(parent, modal);
        initComponents();
        
        //CENTRO VENTANA REFERENTE A LA APLICACION EN CURSO
        this.setLocationRelativeTo(parent);
        
        //CARGO EL IDIOMA
        CargarIdioma(idioma);
        
        //CARGO CONFIGURACION DE CONEXION
        CargarInfoConexion();
    }
    
    private void CargarInfoConexion(){
        InputStream f;
        Properties defProps = new Properties();
        String fichero = "Recursos/config.properties";
        
        try{
            f = new FileInputStream(fichero);
            defProps.load(f);
            
            this.Servidor.setText(defProps.getProperty("server"));
            this.Puerto.setValue(Integer.parseInt(defProps.getProperty("port")));
            
            f.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void CargarIdioma(int idioma){
        String fichero="";
        InputStream f;
        Properties defProps = new Properties();
        
        switch(idioma){            
            case 0: //ESPANOL
                fichero = "Recursos/lenguajes_es_ES.properties";
                break;
                
            case 1: //INGLES
                fichero = "Recursos/lenguajes_en_GB.properties";
                break;
        }
        
        
        //CONFIGURO LA INTERFAZ EN FUNCION DEL IDIOMA
        try{            
            f = new FileInputStream(fichero);
            defProps.load(f);
            
            this.LabelPuerto.setText(defProps.getProperty("port"));
            this.LabelServidor.setText(defProps.getProperty("server"));
            this.BotonCancel.setText(defProps.getProperty("cancel"));
            this.BotonAceptar.setText(defProps.getProperty("accept"));
            this.setTitle(defProps.getProperty("connection"));
            
            f.close();
        }catch(IOException e){
            System.err.println("Error al cargar idioma por defecto");
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelServidor = new javax.swing.JLabel();
        LabelPuerto = new javax.swing.JLabel();
        BotonAceptar = new javax.swing.JButton();
        BotonCancel = new javax.swing.JButton();
        Servidor = new javax.swing.JTextField();
        Puerto = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        LabelServidor.setText("Servidor:");

        LabelPuerto.setText("Puerto:");

        BotonAceptar.setText("jButton1");
        BotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarActionPerformed(evt);
            }
        });

        BotonCancel.setText("jButton2");
        BotonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCancelActionPerformed(evt);
            }
        });

        Servidor.setText("jTextField1");

        Puerto.setModel(new javax.swing.SpinnerNumberModel(1024, 1024, 65535, 1));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(LabelServidor)
                            .add(LabelPuerto))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(Puerto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(Servidor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(BotonAceptar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 49, Short.MAX_VALUE)
                        .add(BotonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(LabelServidor)
                    .add(Servidor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(LabelPuerto)
                    .add(Puerto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(BotonAceptar)
                    .add(BotonCancel))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed
    
    //SOBRE ESCRIBE LA CONFIGURACION POR DEFECTO
    //LA PROXIMA VEZ QUE SE HABRA LA APLICACION ESTARA DISPONIBLE
    //LA NUEVA CONFIGURACION
    
    Properties defProps = new Properties();
    String server = this.Servidor.getText();
    
    String port = this.Puerto.getValue().toString();
    
    
    //ALAMACENO EL IDIOMA SELECCIONADO PARA QUE LA PROXIMA VEZ QUE SE ABRA
    //LA APLICACION SE ENCUENTRE EN EL IDIOMA SELECCIONADO
    try{
        //Obtengo las propiedades actuales
        InputStream fi = new FileInputStream("Recursos/config.properties");
        defProps.load(fi);
        fi.close();
        
        //modifico las propiedades
        defProps.setProperty("server",server);            
       defProps.setProperty("port",port);
       
       //almaceno propiedades
       OutputStream fo = new FileOutputStream("Recursos/config.properties");               
       defProps.store(fo,null);
       
       fo.close();
    }catch(IOException e){
        e.printStackTrace();
    }
    
    
    
    this.dispose();
}//GEN-LAST:event_BotonAceptarActionPerformed

private void BotonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCancelActionPerformed
    this.dispose();
}//GEN-LAST:event_BotonCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAceptar;
    private javax.swing.JButton BotonCancel;
    private javax.swing.JLabel LabelPuerto;
    private javax.swing.JLabel LabelServidor;
    private javax.swing.JSpinner Puerto;
    private javax.swing.JTextField Servidor;
    // End of variables declaration//GEN-END:variables
}
