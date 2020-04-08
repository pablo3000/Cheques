package ar.com.pablo.cheques.common.libs.components;

import ar.com.pablo.cheques.common.interfaces.IConfig;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Componente JButton geneticamente modificado
 *
 * @author Pablo M.
 */
public class JXButton extends JButton implements Serializable, ICursorFocus, IListeners {

    final String SEPARATOR = ":";

    public enum EtipoBotones {
        Aceptar,
        Cancelar,
        Cerrar,
        Imprimir,
        Volver,
        Abrir_Archivo,
        Guardar_Archivo,
        Guardar_Como,
        Guardar_Todo,
        Examinar,
        Aplicar,
        Calcular,
        Grafico;
    };

    private String[] btnConfig = {
        "Aceptar:Aceptar:btn_aceptar24x24.png:A:Confirma la operación",
        "Cancelar:Cancelar:btn_cancelar24x24.png:C:Cancela la operación",
        "Cerrar:Cerrar:btn_close24x24.png:E:Cierra el formulario",
        "Imprimir:Imprimir:btn_print24x24.png:I:Inicia la impresión",
        "Volver:Volver:btn_back24x24.png:l:Regresa al formulario anterior",
        "Abrir_Archivo:Arbrir:btn_fileopen24x24.png:r:Abre un archivo",
        "Guardar_Archivo:Guardar:btn_filesave24x24.png:g:Almancena el contenido en un archivo",
        "Guardar_Como:Guardar como...:btn_filesaveas24x24.png:d:Almacena el contenido en un archivo y le pone un nombre",
        "Guardar_todo:Guardar todo:btn_saveall24x24.png:u:Almacena el contenido de todos los documentos abiertos",
        "Examinar:Examinar:btn_view24x24.png:e:Ver listado",
        "Aplicar:Aplicar:btn_aplicar24x24.png:p:Aplicar Cambios",
        "Calcular:Calcular:btn_calc24x24.png:c:Calcula valores",
        "Grafico:Gráfico:btn_graph24x24.png:g:Gráfico  "
    };

    public JXButton() {
        initBTN();
    }

    public JXButton(EtipoBotones tipo, ActionListener actionL) {
        setTipo(tipo);
        super.addActionListener(actionL);
        initBTN();
    }

    public JXButton(ActionListener actionL) {
        setTipo(EtipoBotones.Aceptar);
        super.addActionListener(actionL);
        initBTN();
    }

    public JXButton(EtipoBotones tipo) {
        setTipo(tipo);
        initBTN();
    }

    public ImageIcon getIcon(String iconName) {
        try {
            return new ImageIcon(ImageIO.read(IConfig.class.getResourceAsStream("/" + iconName)));
        } catch (IOException ex) {
            return null;
        }
    }

    private EtipoBotones pTipoBotones;
    private String btn_Text, btn_HotKey, btn_Descripcion;
    private ImageIcon btn_Image;

    private ClsArrowKeyFocus arrowListener;
    efocoArrow pFocusKeyArrowL;
    efocoArrow pFocusKeyArrowR;
    efocoArrow pFocusKeyArrowU;
    efocoArrow pFocusKeyArrowD;

    public void setFocusKeyArrowL(efocoArrow pFoco) {
        arrowListener.setarrowL(pFoco);
        // efocoArrow valorViejo = pFoco;
        pFocusKeyArrowL = pFoco;
    }

    public efocoArrow getFocusKeyArrowL() {
        return pFocusKeyArrowL;
    }

    public void setFocusKeyArrowR(efocoArrow pFoco) {
        arrowListener.setarrowR(pFoco);
        //  efocoArrow valorViejo = pFoco;
        pFocusKeyArrowR = pFoco;
    }

    public efocoArrow getFocusKeyArrowR() {
        return pFocusKeyArrowR;
    }

    public void setFocusKeyArrowU(efocoArrow pFoco) {
        arrowListener.setarrowU(pFoco);
        //   efocoArrow valorViejo = pFoco;
        pFocusKeyArrowU = pFoco;
    }

    public efocoArrow getFocusKeyArrowU() {
        return pFocusKeyArrowU;
    }

    public void setFocusKeyArrowD(efocoArrow pFoco) {
        arrowListener.setarrowD(pFoco);
        //    efocoArrow valorViejo = pFoco;
        pFocusKeyArrowD = pFoco;
    }

    public efocoArrow getFocusKeyArrowD() {
        return pFocusKeyArrowD;
    }

    public EtipoBotones getTipo() {
        return pTipoBotones;
    }

    public void setTipo(EtipoBotones tipo) {
        setTipo(tipo, null, 'a', null);
    }

    public void setTipo(EtipoBotones tipo, String texto, char hotKey, String toolTip) {
        if (tipo != null) {
            if (loadInfo(tipo)) {
                if (null == texto) {
                    super.setText(btn_Text);
                    super.setMnemonic(btn_HotKey.toCharArray()[0]);
                    super.setToolTipText(btn_Descripcion);
                } else {
                    super.setText(texto);
                    super.setMnemonic(hotKey);
                    super.setToolTipText(toolTip);
                }

                super.setIcon(btn_Image);

                super.setPreferredSize(new Dimension(120, 36));
            }

        } else {
            super.setText("");
            super.setIcon(null);
        }
        pTipoBotones = tipo;

    }

    private void initBTN() {
        this.addKeyListener(new java.awt.event.KeyListener() {
            public void keyTyped(KeyEvent ke) {
            }

            public void keyPressed(KeyEvent ke) {
            }

            public void keyReleased(KeyEvent ke) {
                arrowKeyEvent(ke);
            }
        });

        arrowListener = new ClsArrowKeyFocus(this);
        this.addKeyListener(arrowListener);
    }

    public String getVersion() {
        return "1.1";
    }

    public String getNombre() {
        return "JxButton";
    }

    private void arrowKeyEvent(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            if (pFocusKeyArrowL != null) {
                if (pFocusKeyArrowL == efocoArrow.Previo) {
                    super.transferFocusBackward();
                } else {
                    super.transferFocus();
                }
            }
        }

        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (pFocusKeyArrowD != null) {
                if (pFocusKeyArrowD == efocoArrow.Previo) {
                    super.transferFocusBackward();
                } else {
                    super.transferFocus();
                }
            }
        }

        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            if (pFocusKeyArrowU != null) {
                if (pFocusKeyArrowU == efocoArrow.Previo) {
                    super.transferFocusBackward();
                } else {
                    super.transferFocus();
                }
            }
        }

        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            if (pFocusKeyArrowD != null) {
                if (pFocusKeyArrowD == efocoArrow.Previo) {
                    super.transferFocusBackward();
                } else {
                    super.transferFocus();
                }
            }
        }
    }

    private boolean loadInfo(EtipoBotones boton) {
        for (String btnConfig1 : btnConfig) {
            if (btnConfig1.trim().split(SEPARATOR)[0].equals(boton.toString())) {
                btn_Text = btnConfig1.trim().split(SEPARATOR)[1];
                btn_Image = getIcon(btnConfig1.trim().split(SEPARATOR)[2]);
                btn_HotKey = btnConfig1.trim().split(SEPARATOR)[3];
                btn_Descripcion = btnConfig1.trim().split(SEPARATOR)[4];
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeAllActionListeners() {
        ActionListener[] al = super.getActionListeners();

        for (int i = 0; i < al.length; i++) {
            super.removeActionListener(al[i]);
        }

        al = null;
    }
}
