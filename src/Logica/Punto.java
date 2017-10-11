package Logica;

public class Punto 
{
	private double x;
	private double y;
        
       
	public Punto(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public void setX(double x) {
		this.x = x;
	} 
        public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Punto(double x) {
		super();
		this.x = x;
	}
}
