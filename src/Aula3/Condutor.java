package Aula3;

public class Condutor extends Pessoa{
	private char categoria;
	
	public Condutor(String nome,int cc, Data dataNasc, char categoria){
		super(nome, cc, dataNasc);
		this.categoria = categoria;
	}
	
	public char categoria(){
		return categoria;
	}
	
	@Override 
	public String toString(){
		return super.toString()+"\nCategoria: "+Character.toString(categoria);
	}
}
