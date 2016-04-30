package Treino;

public class Vinho extends Bebida implements Alcoolica{
	private double teor;
	private Regiao origem;
	enum Regiao{Douro, Alentejo, Dão, Beiras, Bairrada};
	
	public Vinho(String nome, int quantidade, double preco, double teor, Regiao origem){
		super(nome, quantidade, preco);
		this.teor = teor;
		this.origem = origem;
		
	}
	
	public Regiao getOrigem() {
		return origem;
	}

	public void setOrigem(Regiao origem) {
		this.origem = origem;
	}

	@Override
	public double getTeor() {
		return teor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		long temp;
		temp = Double.doubleToLongBits(teor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vinho other = (Vinho) obj;
		if (origem != other.origem)
			return false;
		if (Double.doubleToLongBits(teor) != Double.doubleToLongBits(other.teor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ", teor=" + teor + ", origem=" + origem;
	}
	
	

}
