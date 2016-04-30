package Aula9;

public class GeladoDecorador implements Gelado{
	private Gelado j;
	
	public GeladoDecorador(Gelado j){
		this.j =j;
	}
		
	public void base(int n){
		j.base(n);
	}
	
	public String sabor(){
		return j.sabor();
	}
}
