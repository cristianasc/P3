package Aula10;


public class ListaGeneric<T>{
	Node top = null;
	int size = 0;
	
	public void addElem(T e){
		Node novo = new Node(e);
		novo.next = top;
		top = novo;
		size++;
	}
	
	private boolean removeElem(T e){
		Node tmp = top;
		if(top.e.equals(e) && top.next==null){
			top = null;
			size--;
			return true;
		}else if(top.e.equals(e) && top.next!=null){
			top = top.next;
			size--;
			return true;
		}
		while(tmp.next!=null){
			if(tmp.next.e.equals(e)){
				tmp.next = tmp.next.next;
				size--;
				return true;
			}
			tmp = tmp.next;
		}
		return false;
	}
	
	public T[] toArray(){
		Node tmp = top;
		T[] array = (T[]) new Object[size];
		int i = 0;
		while(tmp!=null){
			array[i++] = (T) tmp.e;
			tmp = tmp.next;
		}
		return array;
	}
	
	@Override
	public String toString(){
		Node tmp = top;
		String out = "";
		while(tmp!=null){
			out += "\n"+tmp.e;
			tmp = tmp.next;
		}
		return out;
	}
	
	public Iterator<T> iterator(){
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T>{
		Node<T> tmp = top;
		@Override public boolean hasNext(){
			return (tmp!=null);
		}

		@Override public T next(){
			T p = tmp.e;
			tmp = tmp.next;
			return p;
		}

		@Override public void remove() throws Exception{
			throw new Exception("Impossivel remover");
		}
	}
	 
	class Node<T>{
		Node next;
		T e;
		public Node(T e){
			this.e = e;
		}
	}

}