/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Logica.Punto;
import Logica.Valor;
import Logica.Variable;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class AddVariable extends javax.swing.JFrame {

    /**
     * Creates new form AddVariable
     */
	
	
	/*
	 * Comentario de Me
	 */
    public AddVariable() {
        initComponents();
        listvariables = new ArrayList<Variable>();
        listModelVariables = new DefaultListModel();
        listModelValores = new DefaultListModel();
        
        //TODO: Cargar registros del archivo a listvariables
        
        //llenar JList de Variables
        llenarJListVariables();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomVar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListVar = new javax.swing.JList<String>();
        btnAddVar = new javax.swing.JButton();
        btnAddVal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNomVal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListVal = new javax.swing.JList<String>();
        panelGraf = new javax.swing.JPanel();
        txtX1 = new javax.swing.JTextField();
        txtX2 = new javax.swing.JTextField();
        txtX3 = new javax.swing.JTextField();
        txtX4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtY4 = new javax.swing.JTextField();
        txtY1 = new javax.swing.JTextField();
        txtY2 = new javax.swing.JTextField();
        txtY3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAlias = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTraslape = new javax.swing.JTextField();
        btnGuardarTodo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Variable");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setText("Nombre Variable:");

        ListVar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListVarValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListVar);

        btnAddVar.setText("Agregar Variable");
        btnAddVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVarActionPerformed(evt);
            }
        });

        btnAddVal.setText("Agregar Valor");
        btnAddVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddValActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre Valor:");

        ListVal.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ListVal.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListValValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ListVal);

        javax.swing.GroupLayout panelGrafLayout = new javax.swing.GroupLayout(panelGraf);
        panelGraf.setLayout(panelGrafLayout);
        panelGrafLayout.setHorizontalGroup(
            panelGrafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelGrafLayout.setVerticalGroup(
            panelGrafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        txtX4.setText(" ");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Y");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");

        txtY4.setText(" ");

        jLabel6.setText("Alias: ");

        jLabel7.setText("Traslape");

        btnGuardarTodo.setText("Guardar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNomVar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAddVar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomVal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAddVal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtX4)
                            .addComponent(txtX3)
                            .addComponent(txtX2)
                            .addComponent(txtX1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtY4)
                            .addComponent(txtY3)
                            .addComponent(txtY2)
                            .addComponent(txtY1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGraf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 413, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTraslape, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnGuardarTodo, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNomVal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddVal)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel5))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtNomVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtX1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtX3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtX4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtY1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtY2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtY3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtY4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnAddVar)
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelGraf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTraslape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarTodo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Comentario para prueba de commit
    
    //Comentario de John
    /**
     * Evento que se desencadena al seleccionar un elemento de ListVar
     */
    private void ListVarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListVarValueChanged
        //determinar el elemento seleccionado
        int indice = ListVar.getSelectedIndex();
        System.out.println(indice);
        
        //Validacion por si no se ha seleccionado ningun elemento de la lista de variables
        if (indice == -1)
            return;
        
        //vaciar los campos de valor
        vaciarCamposValor();
        
        //Vaciar el JList de valores
        listModelValores.removeAllElements();
        //Agregar los valores de la variable seleccionada al JList de valores
        for (Valor val : listvariables.get(indice).getFunciones()) {
            listModelValores.addElement(val.getNombre());
        }
        ListVal.setModel(listModelValores);
        
        //TODO: Pintar la grafica con los subconjuntos difusos(valores) de la variable seleccionada
        
    }//GEN-LAST:event_ListVarValueChanged
    
    /**
     * Guardar una nueva variable
     */
    private void btnAddVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVarActionPerformed
        //Validar campos
        if (txtNomVar.getText().isEmpty() || txtAlias.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "El nombre y alias son obligaotrios", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String variable = txtNomVar.getText();
        String alias = txtAlias.getText();
       
        Variable var = new Variable();
        var.setNombre(variable);
        var.setAlias(alias);
        listvariables.add(var);
       
        //Agregar nueva variable a la JList
        listModelVariables.addElement(variable);
        ListVar.setModel(listModelVariables);
       
    }//GEN-LAST:event_btnAddVarActionPerformed

    /**
     * Evento que se desencadena al seleccionar un elemento de ListVal
     */
    private void ListValValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListValValueChanged
        //determinar el elemento seleccionado
        int indiceVariable = ListVar.getSelectedIndex();
        
        //Validacion por si no se ha seleccionado ningun elemento de la lista de variables
        if (indiceVariable == -1)
            return;
        
        int indiceValor = ListVal.getSelectedIndex();
        
        //Validacion por si no se ha seleccionado ningun elemento de la lista de valores
        if (indiceValor == -1)
            return;
        
        //vaciar los campos
        vaciarCamposValor();
        
        //determinar el elemento seleccionado
        Valor valorSel = listvariables.get(indiceVariable).getFunciones().get(indiceValor);
        //Mostrar el nombre del valor seleccionado
        txtNomVal.setText(valorSel.getNombre());
        
        /***********************************************+
         * Mostrar los puntos del valor seleccionado    |
         ***********************************************/
        
        //si el valor es trapecio completo
        if (valorSel.getPuntos().size() == 4)
        {
            //Valores de x
            txtX1.setText(""+valorSel.getPuntos().get(0).getX());
            txtX2.setText(""+valorSel.getPuntos().get(1).getX());
            txtX3.setText(""+valorSel.getPuntos().get(2).getX());
            txtX4.setText(""+valorSel.getPuntos().get(3).getX());
            //Valores de y
            txtY1.setText(""+valorSel.getPuntos().get(0).getY());
            txtY2.setText(""+valorSel.getPuntos().get(1).getY());
            txtY3.setText(""+valorSel.getPuntos().get(2).getY());
            txtY4.setText(""+valorSel.getPuntos().get(3).getY());
        }
        //si el valor es triangulo o trapecio abierto
        else if(valorSel.getPuntos().size() == 3)
        {
            //Valores de x
            txtX1.setText(""+valorSel.getPuntos().get(0).getX());
            txtX2.setText(""+valorSel.getPuntos().get(1).getX());
            txtX3.setText(""+valorSel.getPuntos().get(2).getX());
            //Valores de y
            txtY1.setText(""+valorSel.getPuntos().get(0).getY());
            txtY2.setText(""+valorSel.getPuntos().get(1).getY());
            txtY3.setText(""+valorSel.getPuntos().get(2).getY());
        }
        //si el valor es triangulo abierto
        else
        {
            //Valores de x
            txtX1.setText(""+valorSel.getPuntos().get(0).getX());
            txtX2.setText(""+valorSel.getPuntos().get(1).getX());
            //Valores de y
            txtY1.setText(""+valorSel.getPuntos().get(0).getY());
            txtY2.setText(""+valorSel.getPuntos().get(1).getY());
        }
    }//GEN-LAST:event_ListValValueChanged

    /**
     * Guardar un nuevo valor
     */
    private void btnAddValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddValActionPerformed
        //determinar la variable seleccionada
        int indiceVariable = ListVar.getSelectedIndex();
        //crear el valor
        Valor nuevoValor = new Valor();
        nuevoValor.setNombre(txtNomVal.getText());
        
        //crear el arreglo de puntos
        ArrayList<Punto> puntos = new ArrayList();
        Punto nuevoPunto;
        Double x,y;
        
        /***********************************************+
         * Validar los campos y crear los puntos        |
         ***********************************************/
        
        //El primer punto no puede estar vacio
        if (txtX1.getText().isEmpty() || txtY1.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "El primer punto esta vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        {
            x = Double.parseDouble(txtX1.getText());
            y = Double.parseDouble(txtY1.getText());
            nuevoPunto = new Punto(x,y);
            puntos.add(nuevoPunto);
        }
        
        //El segundo punto tampoco puede estar vacio
        if (txtX2.getText().isEmpty() || txtY2.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "El segundo punto esta vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        {
            x = Double.parseDouble(txtX2.getText());
            y = Double.parseDouble(txtY2.getText());
            nuevoPunto = new Punto(x,y);
            puntos.add(nuevoPunto);
        }
        
        //Si el tercer punto no es vacio, se crea
        if (!(txtX3.getText().trim().isEmpty() || txtY3.getText().trim().isEmpty()))
        {
            x = Double.parseDouble(txtX3.getText());
            y = Double.parseDouble(txtY3.getText());
            nuevoPunto = new Punto(x,y);
            puntos.add(nuevoPunto);
        }
        
        //Si el cuarto punto no es vacio, se crea
        if (!(txtX4.getText().trim().isEmpty() || txtY4.getText().trim().isEmpty()))
        {
            x = Double.parseDouble(txtX4.getText());
            y = Double.parseDouble(txtY4.getText());
            nuevoPunto = new Punto(x,y);
            puntos.add(nuevoPunto);
        }
        
        /******************************************************************+
         * Agregar los puntos al nuevo valor de la variable seleccionada   |
         ******************************************************************/
        nuevoValor.setPuntos(puntos);
        listvariables.get(indiceVariable).getFunciones().add(nuevoValor);
        
        /******************************************************************+
         * Agregar el nuevo valor a la JList de valores                    |
         ******************************************************************/
        listModelValores.addElement(nuevoValor.getNombre());
        ListVal.setModel(listModelValores);
    }//GEN-LAST:event_btnAddValActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddVariable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddVariable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddVariable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddVariable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddVariable().setVisible(true);
            }
        });
    }
    
    /**
     * Esta funcion llena el JList de variables a partir del arreglo ListVar
     */
    private void llenarJListVariables() {
        for (Variable var : listvariables) {
            listModelVariables.addElement(var.getNombre());
        }
        ListVar.setModel(listModelVariables);
    }
    
    /**
     * Esta funcion vacia los campos del valor
     */
    private void vaciarCamposValor() {
        txtNomVal.setText("");
        txtX1.setText("");
        txtX2.setText("");
        txtX3.setText("");
        txtX4.setText("");
        txtY1.setText("");
        txtY2.setText("");
        txtY3.setText("");
        txtY4.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListVal;
    private javax.swing.JList<String> ListVar;
    private javax.swing.JButton btnAddVal;
    private javax.swing.JButton btnAddVar;
    private javax.swing.JButton btnGuardarTodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelGraf;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JTextField txtNomVal;
    private javax.swing.JTextField txtNomVar;
    private javax.swing.JTextField txtTraslape;
    private javax.swing.JTextField txtX1;
    private javax.swing.JTextField txtX2;
    private javax.swing.JTextField txtX3;
    private javax.swing.JTextField txtX4;
    private javax.swing.JTextField txtY1;
    private javax.swing.JTextField txtY2;
    private javax.swing.JTextField txtY3;
    private javax.swing.JTextField txtY4;
    // End of variables declaration//GEN-END:variables
    private DefaultListModel listModelVariables;
    private DefaultListModel listModelValores;
    ArrayList<Variable> listvariables;
}
