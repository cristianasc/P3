package Aula3;

public class Ex1 {
	public static void main(String[] args) {
		Estudante est = new Estudante ("Andreia", 9855678, new Data(18, 7, 1974)); 
		Bolseiro bls = new Bolseiro ("Maria", 8976543, new Data(11, 5, 1976)); 
		bls.setMontante(745);
		
		System.out.println("Estudante:" + est.nome()); 
		System.out.println(est);
		System.out.println();
		System.out.println("Bolseiro:" + bls.nome() + ", NMec: " + bls. nMec() +",Bolsa:"+ bls.getMontante());
		System.out.println(bls); 
	}
}

