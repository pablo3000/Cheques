package ar.com.pablo.cheques.common.varios;

import ar.com.pablo.cheques.common.interfaces.IConfig;
import ar.com.pablo.cheques.common.libs.VerticalLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * Panel Generico
 *
 * @author Pablo M.
 */
public class GenericDialog extends javax.swing.JDialog {

    IConfig config;

    public GenericDialog(java.awt.Frame parent, String title, boolean modal, JPanel panel, IConfig config) {
        super(parent, modal);
        commonInit(title, modal, panel, config);
    }

    public GenericDialog(JDialog parent, String title, boolean modal, JPanel panel, IConfig config) {
        super(parent, modal);
        commonInit(title, modal, panel, config);
    }

    private void commonInit(String title, boolean modal, JPanel panel, IConfig config) {
        initComponents();
        super.setTitle(title);
        this.config = config;
        this.setLayout(new VerticalLayout());

        jXButton2.setText(config.getResourceText("BTN_CERRAR"));
        getRootPane().setDefaultButton(jXButton2);

        JPanel btnPanel = jPanel3;
        this.getContentPane().removeAll();

        this.add(panel);
        this.add(btnPanel);
        jXButton2.requestFocus();

        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jXButton2 = new ar.com.pablo.cheques.common.libs.components.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerda del Addon");

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jXButton2.setTipo(ar.com.pablo.cheques.common.libs.components.JXButton.EtipoBotones.Cerrar);
        jXButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jXButton2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jXButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private ar.com.pablo.cheques.common.libs.components.JXButton jXButton2;
    // End of variables declaration//GEN-END:variables
}
