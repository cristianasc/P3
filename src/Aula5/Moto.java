package Aula5;

public class Moto extends Motorizado{
	
	public Moto(int ano, String corBase, int nrRodas, int potencia, int consumo, String combustivel, int cilindrada){
		super(ano,corBase,nrRodas, potencia, consumo, combustivel, cilindrada);
	}

	@Override 
	public boolean equals(Object b){
		return super.equals(b);
	}
	
}
