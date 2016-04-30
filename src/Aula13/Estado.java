package Aula13;

public class Estado extends Regiao{
	private	Localidade capital;

	public Estado(String nome, int populacao, Localidade capital){
		super(nome, populacao);
		assert (capital.tipo() != Localidade.TipoLocalidade.Cidade);
		this.capital = capital;
	}
	
	public Localidade capital(){
		return capital;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
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
		Estado other = (Estado) obj;
		if (capital != other.capital)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Capital:" + capital;
	}
	
	



}


