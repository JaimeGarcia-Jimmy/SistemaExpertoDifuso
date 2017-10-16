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
	public double calcMx(Punto A, Punto B)
	{
		//Calculamos los valores de la recta, f(x) = mx + b
		double m = calcM(A, B);
		double b = calcB(A, m);
		
		return evaluarMx(B.getX(), m, b)-evaluarMx(A.getX(), m, b);
	}
	//Ecuacion para calcular Mx = m²x³/6  + mbx²/4  + b²x 
	private double evaluarMx(double x,double m, double b)
	{
		return ((Math.pow(m,2)* Math.pow(x, 3)) / 6 )
				+((m*b*Math.pow(x, 2) ) / 4 )
				+ (Math.pow(b, 2) * x);
	}
	
	//Ecuacion para calcular My = mx³/3 + bx²/2
	private double evaluarMy(double x,double m, double b)
	{
		return ((m*Math.pow(x, 3))/3) + ((b* Math.pow(x, 2)) /2) ;
	}
	
	
	public double calcMy(Punto A, Punto B)
	{
		double m = calcM(A,B);
		double b = calcB(A,m);
		return evaluarMy(B.getX(), m, b)- evaluarMy(A.getX(), m, b);
	}
	//Calcula en centroide dada una funcion de puntos
	public double calcCentroide(ArrayList<Punto> puntos)
	{
		ArrayList<Punto> pCentroides = new ArrayList<Punto>();
		Punto A = puntos.get(0);
		Punto B = null;
		double sumatoria = 0;
		double sumatoriaMy = 0;
		double sumatoriaM = 0;
		for(int i = 1; i < puntos.size(); i++)
		{
			B = puntos.get(i);
			sumatoriaMy += calcMy(A, B);
			sumatoriaM += calcM(A, B);
			
			Punto temp = calcCentroide(A, B);
			A = B;
			pCentroides.add(temp);
			temp =null;
		}
		for(Punto p: pCentroides)
			sumatoria+= p.getX();
		return (sumatoria/pCentroides.size());
	}
	
	
	public Punto calcCentroide(Punto A,Punto B)
	{
		Punto pCentroide = new Punto();
		double masa = calcMasa(A, B);
		double x = calcMy(A, B)/masa;
		double y = calcMx(A,B)/masa;
		pCentroide.setX(x);
		pCentroide.setY(y);
		return pCentroide;
	}
	//Ecuacion para calcular M = mx² + bx
	public double calcMasa(Punto A, Punto B)
	{
		return calcArea(A, B);
	}
	
}
