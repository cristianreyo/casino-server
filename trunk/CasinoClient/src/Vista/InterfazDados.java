package Vista;

import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import juego.Dados.ModeloDados;

public class InterfazDados extends JPanel {

    /** Creates new form InterfazDados */
    ArrayList<ImageIcon> listaImagenes = new ArrayList<ImageIcon>();
    DlgApuestas dlg;
    private int saldo;
     ImageIcon imageIcon;

    public DlgApuestas getDlg() {
        return dlg;
    }

    public void setDlg(DlgApuestas dlg) {
        this.dlg = dlg;
    }

    public JButton getjButton3_apostar() {
        return jButton3_apostar;
    }

    public void setjButton3_apostar(JButton jButton3_apostar) {
        this.jButton3_apostar = jButton3_apostar;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }
     
    public InterfazDados(ModeloDados modelo) {

        initComponents();

        ImageIcon imagen1 = new ImageIcon("imagenes/dado_1.png");
        ImageIcon imagen2 = new ImageIcon("imagenes/dado_2.png");
        ImageIcon imagen3 = new ImageIcon("imagenes/dado_3.png");
        ImageIcon imagen4 = new ImageIcon("imagenes/dado_4.png");
        ImageIcon imagen5 = new ImageIcon("imagenes/dado_5.png");
        ImageIcon imagen6 = new ImageIcon("imagenes/dado_6.png");

        listaImagenes.add(imagen1);
        listaImagenes.add(imagen2);
        listaImagenes.add(imagen3);
        listaImagenes.add(imagen4);
        listaImagenes.add(imagen5);
        listaImagenes.add(imagen6);


        imageIcon= new ImageIcon("imagenes/craps-table.gif");
        
        dlg = new DlgApuestas((JFrame)this.getParent(), true, modelo);
    }
    
    @Override
     public void paint(Graphics g) 
    {
        if (imageIcon != null) {
            g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);
        } else {
            setOpaque(true);
        }

        super.paint(g);
    }

    public void addApuestaListener(ActionListener mal) {
        jButton3_apostar.addActionListener(mal);
    }

    public void addTirarListener(ActionListener mal) {
        jButton2.addActionListener(mal);
    }

    public void cambiarImagenDados(int d1, int d2) {
        dado1.setIcon(listaImagenes.get(d1));
        dado2.setIcon(listaImagenes.get(d2));
    }

    public void setTextSaldo(int saldo) {
        jTextField_saldo.setText(Integer.toString(saldo));
    }

    public void showAviso(String aviso) {
        JOptionPane.showMessageDialog(null, "" + aviso);
    }

    public int getTipoApuesta() {
        return dlg.tipoApuesta;
    }

    public int getApuesta() {
        return dlg.apuesta;
    }

    public void setEnabledButton() {
        jButton2.setEnabled(false);
    }

    public void setVisibleDlg() {
        dlg.setVisible(true);
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
        try{
            dlg.setSaldo(saldo);
        }
           catch(Exception e){
                
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jDialog1 = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        dado2 = new javax.swing.JLabel();
        dado1 = new javax.swing.JLabel();
        jButton3_apostar = new javax.swing.JButton();
        jTextField_saldo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel3.setText("jLabel3");

        dado2.setIcon(new ImageIcon("imagenes/dado_1.png"));

        dado1.setIcon(new ImageIcon("imagenes/dado_1.png"));

        jButton3_apostar.setText("Apostar");
        jButton3_apostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_apostarActionPerformed(evt);
            }
        });

        jTextField_saldo.setEditable(false);

        jLabel1.setText("Saldo");

        jButton2.setIcon(new ImageIcon("imagenes/roll-button-hi.png"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(537, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dado2)
                        .addGap(6, 6, 6)
                        .addComponent(dado1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_saldo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3_apostar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton3_apostar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dado1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dado2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Este metodo no sirve
private void jButton3_apostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_apostarActionPerformed
}//GEN-LAST:event_jButton3_apostarActionPerformed

                                  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dado1;
    private javax.swing.JLabel dado2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3_apostar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField_saldo;
    // End of variables declaration//GEN-END:variables
}
