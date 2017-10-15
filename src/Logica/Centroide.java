package Logica;

import java.util.ArrayList;

public class Centroide extends Util
{
	private Variable variable;
	private ArrayList<Punto> puntosY;
	public Centroide(Variable variable, ArrayList<Punto> puntosY)
	{
		this.variable = variable;
		this.puntosY = puntosY;
	}
	public Centroide()
	{
		
	}
	public double calcArea(Punto A,Punto B)
	{
		double m = calcM(A, B);
		double b = calcB(A, m);
		double area = (((m*(B.getX()*B.getX()))/2) + (b*B.getX()) )
				- (((m*(A.getX()*A.getX()))/2) + (b*A.getX()) );
		return area;
	}
	public double calcArea(Punto p,double x1,double x2)
	{
		double area = (p.getY() * x2) -( p.getY() * x1); 
		return area;
	}
	
	public double calcArea(Punto A, Punto B, Punto p)
	{
		double area = calcArea(A, B) - calcArea(p, A.getX(), B.getX());
		
		return area;
	}
	
}
