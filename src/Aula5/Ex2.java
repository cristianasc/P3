package Aula5;

public class Ex2 {
	public static void main(String[] args){
		Veiculo veiculos[] = {
			new Automovel(1996, "Branco", 4, 1384, 90, "Gasolina", 180),
			new Bicicleta(2011, "Preto", 2),
			new BicicletaPolicia(1781, "Azul",2,"1", "Bombeiros"),
			new CarroPolicia(2010, "Branco", 4, 2200, 170, "Gasoleo", 250, "8", "INEM"),	
			new Moto(1988, "Branco", 2, 8000, 80, "Gasolina", 200), 
			new MotoPolicia(2015, "Azul", 2, 900, 85, "Gasolina", 250, "9" ,"PSP")
		};
		
		  UtilCompare.sortArray(veiculos);
	        for(Veiculo v: veiculos){
	            System.out.println(v);
	            System.out.println();
	        }
	} 
}
