/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AboutView.java
 *
 * Created on 29-dic-2011, 16:30:08
 */
package Vista;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Miguel Angel Fuentes Cardenas
 */
public class AboutView extends javax.swing.JDialog {

    /** Creates new form AboutView */
    public AboutView(java.awt.Frame parent, boolean modal, int idioma) {
        super(parent, modal);
        initComponents();
        
        //CENTRO VENTANA REFERENTE A LA APLICACION EN CURSO
        this.setLocationRelativeTo(parent);
        
        //CARGO EL IDIOMA
        CargarIdioma(idioma);
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
            
            this.LabelRealizado.setText(defProps.getProperty("developer"));
            this.setTitle(defProps.getProperty("about"));
            
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

        Boton = new javax.swing.JButton();
        LabelRealizado = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Boton.setText("ok");
        Boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActionPerformed(evt);
            }
        });

        LabelRealizado.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        LabelRealizado.setText("Proyecto realizado por:");

        jLabel2.setText("Fernando Jesús Fernández Carrillo");

        jLabel3.setText("Miguel Ángel Fuentes Cárdenas");

        jLabel4.setText("Antonio J. Díaz Rodríguez");

        jLabel5.setText("Gonzalo Fernández");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(LabelRealizado)
                .addContainerGap(169, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .add(jLabel2)
                .add(99, 99, 99))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .add(jLabel4)
                .add(112, 112, 112))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .add(jLabel5)
                .add(136, 136, 136))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .add(jLabel3)
                .add(92, 92, 92))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .add(Boton)
                .add(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(LabelRealizado)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .add(18, 18, 18)
                .add(Boton)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void BotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActionPerformed
    this.dispose();
}//GEN-LAST:event_BotonActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton;
    private javax.swing.JLabel LabelRealizado;
    // End of variables declaration//GEN-END:variables
}
