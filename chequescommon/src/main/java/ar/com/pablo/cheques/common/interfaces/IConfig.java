package ar.com.pablo.cheques.common.interfaces;

import java.awt.Component;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Descripción: Configuración de la aplicación
 *
 * @author Pablo M. Chabas-Santa Fe-Argentina Fecha 30/03/2020
 * @version 1.0
 */
public interface IConfig {

    public String getReportPath();

    public String getAddonsFolder();

    public List<IAddon> getAddons();

    public void destroy();

    public String getResourceText(String key);

    public AppInfo appInfo();

    public static void showMessage(String title, String message, Component padre) {
        try {
            JOptionPane.showMessageDialog(padre, message, title, JOptionPane.DEFAULT_OPTION,
                    new ImageIcon(ImageIO.read(IConfig.class.getResourceAsStream("/Information64.png"))));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}