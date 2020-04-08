package ar.com.pablo.cheques;

import ar.com.pablo.cheques.common.varios.GUIAboutBox;
import ar.com.pablo.cheques.common.interfaces.IConfig;
import javax.swing.JDialog;

/**
 * Descripción:
 * @author Pablo M.  Chabas-Santa Fe-Argentina
 * Fecha 31/03/2020
 * @version 1.0
 */
public class DialogAboutbox extends JDialog{
    IConfig config;
    
    public void init(IConfig config){
        this.config = config;
        this.add(new GUIAboutBox(config, this));  
        this.pack();
        this.setLocationRelativeTo(null);     
    }


}