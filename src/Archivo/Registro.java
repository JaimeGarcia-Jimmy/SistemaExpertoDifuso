package Archivo;
import Logica.Valor;
import Logica.Punto;
import Logica.Variable;
import java.io.*; 
import java.text.ParseException;
import java.util.ArrayList;
public class Registro extends Files { 
    
    public static int DIM = 1109; 
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
      {
          try
          {
              campo[i] = file.readChar();
          }
          catch (Exception e)
          {
              campo[i]=' ';
          }
          
      }
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
            variable.setNombre( readString(file,20).replace(" ",""));
            variable.setAlias(  readString(file,10).replace(" ",""));
            variable.setTraslape(file.readDouble());
            variable.setSalida(file.readBoolean());

            ArrayList<Valor> vl = new ArrayList();

            for (int j = 0; j < 10; j++) 
            {
                String nombreValor = readString(file,20).replace(" ","");
                if(!nombreValor.equals(""))
                {
                Valor valor = new Valor();
                valor.setNombre( nombreValor );
                ArrayList<Punto> punto = new ArrayList();

                for (int k = 0; k < 4; k++) 
                {
                    Double X = file.readDouble();
                    Double Y = file.readDouble();
                    if(!(X==-99.99 && Y==-99.99))
                    {
                        Punto puntos = new Punto( X , Y );
                        punto.add(puntos);
                    }
                }
                valor.setPuntos(punto);
                vl.add(valor);
                }
                else
                {
                    for (int k = 0; k < 4; k++) 
                {
                    Double X = file.readDouble();
                    Double Y = file.readDouble();
                }
                }
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
            file.writeBoolean(v.isSalida());
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
                        {
                            file.writeDouble(-99.99);
                            file.writeDouble(-99.99);
                            //writeString(file,"",8);
                        }
                    }
                }
                for(int j=i; j<10;j++)
                    writeString(file,"",52);

            }
        }
    }
    public long intoHash(String regla)
    {
        long c2;
        long c1;
        
        String regla2 = regla.replace("^","");
        
        if (regla.hashCode()<0) 
            c1  = regla.hashCode()*-1;
        else
            c1 = regla.hashCode();
        
        if (regla2.hashCode()<0) 
            c2  = regla.hashCode()*-1;
        else
            c2 = regla.hashCode();
        
        long H = ((c1/11)*((c2 % 100))+1)/117191;
        
        if(H<0)
            H = H*-1;
        return H;       
    }

    public String getConsecuente(String regla) throws FileNotFoundException, IOException
    {
        RandomAccessFile archivo = new RandomAccessFile("Files/consecuentes.data","rw");
        int id= (int) intoHash(regla);
        if(!(id<0))
            archivo.seek(id*10);
        
        String consecuente = readString(archivo,10);
        return consecuente;
    }
    public void setConsecuente(String regla,String consecuente) throws FileNotFoundException, IOException
    {
        RandomAccessFile archivo = new RandomAccessFile("Files/consecuentes.data","rw");
        int pos = (int) intoHash(regla);
        archivo.seek(pos*10);
        writeString(archivo,consecuente,10);
    }
    
    public void delConsecuente() throws FileNotFoundException, IOException
    {
        RandomAccessFile archivo = new RandomAccessFile("Files/consecuentes.data","rw");
        archivo.setLength(0);
    }
}
