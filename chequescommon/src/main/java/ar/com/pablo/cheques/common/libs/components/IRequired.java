package ar.com.pablo.cheques.common.libs.components;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * Interface que implementan los componentes que necesitan que sus datos sean
 * requeridos
 *
 * @author pablo
 * @version
 */
public interface IRequired {

    /**
     * @return Informacion del caracter requerido
     */
    public JLabel getRequired();

    /**
     * @param jLabelRequired Informacion del caracter requerido
     */
    public void setRequired(JLabel jLabelRequired);

    /**
     * Retorna el mensaje a mostrar si la información ingresada es requerida
     *
     * @return Mensajito
     */
    public String getMessageRequired();

    /**
     * Settea el mensaje a mostrar si la información ingresada es requerida
     *
     * @param msgRequired Mensajito
     */
    public void setMessageRequired(String msgRequired);

    /**
     * @return Retorna true si se requiere un valor y este se encuentra en la
     * caja de texto
     */
    public boolean isValidRequired();

    /**
     * Settea si la caja de texto contine un valor requerido
     */
    public void setValidRequired(boolean valor);

    /**
     * Settea la expresión regular utilizada para validar los datos
     *
     * @param regEx Expresión regular
     */
    public void setValidator(String regEx);

    /**
     * Retorna la expresión regular utilizada para validar los datos
     *
     * @return Expresión regular
     */
    public String getValidator();

    /**
     * Retorna el mensaje a mostrar si la información ingresada no es valida
     *
     * @return Mensajito
     */
    public String getMessageNoValid();

    /**
     * Settea el mensaje a mostrar si la información ingresada no es valida
     *
     * @param msgNoValid Mensajito
     */
    public void setMessageNoValid(String msgNoValid);

    /**
     * Settea el color del borde si el componente es requerido
     *
     * @param valor el color
     */
    public void setColorRequired(Color valor);

    /**
     * Settea el color del borde si el componente es requerido
     *
     * @return el color de borde
     */
    public Color getColorRequired();

    /**
     * Settea el color de fondo si el componente contiene un valor invalido
     *
     * @param valor el color
     */
    public void setColorValid(Color valor);

    /**
     * Retorna el color de fondo si el componente contiene un valor invalido
     *
     * @param valor el color
     */
    public Color getColorValid();
}
