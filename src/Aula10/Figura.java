package Aula10;

public abstract class Figura implements Comparable<Figura> {
	private Ponto centro;
	
	public Figura(Ponto centro){
		this.centro = centro;
	}
	
	public Figura(double x, double y){
		new Ponto(x,y);
	}
	
	public Ponto centro(){
		return centro;
	}
	
	public abstract double area();
	public abstract double perimetro();
	
	@Override 
	public int compareTo(Figura b){
		if(this.area()<((Figura)b).area()){
			return -1;
		}else if(this.area()>((Figura)b).area()){
			return 1;
		}else{
			return 0;
		}
	}
	
	@Override 
	public String toString(){
		return "centro: "+centro;
	}
}