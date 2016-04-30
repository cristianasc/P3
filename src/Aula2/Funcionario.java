package Aula2;

public class Funcionario {
	private int nrFunc;
	private int nif;
	private Cliente cliente;
	
	public Funcionario(int nrFunc, int nif, String nome, int cc, Data dataInscricao, Data dataNascimento){
		this.nrFunc = nrFunc;
		this.nif = nif;
		cliente = new Cliente(nome, cc, dataInscricao, dataNascimento);
	}
	
	public Funcionario(int nrFunc, int nif, Cliente cliente){
		this.nrFunc = nrFunc;
		this.nif = nif;
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
	
	public int nif(){
		return nif;
	}
	
	public int nrFunc(){
		return nrFunc;
	}

}
