package Logica;

public class Util {
	public double calcM(Punto a, Punto b) {
		return (b.getY() - a.getY()) / (b.getX() - a.getX());
	}
	public double calcB(Punto x, double m){
		return x.getY() - (m*x.getX());
	}
}
