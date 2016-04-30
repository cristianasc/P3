package Aula10;

public class VectorGeneric<T>{
	@SuppressWarnings("unchecked")
	T[] array = (T[]) new Object[0];
	
	public boolean addElem(T p){
		if(exists(p)) return false;
		T[] arr2= (T[]) new Object[array.length+1];
		for(int i=0; i<array.length;i++){
			arr2[i]=(T) array[i];
		}
		arr2[array.length]= p;
		array = (T[]) arr2;
		return true;
	}
	
	public boolean removeElem(T p){
		if(!exists(p)) return false;
		T arr2[] = (T[]) new Object[array.length-1];
		int j=0;
		for(int i=0;i<array.length;i++){
			if (array[i]==p){
				array[i]=null;
		}
			if(array[i]!=null){
				arr2[j++]= (T) array[i];
			}
		}
		array = (T[]) arr2;
		return true;
	}
	
	public int totalElem(){
		return array.length-1;
	}
	
	public <T> boolean exists(T p){
		for(int i=0;i<array.length;i++){
			if(array[i]==p){
				return true;
			}
		}
		return false;
	}
	
	@Override 
	public String toString(){
		String out = "";
		
		for(int i=0; i<array.length; i++){
			out += "\n"+array[i];
		}
		
		return out;
	}
	
	public Iterator<T> iterator(){
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator{
		int i=0;
		
		@Override
		public boolean hasNext(){
			return (i<array.length);
		}
		
		@Override
		public Object next(){
			return array[i++];
		}
		
		@Override public void remove() throws Exception{
			throw new Exception("Impossivel remover");
		}
	}

}
