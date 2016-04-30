package Aula9;

public class Copo extends GeladoDecorador{
	
	public Copo(Gelado gelado){
		super(gelado);
	}
	
	public void base(int n){
		super.base(n);
		System.out.print(" em copo");
	}
}
