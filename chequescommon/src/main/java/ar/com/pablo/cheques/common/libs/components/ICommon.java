package ar.com.pablo.cheques.common.libs.components;

/**
 * Interface Que deben implementar alguno componentes
 *
 * @author Pablo
 */
public interface ICommon {

    /**
     * Retorna si se puede pasar el foco automaticamente
     */
    public boolean getAutoLostFocus();

    /**
     * Establece si se puede pasar el foco automaticamente
     */
    public void setAutoLostFocus(boolean valor);
}
