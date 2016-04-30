package Treino;

public class Agua extends Bebida{
	enum TipoAgua{Nascente,Mineral};
	private TipoAgua tipo;
	
	public Agua(String nome, int quantidade, double preco, TipoAgua tipo){
		super(nome,quantidade,preco);
		this.tipo = tipo;
	}
	

	public TipoAgua getTipo() {
		return tipo;
	}

	public void setTipo(TipoAgua tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Agua other = (Agua) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return	super.toString() + ", tipo: " + tipo;
	}
	
}
