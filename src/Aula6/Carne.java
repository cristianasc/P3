package Aula6;

public class Carne extends Alimento{
	enum VariedadeCarne{vaca, porco, peru, frango, outra};
	private VariedadeCarne var;
	
	public Carne(VariedadeCarne var, double proteinas, double calorias, double peso){
		super(proteinas,calorias,peso);
		this.var = var;
	}
	
	public VariedadeCarne var(){
		return var;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((var == null) ? 0 : var.hashCode());
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
		Carne other = (Carne) obj;
		if (var != other.var)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return  "\nVariedade: " + var + super.toString();
	}
	
}
