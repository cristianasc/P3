package Aula5;

public class Pessoa {
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
}
