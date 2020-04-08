package ar.com.pablo.cheques.common.addons.upper;

import ar.com.pablo.cheques.common.varios.GenericPanel;
import ar.com.pablo.cheques.common.interfaces.IAddOnInfo;
import ar.com.pablo.cheques.common.interfaces.IAddon;
import ar.com.pablo.cheques.common.interfaces.IConfig;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import ar.com.pablo.cheques.common.interfaces.IComponents;

/**
 * Descripción: Addon para Cheques
 *
 * @author Pablo M. Chabas-Santa Fe-Argentina Fecha 15/03/2020
 * @version 1.0
 */
public class AddonUpper implements IAddon {

    @Override
    public void init(IConfig config) {
    }

    @Override
    public void destroy(IConfig config) {
    }

    @Override
    public void beforePrint(HashMap data, IConfig config) {
        data.replace("importetexto", ((String) data.get("importetexto")).toUpperCase());
    }

    @Override
    public void afterPrint(HashMap data, IConfig config) {
    }

    @Override
    public IAddOnInfo getInfo() {
        return new IAddOnInfo() {
            @Override
            public int getID() {
                return 1;
            }

            @Override
            public ImageIcon getIcon() {
                try {
                    return new ImageIcon(
                            ImageIO.read(AddonUpper.class.getResourceAsStream("/icon.png")));
                } catch (IOException ex) {
                    return null;
                }
            }

            @Override
            public JPanel getInfoPanel() {
                return new GenericPanel(getIcon(), this.getAppName(), this.getAppVersion(),
                        this.getAppAutor(), this.getAppDescrip(),
                        new java.awt.Font("Tahoma", 1, 24));
            }

            @Override
            public String getAppName() {
                return "2Upper";
            }

            @Override
            public String getAppAutor() {
                return "Pablo M.";
            }

            @Override
            public String getAppVersion() {
                return "1.0";
            }

            @Override
            public String getAppDescrip() {
                return "Convierte el texto del importe a mayúsculas.";
            }
        };
    }

    @Override
    public void setComponent(IComponents component, IConfig config) {
    }
}
