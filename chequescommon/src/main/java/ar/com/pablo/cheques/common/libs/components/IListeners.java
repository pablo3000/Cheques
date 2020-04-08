package ar.com.pablo.cheques.common.libs.components;

import java.awt.event.ActionListener;

/**
 * Descripción:
 *
 * @author Pablo M.
 * @version 1.0
 */
public interface IListeners {

    /**
     * Quita todos los Listeners del componente.
     * <br><br>ooO_(_)_Ooo
     */
    public void removeAllActionListeners();

    /**
     * Agrega un listener
     *
     * @param l El listener
     */
    public void addActionListener(ActionListener l);
}
