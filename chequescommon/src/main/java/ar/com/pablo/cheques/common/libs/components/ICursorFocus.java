package ar.com.pablo.cheques.common.libs.components;

/**
 * @author Pablo M.
 */
public interface ICursorFocus {

    public enum efocoArrow {
        Previo, Proximo;
    };

    /**
     * Comportamientos del foco al presionar la fecha Izquierda
     */
    public void setFocusKeyArrowL(efocoArrow pFoco);

    public efocoArrow getFocusKeyArrowL();

    /**
     * Comportamientos del foco al presionar la fecha Derecha
     */
    public void setFocusKeyArrowR(efocoArrow pFoco);

    public efocoArrow getFocusKeyArrowR();

    /**
     * Comportamientos del foco al presionar la fecha Arriba
     */
    public void setFocusKeyArrowU(efocoArrow pFoco);

    public efocoArrow getFocusKeyArrowU();

    /**
     * Comportamientos del foco al presionar la fecha Abajo
     */
    public void setFocusKeyArrowD(efocoArrow pFoco);

    public efocoArrow getFocusKeyArrowD();
}
