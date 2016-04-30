package Aula3;

public class Veiculo {
	private int cilindrada;
	private int potencia;
	private int lotacao;
	private int pesoBruto;
	
	
	public Veiculo(int cilindrada, int potencia, int lotacao, int pesoBruto){
		this.cilindrada = cilindrada;
		this.potencia = potencia;
		this.lotacao = lotacao;
		this.pesoBruto = pesoBruto;
	}
	
	public int cilindrada(){
		return cilindrada;
	}
	
	public int potencia(){
		return potencia;
	}
	
	public int lotacao(){
		return lotacao;
	}
	
	public int pesoBruto(){
		return pesoBruto;
	}
	
	@Override 
	public String toString(){
		return "Cilindrada: "+cilindrada+"\nPotencia: "+potencia+"\nPeso bruto: "+pesoBruto+"\nLotação: "+lotacao;
	}
}

