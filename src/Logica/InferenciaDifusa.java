/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Archivo.Registro;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public Double calcularSalida() throws FileNotFoundException, IOException {
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
        
        //Producto cartesiano para obtener las reglas
        //Se obtienen dos arreglos de arreglos, el primero tiene los valores linguisticos que forma la regla
        //el segundo tiene las membresias calculadas de esos valores linguisticos en la misma posicion
        List<List<String>> cadenas = getCombinacionCadenas();
        List<List<Double>> membresias = getCombinacionMembresias();
        
        //Se recorren al mismo tiempo los dos arreglos para poder obtener los consecuentes del archivo y asignarles
        //su valor difuso, se usa un arraylist de tipo Consecuente para almacenar los resultados de evaluar las reglas
        ArrayList<Consecuente> consecuentes = new ArrayList();
        int i=0, j=0, k=0;
        String regla = "";
        Double minimo = 1.0;
        String cadenaConsecuente = "";
        Boolean consecuenteRepetido;
        //esta clase tiene la funcion hash para obtener los consecuentes
        Registro reg = new Registro();
        
        for (i=0 ; i<cadenas.size() ; i++) {
            
            //vaciar cadena de regla
            regla = "";
            //valor maximo para minimo
            minimo = 1.0;
            
            for (j=0 ; j<cadenas.get(0).size() ; j++) {
                
                //concatenar valores en la regla
                regla += cadenas.get(i).get(j);
                //buscar el valor minimo en la regla (conjuncion)
                if(membresias.get(i).get(j) < minimo)
                    minimo = membresias.get(i).get(j);
                
            }
            
            //evaluar regla con funcion hash para obtener consecuente
            cadenaConsecuente = reg.getConsecuente(regla);
            
            //recorrer los consecuentes para reemplazar si es necesario la membresia de un valor existente
            consecuenteRepetido = false;
            for (k=0 ; k<consecuentes.size() ; k++) {
                if (consecuentes.get(k).getAlias().equals(cadenaConsecuente)) {
                    consecuenteRepetido = true;
                    //Se conserva el valor maximo de los consecuentes con la misma cadena
                    if (consecuentes.get(k).getValorDifuso() < minimo)
                        consecuentes.get(k).setValorDifuso(minimo);
                }
            }
            
            //agregar resultado al arreglo de consecuentes si no es un consecuente repetido
            if (!consecuenteRepetido)
                consecuentes.add(new Consecuente(cadenaConsecuente, minimo));
            
        }
        
        
        /*******************************************************+
           Agregacion de los consecuentes de las reglas         |
         *******************************************************/
        
        //funcion donde se van a guardar los puntos que formaran la funcion de agregacion
        Valor funcionAgr = new Valor();
        
        //Recuperar la variable de salida del modelo
        Variable varSalida = null;
        for (Variable var : listaVariables) {
            if (var.isSalida()){
                varSalida = var;
                break;
            }
        }
        
        //Recorres los valores de la variable para empezar a calcular los puntos resultantes
        int index = 0;
        Consecuente consec = null;
        Double x=0.0, y=0.0;
        ArrayList<Valor> valores = varSalida.getFunciones();
        
        for (index=0 ; index<valores.size() ; index++) {
            
            Valor valor = valores.get(index);
            
            //obtener el consecuente que corresponda con el valor actual
            for (Consecuente cons : consecuentes) {
                if (valor.getNombre().substring(0, 2) == cons.getAlias())
                    consec = cons;
            }
            
            /**********************************************************
            * Si es el primer valor linguistico es un caso especial
            **********************************************************/
            if (index == 0) {
                /*******************************
                 * Caso 1: consecuente > f(0)
                 ******************************/
                if (consec.getValorDifuso() > valor.calcMembresia(0.0)) {
                    x = 0.0;
                    y = valor.calcMembresia(x);
                    funcionAgr.getPuntos().add(new Punto(x,y));
                    //El siguiente punto es la interseccion de la primera linea de la funcion con el consecuente
                    y = consec.getValorDifuso();
                    x = valor.inversa(y, valor.getPuntos().get(0), valor.getPuntos().get(1));
                    funcionAgr.getPuntos().add(new Punto(x,y));
                }
                /*******************************
                 * Caso 2: consecuente <= f(0)
                 ******************************/
                else {
                    x = 0.0;
                    y = consec.getValorDifuso();
                    funcionAgr.getPuntos().add(new Punto(x,y));
                }
                
                /*************************************
                 * Esto ocurre para ambos casos 1 y 2
                 ************************************/
                //El punto antes de la interseccion depende de la relacion entre la membresia y el punto de interseccion
                /***************************************
                 * Caso A: consecuente > interseccion
                 **************************************/
                if (consec.getValorDifuso() > varSalida.intersecciones.get(index).getY()) {
                    //El siguiente punto es la interseccion del consecuente con la ultima linea de la funcion
                    y = consec.getValorDifuso();
                    x = valor.inversa(y, valor.getPuntos().get(valor.getPuntos().size()-2), valor.getPuntos().get(valor.getPuntos().size()-1));
                    funcionAgr.getPuntos().add(new Punto(x,y));
                }
                /***************************************
                 * Caso B: consecuente == interseccion
                 **************************************/
                else if (consec.getValorDifuso() == varSalida.intersecciones.get(index).getY()) {
                    //en este caso no se agrega un punto extra, solo el punto de la interseccion que tambien aplica para los
                    //otros casos y que se agrega fuera la condicion
                }
                /***************************************
                 * Caso C: consecuente < interseccion
                 **************************************/
                else {
                    //El siguiente punto es la interseccion del consecuente con la primera linea de la siguiente funcion
                    Valor valorSiguiente = valores.get(index+1);
                    y = consec.getValorDifuso();
                    x = valor.inversa(y, valorSiguiente.getPuntos().get(0), valorSiguiente.getPuntos().get(1));
                    funcionAgr.getPuntos().add(new Punto(x,y));
                }
                
                /*************************************
                 * Esto ocurre para todos los casos
                 ************************************/
                //Se agrega el punto de interseccion entre ambos valores
                x = varSalida.intersecciones.get(index).getX();
                y = valor.calcMembresia(x);
                funcionAgr.getPuntos().add(new Punto(x,y));
                
            }
            /**********************************************************
            * Caso para los valores de en medio
            **********************************************************/
            else if (index < valores.size()-1) {
                /************************************************************************
                 * Caso 1: El consecuente es mayor que el punto de interseccion anterior
                 ***********************************************************************/
                if (consec.getValorDifuso() > varSalida.intersecciones.get(index-1).getY()) {
                    //El punto se calcula con la primera recta del valor actual
                    y = consec.getValorDifuso();
                    x = valor.inversa(y, valor.getPuntos().get(0), valor.getPuntos().get(1));
                    funcionAgr.getPuntos().add(new Punto(x,y));
                }
                /************************************************************************
                 * Caso 2: El consecuente es igual que el punto de interseccion anterior
                 ***********************************************************************/
                else if (consec.getValorDifuso() == varSalida.intersecciones.get(index-1).getY()) {
                    //No hace falta agregar puntos adicionales en este caso
                }
                /************************************************************************
                 * Caso 3: El consecuente es menor que el punto de interseccion anterior
                 ***********************************************************************/
                else {
                    //El punto se calcula con la ultima recta de la funcion anterior
                    Valor valorAnterior = valores.get(index-1);
                    y = consec.getValorDifuso();
                    x = valor.inversa(y, valorAnterior.getPuntos().get(valorAnterior.getPuntos().size()-2), valorAnterior.getPuntos().get(valorAnterior.getPuntos().size()-1));
                    funcionAgr.getPuntos().add(new Punto(x,y));
                }
                
                /**********************************************
                 * Esto ocurre para los tres casos anteriores
                 *********************************************/
                //El punto antes de la interseccion depende de la relacion entre la membresia y el punto de interseccion
                /***************************************
                 * Caso A: consecuente > interseccion
                 **************************************/
                if (consec.getValorDifuso() > varSalida.intersecciones.get(index).getY()) {
                    //El siguiente punto es la interseccion del consecuente con la ultima linea de la funcion
                    y = consec.getValorDifuso();
                    x = valor.inversa(y, valor.getPuntos().get(valor.getPuntos().size()-2), valor.getPuntos().get(valor.getPuntos().size()-1));
                    funcionAgr.getPuntos().add(new Punto(x,y));
                }
                /***************************************
                 * Caso B: consecuente == interseccion
                 **************************************/
                else if (consec.getValorDifuso() == varSalida.intersecciones.get(index).getY()) {
                    //en este caso no se agrega un punto extra, solo el punto de la interseccion que tambien aplica para los
                    //otros casos y que se agrega fuera la condicion
                }
                /***************************************
                 * Caso C: consecuente < interseccion
                 **************************************/
                else {
                    //El siguiente punto es la interseccion del consecuente con la primera linea de la siguiente funcion
                    Valor valorSiguiente = valores.get(index+1);
                    y = consec.getValorDifuso();
                    x = valor.inversa(y, valorSiguiente.getPuntos().get(0), valorSiguiente.getPuntos().get(1));
                    funcionAgr.getPuntos().add(new Punto(x,y));
                }
                
                /*************************************
                 * Esto ocurre para todos los casos
                 ************************************/
                //Se agrega el punto de interseccion entre ambos valores
                x = varSalida.intersecciones.get(index).getX();
                y = valor.calcMembresia(x);
                funcionAgr.getPuntos().add(new Punto(x,y));
            }
            /**********************************************************
            * Caso para el ultimo valor
            **********************************************************/
            else {
                /************************************************************************
                 * Caso 1: El consecuente es mayor que el punto de interseccion anterior
                 ***********************************************************************/
                if (consec.getValorDifuso() > varSalida.intersecciones.get(index-1).getY()) {
                    //El punto se calcula con la primera recta del valor actual
                    y = consec.getValorDifuso();
                    x = valor.inversa(y, valor.getPuntos().get(0), valor.getPuntos().get(1));
                    funcionAgr.getPuntos().add(new Punto(x,y));
                }
                /************************************************************************
                 * Caso 2: El consecuente es igual que el punto de interseccion anterior
                 ***********************************************************************/
                else if (consec.getValorDifuso() == varSalida.intersecciones.get(index-1).getY()) {
                    //No hace falta agregar puntos adicionales en este caso
                }
                /************************************************************************
                 * Caso 3: El consecuente es menor que el punto de interseccion anterior
                 ***********************************************************************/
                else {
                    //El punto se calcula con la ultima recta de la funcion anterior
                    Valor valorAnterior = valores.get(index-1);
                    y = consec.getValorDifuso();
                    x = valor.inversa(y, valorAnterior.getPuntos().get(valorAnterior.getPuntos().size()-2), valorAnterior.getPuntos().get(valorAnterior.getPuntos().size()-1));
                    funcionAgr.getPuntos().add(new Punto(x,y));
                }
                
                /********************************************************************
                 * El ulitmo punto termina en 100 y esta a la altura del consecuente
                 *******************************************************************/
                y = consec.getValorDifuso();
                x = 100.0;
                funcionAgr.getPuntos().add(new Punto(x,y));
                
            }
            
        }
        
        
        /***********************************************
         Calcular el centroide con los puntos obtenidos
         **********************************************/
        Centroide cent = new Centroide();
        resultado = cent.calcCentroide(funcionAgr.getPuntos());
        
        
        return resultado;
    }
    
    /*
     * Este metodo se utiliza en conjunto con productoCartesianoListasCadenas para obtner
     * las combinaciones de cadenas de los valores
    */
    private List<List<String>> getCombinacionCadenas()
    {
        List<List<String>> vari = new ArrayList();
        for( Variable var : listaVariables )
        {
            if(!var.isSalida())
            {
                ArrayList<String> nomb = new ArrayList();
                for (Valor val : var.getFunciones()) 
                {

                    nomb.add(val.getNombre().substring(0, 2));
                }
                vari.add(nomb);
            }
        }
        
        return productoCartesianoListasCadenas(vari);
        //System.out.println("");
    }
    
    
    List<List<String>> productoCartesianoListasCadenas(List<List<String>> lists) 
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


            List<List<String>> remainingLists = productoCartesianoListasCadenas(lists.subList(1, lists.size()));
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
    
    
    /*
     * Este metodo se utiliza en conjunto con productoCartesianoListasMembresias para obtner
     * las combinaciones de cadenas de los valores
    */
    private List<List<Double>> getCombinacionMembresias()
    {
        List<List<Double>> vari = new ArrayList();
        for( Variable var : listaVariables )
        {
            if(!var.isSalida())
            {
                ArrayList<Double> nomb = new ArrayList();
                for (Valor val : var.getFunciones()) 
                {

                    nomb.add(val.getValorDifuso());
                }
                vari.add(nomb);
            }
        }
        
        return productoCartesianoListasMembresias(vari);
        //System.out.println("");
    }
    
    
    List<List<Double>> productoCartesianoListasMembresias(List<List<Double>> lists) 
    {
        List<List<Double>> resultLists = new ArrayList<List<Double>>();
        if (lists.size() == 0) 
        {
            resultLists.add(new ArrayList<Double>());
            return resultLists;
        } 
        else 
        {
            List<Double> firstList = lists.get(0);
            //Nos dirijimos hasta la ultima lista de la coleccion de listas (Despues de llegar al true de este IF)
            //Una vez que recibimos las combinaciones resultantes de las listas
            //que preceden de nuestra posicion actual
            //y guardando la lista de nuestra posicion actual 
            //comenzaremos a combinar las condiciones compuestas


            List<List<Double>> remainingLists = productoCartesianoListasMembresias(lists.subList(1, lists.size()));
            //Tomamos una a una las condiciones 
            for (Double condition : firstList) 
            {
                //Tomamos todas las condiciones de la lista que antecede a la ultima (de forma recursiva)
                for (List<Double> remainingList : remainingLists) 
                {

                    ArrayList<Double> resultList = new ArrayList<Double>();
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
    
}
