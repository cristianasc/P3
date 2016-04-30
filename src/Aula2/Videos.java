package Aula2;


public class Videos {
	private static int num =0;
	private int ID;
	private String titulo;
	private String categoria;
	private String idade;
	private double rating = 0;
	private int count=0;
	
	public Videos(String titulo, String categoria, String idade){
		ID = num;
		num++;
		this.titulo=titulo;
		this.categoria=categoria;
		this.idade = idade;
	}
	
	public int ID(){
		return ID;
	}
	
	public String titulo(){
		return titulo;
	}
	
	public String categoria(){
		return categoria;
	}
	
	public String idade(){
		return idade;
	}
	
	public void ratingTotal(int rating){
		count++;
		this.rating += rating;
	}
	
	public double ratingMedio(){
		double ratingMedio = 0;
		if (count!=0)
		ratingMedio = rating/count;
		return ratingMedio;
	}
	
}