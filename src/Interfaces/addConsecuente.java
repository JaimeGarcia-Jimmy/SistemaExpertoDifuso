/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Archivo.Files;
import Archivo.Registro;
import Logica.Valor;
import Logica.Variable;
import java.awt.BorderLayout;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author danie
 */
public class addConsecuente extends javax.swing.JFrame {

    /**
     * Creates new form addConsecuente
     */
    ArrayList<Variable> listvariables;
    Registro reg = new Registro();
    Files archivo = new Files();
    ArrayList<String> aliasvalor = new ArrayList();
    List<List<String>> vari;
    Object[][] tablaalias ;
    ArrayList<String> alias;
    JTable jtAlias;
    JTable jtReglas;
    Registro regi = new Registro();
    public addConsecuente() throws IOException, ParseException 
    {
        initComponents();
        listvariables= new ArrayList<Variable>();
        archivo.abrir();
        reg.read(archivo.file);
        listvariables = reg.getVariable();
        getCombinacion();
        //Creamos el contenedor de la tabla
        iniciarTabla();
        iniciarTablaAlias();
    }
    private void iniciarTabla() throws IOException
    {
        Object[][] vect = new Object[vari.size()][2];
        
        int i=0;
        for(List regla: vari)
        {
           String reg="";
           for(Object condicion: regla)
           {
               reg+=condicion+" ^ ";
           }
           vect[i][0]=reg.substring(0,reg.length()-3);
           //Recuperamos el consecuente del archivo (si este existe)
           //sino se deja en blanco 
           regi = new Registro();
           //regi.getConsecuente(vect[i][0].toString());
           vect[i][1]=regi.getConsecuente(vect[i][0].toString()).replace(" ","");
           i++;
        }
        String[] headers = {"Antecedente","Consecuente"};
        jtReglas = new JTable(vect,headers);
        JScrollPane js = new JScrollPane(jtReglas);
        jpReglas.setLayout(new BorderLayout());
        jpReglas.add(js,0);
    }
    ;
    private void iniciarTablaAlias()
    {
        String[] headers = {"Variable","Valor","Alias"};
        jtAlias = new JTable(tablaalias,headers);
        JScrollPane js = new JScrollPane(jtAlias);
        jpAlias.setLayout(new BorderLayout());
        jpAlias.add(js,0);
    }
    private void getCombinacion()
    {
        vari = new ArrayList();
        alias = new ArrayList<String>();
        for( Variable var : listvariables )
        {
            String nombre = var.getNombre();
            if(!var.isSalida())
            {
                ArrayList<String> nomb = new ArrayList();
                for (Valor val : var.getFunciones()) 
                {
                    nomb.add(val.getNombre().substring(0, 2));
                    alias.add(nombre);
                    alias.add(val.getNombre());
                    alias.add(val.getNombre().substring(0, 2));
                }
                vari.add(nomb);
            }
        }
        
        tablaalias= new Object[alias.size()/3][3];
        for (int i = 0; i <alias.size()/3; i++) 
        {
            tablaalias[i][0]=alias.get(i*3);
            tablaalias[i][1]=alias.get((i*3)+1);
            tablaalias[i][2]=alias.get((i*3)+2);
        }
        vari = productoCartesianoListas(vari);
    }
    private List<List<String>> productoCartesianoListas(List<List<String>> lists) 
    {
            List<List<String>> resultLists = new ArrayList<List<String>>();
            if (lists.size() == 0) 
            {
                resultLists.add(new ArrayList<String>());
                return resultLists;
            } 
            else 
            {
                List<String> firstList = lists.get(0);
                //Nos dirijimos hasta la ultima lista de la coleccion de listas (Despues de llegar al true de este IF)
                //Una vez que recibimos las combinaciones resultantes de las listas
                //que preceden de nuestra posicion actual
                //y guardando la lista de nuestra posicion actual 
                //comenzaremos a combinar las condiciones compuestas
                
                
                List<List<String>> remainingLists = productoCartesianoListas(lists.subList(1, lists.size()));
                //Tomamos una a una las condiciones 
                for (String condition : firstList) 
                {
                    //Tomamos todas las condiciones de la lista que antecede a la ultima (de forma recursiva)
                    for (List<String> remainingList : remainingLists) 
                    {
                        
                        ArrayList<String> resultList = new ArrayList<String>();
                        //Agregamos la condicion de la lista ( de la penultima )
                        resultList.add(condition);
                        //Agregamos la condicion de la (ulitma lista)
                        resultList.addAll(remainingList);
                        //La combinacion de estas dos condiciones seran en otro caso
                        //una condicion unica que se tendra que combinar con cada una de
                        //las condiciones de la lista que antecede a nuestra posicion actual
                        resultLists.add(resultList);
                    }
                }
            }
            //Enviamos las combinaciones resultantes hacia atras recursivo OnO
            return resultLists;
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
        jpReglas = new javax.swing.JPanel();
        jpAlias = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Establecer Consecuentes");

        jpReglas.setBorder(javax.swing.BorderFactory.createTitledBorder("Reglas"));

        javax.swing.GroupLayout jpReglasLayout = new javax.swing.GroupLayout(jpReglas);
        jpReglas.setLayout(jpReglasLayout);
        jpReglasLayout.setHorizontalGroup(
            jpReglasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jpReglasLayout.setVerticalGroup(
            jpReglasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jpAlias.setBorder(javax.swing.BorderFactory.createTitledBorder("Alias"));

        javax.swing.GroupLayout jpAliasLayout = new javax.swing.GroupLayout(jpAlias);
        jpAlias.setLayout(jpAliasLayout);
        jpAliasLayout.setHorizontalGroup(
            jpAliasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpAliasLayout.setVerticalGroup(
            jpAliasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar Consecuentes");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpReglas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpAlias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 199, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnRegresar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnGuardar))
                                    .addComponent(btnBorrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpReglas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                        .addComponent(btnBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnRegresar))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
            for (int j = 0; j < jtReglas.getRowCount(); j++) 
            {
                try 
                {
                    regi.setConsecuente(jtReglas.getModel().getValueAt(j,0).toString(), jtReglas.getModel().getValueAt(j,1).toString());
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(addConsecuente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
     try 
        {
            reg.delConsecuente();
            for (int i = 0; i < jtReglas.getRowCount(); i++) 
                jtReglas.setValueAt("",i,1);
            
        } catch (IOException ex) {
            Logger.getLogger(addConsecuente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
    this.dispose();
    Principal p  = new Principal();
    p.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpAlias;
    private javax.swing.JPanel jpReglas;
    // End of variables declaration//GEN-END:variables
}
