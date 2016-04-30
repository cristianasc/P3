package Aula5;

public class Motorizado extends Veiculo{
	private int potencia;
	private int consumo;
	private String combustivel;
	private int cilindrada;
	
	
	public Motorizado(int ano, String corBase, int nrRodas, int potencia, int consumo, String combustivel, int cilindrada){
		super(ano, corBase, nrRodas);
		this.combustivel = combustivel;
		this.consumo = consumo;
		this.potencia = potencia;
		this.cilindrada = cilindrada;
	}


	public int Potencia() {
		return potencia;
	}

	public int Consumo() {
		return consumo;
	}

	public String Combustivel() {
		return combustivel;
	}

	public int Cilindrada() {
		return cilindrada;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cilindrada;
		result = prime * result + ((combustivel == null) ? 0 : combustivel.hashCode());
		result = prime * result + consumo;
		result = prime * result + potencia;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorizado other = (Motorizado) obj;
		if (cilindrada != other.cilindrada)
			return false;
		if (combustivel == null) {
			if (other.combustivel != null)
				return false;
		} else if (!combustivel.equals(other.combustivel))
			return false;
		if (consumo != other.consumo)
			return false;
		if (potencia != other.potencia)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return super.toString() + "\nCilindrada: "+cilindrada+"\nPotencia: "+potencia+"\nConsumo: "+consumo+"\nCombustivel: "+combustivel;
	}
	
	
}
