package Treino;

public class Bebida {
	private String nome;
	private int quantidade;
	private double preco;
	
	public Bebida(String nome, int quantidade, double preco){
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		
	}

	public String nome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int quantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double preco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantidade;
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
		Bebida other = (Bebida) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bebida: nome:" + nome + ", quantidade:" + quantidade + ", preco:" + preco;
	}
	
	
	
	
}
