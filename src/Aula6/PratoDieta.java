package Aula6;

public class PratoDieta extends Prato{
	private Stack<Alimento> alimento = new Stack<Alimento>();
	private double maxCalorias;	
	
	public PratoDieta(String nome, double maxCalorias){
		super(nome);
		this.maxCalorias = maxCalorias;
	}
	
	public double maxCalorias(){
		return maxCalorias;
	}
	
	
	
	 @Override
	 public boolean addIngrediente(Alimento ali){
		 double cal=0;
	     for(Object e: alimento.nodesToArray()){
	    	 Alimento a = (Alimento)e;
	         cal += a.TotalCalorias();
	        }
	         
	     if(cal+ali.TotalCalorias()>maxCalorias)
	    	 return false;
	         
	     alimento.push(ali);
	     return true;
	    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(maxCalorias);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PratoDieta other = (PratoDieta) obj;
		if (Double.doubleToLongBits(maxCalorias) != Double.doubleToLongBits(other.maxCalorias))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nMáximo de Calorias:" + maxCalorias +  super.toString();
	}
	
	
}
