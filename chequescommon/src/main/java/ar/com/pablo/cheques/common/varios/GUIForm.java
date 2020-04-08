package ar.com.pablo.cheques.common.varios;

import ar.com.pablo.cheques.common.interfaces.IAddon;
import ar.com.pablo.cheques.common.interfaces.IConfig;
import ar.com.pablo.cheques.common.libs.ClsFechaHora;
import ar.com.pablo.cheques.common.libs.ClsNum2Text;
import ar.com.pablo.cheques.common.libs.components.JXButton;
import ar.com.pablo.cheques.common.libs.components.JXTextField;

import java.awt.Dimension;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.swing.JRViewerToolbar;
import org.jdatepicker.JDatePicker;
import ar.com.pablo.cheques.common.interfaces.IComponents;

/**
 * Panel principal de la aplicación
 *
 * @author Pablo M.
 */
public class GUIForm extends javax.swing.JPanel {

    final String ERR_NO_DATE, ERR_NO_PAGESE, ERR_NO_MONEY, ERR_DATE_FROM_TO;
    final String[] MESES;
    final Integer LONG_TEXT_IMPORTETEXT = 45;
    final String PRINT_WIN_TITLE = "Vista preliminar";
    final String RESORCES_PATH = "/resources.properties";
    final String APP_FOLDER = Paths.get(".").toAbsolutePath().normalize().toString();
    private IConfig config;
    private JFrame framePadre;

    public void setFramePadre(JFrame framePadre) {
        this.framePadre = framePadre;
    }

