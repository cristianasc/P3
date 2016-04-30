package Aula9;

public class GeladoSimples implements Gelado{
	private String sabor;
	private int i;
	
	public GeladoSimples(String sabor){
		this.sabor = sabor;
	}
	
	public String sabor(){
		return sabor;
	}
	
	public void base(int n){
		i = n;
		System.out.print( "\n"+i+ " bolas de gelado de " + sabor);
	}

}
