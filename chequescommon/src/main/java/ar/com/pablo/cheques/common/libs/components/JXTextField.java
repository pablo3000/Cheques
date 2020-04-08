package ar.com.pablo.cheques.common.libs.components;

import ar.com.pablo.cheques.common.libs.components.events.XTextClass;
import ar.com.pablo.cheques.common.libs.components.events.XTextClassListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.EventListenerList;

/**
 * Componente JTextField geneticamente modificado
 * @author Pablo M.
 */
public class JXTextField extends  JComponent implements Serializable, ICommon, IRequired,ICursorFocus,IListeners,ITextEdit{
    
    private JTextField jtxt;
    private JLabel jxLblR;
    private String msgNoValid = null,msgRequired = null;  //Mesajes dato no valido y Mensaje valor requrido;
    private Border txtBorderEmpty = null; //Borde del jxTextField por si es requerido  
    private Border txtBorderNormal = null;
  
    private String validator; // RegEx utilizada para validar datos
    private Pattern patronRegEx = null;  //patron para validar una RegEx
    
    private Color COLORREQUIRED = Color.red;
    private Color DEFCOLORCHARVALID = new Color(255,150,150);
    private final Color DEFCOLORNORMAL = Color.white;
    private final String DEFCHARVALID = " * ";
    
    private boolean pPasaConEnter = true;
    private boolean pSelConElFoco = true;
   
   private int pmaxLength = 0;

    private ClsArrowKeyFocus arrowListener;
    efocoArrow pFocusKeyArrowL;
    efocoArrow pFocusKeyArrowR;
    efocoArrow pFocusKeyArrowU;
    efocoArrow pFocusKeyArrowD;

