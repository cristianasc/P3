package Aula5;

public class Automovel extends Motorizado{
	
	public Automovel(int ano, String corBase, int nrRodas, int potencia, int consumo, String combustivel, int cilindrada){
		super(ano,corBase,4, potencia, consumo, combustivel, cilindrada);
	}

	@Override 
	public boolean equals(Object b){
		return super.equals(b);
	}
	
}
