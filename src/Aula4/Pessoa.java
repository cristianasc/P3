package Aula4;

public class Pessoa{
	private String nome;
	private int cc;
	private Data dataNasc; 
	
	public Pessoa(String nome, int cc, Data dataNasc){
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dataNasc; 
	}
	
	public String nome(){
        return nome;
    }
     
    public int cc(){
        return cc;
    }
     
    public Data data(){
        return dataNasc;
    }
    
    @Override 
	public String toString(){
		return "Nome: "+this.nome+", CC: "+this.cc+", Data de nascimento: "+this.dataNasc;
	}
 
}