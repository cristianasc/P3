package Aula3;

public class Quadrado extends Retangulo {
	
	public Quadrado(double l){
		super(l,l);
	}
	
	public Quadrado(double l, double x, double y){
		super(new Ponto(x,y),l,l);
	}
	
	public Quadrado(double l, Ponto centro){
		super(centro,l,l);
	}
	
	public Quadrado(Quadrado quadrado){
		this(quadrado.l(), quadrado.centro());
	}

	
	public void dadosQuadrado(){
		System.out.println("Área do quadrado: " + area());
		System.out.println("Perímetro do quadrado: " + perimetro());
		System.out.println(toString());
	}
		 
	 public String toString(){
	        return "Quadrado com lado de comprimento "+l()+".";
	    }
	
}
