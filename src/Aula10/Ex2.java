package Aula10;

import java.util.Iterator;
import java.util.Stack;
import java.lang.Comparable;

public class Ex2<T extends Comparable<? super T>> implements Iterable<T> {
	
	private static class BSTNode<T> { 
		T element;
		BSTNode<T> left; 
		BSTNode<T> right;
		
		BSTNode(T theElement) { 
			element = theElement;
			left = right = null;
		} 
	}
	
	private BSTNode<T> root; 
	private int numNodes;
	
	public Ex2() { 
		root = null; 
		numNodes = 0;
	}
	
	public void insert(T value) { 
		BSTNode<T> novo = new BSTNode<T>(value);
		root = insert(novo, root);
	}

	private BSTNode<T> insert(BSTNode<T> novo, BSTNode<T> root){
		if(root==null){
			numNodes++;
			return root = novo;
		}else if(novo.element.compareTo(root.element) <= 0 && root.left == null){
			numNodes++;
			return root.left = novo;
		}else if(novo.element.compareTo(root.element) <= 0){
			return insert(novo, root.left);
		}else if(novo.element.compareTo(root.element) > 0 && root.right == null){
			numNodes++;
			return root.right = novo;
		}else if(novo.element.compareTo(root.element) > 0){
			insert(novo, root.right);
		}
		return root;
	}

	public void remove(T value) { 
		root = remove(value, root);
	}
	
	private BSTNode<T> remove(T value, BSTNode<T> root) {
		if(root == null){ 
			return null;
		}else if(value.compareTo(root.element) < 0) 
			root.left = remove(value, root.left);
		else if(value.compareTo(root.element) > 0)
			root.right = remove(value, root.right);
		else if(value.equals(root.element)){
			if(root.left == null){
				return root.right;
			}else if(root.right == null){
				return root.left;
			}else{
				return insert(root.left, root.right);
			}
		}
		return root;
	}
	
	public boolean contains(T value) {
		return valueOf(find(value, root)) != null;
	}
	
	private T valueOf(BSTNode<T> find) {
		if(find==null){
			return null;
		}
		return find.element;
	}
	
	private BSTNode<T> find(T value, BSTNode<T> root) {
		if(root != null && root.element.equals(value)){
			return root;
		}else if(root != null){
			if(root.left != null && root.left.element.compareTo(value) <= 0){
				return find(value, root.left);
			}else if(root.right != null && root.right.element.compareTo(value) > 0){
				return find(value, root.right);
			}
		}
		return null;
	}

	public Iterator<T> iterator() {
		return new BSTiterator();
	}
	
	private class BSTiterator implements Iterator<T>{
		Stack<BSTNode<T>> stackOfReferences = new Stack<>();
		BSTNode<T> atual;
		
		public BSTiterator(){
			setReferences(root);
			atual = stackOfReferences.peek();
		}
		
		private void setReferences(BSTNode <T> root) {
			if(root!=null){
				this.stackOfReferences.add(root);
				if(root.left != null){
					setReferences(root.left);
				} 
				if(root.right != null){
					setReferences(root.right);
				}
			}
		}

		@Override public boolean hasNext() {
			return stackOfReferences.size()!=0;
		}

		@Override public T next() {
			atual = stackOfReferences.peek();
			return valueOf(stackOfReferences.pop());
		}
		
		@Override public void remove() {
			Ex2.this.remove(atual.element, root);
			stackOfReferences.remove(atual);
			atual = stackOfReferences.peek();
		}
	}
	
	
	
}
