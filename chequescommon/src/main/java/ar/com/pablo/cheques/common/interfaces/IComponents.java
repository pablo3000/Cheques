package ar.com.pablo.cheques.common.interfaces;

import ar.com.pablo.cheques.common.libs.components.JXButton;
import ar.com.pablo.cheques.common.libs.components.JXTextField;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import org.jdatepicker.JDatePicker;

/**
 * Descripción: Contiene contiene todos componentes de de la ventana principal
 * de la aplicación
 *
 * @author Pablo M. Chabas-Santa Fe-Argentina Fecha 25/03/2020
 * @version 1.0
 */
public interface IComponents {

    public JDatePicker getFechaCheque();

    public JDatePicker getFechaCobro();

    public JXTextField getPagueseA();

    public JFormattedTextField getImporte();

    public JXButton getBTNimprimir();

    public JXButton getBTNCerrar();

    public JFrame getMainFrame();
}
