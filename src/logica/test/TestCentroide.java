package logica.test;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Logica.Centroide;
import Logica.Punto;

class TestCentroide {

	@Test
	void testArea2Puntos() {
		Centroide centroide = new Centroide();
		// f(x) = 2x + 1
		Punto A = new Punto(0.0, 1.0);
		Punto B = new Punto(10.0, 21.0);
		double areaEsperada = 110;

		double areaReal = centroide.calcArea(A, B);

		assertEquals(areaEsperada, areaReal, 0);
	}

	@Test
	void testArea1Punto() {
		Centroide centroide = new Centroide();
		// f(x) = 1
		Punto A = new Punto(0.0, 1.0);
		double areaEsperada = 10;
		double areaReal = centroide.calcArea(A, 0, 10);

		assertEquals(areaEsperada, areaReal, 0);
	}

	@Test
	void testArea2Funciones() {
		Centroide centroide = new Centroide();
		// f(x) = 2x + 1
		Punto A = new Punto(0.0, 1.0);
		Punto B = new Punto(10.0, 21.0);
		// f(x) = 1
		Punto p = new Punto(0.0, 2.0);
		double areaEsperada = 90;
		double areaReal = centroide.calcArea(A, B, p);

		assertEquals(areaEsperada, areaReal, 0);
	}

	@Test
	void testEvaluarMx() {
		Centroide centroide = new Centroide();
		// f(x) = 1
		Punto A = new Punto(0.0, 1.0);
		Punto B = new Punto(10.0,1.0);
		double valEsperado = 10;
		double valReal = centroide.calcMx(A, B);
		assertEquals(valEsperado, valReal,0);
	}
	@Test
	void testEvaluarMy()
	{
		Centroide centroide = new Centroide();
		//(fx)=1
		Punto A = new Punto(0.0, 1.0);
		Punto B = new Punto(10.0,1.0);
		double valEsperado = 50;
		double valReal = centroide.calcMy(A, B);
		assertEquals(valEsperado, valReal,0);
	}
	@Test
	void testEvaluarMasa()
	{
		Centroide centroide = new Centroide();
		//(fx)=1
		Punto A = new Punto(0.0, 1.0);
		Punto B = new Punto(10.0,1.0);
		double valEsperado = 10;
		double valReal = centroide.calcMasa(A, B);
		assertEquals(valEsperado, valReal,0);
		
	}
	@Test
	void testCentroide()
	{
		Centroide centroide = new Centroide ();
		Punto A = new Punto(0.0,0.0);
		Punto B = new Punto(10.0,1.0);
		double x = 6.66;
		double y = 0.33;
		
		Punto valReal = centroide.calcCentroide(A, B);
		System.out.println("Val real"+valReal.getY()+"Val esperado"+y);
		System.out.println("Val real"+valReal.getX()+"Val esperado"+x);
	}
	@Test
	void testCentroide2()
	{
		Centroide centroide = new Centroide();
		ArrayList<Punto> fun = new ArrayList<Punto>();
		fun.add(new Punto(0.0,0.1));
		fun.add(new Punto(20.0,0.1));
		fun.add(new Punto(30.0,0.2));
		fun.add(new Punto(60.0,0.2));
		fun.add(new Punto(70.0,0.5));
		fun.add(new Punto(100.0,0.5));
		
		double centro = centroide.calcCentroide(fun);
		
		System.out.println(centro);
		
	}
	

}
