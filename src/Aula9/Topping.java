package Aula9;

public class Topping extends GeladoDecorador{
	private String topping;

	public Topping(Gelado gelado, String topping){
		super(gelado);
		this.topping = topping;
		
	
	}
	
	public String topping(){
		return topping;
	}
	
	public void base(int n){
			super.base(n);
			System.out.print(" com " + topping() );		
	}
}
