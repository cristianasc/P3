package Aula11;

import java.util.*;

public class Ex2 {
	public static void main(String[] args) {
		ArrayList<Quadrado> q = new ArrayList<>();
         
        q.add(new Quadrado(1,1,2));
        q.add(new Quadrado(2,2,3));
        System.out.println(maiorFiguraJ8(q));
        System.out.println(maiorFiguraPerimetroJ8(q));
        System.out.println(areaTotalJ8(q));
        System.out.println(areaTotalJ8(q, "Retangulo"));
	}
	
	private static Optional<? extends Figura> maiorFiguraJ8(ArrayList<? extends Figura> figs) { 
		return figs.stream().max((a,b) -> a.compareTo(b));
	}
	
	private static Optional<? extends Figura> maiorFiguraPerimetroJ8(ArrayList<? extends Figura> figs) { 
		return figs.stream().max((a,b) -> Double.compare(a.perimetro(), b.perimetro()));
	}
	
	private static double areaTotalJ8(ArrayList<? extends Figura> figs) {
		return figs.stream()
				   .mapToDouble(Figura::area)
                   .sum();
	}
	
	private static double areaTotalJ8(List<? extends Figura> figs,String subtipoNome){ 
		return figs.stream()
				   .filter(p -> p.getClass().getSimpleName().equals(subtipoNome))
				   .mapToDouble(Figura::area)
                   .sum();
	}
}
