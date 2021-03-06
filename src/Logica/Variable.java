package Logica;

import java.util.ArrayList;

public class Variable 
{
    private ArrayList<Valor> funciones;
    private String nombre;
    private String alias;
    private double traslape=0.0;
    private boolean salida;
    public ArrayList<Punto> intersecciones;
    
    public Variable()
    {
        this.funciones = new ArrayList();
        this.intersecciones = new ArrayList();
    }
    
    public void actuTraslape()
    {
        for(int i=0;i<funciones.size()-1;i++)
        {
            Valor f1 =funciones.get(i);
            Valor f2 =funciones.get(i+1);
            
            //Penultimo punto de la funcion 1
            Double x1a = f1.getPuntos().get(f1.getPuntos().size()-2).getX();
            //No importa para la segunda funcion que forma tenga siempre se ocupa el primer y segundo punto 
            Double x2b = f2.getPuntos().get(1).getX();
            //CAlculamos el punto medio entre las dos funciones 
            Double puntoM = (x1a+x2b)/2;
            //Modificar los calores de X en funcion 1
            f1.getPuntos().get(f1.getPuntos().size()-1).setX(puntoM+(traslape/2));
            //Modificar los valores de  Funcion 2
            f2.getPuntos().get(0).setX(puntoM-(traslape/2));
            
        }
        
        //calcular las intersecciones despues de ajustar los traslapes
        //calcularIntersecciones();
        
    }
    
    public void calcularIntersecciones() {
        
        for(int i=0;i<funciones.size()-1;i++)
        {
            Valor f1 =funciones.get(i);
            Valor f2 =funciones.get(i+1);
            
            //Penultimo punto de la funcion 1
            Double x1a = f1.getPuntos().get(f1.getPuntos().size()-2).getX();
            //No importa para la segunda funcion que forma tenga siempre se ocupa el primer y segundo punto 
            Double x2b = f2.getPuntos().get(1).getX();
            //CAlculamos el punto medio entre las dos funciones
            //el punto medio tambien es el punto de interseccion entre las dos funciones
            Double puntoM = (x1a+x2b)/2;
            //Calcular el valor de y en el punto medio
            Double puntoMy = f1.calcMembresia(puntoM);
            //Guardar el punto en el arreglo de intersecciones
            intersecciones.add(new Punto(puntoM, puntoMy));
        }
        
    }

    public boolean isSalida() {
        return salida;
    }

    public void setSalida(boolean salida) {
        this.salida = salida;
    }
    
    
    public double getTraslape() {
        return traslape;
    }

    public void setTraslape(double traslape) {
        this.traslape = traslape;
        actuTraslape();
    }
  
    public ArrayList<Valor> getFunciones() {
        return funciones;
    }

    public void setFunciones(ArrayList<Valor> Funciones) {
        this.funciones = Funciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
