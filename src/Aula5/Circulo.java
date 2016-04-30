package Aula5;

public class Circulo extends Figura  {
	private double raio;
	
	public double raio(){
		return raio;
	}

	public Circulo(double x, double y, double r){
		super(new Ponto(x,y));
		this.raio = r;
	}
	
	public Circulo(double r){
		super(new Ponto(0,0));
		this.raio = r;
	}
	
	public Circulo(Ponto centro, double r){
		super(centro);
		this.raio = r;
	}
	
	public Circulo(Circulo circulo){
		this(circulo.centro(), circulo.raio());
	}
	 
	 public void dadosCirulo(){
		 
		 System.out.println("Área do circulo 1: " + area());
		 System.out.println("Perímetro do circulo 1: " + perimetro());

		 System.out.println("Área do circulo 2: " + area());
		 System.out.println("Perímetro do circulo 2: " + perimetro());
	 }
		
		 public double area(){
			 double area;
			 area = Math.PI*Math.pow(raio(),2);
			 return area;
		 }
		 
		 public double perimetro(){
			 double perimetro;
			 perimetro = 2*Math.PI*raio();
			 return perimetro;
		 }
		 
		 @Override
		 public boolean equals(Object c){
		        if(((Circulo) c).raio==raio())
		            return true;
		        return false;
		 }
		 
		 public boolean intersecao(Circulo c){
		        if (raio() + c.raio>= dist(c))  return true;
		        return false;
		    }
		 

		  public double dist(Circulo c){
		        return Math.sqrt(Math.pow((centro().x)-(c.centro().x), 2)+Math.pow((centro().y)-(c.centro().y), 2));
		    }
		  
		  @Override
		  public String toString(){
		        return "Circulo de "+super.toString()+", com raio de "+raio()+".";
		    }
}
