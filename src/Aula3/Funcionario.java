package Aula3;

public class Funcionario extends Cliente{
	private int nrFunc;
	private int nif;
	
	public Funcionario(int nrFunc, int nif, String nome, int cc, Data dataInscricao, Data dataNascimento){
		super(nome,cc,dataInscricao,dataNascimento);
		this.nrFunc = nrFunc;
		this.nif = nif;
	}
	
	public int nif(){
		return nif;
	}
	
	public int nrFunc(){
		return nrFunc;
	}

}
