/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;
import Logica.Valor;
import Logica.Punto;
import Logica.Variable;

import java.io.*; 
import java.text.ParseException;
import java.util.ArrayList;
public class Registro extends Files { 
    
  public static int DIM = 1108; 
  ArrayList<Variable> variables;
  
    public ArrayList<Variable> getVariable() {
        return variables;
    }

    public void setVariable(ArrayList<Variable> variable) {
        this.variables = variable;
    }
  // Lectura 
  public void read (RandomAccessFile file) throws IOException, ParseException 
  { 
    setVariable(readArrayVariable(file));
  } 
  private String readString(RandomAccessFile file, int dim) throws IOException 
  { 
    char campo[] = new char[dim]; 
    for (int i=0; i<dim; i++) 
        campo[i] = file.readChar(); 
    return new String(campo).replace('\0',' '); 
  } 
  private ArrayList<Variable> readArrayVariable(RandomAccessFile file) throws IOException
  {
      
      ArrayList<Variable> array = new ArrayList<Variable>();
      file.seek(0);
      Long numR = file.length()/DIM;
      
      for(int i=0;i<numR;i++)
      {
        Variable variable= new Variable();
        variable.setNombre( readString(file,20));
        variable.setAlias(  readString(file,10));
        variable.setTraslape(file.readDouble());
        
        ArrayList<Valor> vl = new ArrayList();
        
        for (int j = 0; j < 10; j++) 
        {
            Valor valor = new Valor();
            valor.setNombre( readString(file,20));
            ArrayList<Punto> punto = new ArrayList();
            for (int k = 0; k < 4; k++) 
            {
                Punto puntos = new Punto( file.readDouble(), file.readDouble());
                punto.add(puntos);
            }
            valor.setPuntos(punto);
            vl.add(valor);
            
        }
        variable.setFunciones(vl);
        array.add(variable);
      }
      
      return array;
  }
    // Escritura 
    private void writeString (RandomAccessFile file, String str, int dim) throws IOException 
    { 
        StringBuffer buffer = new StringBuffer(); 
        if (str!=null) 
           buffer.append(str); 
        buffer.setLength(dim); 
        file.writeChars(buffer.toString()); 
    }
    public void write (RandomAccessFile file, ArrayList<Variable> array)throws IOException 
    {     
        file.setLength(0);
        file.seek(0);
      
        for(Variable v: array)
        {
            writeString(file,v.getNombre(),20);
            writeString(file,v.getAlias(),10);
            file.writeDouble(v.getTraslape());
            ArrayList<Valor> vl = v.getFunciones();
            if(vl.isEmpty())
                writeString(file,"",520);
            else
            {
                int i=0;
                for(Valor val: vl)
                {
                    i++;
                    writeString(file,val.getNombre(),20);
                    ArrayList<Punto> pu= val.getPuntos();
                    if(pu.isEmpty())
                        writeString(file,"",64);
                    else
                    {
                        int ii=0;
                        for(Punto pun: pu)
                        {
                            ii++;
                            //Escribir X
                            file.writeDouble(pun.getX());

                            //Escribir Y
                            file.writeDouble(pun.getY());

                        }
                        for (int j=ii ; j<4 ; j++) 
                            writeString(file,"",8);
                    }
                }
                for(int j=i; j<10;j++)
                    writeString(file,"",52);
                
            }
        }
}
}
