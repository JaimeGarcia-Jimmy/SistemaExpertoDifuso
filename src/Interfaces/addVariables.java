/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Archivo.Files;
import Archivo.Registro;
import Interfaces.grafica.Graficar;
import Logica.Punto;
import Logica.Valor;
import Logica.Variable;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author danie
 */
public class addVariables extends javax.swing.JFrame {

    /**
     * Creates new form addVariable
     */
        Graficar grafica = new Graficar();
	Registro reg = new Registro();
	Files archivo = new Files();
	private DefaultListModel listModelVariables;
        private DefaultListModel listModelValores;
        ArrayList<Variable> listvariables;
        private int indSegList;
        
    public addVariables() throws IOException, ParseException {
        initComponents();
        listvariables = new ArrayList<Variable>();
        listModelVariables = new DefaultListModel();
        listModelValores = new DefaultListModel();
        
        //TODO: Cargar registros del archivo a listvariables
        archivo.abrir();
        reg.read(archivo.file);
        listvariables = reg.getVariable();
        
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

        txtY2 = new javax.swing.JTextField();
        txtY3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAlias = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTraslape = new javax.swing.JTextField();
        btnGuardarTodo = new javax.swing.JButton();
        txtNomVal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListVal = new javax.swing.JList<>();
        panelGraf = new javax.swing.JPanel();
        txtX1 = new javax.swing.JTextField();
        txtX2 = new javax.swing.JTextField();
        txtX3 = new javax.swing.JTextField();
        txtX4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomVar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListVar = new javax.swing.JList<>();
        btnAddVar = new javax.swing.JButton();
        btnAddVal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtY4 = new javax.swing.JTextField();
        txtY1 = new javax.swing.JTextField();
        cbxSalida = new javax.swing.JCheckBox();
        btnBorrarVariable = new javax.swing.JButton();
        btnActVal = new javax.swing.JButton();
        btnBorrarValor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("Alias: ");

        jLabel7.setText("Traslape");

        txtTraslape.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTraslapeFocusLost(evt);
            }
        });

        btnGuardarTodo.setText("Guardar");
        btnGuardarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTodoActionPerformed(evt);
            }
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

        txtY4.setText(" ");

        cbxSalida.setText("¿Es la Variable de Salida?");

        btnBorrarVariable.setText("Borrar Variable");
        btnBorrarVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarVariableActionPerformed(evt);
            }
        });

        btnActVal.setText("Actualizar Valor");
        btnActVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActValActionPerformed(evt);
            }
        });

        btnBorrarValor.setText("Borrar Valor");
        btnBorrarValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomVar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAddVar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarVariable, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxSalida)
                            .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActVal)
                        .addGap(26, 26, 26)
                        .addComponent(btnBorrarValor))
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
                        .addGap(0, 378, Short.MAX_VALUE)
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
                                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbxSalida)))
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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrarVariable))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelGraf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTraslape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarTodo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActVal)
                    .addComponent(btnBorrarValor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        grafica.setSize(panelGraf.getWidth(),panelGraf.getHeight());
        panelGraf.add(grafica);
        
        
    }// </editor-fold>//GEN-END:initComponents

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

        grafica.setValSeleccionado(indiceValor);
        grafica.repaint();

    }//GEN-LAST:event_ListValValueChanged

    private void ListVarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListVarValueChanged
        //determinar el elemento seleccionado
        int indice = ListVar.getSelectedIndex();

        //Validacion por si no se ha seleccionado ningun elemento de la lista de variables
        if (indice == -1)
        return;

        //vaciar los campos de valor
        vaciarCamposValor();

        //Vaciar el JList de valores
        listModelValores.removeAllElements();
        //Agregar los valores de la variable seleccionada al JList de valores
        cbxSalida.setSelected(listvariables.get(indice).isSalida());
        for (Valor val : listvariables.get(indice).getFunciones()) {
            listModelValores.addElement(val.getNombre());

        }
        ListVal.setModel(listModelValores);

        //TODO: Pintar la grafica con los subconjuntos difusos(valores) de la variable seleccionada
        grafica.setVariable(listvariables.get(indice));
    }//GEN-LAST:event_ListVarValueChanged

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
        var.setSalida(cbxSalida.isSelected());
        listvariables.add(var);

        //Agregar nueva variable a la JList
        listModelVariables.addElement(variable);
        ListVar.setModel(listModelVariables);

    }//GEN-LAST:event_btnAddVarActionPerformed

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
        grafica.setVariable(listvariables.get(indiceVariable));
        /******************************************************************+
        * Agregar el nuevo valor a la JList de valores                    |
        ******************************************************************/
        listModelValores.addElement(nuevoValor.getNombre());
        ListVal.setModel(listModelValores);
    }//GEN-LAST:event_btnAddValActionPerformed

    private void btnGuardarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTodoActionPerformed
            try {
                //Escribimos todo la info en el archivo binario
                reg.write(archivo.file, listvariables);
            } catch (IOException ex) {
                Logger.getLogger(addVariables.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnGuardarTodoActionPerformed

    private void txtTraslapeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTraslapeFocusLost
        //determinar si existe una variable seleccionada
        if(!ListVar.isSelectionEmpty())
        {
            //Recuperamos el indice de la lista (Variable seleccionada)
            int indiceVariable = ListVar.getSelectedIndex();
            //Validamos que el traslape no este vacio
            if(!txtTraslape.getText().equals(""))
            {
                //Recuperamos el traslape 
                double traslape = Double.parseDouble(txtTraslape.getText());
                //Realizamos el set para desencadenar la actualizacion del Traslape
                listvariables.get(indiceVariable).setTraslape(traslape);
            }
        }
    }//GEN-LAST:event_txtTraslapeFocusLost

    private void btnActValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActValActionPerformed
    //determinar el elemento seleccionado
        int indiceVariable = ListVar.getSelectedIndex();
        
        //Validacion por si no se ha seleccionado ningun elemento de la lista de variables
        if (indiceVariable == -1)
            return;
        
        int indiceValor = ListVal.getSelectedIndex();
        
        //Validacion por si no se ha seleccionado ningun elemento de la lista de valores
        if (indiceValor == -1)
            return;
        
        //determinar el elemento seleccionado
        Valor valorSel = listvariables.get(indiceVariable).getFunciones().get(indiceValor);
        //Actualizar el nombre del valor seleccionado
        valorSel.setNombre(txtNomVal.getText());
        
        //Validar cuantas txt cuentan con un valor para crear puntos
        double x,y;
        Punto nuevoPunto;
        ArrayList<Punto> puntos= new ArrayList<Punto>();
        
        //Se verifica la txt para el punto 1
        if (!(txtX1.getText().trim().isEmpty() || txtY1.getText().trim().isEmpty()))
        {
            x = Double.parseDouble(txtX1.getText());
            y = Double.parseDouble(txtY1.getText());
            nuevoPunto = new Punto(x,y);
            puntos.add(nuevoPunto);
        }
        //Se verifica la txt para el punto 2
        if (!(txtX2.getText().trim().isEmpty() || txtY2.getText().trim().isEmpty()))
        {
            x = Double.parseDouble(txtX2.getText());
            y = Double.parseDouble(txtY2.getText());
            nuevoPunto = new Punto(x,y);
            puntos.add(nuevoPunto);
        }
        //Se verifica la txt para el punto 3
        if (!(txtX3.getText().trim().isEmpty() || txtY3.getText().trim().isEmpty()))
        {
            x = Double.parseDouble(txtX3.getText());
            y = Double.parseDouble(txtY3.getText());
            nuevoPunto = new Punto(x,y);
            puntos.add(nuevoPunto);
        }
        //Se verifica la txt para el punto 4
        if (!(txtX4.getText().trim().isEmpty() || txtY4.getText().trim().isEmpty()))
        {
            x = Double.parseDouble(txtX4.getText());
            y = Double.parseDouble(txtY4.getText());
            nuevoPunto = new Punto(x,y);
            puntos.add(nuevoPunto);
        }
        //Se envia el nuevo Arraylist al modelo de Valor
        valorSel.setPuntos(puntos);
        
    }//GEN-LAST:event_btnActValActionPerformed

    private void btnBorrarVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarVariableActionPerformed
    //determinar si existe una variable seleccionada
        if(!ListVar.isSelectionEmpty())
        {
            //Recuperamos el indice de la lista (Variable seleccionada)
            int indiceVariable = ListVar.getSelectedIndex();
            //Removemos de la lista global el indice que seleccionaron
            listvariables.remove(indiceVariable);
        }
    }//GEN-LAST:event_btnBorrarVariableActionPerformed

    private void btnBorrarValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarValorActionPerformed
        //determinar si existe una variable seleccionada
        if(!ListVar.isSelectionEmpty())
        {
            //Recuperamos el indice de la lista (Variable seleccionada)
            int indiceVariable = ListVar.getSelectedIndex();
            if(!ListVal.isSelectionEmpty())
            {
                int indiceValor = ListVal.getSelectedIndex();
                listvariables.get(indiceVariable).getFunciones().remove(indiceValor);
            }
        }
    }//GEN-LAST:event_btnBorrarValorActionPerformed
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
            java.util.logging.Logger.getLogger(addVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new addVariables().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(addVariables.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(addVariables.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListVal;
    private javax.swing.JList<String> ListVar;
    private javax.swing.JButton btnActVal;
    private javax.swing.JButton btnAddVal;
    private javax.swing.JButton btnAddVar;
    private javax.swing.JButton btnBorrarValor;
    private javax.swing.JButton btnBorrarVariable;
    private javax.swing.JButton btnGuardarTodo;
    private javax.swing.JCheckBox cbxSalida;
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
}
