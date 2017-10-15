package logica.test;

import static org.junit.Assert.assertEquals;

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
		double valReal = centroide.caclMx(A, B);
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

}
