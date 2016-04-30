package Aula11;

import Aula6.Prato;

import java.util.LinkedList;
public class Ementa {
	private String nome;
	private String local;
	@SuppressWarnings("unchecked")
	private LinkedList <Prato>[] pratos = new LinkedList[7];
	
	public Ementa(String nome, String local){
		this.nome = nome;
		this.local = local;
	}
	
	public String nomeEmenta(){
		return nome;
	}
	
	public String nomeLocal(){
		return local;
	}
	
	public void addPrato(Prato a, DiaSemana d){
		if(pratos[d.ordinal()]==null)
			pratos[d.ordinal()] = new LinkedList<Prato>();
		pratos[d.ordinal()].push(a);
	}
	
	public Prato[] getPratPorDia(int i){
        Object[] e = pratos[i].toArray();
        Prato[] a = new Prato[e.length];
        for (int j=0;j<e.length;j++){
            a[j] = (Prato)e[j];
        }
        return a;
    }
	
	public void remove(Prato p, int dia){ 
        pratos[dia].remove(p);
    }
	
	public enum DiaSemana{
		Segunda(0),Terca(1),Quarta(2),Quinta(3),Sexta(4),Sabado(5),Domingo(6);
		private int dia;
		
		DiaSemana(int dia){
			this.dia = dia;
		}
		
		public int intDia(){
			return dia;
		}
		
		public static DiaSemana rand(){
			switch ((int) (Math.random() * 6)){ 
				default:
				case 0:
					return DiaSemana.Segunda;
				case 1:
					return DiaSemana.Terca;
				case 2:
					return DiaSemana.Quarta;
				case 3:
					return DiaSemana.Quinta;
				case 4:
					return DiaSemana.Sexta;
				case 5:
					return DiaSemana.Sabado;
				case 6:
					return DiaSemana.Domingo;
			}
		}
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((local == null) ? 0 : local.hashCode());
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
		Ementa other = (Ementa) obj;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override 
	public String toString() {
        String ementa ="";
        for(int i=0;i<pratos.length;i++){
            if(pratos[i]!=null && !pratos[i].isEmpty())
                for(Object e: pratos[i].toArray()){
                    Prato a = (Prato)e;
                    ementa += "\n"+a.toString()+", dia "+DiaSemana.rand();
                }
             
        }
        return ementa;
    }
	
	
	
	
	
	
}
