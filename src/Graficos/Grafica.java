/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Logica.Punto;
import Logica.Variable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Grafica extends JPanel
{
    private int alto,ancho;
    private Punto pInicial, pFinal;
    private ArrayList<Variable> variables;
    private int pos;
    
    Grafica(ArrayList<Variable> variables,int pos )
    {
        this.variables = variables;
        this.pos=pos;
    }
    
    @Override
    public void paint(Graphics g)
    {
     
        super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			// Lineas de la grafica
                        //Eje Y
                        g2.drawLine(30, 30, 30, alto - 30);
                        //Eje X
			g2.drawLine(30, alto - 30, ancho - 30, alto - 30);
			
                        g2.drawString("0", 20, alto - 30);
			g2.drawString("1", 20, 30);
                        
                        //
                        // Dibujando valores X
                        pInicial = variables.get(pos).getFunciones().get(0).getPuntos().get(0);
			pFinal = variables.get(pos).getFunciones().get(variables.get(pos).getFunciones().size()-1).getPuntos().get(variables.get(pos).getFunciones().get(variables.get(pos).getFunciones().size()-1).getPuntos().size()-1);
			g2.drawString(pInicial.getX() + "", 30, alto - 10);
			g2.drawString(pFinal.getX() + "", ancho - 30, alto - 10);
    }
}
