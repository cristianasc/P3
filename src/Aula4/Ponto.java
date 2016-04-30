package Aula4;

public class Ponto{
	double x;
	double y;
	
	public Ponto(double x, double y){
	this.x = x;
	this.y = y; 
	}
	
	public double y(){
		return this.y;
	}
	
	public double x(){
		return this.x;
	}
	
	public double distancia(Ponto p){
		return Math.sqrt(Math.pow((this.x-p.x), 2)+Math.pow((this.y-p.y), 2));
	}
	
	@Override 
	public String toString(){
		return "x:"+x+", y:"+y; 
	}
	
}