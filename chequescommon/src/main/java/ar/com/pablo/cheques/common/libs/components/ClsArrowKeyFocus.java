package ar.com.pablo.cheques.common.libs.components;

import ar.com.pablo.cheques.common.libs.components.ICursorFocus.efocoArrow;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Pablo M.
 */
class ClsArrowKeyFocus implements KeyListener {

    Component pobjElComp;
    efocoArrow pFocusKeyArrowL;
    efocoArrow pFocusKeyArrowR;
    efocoArrow pFocusKeyArrowU;
    efocoArrow pFocusKeyArrowD;

    public ClsArrowKeyFocus(Component objElComp) {
        pobjElComp = objElComp;
    }

    public void setarrowL(efocoArrow l) {
        pFocusKeyArrowL = l;
    }

    public void setarrowR(efocoArrow r) {
        pFocusKeyArrowR = r;
    }

    public void setarrowU(efocoArrow u) {
        pFocusKeyArrowU = u;
    }

    public void setarrowD(efocoArrow d) {
        pFocusKeyArrowD = d;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            if (pFocusKeyArrowL != null) {
                if (pFocusKeyArrowL == efocoArrow.Previo) {
                    pobjElComp.transferFocusBackward();
                } else {
                    pobjElComp.transferFocus();
                }
            }
        }

        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (pFocusKeyArrowR != null) {
                if (pFocusKeyArrowR == efocoArrow.Previo) {
                    pobjElComp.transferFocusBackward();
                } else {
                    pobjElComp.transferFocus();
                }
            }
        }

        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            if (pFocusKeyArrowU != null) {
                if (pFocusKeyArrowU == efocoArrow.Previo) {
                    pobjElComp.transferFocusBackward();
                } else {
                    pobjElComp.transferFocus();
                }
            }
        }

        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            if (pFocusKeyArrowD != null) {
                if (pFocusKeyArrowD == efocoArrow.Previo) {
                    pobjElComp.transferFocusBackward();
                } else {
                    pobjElComp.transferFocus();
                }
            }
        }
    }
}
