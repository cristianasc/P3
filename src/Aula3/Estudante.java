package Aula3;


public class Estudante extends Pessoa{ 
	private static int num=100;
	private int Nmec;
	private Data dataInsc;


	public Estudante(String nome, int cc, Data dataNasc, Data dataInsc){
		super(nome,cc,dataNasc);
		Nmec = num;
		num++; 
		this.dataInsc = dataInsc;
	} 
	
	public Estudante(String nome, int cc, Data dataNasc){
		super(nome,cc,dataNasc);
		Nmec = num;
		num++; 
		dataInsc = Data.hoje();
	}

	public int nMec() {
		return Nmec;
	} 
	
	public Data dataInsc() {
		return dataInsc;
	} 
	
	@Override public String toString(){
		return super.toString()+", Data de inscriçao: "+this.dataInsc+", Nmec: "+Nmec;
	}
}