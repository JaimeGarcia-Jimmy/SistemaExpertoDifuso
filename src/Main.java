
import Archivo.Files;
import Archivo.Registro;
import Logica.Valor;
import Logica.Punto;
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
    public static void main(String[] args) {
        
        Punto p1 = new Punto(0.0,0.0);
        Punto p2 = new Punto(1.0,1.0);
        Punto p3 = new Punto(2.0,2.0);
        //Punto p4 = new Punto(3.0,3.0);
        
        
        Valor f = new Valor();
        f.setNombre("Poco");
        ArrayList<Punto> puntos = new ArrayList();
        puntos.add(p1);
        puntos.add(p2);
        puntos.add(p3);
       // puntos.add(p4);
        f.setPuntos(puntos);
        
        
        
        
        Files file = new Files();
        
        try {
           
            file.abrir();
           /* for (int i = 1; i <= 1; i++) {
               */ Registro R = new Registro();
                R.setVarLinguistica("Entusiasmo");
                R.setF1(f);
                file.escribir(R);
                /*
                //file.escribir(R,i*R.DIM);
            }
        */
        
        //    file.abrir();
       /// file.file.seek(0);
          //  Registro R = file.leer();
          //  Registro R1 = file.leer(9*R.DIM);
     
            file.cerrar();
        
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
