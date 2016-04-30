package Aula5;

public class Veiculo implements Comparable<Veiculo>{
	private int ano;
	private String corBase;
	private int nrRodas;

	public Veiculo(int ano, String corBase, int nrRodas){
		this.ano = ano;
		this.corBase = corBase;
		this.nrRodas = nrRodas;
	}
	
	public int ano(){
		return ano;
	}
	
	public int nrRodas(){
		return nrRodas;
	}
	
	public String corBase(){
		return corBase;
	}
	
	@Override 
	public int compareTo(Veiculo b){
		if(this.ano<((Veiculo)b).ano){
			return -1;
		}else if(this.ano>((Veiculo)b).ano){
			return 1;
		}else{
			return 0;
		}
	}

	@Override 
	public String toString(){
		return "Ano: "+ano+"\nCor Base: "+corBase+"\nNúmero de Rodas: "+nrRodas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((corBase == null) ? 0 : corBase.hashCode());
		result = prime * result + nrRodas;
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
		Veiculo other = (Veiculo) obj;
		if (ano != other.ano)
			return false;
		if (corBase == null) {
			if (other.corBase != null)
				return false;
		} else if (!corBase.equals(other.corBase))
			return false;
		if (nrRodas != other.nrRodas)
			return false;
		return true;
	}
	
}
