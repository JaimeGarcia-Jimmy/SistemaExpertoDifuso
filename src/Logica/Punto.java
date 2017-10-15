package Logica;

public class Punto 
{
	private Double x;
	private Double y;
        
	public Punto ()
	{
		
	}
       
	public Punto(Double x, Double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void setX(Double x) {
		this.x = x;
	} 
        public Double getX() {
		return x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	public Punto(Double x) {
		super();
		this.x = x;
	}
}
