package Aula4;

public class Emprestimo {
	private int nrSocio;
	private int ID;
	private static int num =0;
	
	public Emprestimo(int nrSocio, int id){
		ID = num;
		num++;
		this.nrSocio = nrSocio;
		}
	
	public int ID(){
		return ID;
	}
	
	public int nrSocio(){
		return nrSocio;
	}
	
}