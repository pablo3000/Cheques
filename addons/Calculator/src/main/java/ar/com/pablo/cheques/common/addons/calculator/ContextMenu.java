package ar.com.pablo.cheques.common.addons.calculator;

import ar.com.pablo.cheques.common.interfaces.IComponents;
import ar.com.pablo.cheques.common.interfaces.IConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * Descripción :Menu contextual
 * @author Pablo M. Chabas-Santa Fe-Argentina Fecha 03/04/2020
 * @version 1.0
 */
public class ContextMenu extends JPopupMenu {
    final String WINDOWS_TITLE = "Calculadora";
    JMenuItem anItem;
    IConfig config;
    String value;

    public ContextMenu(IConfig config, IComponents components) {
        this.config = config;
        anItem = new JMenuItem("Calculadora");
        anItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JDialog jDlg = new JDialog(components.getMainFrame(), WINDOWS_TITLE);
                jDlg.add(new PanelCalculator(jDlg, components, config));
                jDlg.pack();
                jDlg.setLocationRelativeTo(null);
                jDlg.setModal(true);
                jDlg.setVisible(true);
            }
        });

        try {
            ImageIcon icon = new ImageIcon(ImageIO.read(Calculator.class.getResourceAsStream("/menu.png")));
            anItem.setIcon(icon);
        } catch (IOException ex) {
        }

        add(anItem);
    }
}
