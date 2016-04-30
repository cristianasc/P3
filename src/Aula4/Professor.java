package Aula4;

public class Professor extends Pessoa{
	private static int num=1;
	private int nrFunc;
	private Data dataAdmissao;
	
	public Professor(int nif, String nome, int cc, Data dataAdmissao, Data dataNascimento){
		super(nome,cc,dataNascimento);
		nrFunc = num;
		num++;
		this.dataAdmissao = dataAdmissao;
	}
	
	public Professor(String nome,int cc, Data dataNascimento){
		super(nome,cc,dataNascimento);
		nrFunc = num;
		num++;
		dataAdmissao = Data.hoje();
	}
	
	public Data dataAdmissao(){
		return dataAdmissao;
	}
	
	public int nrFunc(){
		return nrFunc;
	}

}