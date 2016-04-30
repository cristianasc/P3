package Aula6;

public class PratoVegetariano extends Prato implements Vegetariano{
	
	private Stack<Vegetariano> AlVegetariano=new Stack<Vegetariano>();
	public PratoVegetariano(String nome){
		super(nome);
	}
	
	@Override
    public boolean addIngrediente(Alimento vegetariano){
        if(!(vegetariano instanceof Vegetariano)) return false;
        AlVegetariano.push((Vegetariano)vegetariano);
        return true;
    }
	
	@Override
	public int hashCode(){
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
