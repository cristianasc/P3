package Aula10;

public interface Iterator<T>{
	public boolean hasNext();
	public T next();
	public void remove() throws Exception;
}

