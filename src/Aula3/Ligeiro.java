package Aula3;

public class Ligeiro extends Veiculo{
	private char categoria = 'B';
	
	public Ligeiro(int cilindrada,int potencia,int lotacao, int pesoBruto){
		super(cilindrada,potencia,lotacao,pesoBruto);
	}
	
	public char categoria(){
		return categoria;
	}
	
	@Override 
	public String toString(){
		return super.toString()+"\nCategoria: "+Character.toString(categoria);
	}
	
}
