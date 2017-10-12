package Interfaces.grafica;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Logica.Punto;
import Logica.Valor;
import Logica.Variable;

public class Graficar extends JPanel {
	private int alto, ancho;
	private ArrayList<Valor> funciones;

	private double segmento;
	private double tamano;

	public Graficar(Variable listVariable) {
		super();
		this.setSize(460, 260);
		ancho = this.getWidth();
		alto = this.getHeight();
		this.funciones = listVariable.getFunciones();

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		// Lineas de la grafica
		g2.setStroke(new BasicStroke(2f));
		g2.drawLine(30, 30, 30, alto - 30);
		g2.drawLine(30, alto - 30, ancho - 30, alto - 30);
		g2.drawString("0", 20, alto - 30);
		g2.drawString("1", 20, 30);
		tamano = 100;
		segmento = (ancho - 60) / tamano;
	//Graficar n funciones
		for (Valor fun : funciones) 
		{
			g2.setColor(Color.black);
			//Obetenemos los puntos de la primera funcion
			ArrayList<Punto> puntos = fun.getPuntos();
			//Primer punto de la funcion
			Punto a = puntos.get(0);
			g2.drawString(""+a.getX(), caclValRealX(a.getX())-10, alto-10);
			g2.drawLine(caclValRealX(a.getX()), alto-30, caclValRealX(a.getX()), alto-20);
			for (int i = 1; i < puntos.size(); i++) 
			{
				//Dibujamos la funcion
				Punto b = puntos.get(i);
				g2.setColor(Color.BLACK);
				g2.drawLine(caclValRealX(b.getX()), alto-30, caclValRealX(b.getX()), alto-20);
				g2.drawString(""+b.getX(), caclValRealX(b.getX())-10, alto-10);
				g2.setColor(Color.BLUE);
				
				g2.drawLine(caclValRealX(a.getX()), caclValRealY(a.getY()), caclValRealX(b.getX()),
						caclValRealY(b.getY()));
				
				a = b;
			}
		}

	}

	private int caclValRealX(double x) {
		double val = 100 - x;
		x = tamano - val;
		return (int) (segmento * x) + 30;
	}

	private int caclValRealY(double y) {
		double val = ((alto-60) * y);
		val = (alto-60) - val;
		return (int) (val + 30);
	}
/*
	public static void main(String arg[]) {
		JFrame ventana = new JFrame("Holi");
		ventana.setSize(500, 300);

		// Valor Linguisitico 1
		Punto A = new Punto(0, 0);
		Punto B = new Punto(20, 1);
		Punto C = new Punto(30, 0);
		ArrayList<Punto> valLin1 = new ArrayList<Punto>();
		valLin1.add(A);
		valLin1.add(B);
		valLin1.add(C);
		// Valor linguistico 2
		Punto D = new Punto(20, 0);
		Punto E = new Punto(30, 1);
		Punto F = new Punto(50, 1);
		Punto G = new Punto(100, 0);
		ArrayList<Punto> valLin2 = new ArrayList<Punto>();
		valLin2.add(D);
		valLin2.add(E);
		valLin2.add(F);
		valLin2.add(G);

		ArrayList<Valor> valorLinguistico = new ArrayList<Valor>();
		valorLinguistico.add(new Valor(valLin1));
		valorLinguistico.add(new Valor(valLin2));
		Variable variableLinguistica = new Variable();
		variableLinguistica.setFunciones(valorLinguistico);

		ventana.setLayout(new BorderLayout());
		ventana.add(new Graficar(variableLinguistica));
		ventana.setVisible(true);

	}*/

}
