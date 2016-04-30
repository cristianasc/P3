package Aula10;

public class Quadrado extends Retangulo {
	
	public Quadrado(double l){
		super(0,0,l,l);
	}
	
	public Quadrado(double x, double y, double l){
		super(x,y,l,l);
	}
	
	public Quadrado(Ponto centro, double l){
		super(centro,l,l);
	}
	
	public Quadrado(Quadrado quadrado){
		this(quadrado.centro(), quadrado.l());
	}

	
	public void dadosQuadrado(){
		System.out.println("Área do quadrado: " + area());
		System.out.println("Perímetro do quadrado: " + perimetro());
		System.out.println(toString());
	}
	
	@Override
	public boolean equals(Object r){
        if((((Quadrado) r).c()==c()) && (((Quadrado) r).l()==l()) && (((Quadrado) r).area() == area()) && (((Quadrado) r).perimetro()==perimetro()))
            return true;
        return false;
	}
		 
	 public String toString(){
	        return "Quadrado de centro: "+super.centro().toString()+", com lado de comprimento "+l()+".";
	    }
}