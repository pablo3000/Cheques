package ar.com.pablo.cheques.common.addons.asterix;

import ar.com.pablo.cheques.common.varios.GenericPanel;
import ar.com.pablo.cheques.common.interfaces.IAddOnInfo;
import ar.com.pablo.cheques.common.interfaces.IAddon;
import ar.com.pablo.cheques.common.interfaces.IConfig;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.apache.commons.lang3.StringUtils;
import ar.com.pablo.cheques.common.interfaces.IComponents;

/**
 * Descripción: Addon para Cheques
 *
 * @author Pablo M. Chabas-Santa Fe-Argentina Fecha 15/03/2020
 * @version 1.0
 */
public class Asterix implements IAddon {

    final Integer LONG_TEXT_IMPORTETEXT = 45;
    char CHAR_COMPLETE = '*';

    @Override
    public void init(IConfig config) {
    }

    @Override
    public void destroy(IConfig config) {
    }

    @Override
    public void beforePrint(HashMap data, IConfig config) {
        String texto = (String) data.get("importetexto");
        String outSTR;
        if (texto.length() > LONG_TEXT_IMPORTETEXT) {
            outSTR = StringUtils.rightPad(texto + " ", (LONG_TEXT_IMPORTETEXT * 2) + 5, CHAR_COMPLETE);
        } else {
            int charLargo = LONG_TEXT_IMPORTETEXT - texto.length();
            if (charLargo == 2) {
                outSTR = texto + " " + CHAR_COMPLETE + " ";
            } else {
                outSTR = StringUtils.rightPad(texto + " ", LONG_TEXT_IMPORTETEXT - 2, CHAR_COMPLETE) + " ";
            }

            outSTR = outSTR + StringUtils.rightPad("", LONG_TEXT_IMPORTETEXT - 1, CHAR_COMPLETE);
        }
        data.replace("importetexto", outSTR);
    }

    @Override
    public void afterPrint(HashMap data, IConfig config) {
    }

    @Override
    public IAddOnInfo getInfo() {
        return new IAddOnInfo() {
            @Override
            public int getID() {
                return 2;
            }

            @Override
            public ImageIcon getIcon() {
                try {
                    return new ImageIcon(
                            ImageIO.read(Asterix.class.getResourceAsStream("/icon.png")));
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
                return "Asterix";
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
                return "Completa con asteriscos un texto.";
            }
        };
    }

    @Override
    public void setComponent(IComponents component, IConfig config) {
    }
}