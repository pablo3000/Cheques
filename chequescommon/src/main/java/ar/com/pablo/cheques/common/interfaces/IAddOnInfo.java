package ar.com.pablo.cheques.common.interfaces;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Descripción: Interface con la infroamción del Addons
 *
 * @author Pablo M. Chabas-Santa Fe-Argentina Fecha 14/03/2020
 * @version 1.0
 */
public interface IAddOnInfo {

    /**
     * ID del Addon
     */
    public int getID();

    /**
     * Icono del Addon
     */
    public ImageIcon getIcon();

    /**
     * Panel AboutBox del Addon
     */
    public JPanel getInfoPanel();

    /**
     * Nombre del Addon
     */
    public String getAppName();

    /**
     * Autor del Addon
     */
    public String getAppAutor();

    /**
     * Versión del Addon
     */
    public String getAppVersion();

    /**
     * Descripción del Addon
     */
    public String getAppDescrip();
}
