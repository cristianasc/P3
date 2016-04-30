package Aula11;

import java.util.LinkedList;

import Aula6.Alimento;


public class Prato implements Comparable<Prato>{
	private String nome;

	private LinkedList<Alimento> alimentos = new LinkedList<Alimento>();
	
	public Prato(String nome){
		this.nome = nome;
	}
	
	public String nomePrato(){
		return nome;
	}
	
	public boolean addIngrediente(Alimento a){
		alimentos.add(a);
		return true;
	}
	
	public boolean exists(Alimento a){
	    return alimentos.contains(a);
	}
	     
	public void del(Alimento a){
	    alimentos.remove(a);
	}
	
	public Alimento[] Alimentos(){
        Object[] e = alimentos.toArray();
        Alimento[] a = new Alimento[e.length];
        for (int i=0;i<e.length;i++){
            a[i] = (Alimento)e[i];
        }
        return a;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Prato other = (Prato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override 
	public int compareTo(Prato b) {
		double thisCalorias = getCalorias();
		double bCalorias = ((Prato)b).getCalorias();
		
		if(thisCalorias < bCalorias){
			return -1;
		}else if(thisCalorias == bCalorias){
			return 0;
		}else{
			return 1;
		}	
	}
	
	public double getCalorias(){
		double thisCalorias =0;
		for(Object e: alimentos.toArray()){
            Alimento a = (Alimento)e;
            thisCalorias += a.TotalCalorias();
		}
		return thisCalorias;
	}
	
	

	@Override
	public String toString() {
		return "Nome do Prato:" + nome;
	}
	
	
}
