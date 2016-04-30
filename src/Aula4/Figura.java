package Aula4;

public class Figura {
	private Ponto centro;
		
		public Figura(Ponto centro){
			this.centro = centro;
		}
		
		public Figura(double x, double y){
			new Ponto(x,y);
		}
		
		public Ponto centro(){
			return centro;
		}
		
		@Override 
		public String toString(){
			return "centro: "+centro;
		}

}
