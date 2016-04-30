package Aula3;

public class Retangulo extends Figura{
	private double c;
	private double l;
	
	public Retangulo(double c, double l, double x, double y){
		super(new Ponto(x,y));
		this.c = c;
		this.l = l;
	}
	
	public Retangulo(double c, double l){
		super(new Ponto(0,0));
		this.c = c;
		this.l = l;
	}
	
	public Retangulo(Ponto centro, double c, double l){
		super(centro);
		this.c = c;
		this.l = l;
	}
	
	public Retangulo(Retangulo retangulo){
		this(retangulo.centro(),retangulo.c(),retangulo.l());
	}
	
	public double l(){
		return l;
	}
	
	public double c(){
		return c;
	}
	
	public void dadosRetangulo(){
			System.out.println("Área do retângulo: " + area());
			System.out.println("Perímetro do retângulo: " + perimetro());
			System.out.println(toString());
		}
		
	public double area(){
			 double area;
			 area = c*l();
			 return area;
		 }
		 
	public double perimetro(){
			 double perimetro;
			 perimetro = c*2+l()*2;
			 return perimetro;
		 }
	
		 
	public boolean iguais(Retangulo r){
        if((r.c()==c()) && (r.l()==l()) && (r.area() == area()) && (r.perimetro()==perimetro()))
            return true;
        return false;
	}
	
	@Override 
	public String toString(){
        return "Retangulo com lado de comprimento "+c+" e de largura "+l()+".";
    }
}
