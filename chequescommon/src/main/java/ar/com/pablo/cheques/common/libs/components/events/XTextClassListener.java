package ar.com.pablo.cheques.common.libs.components.events;

import java.util.EventListener;

/**
 * @author Pablo M.
 */
public interface XTextClassListener extends EventListener {

    /**
     * Ocurre cuando el texto cambia
     */
    public void textChange(XTextClass e);

    /**
     * Ocurre cuando se inserta un texto
     */
    public void textInsert(XTextClass e);

    /**
     * Ocurre cuando se remueve parte del texto
     */
    public void textRemove(XTextClass e);

}
