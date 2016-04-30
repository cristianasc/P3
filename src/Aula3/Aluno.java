package Aula3;

public class Aluno extends Cliente{
	private int mec;
	private String curso;
	
	public Aluno(int mec, String curso, String nome, int cc, Data dataInscricao, Data dataNascimento){
		super(nome,cc,dataInscricao, dataNascimento);
		this.mec = mec;
		this.curso = curso;
	}
	
	public int mec(){
		return mec;
	}

	public String curso(){
		return curso;
	}


}
