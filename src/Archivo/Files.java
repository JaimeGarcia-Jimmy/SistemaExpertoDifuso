/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;
import java.io.*; 
import java.text.ParseException;
public class Files 
{ 
   // Fichero de acceso aleatorio 
public RandomAccessFile file; 
   // Apertura del fichero 
public void abrir() 
          throws IOException 
   { 
     file = new RandomAccessFile("Files/subconjuntos.data","rw"); 
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
   public void escribir (Registro registro)throws IOException 
   { 
     if (file!=null) 
        registro.write(file); 
   } 
   // Escribir un registro en una posición cualquiera 
   public void escribir (Registro registro, long pos) throws IOException 
   { 
        if (file!=null) 
        {   
            file.seek ( (pos-1)*Registro.DIM ); 
            escribir(registro); 
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