    public GUIForm(IConfig config) throws IOException {
        this.config = config;
        initComponents();

        txt1.setMaxLength(100);

        ERR_NO_DATE = config.getResourceText("ERR_NO_DATE");
        ERR_NO_PAGESE = config.getResourceText("ERR_NO_PAGESE");
        ERR_NO_MONEY = config.getResourceText("ERR_NO_MONEY");
        ERR_DATE_FROM_TO = config.getResourceText("ERR_DATE_FROM_TO");

        jLabel1.setText(config.getResourceText("TXT_FECHA1") + ":");
        jLabel2.setText(config.getResourceText("TXT_FECHA2") + ":");
        jLabel3.setText(config.getResourceText("TXT_PAGESEA") + ":");
        jLabel4.setText(config.getResourceText("TXT_IMPORTE") + ":");

        jXButton1.setText(config.getResourceText("BTN_IMPRIME"));
        jXButton2.setText(config.getResourceText("BTN_CERRAR"));

        MESES = config.getResourceText("MESES").split(",");

        IComponents componentes = new IComponents() {
            @Override
            public JDatePicker getFechaCheque() {
                return datefrom;
            }

            @Override
            public JDatePicker getFechaCobro() {
                return dateto;
            }

            @Override
            public JXTextField getPagueseA() {
                return txt1;
            }

            @Override
            public JFormattedTextField getImporte() {
                return txt2;
            }

            @Override
            public JXButton getBTNimprimir() {
                return jXButton1;
            }

            @Override
            public JXButton getBTNCerrar() {
                return jXButton1;
            }

            @Override
            public JFrame getMainFrame() {
                return framePadre;
            }
        };

        List<IAddon> addOns = config.getAddons();
        if (null != addOns) {
            if (addOns.size() > 0) {
                for (int i = 0; i < addOns.size(); i++) {
                    addOns.get(i).setComponent(componentes, config);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jXButton1 = new ar.com.pablo.cheques.common.libs.components.JXButton();
        jXButton2 = new ar.com.pablo.cheques.common.libs.components.JXButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dateto = new org.jdatepicker.JDatePicker();
        jLabel2 = new javax.swing.JLabel();
        datefrom = new org.jdatepicker.JDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt2 = new javax.swing.JFormattedTextField();
        txt1 = new ar.com.pablo.cheques.common.libs.components.JXTextField();

        jXButton1.setTipo(ar.com.pablo.cheques.common.libs.components.JXButton.EtipoBotones.Imprimir);
        jXButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jXButton1);

        jXButton2.setTipo(ar.com.pablo.cheques.common.libs.components.JXButton.EtipoBotones.Cerrar);
        jXButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jXButton2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("AAAAAAA:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha Cobro:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Pagese a:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Importe:");

        txt2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addComponent(dateto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(datefrom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(datefrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jXButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton1ActionPerformed
        if (controlar()) {
            ClsNum2Text importeText = new ClsNum2Text();
            Double dblImporte = Double.parseDouble(txt2.getText().replace(",", "."));
            try {
                ClsFechaHora objFechaHora = new ClsFechaHora();
                Date fec1 = ((GregorianCalendar) datefrom.getModel().getValue()).getTime();
                Date fec2 = ((GregorianCalendar) dateto.getModel().getValue()).getTime();

                HashMap params = new HashMap();
                params.put("importe", dblImporte);

                params.put("diafecha1", objFechaHora.getDia(fec1));
                params.put("mesfecha1", MESES[objFechaHora.getMes(fec1) - 1]);
                params.put("aniofecha1", objFechaHora.getAnio(fec1));

                params.put("diafecha2", objFechaHora.getDia(fec2));
                params.put("mesfecha2", MESES[objFechaHora.getMes(fec2) - 1]);
                params.put("aniofecha2", objFechaHora.getAnio(fec2));
                params.put("pagesea", txt1.getText());
                params.put("importetexto", importeText.getText(dblImporte, true));

                List<IAddon> addOns = config.getAddons();

                if (null != addOns) {
                    if (addOns.size() > 0) {
                        for (int i = 0; i < addOns.size(); i++) {
                            addOns.get(i).beforePrint(params, config);
                        }
                    }
                }

                generaReporte(params);

                if (null != addOns) {
                    if (addOns.size() > 0) {
                        for (int i = 0; i < addOns.size(); i++) {
                            addOns.get(i).afterPrint(params, config);
                        }
                    }
                }

            } catch (JRException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(GUIForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jXButton1ActionPerformed

    private void jXButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton2ActionPerformed
        config.destroy();
        System.exit(0);
    }//GEN-LAST:event_jXButton2ActionPerformed

    private boolean controlar() {
        Date date1 = null, date2 = null;
        String title = config.getResourceText("MSG_BOX_TITLE");

        if (null != datefrom.getModel().getValue()) {
            date1 = ((GregorianCalendar) datefrom.getModel().getValue()).getTime();
        }

        if (null != dateto.getModel().getValue()) {
            date2 = ((GregorianCalendar) dateto.getModel().getValue()).getTime();
        }

        if (null == datefrom.getModel().getValue()) {
            IConfig.showMessage(title, ERR_NO_DATE, framePadre);
            datefrom.grabFocus();
            return false;
        } else if (null == dateto.getModel().getValue()) {
            IConfig.showMessage(title, ERR_NO_DATE, framePadre);
            dateto.grabFocus();
            return false;
        } else if (txt1.getText().length() < 1) {
            IConfig.showMessage(title, ERR_NO_PAGESE, framePadre);
            txt1.grabFocus();
            return false;
        } else if (txt2.getText().length() < 1) {
            IConfig.showMessage(title, ERR_NO_MONEY, framePadre);
            txt2.grabFocus();
            return false;
        } else if (date1.after(date2)) {
            IConfig.showMessage(title, ERR_DATE_FROM_TO, framePadre);
            datefrom.grabFocus();
            return false;
        } else {
            return true;
        }
    }

    private void generaReporte(HashMap params) throws JRException, IOException {
//        JFrame frameWait = new JFrame();
//        frameWait.add(new GUIWait(config.getResourceText("MSG_05")));
//        frameWait.pack();
//        frameWait.setLocationRelativeTo(null);
//        frameWait.setVisible(true);

        JasperReport report = JasperCompileManager.compileReport(config.getReportPath());
        JasperPrint jprint = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        JDialog frame = new JDialog(framePadre, PRINT_WIN_TITLE, true);
        JRViewer viewer = new JRViewer(jprint);
        viewer.setZoomRatio(0.50f);
        JRViewerToolbar toolBar = (JRViewerToolbar) viewer.getComponents()[0];
        toolBar.getComponent(0).setVisible(false);
        toolBar.getComponent(2).setVisible(false);
        toolBar.getComponent(3).setVisible(false);
        toolBar.getComponent(4).setVisible(false);
        toolBar.getComponent(5).setVisible(false);
        toolBar.getComponent(6).setVisible(false);
        toolBar.getComponent(7).setVisible(false);
        toolBar.getComponent(8).setVisible(false);

        frame.add(viewer);
        frame.setSize(new Dimension(960, 500));
        frame.setLocationRelativeTo(null);

        frame.setIconImage(framePadre.getIconImage());
//        frameWait.setVisible(false);
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdatepicker.JDatePicker datefrom;
    private org.jdatepicker.JDatePicker dateto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private ar.com.pablo.cheques.common.libs.components.JXButton jXButton1;
    private ar.com.pablo.cheques.common.libs.components.JXButton jXButton2;
    private ar.com.pablo.cheques.common.libs.components.JXTextField txt1;
    private javax.swing.JFormattedTextField txt2;
    // End of variables declaration//GEN-END:variables
}
