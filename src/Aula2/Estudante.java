package Aula2;

public class Estudante {
	private int mec;
	private String curso;
	private Cliente cliente;
	
	public Estudante(int mec, String curso, String nome, int cc, Data dataInscricao, Data dataNascimento){
		this.mec = mec;
		this.curso = curso;
		cliente = new Cliente(nome, cc, dataInscricao, dataNascimento);
	}
	
	public Estudante(int mec, String curso, Cliente cliente){
		this.mec = mec;
		this.curso = curso;
		this.cliente = cliente;
	}
	
	public int cc(){
		return cliente.cc();
	}
	
	public int nrSocio(){
		return cliente.nrSocio();
	}
	
	public Data dataNascimento(){
		return cliente.dataNascimento();
	}
	
	public Videos[] hist(){
		return cliente.hist();
	}
	
	public Cliente cliente(){
		return cliente;
	}
	
	
	public int mec(){
		return mec;
	}

	public String curso(){
		return curso;
	}


}
