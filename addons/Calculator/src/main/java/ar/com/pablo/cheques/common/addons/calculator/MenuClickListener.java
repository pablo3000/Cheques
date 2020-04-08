package ar.com.pablo.cheques.common.addons.calculator;

import ar.com.pablo.cheques.common.interfaces.IComponents;
import ar.com.pablo.cheques.common.interfaces.IConfig;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Descripción: Listener para el menu contextual
 *
 * @author Pablo M. Chabas-Santa Fe-Argentina Fecha 03/04/2020
 * @version 1.0
 */
public class MenuClickListener extends MouseAdapter {

    IConfig config;
    IComponents components;

    public MenuClickListener(IConfig config, IComponents components) {
        this.config = config;
        this.components = components;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) {
            doPop(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            doPop(e);
        }
    }

    private void doPop(MouseEvent e) {
        ContextMenu menu = new ContextMenu(config, components);
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}
