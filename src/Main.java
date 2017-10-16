
import Archivo.Files;
import Archivo.Registro;
import Logica.Valor;
import Logica.Punto;
import Logica.Variable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
        Punto p1 = new Punto(0.0,0.0);
        Punto p2 = new Punto(1.0,1.0);
        Punto p3 = new Punto(2.0,2.0);
        Punto p4 = new Punto(3.0,3.0);
        
        
        Valor f = new Valor();
        f.setNombre("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");      //20 BYTES
        ArrayList<Punto> puntos = new ArrayList();
        puntos.add(p1);
        puntos.add(p2);
        puntos.add(p3);
        puntos.add(p4);
        
        f.setPuntos(puntos);                                                    //84 BYTES
                                                                                //104
        
        
        
        ArrayList<Valor> val = new ArrayList<Valor>();      
       
        val.add(f);//1        //104 BYTES
        val.add(f);//2                                
        val.add(f);//3                                                
        val.add(f);//4 
        val.add(f);//5 
        val.add(f);//6 
        val.add(f);//7 
        val.add(f);//8
        val.add(f);//9
        val.add(f);//10
        
        
        //Variable
        Variable var = new Variable();
        
        var.setNombre("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");                               //20BYTES
        var.setAlias("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");                              //10 BYTES
        var.setTraslape(0.0);                                                 //08BYTES
        var.setFunciones(val);                                                  //840 BYTES
        var.setSalida(false);
        ArrayList<Variable> v = new ArrayList<Variable>();                      
        v.add(var);//1  
        /*v.add(var);//1   //1108 BYTES
        v.add(var);//1   
        v.add(var);//1   
        v.add(var);//1   

*/        
        
        //Escribir
        
        Files file = new Files();
        try {
           
            file.abrir();
            file.escribir(v);
            
            System.out.println(file.file.length());
            file.cerrar();
        
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //Leer
        
        /*
        file.abrir();
        Registro R= file.leer();
        
        R.setConsecuente("em^en", "em");
        R.setConsecuente("me^ne", "am");
        System.out.println(""+R.getConsecuente("em^en"));
        R.delConsecuente();
        
        System.out.println("");
*/
    }
}
