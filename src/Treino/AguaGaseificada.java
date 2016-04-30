package Treino;

public class AguaGaseificada extends Agua implements Gaseificada{
	
	public AguaGaseificada(String nome, int quantidade, double preco, TipoAgua tipo){
		super(nome, quantidade, preco, tipo);
	}
	
	@Override public String toString(){
		return super.toString()+" Gaseificada.";
	}

}
