package ar.com.pablo.cheques.common.addons.calculator;

import ar.com.pablo.cheques.common.varios.GenericPanel;
import ar.com.pablo.cheques.common.interfaces.IAddOnInfo;
import ar.com.pablo.cheques.common.interfaces.IAddon;
import ar.com.pablo.cheques.common.interfaces.IConfig;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import ar.com.pablo.cheques.common.interfaces.IComponents;

/**
 * Descripción: Addon para Cheques
 *
 * @author Pablo M. Chabas-Santa Fe-Argentina Fecha 15/03/2020
 * @version 1.0
 */
public class Calculator implements IAddon {

    @Override
    public void init(IConfig config) {
    }

    @Override
    public void destroy(IConfig config) {
    }

    @Override
    public void beforePrint(HashMap data, IConfig config) {

    }

    @Override
    public void afterPrint(HashMap data, IConfig config) {
    }

    @Override
    public IAddOnInfo getInfo() {
        return new IAddOnInfo() {
            @Override
            public int getID() {
                return 3;
            }

            @Override
            public ImageIcon getIcon() {
                try {
                    return new ImageIcon(
                            ImageIO.read(Calculator.class.getResourceAsStream("/icon.png")));
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
                return "Calculator";
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
                return "Muestra una calculadora en el menu contextual del importe.\n"
                        + "Este aplicacion esta basada en el código complementario que acompaña el libro Core Java 8th ed\n\n"
                        + "http://horstmann.com/corejava \n\n"
                        + "http://www.java2s.com/Code/Java/Tiny-Application/Asimplecalculator.htm";
            }
        };
    }

    @Override
    public void setComponent(IComponents components, IConfig config) {
        JFormattedTextField ImporteComponent = components.getImporte();
        ImporteComponent.addMouseListener(new MenuClickListener(config, components));
    }
}
