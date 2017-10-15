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
	{}
	//Area de f(x) = mx + b
	public double calcArea(Punto A,Punto B)
	{
		double m = calcM(A, B);
		double b = calcB(A, m);
		double area = (((m*(B.getX()*B.getX()))/2) + (b*B.getX()) )
				- (((m*(A.getX()*A.getX()))/2) + (b*A.getX()) );
		return area;
	}
	//Area de g(x) = c
	public double calcArea(Punto p,double x1,double x2)
	{
		double area = (p.getY() * x2) -( p.getY() * x1); 
		return area;
	}
	//Calcula el area de f(x) - g(x)
	
	public double calcArea(Punto A, Punto B, Punto p)
	{
		double area = calcArea(A, B) - calcArea(p, A.getX(), B.getX());
		return area;
	}
	public double caclMx(Punto A, Punto B)
	{
		double m = calcM(A, B);
		double b = calcB(A, m);
		return evaluarMx(B.getX(), m, b)-evaluarMx(A.getX(), m, b);
	}
	private double evaluarMx(double x,double m, double b)
	{
		return ((Math.pow(m,2)* Math.pow(x, 3)) / 6 )
				+((m*b*Math.pow(x, 2) ) / 4 )
				+ (Math.pow(b, 2) * x);
	}
	private double evaluarMy(double x,double m, double b)
	{
		return ((m*Math.pow(x, 3))/3) + ((b* Math.pow(x, 2)) /2) ;
	}
	
	
	private double calcMy(Punto A, Punto B)
	{
		double m = calcM(A,B);
		double b = calcB(A,m);
		return evaluarMy(B.getX(), m, b)- evaluarMy(A.getX(), m, b);
	}
	
	public double calcMasa(Punto A, Punto B)
	{
		return calcArea(A, B);
	}
	
}
