package Treino;

public class Espumante extends Vinho implements Gaseificada{

	public Espumante(String nome, int quantidade, double preco, double teor, Regiao origem) {
		super(nome, quantidade, preco, teor, origem);
	}
	
	@Override 
	public String toString(){
		return super.toString()+" Espumante.";
	}
}
