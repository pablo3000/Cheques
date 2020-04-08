package ar.com.pablo.cheques.common.addons.calculator;

import ar.com.pablo.cheques.common.interfaces.IComponents;
import ar.com.pablo.cheques.common.interfaces.IConfig;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;

/**
 * Descripción: Calculadora
 * @author Cay S. Horstmann
 * @see  http://horstmann.com/corejava/
 * @see "http://www.java2s.com/Code/Java/Tiny-Application/Asimplecalculator.htm
 */
class PanelCalculator extends JPanel {

    public PanelCalculator(JDialog padre, IComponents components, IConfig config) {
        setLayout(new BorderLayout());
        this.padre = padre;
        this.components = components;
        this.config = config;

        source = components.getImporte();
        if ("".equals(source.getText()))
            result = 0;
        else
            result =  Double.parseDouble(source.getText().replace(",", "."));;
            
        lastCommand = "=";
        start = true;

        padre.addWindowListener(new WindowAdapter(){
            public void windowClosed(WindowEvent e){
                source.setValue(result);
            }
            public void windowClosing(WindowEvent e){
                 source.setValue(result);
            }
        });

        
        // add the display
        display = new JButton(Double.toString(result));
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        // add the buttons in a 4 x 4 grid
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }

    /**
     * Adds a button to the center panel.
     *
     * @param label the button label
     * @param listener the button listener
     */
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    /**
     * This action inserts the button action string to the end of the display
     * text.
     */
    private class InsertAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    /**
     * This action executes the command that the button action string denotes.
     */
    private class CommandAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();

            if (start) {
                if (command.equals("-")) {
                    display.setText(command);
                    start = false;
                } else {
                    lastCommand = command;
                }
            } else {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    /**
     * Carries out the pending calculation.
     *
     * @param x the value to be accumulated with the prior result.
     */
    public void calculate(double x) {
        if (lastCommand.equals("+")) {
            result += x;
        } else if (lastCommand.equals("-")) {
            result -= x;
        } else if (lastCommand.equals("*")) {
            result *= x;
        } else if (lastCommand.equals("/")) {
            result /= x;
        } else if (lastCommand.equals("=")) {
            result = x;
        }
        display.setText("" + result);
    }

    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
    private JFormattedTextField source;
    private IConfig config;
    private IComponents components;
    private JDialog padre;
}
