/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;
import Logica.Valor;
import Logica.Punto;

import java.io.*; 
import java.text.ParseException;
import java.util.ArrayList;
public class Registro extends Files { 
  public static int DIM = 64; 
  String varLinguistica;
  Valor F1;
    public String getVarLinguistica() {
        return varLinguistica;
    }
    public void setVarLinguistica(String varLinguistica) {
        this.varLinguistica = varLinguistica;
    }
    public Valor getF1() {
        return F1;
    }
    public void setF1(Valor F1) {
        this.F1 = F1;
    }
    
  // Lectura 
public void read (RandomAccessFile file) throws IOException, ParseException 
  { 
    setVarLinguistica(readString(file , 20));
    setF1( readFuncionM (file));
  } 
  private String readString(RandomAccessFile file, int dim)throws IOException 
  { 
    char campo[] = new char[dim]; 
    for (int i=0; i<dim; i++) 
        campo[i] = file.readChar(); 
    return new String(campo).replace('\0',' '); 
  } 
private ArrayList<Punto> readArray(RandomAccessFile file, int dim) throws IOException
{
    ArrayList<Punto> puntos = new ArrayList();
    puntos.add(new Punto(file.readDouble(),file.readDouble()));
    puntos.add(new Punto(file.readDouble(),file.readDouble()));
    puntos.add(new Punto(file.readDouble(),file.readDouble()));
    puntos.add(new Punto(file.readDouble(),file.readDouble()));
    
    return puntos;
    
}
private Valor readFuncionM(RandomAccessFile file)throws IOException 
{
    Valor funcion = new Valor();
    funcion.setNombre(readString( file , 20 ));
    funcion.setPuntos(readArray ( file , 24 ));//8 por cada Double
    return funcion;
}
  // Escritura 
public void write (RandomAccessFile file)throws IOException 
{ 
    writeString     ( file, getVarLinguistica(), 20);
    writeFuncionM   ( file, getF1(), 20);
    file.writeDouble( getF1().getPuntos().get(0).getX() );
    file.writeDouble( getF1().getPuntos().get(0).getY() );
    file.writeDouble( getF1().getPuntos().get(1).getX() );
    file.writeDouble( getF1().getPuntos().get(1).getY() );
    file.writeDouble( getF1().getPuntos().get(2).getX() );
    file.writeDouble( getF1().getPuntos().get(2).getY() );
    file.writeDouble( getF1().getPuntos().get(3).getX() );
    file.writeDouble( getF1().getPuntos().get(3).getY() );
    
} 

  private void writeFuncionM(RandomAccessFile file, Valor funcion, int dim) throws IOException
  {
    StringBuffer buffer; 
    if (funcion!=null)
    {
        
        buffer = new StringBuffer();
        buffer.append(funcion.getNombre());//20
        buffer.setLength(20);
        file.writeChars(buffer.toString()); 
        
        
    }
    else
    {
        buffer = new StringBuffer();
        buffer.setLength(dim); 
        file.writeChars(buffer.toString()); 
    }
  }
  private void writeString(RandomAccessFile file, String str, int dim)throws IOException 
  { 
    StringBuffer buffer = new StringBuffer(); 
    if (str!=null) 
       buffer.append(str); 
    
    buffer.setLength(dim); 
    file.writeChars(buffer.toString()); 
  }
} 
