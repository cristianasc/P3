package Aula6;

public class Alimento implements Comparable<Alimento>{
	enum NomeAlimento{Carne, Peixe, Cereal, Legume};
	private NomeAlimento nome;
	private double proteinas;
	private double calorias;
	private double peso;
	
	public Alimento(double proteinas, double calorias, double peso){
		this.proteinas = proteinas;
		this.calorias = calorias;
		this.peso = peso;
	}
	
	public NomeAlimento nomeAlimento(){
		return nome;
	}
	
	public double proteinas(){
		return proteinas;
	}
	
	public double calorias(){
		return calorias;
	}
	
	public double peso(){
		return peso;
	}
	
	public double TotalCalorias(){
		return ((peso)*(calorias))/100;
	}
	
	public double TotalProteinas(){
		return ((peso)*(proteinas))/100;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(calorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(proteinas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Alimento other = (Alimento) obj;
		if (Double.doubleToLongBits(calorias) != Double.doubleToLongBits(other.calorias))
			return false;
		if (nome != other.nome)
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(proteinas) != Double.doubleToLongBits(other.proteinas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nProteínas:" + proteinas + "\nCalorias:" + calorias + "\nPeso:" + peso;
	}
	
	@Override
    public int compareTo(Alimento a){
        if (this.calorias>a.calorias()) return 1;
        else if (this.calorias==a.calorias()) return 0;
        else return -1;
    }
	
	
	
	
}
