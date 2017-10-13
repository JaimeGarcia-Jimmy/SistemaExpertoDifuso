/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;
import java.io.*; 
import java.text.ParseException;
import java.util.ArrayList;
public class Files 
{ 
   // Fichero de acceso aleatorio 
public RandomAccessFile file; 
public Registro R;
   // Apertura del fichero 
public void abrir() 
          throws IOException 
   { 
     file = new RandomAccessFile("Files/subconjuntos.data","rw");
      this.R = new Registro();
   }  
   // Cierre del fichero 
public void cerrar() 
          throws IOException 
   { 
      if (file!=null) 
         file.close(); 
   }  
   // Escribir un registro 
   // en la posición actual del cursor 
   public void escribir (ArrayList array)throws IOException 
   { 
     if (file!=null) 
        R.write(file,array); 
   } 
   // Escribir un registro en una posición cualquiera 
   public void escribir (long pos,ArrayList array) throws IOException 
   { 
        if (file!=null) 
        {   
            file.seek ( (pos-1)*Registro.DIM ); 
            escribir(array); 
        } 
    } 
   // Leer del fichero el registro  
   // que se encuentra en la posición actual del cursor 
public Registro leer () 
   { 
     Registro registro = null; 
     if (file!=null) {  
        try { 
           registro = new Registro(); 
           registro.read(file); 
        } catch (IOException | ParseException error) { 
           error.printStackTrace();
            registro = null; 
        } 
     } 
     return registro; 
   } 
   // Leer del fichero un registro cualquierta 
   // (el parámetro indica la posición del registro) 
public Registro leer (long pos) 
          throws IOException 
   { 
     if (file!=null) { 
file.seek ( (pos-1)*Registro.DIM ); 
     } 
     return leer(); 
   } 
} 