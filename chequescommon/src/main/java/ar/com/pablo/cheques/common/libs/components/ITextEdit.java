package ar.com.pablo.cheques.common.libs.components;

/**
 * Interface que implementan las cajas de texto
 * @author Pablo M
 */
public interface ITextEdit {

    /**
     * Retorna si se selecciona todo el texto al hacer foco
     */
    public boolean getSelConElFoco();

    /**
     * Establece si se selecciona todo el texto al hacer foco
     */
    public void setSelConElFoco(boolean valor);

    /**
     * Retorna el texto del control
     * @return el texto
     */
    public String getText();

    /**
     * Establece el texto del control
     * @param text el texto
     */
    public void setText(String text);
}
