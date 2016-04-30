package Aula5;

public class MotoPolicia extends Moto implements Policia {
	String id;
	Tipo tipo;
	
	public MotoPolicia(int ano, String corBase, int nrRodas, int potencia, int consumo, String combustivel, int cilindrada, String id, String tipo){
		super(ano,corBase,nrRodas, potencia, consumo, combustivel, cilindrada);
		this.id=id;
		this.tipo = Tipo.valueOf(tipo);
	}
	
	public String getTipo(){
		return tipo.toString();
	}
	
	public String getID(){
		return id;
	}
	
	@Override 
	public String toString(){
		return super.toString()+"\nTipo: "+tipo+"\nID: "+id;
	}
}
