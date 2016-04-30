package Aula4;

public class ColecaoFiguras {
	private Figura[] fig = new Figura[0];
	private double maxArea;
	
	public ColecaoFiguras(double maxArea){
		this.maxArea = maxArea;
	}
	
	public double maxArea(){
		return maxArea;
	}
	
	public boolean addFigura(Figura f){
		if(exists(f))
			return false;
		
		double area =0;
		for(int i=0;i<fig.length;i++){
			if(f instanceof Circulo){
				area = ((Circulo) f).areaCirculo();
				if(area+areaTotal()>maxArea())
					return false;
			}
			else if(f instanceof Quadrado){
				area = ((Quadrado) f).area();
				if(area+areaTotal()>maxArea())
					return false;
			}
			else if(f instanceof Retangulo){
				area = ((Retangulo) f).area();
				if(area+areaTotal()>maxArea())
					return false;
			}
			
		}
		Figura arr2[]= new Figura[fig.length+1];
		for(int i=0; i<fig.length;i++){
			arr2[i]=fig[i];
		}
		arr2[fig.length]= f;
		fig = arr2;
		return true;
	}
	
	public boolean	delFigura(Figura f){
		if(!exists(f)) return false;
		Figura arr2[] = new Figura[fig.length-1];
		int j=0;
		for(int i=0;i<fig.length;i++){
			if (fig[i]==f){
				fig[i]=null;
		}
			if(fig[i]!=null){
				arr2[j++]= fig[i];
			}
		}
		fig = arr2;
		return true;
	}
	
	public double areaTotal(){
		double areaTotal=0;
		for(int i=0; i<fig.length; i++){
			if(fig[i] instanceof Circulo){
				areaTotal = areaTotal + ((Circulo) fig[i]).areaCirculo();
			}
			else if(fig[i] instanceof Quadrado){
				areaTotal = areaTotal + ((Quadrado) fig[i]).area();
			}
			else if(fig[i] instanceof Retangulo){
				areaTotal = areaTotal + ((Retangulo) fig[i]).area();
			}
		}
		return areaTotal;
	}
	
	public boolean exists(Figura f){
		for(int i=0;i<fig.length;i++){
			if(fig[i]==f){
				return true;
			}
		}
		return false;
	}
	
	public Figura[] getFiguras(){
			return fig;
	}
	
	public Ponto[] getCentros(){
		Ponto[] centros = new Ponto[fig.length];
        
        for(int i=0;i<centros.length;i++){
            centros[i]=fig[i].centro();
        }
         
        return centros;
	}
	
	@Override
	public String toString(){
		return "Área máxima"+maxArea();
	}
	
}
