package Aula7;

public class Voo {
	private Hora hora; 
	private String voo;
	private String companhia;
	private String origem;
	private Hora atraso;
	
	public Voo(Hora hora, String voo, String companhia, String origem, Hora atraso){
		this.hora = hora;
		this.voo = voo;
		this.companhia = companhia;
		this.origem = origem;
		this.atraso = atraso;
	}
	
	public Voo(Hora hora, String voo, String companhia, String origem){
		this.hora = hora;
		this.voo = voo;
		this.companhia = companhia;
		this.origem = origem;
	}
	
	public Hora hora(){
		return hora;
	}
	
	public String voo(){
		return voo;
	}
	
	public String companhia(){
		return companhia;
	}
	
	public String origem(){
		return origem;
	}
	
	public Hora atraso(){
		return atraso;
	}
	
	public Hora obs() {
        return hora.soma(atraso);
    }

	@Override
	public String toString() {
		 if(atraso!=null)
	            return  hora +"\t"+ voo+"\t"+ companhia+"\t"+ origem+"\t"+ atraso+"\t"+ obs();
	        return hora+"\t"+ voo+"\t"+ companhia+"\t"+ origem;
	    }
	
	
	
	
	
}
