package Logica;

import java.util.ArrayList;

public class Valor extends Util {
	private ArrayList<Punto> puntos;
	private String nombre;
        private Double valorDifuso;

        public double calcMembresia(double x) {
		ArrayList<Punto> puntos = getPuntos();
		Punto a,b;
		a = puntos.get(0);
		for(int i = 1; i < puntos.size(); i++)
		{
			b = puntos.get(i);
			if(a.getX()<= x && b.getX() >= x )
			{
				return f(x,a,b);
			}
			a = b;
			b= null;
		}
		return 0;
	}
	/*
	 *  y = mx + B
	 */
	public double f(double  x,Punto a,Punto b)
	{
		double m = calcM(a, b);
		double B = calcB(a, m);
		return (m*x + B);	
	}
        
	
	public ArrayList<Punto> getPuntos() {
		return puntos;
	}

	public void setPuntos(ArrayList<Punto> puntos) {
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
        
        public Double getValorDifuso() {
		return valorDifuso;
	}

	public void setValorDifuso(Double valorDifuso) {
		this.valorDifuso = valorDifuso;
	}

	public Valor(ArrayList<Punto> puntos) {
		this.puntos = puntos;
	}

	public Valor (){}
}