    public JXTextField() {
         this.setLayout(new BorderLayout());
         jtxt = new JTextField();
         jxLblR = new JLabel(DEFCHARVALID);
         jxLblR.setFont(new Font("Arial", Font.BOLD, 20));
         jxLblR.setForeground(Color.red);
     
         jtxt.setPreferredSize(new Dimension(130, 27));
         this.add(jtxt,java.awt.BorderLayout.CENTER);
         
         txtBorderNormal = jtxt.getBorder();

         jtxt.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override public void focusGained(FocusEvent evt){txtFocusGained(evt);}
            @Override public void focusLost(FocusEvent evt) {txtFocusLost(evt);}
         });
        jtxt.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {txtActionPerformed(evt);}
        });
         
    arrowListener = new ClsArrowKeyFocus(jtxt);
        jtxt.addKeyListener(arrowListener);    
    }

    @Override
    public void requestFocus(){
        jtxt.requestFocus();
    }
   
    @Override
    public JLabel getRequired() {
        return jxLblR;
    }

    @Override
    public void setRequired(JLabel jLabelRequired) {
        if (null != jLabelRequired){
            this.add(jLabelRequired,java.awt.BorderLayout.LINE_END);
            if (null == txtBorderEmpty)
                txtBorderEmpty = new LineBorder(COLORREQUIRED, 2, false);     
        }else
            this.remove(jxLblR);
        jxLblR = jLabelRequired;
       
    }

    /**
     * @return Retorna true si se requiere un valor y este se encuentra en la caja de texto
     * @see Clase JxCharRequired
     */
    @Override
    public  boolean isValidRequired() {
        if (null != jxLblR){
            if ("".equals(jtxt.getText().trim()))
                return false;
            else
                return true;
        }
        return true; 
    }
 
    @Override
     public void setValidRequired(boolean valor) {
       if (valor)
           setRequired(jxLblR);
       else
           setRequired(null);
    }
  
    /**
     * Retorna el mensaje a mostrar si la información ingresada no es valida
     * @return Mensajito
     */
    @Override
    public String getMessageNoValid() {
        return msgNoValid;
    }

    /**
     * Settea  el mensaje a mostrar si la información ingresada no es valida
     * @param msgNoValid Mensajito
     */
    @Override
    public void setMessageNoValid(String msgNoValid) {
        this.msgNoValid = msgNoValid;
    }

    /**
     * Retorna el mensaje a mostrar si la información ingresada es requerida
     * @return Mensajito
     */
    @Override
    public String getMessageRequired() {
        return msgRequired;
    }

    /**
     * Settea  el mensaje a mostrar si la información ingresada es requerida
     * @param msgRequired Mensajito
     */
    @Override
    public void setMessageRequired(String msgRequired) {
        this.msgRequired = msgRequired;
    }

    /**
     * Settea la expresión regular utilizada para validar los datos
     * @param regEx Expresión regular
     */
    @Override
    public void setValidator(String regEx){
        validator = regEx;
        if(null != regEx)
            patronRegEx = Pattern.compile(regEx.trim());
        else
            patronRegEx = null;
        
    }
 
     /**
     * Retorna la expresión regular utilizada para validar los datos
     * @return Expresión regular
     */
    @Override
    public String getValidator() {
        return validator;
    }
    
    
   //Eventos
    private void txtFocusLost(FocusEvent evt){
        //Esto es por si es requerido 
        if (null != jxLblR)
            if("".equals(jtxt.getText().trim()))
                pintaBorde(true);
        
        //Esto es por si se tiene que validar 
        if (!isTextValid()){
            if(!"".equals(jtxt.getText().trim())) 
                pintaFondo(true);
            else
                pintaFondo(false);             
        }else
            pintaFondo(false);  
    }
    
    private void txtFocusGained(FocusEvent evt){
        pintaBorde(false);
        if (pSelConElFoco)jtxt.selectAll();  
    }
    
    private void txtActionPerformed(ActionEvent evt) {
       
        if (pPasaConEnter)
            jtxt.transferFocus();   
    }

    
    //fin de los eventos------------------
    
    /**
     * Retorna True si el texto ingresado es valido
     * @see setValidator
     */
    public boolean isTextValid(){
        if(null != patronRegEx){
            Matcher matcherRegEx = patronRegEx.matcher(jtxt.getText().trim());
            if(matcherRegEx.matches()){
                matcherRegEx = null;
                return true;
            }else{
                matcherRegEx = null;
                return false;
            }
        }
        return true; 
    }
    
    private void pintaFondo(boolean pinta){
        if (pinta)
            jtxt.setBackground(DEFCOLORCHARVALID);
        else
            jtxt.setBackground(DEFCOLORNORMAL);
    }
       
    private void pintaBorde(boolean pinta){
        if (pinta)
            jtxt.setBorder(txtBorderEmpty);
        else
            jtxt.setBorder(txtBorderNormal);     
    }

     @Override
    public boolean getAutoLostFocus() {
        return pPasaConEnter;
    }

    @Override
    public void setAutoLostFocus(boolean valor) {
        pPasaConEnter = valor; 
    }
  
    @Override
    public boolean getSelConElFoco() {
        return pSelConElFoco;
    }

    @Override
    public void setSelConElFoco(boolean valor) {
        pSelConElFoco = valor;
    }
   
    @Override
    public void setFocusKeyArrowL(efocoArrow pFoco) {
       arrowListener.setarrowL(pFoco);
       pFocusKeyArrowL = pFoco;
    }

    @Override
    public efocoArrow getFocusKeyArrowL() {
        return pFocusKeyArrowL;
    }

    @Override
    public void setFocusKeyArrowR(efocoArrow pFoco) {
       arrowListener.setarrowR(pFoco);
       pFocusKeyArrowR = pFoco;
    }

    @Override
    public efocoArrow getFocusKeyArrowR() {
        return pFocusKeyArrowR;
    }

    @Override
    public void setFocusKeyArrowU(efocoArrow pFoco) {
       arrowListener.setarrowU(pFoco);
       pFocusKeyArrowU = pFoco;
    }

    @Override
    public efocoArrow getFocusKeyArrowU() {
        return pFocusKeyArrowU;
    }

    @Override
    public void setFocusKeyArrowD(efocoArrow pFoco) {
       arrowListener.setarrowD(pFoco);
       pFocusKeyArrowD = pFoco;
    }

    @Override
    public efocoArrow getFocusKeyArrowD() {
        return pFocusKeyArrowD;
    }

    @Override
    public void removeAllActionListeners() {
        ActionListener[] al = jtxt.getActionListeners();     
        for (int i = 0; i < al.length; i++) 
            jtxt.removeActionListener(al[i]);
        
        al = null;            
    }
    
     @Override
    public void addActionListener(ActionListener l) {
        jtxt.addActionListener(l);
    }
    
    @Override
     public synchronized void addKeyListener(KeyListener l){
         jtxt.addKeyListener(l);
     }

    // Eventos
  protected EventListenerList listenersList = new EventListenerList();

  public void addXTextClassListener(XTextClassListener listener) {
      listenersList.add(XTextClassListener.class, listener);
  }
  public void removeXTextClassListener(XTextClassListener listener) {
    listenersList.remove(XTextClassListener.class, listener);
  }
  
  private void fireEventTextChange(XTextClass evt) {
      Object[] listeners = listenersList.getListenerList();
    for (int i = 0; i < listeners.length; i = i+2) {
      if (listeners[i] == XTextClassListener.class) {
        ((XTextClassListener) listeners[i+1]).textChange(evt);
      }
    }
  }

  private void fireEventtextInsert(XTextClass evt) {
      Object[] listeners = listenersList.getListenerList();
    for (int i = 0; i < listeners.length; i = i+2) {
      if (listeners[i] == XTextClassListener.class) {
        ((XTextClassListener) listeners[i+1]).textInsert(evt);
      }
    }
  }

  private void fireEventtextRemove(XTextClass evt) {
    Object[] listeners = listenersList.getListenerList();
    for (int i = 0; i < listeners.length; i = i+2) {
      if (listeners[i] == XTextClassListener.class) {
        ((XTextClassListener) listeners[i+1]).textRemove(evt);
      }
    }
  }

 //**************

    private void setJTexFieldChanged(JTextField txt)
    {
        DocumentListener documentListener = new DocumentListener() {

        @Override
        public void changedUpdate(DocumentEvent documentEvent) {
            lanzaEventos(documentEvent);
        }

        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            lanzaEventos(documentEvent);
        }

        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            lanzaEventos(documentEvent);
        }
        };
        txt.getDocument().addDocumentListener(documentListener);
    }

    private void lanzaEventos(DocumentEvent documentEvent) {
         DocumentEvent.EventType type = documentEvent.getType();

        if (type.equals(DocumentEvent.EventType.INSERT))
        {
            fireEventtextInsert(new XTextClass(jtxt));
            fireEventTextChange(new XTextClass(jtxt));
        }
        else if (type.equals(DocumentEvent.EventType.REMOVE))
        {
            fireEventtextRemove(new XTextClass(jtxt));
            fireEventTextChange(new XTextClass(jtxt));
        }
    }
    
     @Override
    public String getText() {
        return  jtxt.getText();
    }

    @Override
    public void setText(String text) {
      jtxt.setText(text);
    }

//***********************

    @Override
    public void setColorRequired(Color valor) {
        COLORREQUIRED = valor;
        txtBorderEmpty = new LineBorder(COLORREQUIRED, 2, false);
    }

    @Override
    public Color getColorRequired() {
        return COLORREQUIRED;
    }

    @Override
    public void setColorValid(Color valor) {
        DEFCOLORCHARVALID = valor;
    }

    @Override
    public Color getColorValid() {
       return DEFCOLORCHARVALID;
    }
 
    public int getMaxLength(){
        return pmaxLength;
    }

    public void setMaxLength(int valor){
        int valorViejo = pmaxLength;
        pmaxLength = valor;
        jtxt.setDocument(new ClsLimitadorCaracteres(jtxt, valor));
        setJTexFieldChanged(jtxt);       
    }

    @Override
     public void setEnabled(boolean enabled){
         jtxt.setEnabled(enabled);
     }
    
    @Override
    public boolean isEnabled(){
        return jtxt.isEnabled();
    }
}