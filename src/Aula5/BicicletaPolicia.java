package Aula5;

public class BicicletaPolicia extends Bicicleta implements Policia{
	String id;
	Tipo tipo;
	
	public BicicletaPolicia(int ano, String corBase, int nrRodas, String id, String tipo){
		super(ano,corBase,2);
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
