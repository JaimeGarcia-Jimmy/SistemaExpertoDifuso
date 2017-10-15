/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

/**
 *
 * @author TOSHIBA
 */
public class InferenciaDifusa {
    
    private ArrayList<Variable> listaVariables;
    private ArrayList<Double> entradas;
    
    public InferenciaDifusa(ArrayList<Variable> listaVariables, ArrayList<Double> entradas) {
        this.listaVariables = listaVariables;
        this.entradas = entradas;
    }
    
    /*
     * Este metodo es el que realiza el proceso de inferencia difusa
     */
    public Double calcularSalida() {
        Double resultado = 0.0;
        Double membresia = 0.0;
        
        /*****************************+
           Difusificar                |
         *****************************/
        
        //el indice se utiliza para poder iterar el arreglo de entradas al mismo tiempo y mantener la sintaxis foreach mas legible
        int indice = 0;
        
        //Calcular la membresia de cada valor linguistico con las variables de entrada
        for (Variable variable : listaVariables) {
            
            Double variableEntradaActual = entradas.get(indice);
            
            for (Valor valor : variable.getFunciones()) {
                //calcular el valor de membresia de la variable actual
                membresia = valor.calcMembresia(variableEntradaActual);
                //guardarlo en el atributo valorDifuso por comodidad
                valor.setValorDifuso(membresia);
            }
            
            
            indice++;
        }
        
        
        /*****************************+
           Evaluar Reglas             |
         *****************************/
        
        return resultado;
    }
    
}
