package ar.com.pablo.cheques;

import ar.com.pablo.cheques.common.interfaces.IAddon;
import ar.com.pablo.cheques.common.varios.GUIAboutBox;
import ar.com.pablo.cheques.common.varios.GUIForm;
import ar.com.pablo.cheques.common.interfaces.IConfig;
import java.awt.Dialog;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Inicia por aca
 */
public class inicio {

    IConfig config;
    final String RESORCES_PATH = "/resources.properties";
    JFrame laVentana = null;
    private JDialog dlgAboutBox = null;

    public static void main(String[] args) throws IOException {
        inicio init = new inicio();
        init.arranca(args);
    }

    public void arranca(String[] args) throws IOException {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {

            }
        }

        Properties resProp = new Properties();
        InputStream is = null;

        boolean isLoadAddon = true;
        for (String arg : args) {
            if (arg.trim().startsWith("-res_")) {
                String fileRes = arg.trim().substring(5);
                is = new FileInputStream(new File(fileRes));
            }
        }

        if (null == is) {
            resProp.load(IConfig.class.getResourceAsStream("/resources.properties"));
        } else {
            resProp.load(is);
        }

        for (String arg : args) {
            if (arg.trim().equals("-noaddons")) {
                isLoadAddon = false;
                IConfig.showMessage(resProp.getProperty("MSG_BOX_TITLE"), resProp.getProperty("MSG_01"), null);
            }
        }

        config = new Config(isLoadAddon, resProp);

        for (String arg : args) {
            if (arg.trim().equals("-info")) {
                System.out.println("");
                System.out.println(config.appInfo().getAppName());
                System.out.println(config.getResourceText("APP_DESCRIP"));
                System.out.println("Version: " + config.appInfo().getAppVersion()
                        + "           Autor: " + config.appInfo().getAutor());
                System.out.println("Idioma: " + config.getResourceText("LANGUAGE"));
                System.out.println(config.getResourceText("MSG_03") + ": "
                        + config.getAddonsFolder());
                System.out.println(config.getResourceText("MSG_04") + ": "
                        + config.getReportPath());
                System.out.println("");
                System.out.println("Addon:");
                if (null != config.getAddons()) {
                    if (config.getAddons().size() > 0) {
                        List<IAddon> l = config.getAddons();
                        for (int i = 0; i < l.size(); i++) {
                            System.out.println("      * " + l.get(i).getInfo().getAppName()
                                    + "     V." + l.get(i).getInfo().getAppVersion());
                        }
                    }
                }
                System.out.println("");
                System.out.println("Parámetros");
                System.out.println("    -info           " + config.getResourceText("MSG_PARAM_INFO"));
                System.out.println("    -noaddons       " + config.getResourceText("MSG_PARAM_NOADDONS"));
                System.out.println("    -res_%archivo%  " + config.getResourceText("MSG_PARAM_RES")
                        + "       %archivo% = Nombre del archivo .properties con los recursos");
                System.exit(0);
            }
        }

        GUIForm gui = new GUIForm(config);

        laVentana = new JFrame("Cheques");

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_F1) {
                    if (null == dlgAboutBox) {
                        dlgAboutBox = new JDialog(laVentana, config.getResourceText("ABOUT_BOX_TITLE"), Dialog.ModalityType.DOCUMENT_MODAL);
                    }
                    if (!dlgAboutBox.isVisible()) {
                        dlgAboutBox.add(new GUIAboutBox(config, dlgAboutBox));
                        dlgAboutBox.pack();
                        dlgAboutBox.setLocationRelativeTo(null);
                        dlgAboutBox.setVisible(true);
                    }
                } else if (key == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
                return false;
            }
        });

        gui.setFramePadre(laVentana);
        laVentana.add(gui);
        laVentana.setResizable(false);
        laVentana.pack();
        laVentana.setLocationRelativeTo(null);

        laVentana.setIconImage(new ImageIcon(GUIForm.class.getResource("/CheckCheck16.png")).getImage());

        laVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                config.destroy();
                System.exit(0);
            }
        });
        laVentana.setVisible(true);
    }
}
