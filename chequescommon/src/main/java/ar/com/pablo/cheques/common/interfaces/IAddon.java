package ar.com.pablo.cheques.common.interfaces;

import java.util.HashMap;

/**
 * Descripción: Interfaces que tiene que implementar los Addons
 *
 * @author Pablo M. Chabas-Santa Fe-Argentina Fecha 14/03/2020
 * @version 1.0
 */
public interface IAddon {

    /**
     * Este metodo se ejecuta al cargar el Addons Antes de cargar la pantalla de
     * la aplicación
     */
    public void init(IConfig config);

    /**
     * Este metodo se ejecuta antes de finalizar la aplicación
     */
    public void destroy(IConfig config);

    /**
     * Este metodo se ejecuta antes de generar la vista previa de empresión
     */
    public void beforePrint(HashMap data, IConfig config);

    /**
     * Este metodo se ejecuta al cerrar la ventana de la vista previa de
     * empresión
     */
    public void afterPrint(HashMap data, IConfig config);

    /**
     * Informacion del Addons
     *
     * @see IAddOnInfo
     */
    public IAddOnInfo getInfo();

    /**
     * Este metodo se ejecuta al iniciar la ventana de la aplicación
     *
     * @param component todos los componentes de de la ventana principal de la
     * aplicación
     * @param config Configuración de la aplicación
     * @see IComponents
     * @see IConfig
     */
    public void setComponent(IComponents component, IConfig config);
}
