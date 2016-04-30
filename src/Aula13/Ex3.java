package Aula13;

import java.util.*;

public class Ex3 {
	 public static void main(String[] args) {
		 List<String> empregados = new ArrayList<>();
		 List<String> brinq = new ArrayList<>();
		 HashMap<String, String> pairs = new HashMap<>();
		 
		 
		 empregados.add("Paula Silva");
		 empregados.add("José Manuel");
		 empregados.add("José");
		 empregados.add("Mariana Carvalho");
		 empregados.add("Mariana Silva");
		 
	
		 brinq.add("Boneca");
	     brinq.add("Carro dos bombeiros");
	   
	     pairs.put(empregados.get((int)(Math.random()*empregados.size())), brinq.get((int)(Math.random()*brinq.size())));
		 int rand = (int)(Math.random()*empregados.size());
		 
	     do{
	     if(pairs.containsKey(empregados.get(rand))){
	    	 rand = (int)(Math.random()*empregados.size());
	     }
	     else{
	    	 pairs.put(empregados.get(rand), brinq.get((int)(Math.random()*brinq.size())));
	     }
	     }while(pairs.size()!=empregados.size());
	     
	     System.out.println(pairs);
	     
	     HashMap<String,Integer> names = new HashMap<>();
	     Iterator<String> it = empregados.iterator();
	     while(it.hasNext()){
	    	 String b = it.next().split(" ") [0];
	    	 if(names.containsKey(b)){
	    		 names.put(b, names.get(b)+1);
	    	 }
	    	 else
	    		 names.put(b,1);
	     }
	     System.out.println(names);
	     
	     HashMap<String, Integer> hm=new HashMap<>();
	     Iterator<String> i=empregados.iterator();
	     hm.put(i.next(), 1);
	     while(i.hasNext()){
	    	 hm.put(i.next(), 0);
	     }
	         
	     System.out.println(hm);
	 }

}
