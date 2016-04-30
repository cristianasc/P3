package Aula13;

import java.util.ArrayList;

public class Pais {
	private String nome;
	private Localidade capital = null;
	private ArrayList<Regiao> regioes = new ArrayList<>();
	
	public Pais(String nome, Localidade capital){
		this.nome = nome;
		this.capital = capital;
	}
	
	public Pais(String nome){
		this.nome = nome;
	}
	
	public String nome(){
		return nome;
	}
	
	public Localidade capital(){
		return capital;
	}
	
	public void addRegiao(Estado est){
		regioes.add(est);
	}
	
	public void addRegiao(Provincia prov){
		regioes.add(prov);
	}
	
	public int populacao(){
		int pop=0;
		for(Regiao reg : regioes){
			pop = pop + reg.populcao();
		}
		return pop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((regioes == null) ? 0 : regioes.hashCode());
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
		Pais other = (Pais) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (regioes == null) {
			if (other.regioes != null)
				return false;
		} else if (!regioes.equals(other.regioes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (capital() != null)
			return "Pais:" + nome() + " População: " + populacao() + (" Capital: " + capital().toString()+ ", população "+ capital.populacao());
		else 
			return "Pais:" + nome() + "População: " + populacao() + (" Capital: *Indefinido*");
	}
}
