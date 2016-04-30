package Aula4;

public class Bolseiro extends Estudante{
	private double montante;
	
	public Bolseiro(String nome, int cc, Data dataNasc, Data dataInsc, double montante){
		super(nome,cc,dataNasc,dataInsc);
		this.montante = montante;
	}
	
	public Bolseiro(String nome, int cc, Data dataNasc){
		super(nome,cc,dataNasc);
	}
	
	public double getBolsa(){
		return montante;
	}
	
	public String Class(){
		return "Bolseiro";
	}
	
	public void setBolsa(double montante){
		this.montante = montante;
	}
	
	@Override 
	public String toString(){
		return super.toString()+", Bolsa: "+montante;
	}
	
}

