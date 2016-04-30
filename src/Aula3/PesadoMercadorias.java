package Aula3;

public class PesadoMercadorias extends Veiculo{
	private char categoria = 'C';
	
	public PesadoMercadorias(int cilindrada,int potencia,int lotacao, int pesoBruto){
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
