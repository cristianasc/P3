package Aula9;

public class Cone extends GeladoDecorador{	
	public Cone(Gelado gelado){
		super(gelado);
	}
	
	public void base(int n){
		super.base(n);
		System.out.print(" em cone");
	}
}
