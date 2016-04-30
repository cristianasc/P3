package Aula7;

public class Hora {
	private int hora;
	private int minutos;
	
	public Hora(int hora, int minutos){
		this.hora = hora;
		this.minutos = minutos;
	}
	
	public int hora(){
		return hora;
	}
	
	public int minutos(){
		return minutos;
	}
	
	@Override
	public String toString(){
		return String.format("%02d", hora)+":"+String.format("%02d", minutos);
	}

	public Hora soma(Hora h){
		Hora prev = new Hora(00,00);
		Hora hora = new Hora(this.hora,this.minutos);
		Hora atraso = new Hora(h.hora,h.minutos);
		if((this.minutos+h.minutos)==60){
			this.hora++;
			prev = new Hora(this.hora,00);
		}
		else if ((this.minutos+h.minutos)<60){
			int minutos = this.minutos+h.minutos;
			prev = new Hora(this.hora,minutos);
		}
		else if ((this.minutos+h.minutos)>60){
			this.hora++;
			int minutos = (this.minutos+h.minutos)-60;
			prev = new Hora(this.hora,minutos);
		}
		
		return prev;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hora;
		result = prime * result + minutos;
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
		Hora other = (Hora) obj;
		if (hora != other.hora)
			return false;
		if (minutos != other.minutos)
			return false;
		return true;
	}
	
	
}
