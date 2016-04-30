package Aula9;

public class VectorPessoas {
	Pessoa[] pessoas = new Pessoa[0];
	
	public boolean addPessoa(Pessoa p){
		if(exists(p)) return false;
		Pessoa arr2[]= new Pessoa[pessoas.length+1];
		for(int i=0; i<pessoas.length;i++){
			arr2[i]=pessoas[i];
		}
		arr2[pessoas.length]= p;
		pessoas = arr2;
		return true;
	}
	
	public boolean	removePessoa(Pessoa p){
		if(!exists(p)) return false;
		Pessoa arr2[] = new Pessoa[pessoas.length-1];
		int j=0;
		for(int i=0;i<pessoas.length;i++){
			if (pessoas[i]==p){
				pessoas[i]=null;
		}
			if(pessoas[i]!=null){
				arr2[j++]= pessoas[i];
			}
		}
		pessoas = arr2;
		return true;
	}
	
	public int totalPessoas(){
		return pessoas.length-1;
	}
	
	public boolean exists(Pessoa p){
		for(int i=0;i<pessoas.length;i++){
			if(pessoas[i]==p){
				return true;
			}
		}
		return false;
	}
	
	@Override 
	public String toString(){
		String out = "";
		
		for(int i=0; i<pessoas.length; i++){
			out += "\n"+pessoas[i];
		}
		
		return out;
	}
	
	public Iterator iterator(){
		return new VectorIterator();
	}
	
	private class VectorIterator implements Iterator{
		int i=0;
		
		@Override
		public boolean hasNext(){
			return (i<pessoas.length);
		}
		
		@Override
		public Object next(){
			return pessoas[i++];
		}
		
		@Override
		public void remove(){
			removePessoa(pessoas[i]);
			i--;
		}
	}
}
