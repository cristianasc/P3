package Aula9;

import java.util.Calendar;

public class Data {
		private int dia;
		private int mes;
		private int ano; 
		
		public Data(int dia, int mes, int ano){
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
		
		public int dia(){
	        return dia;
	    }
	     
	    public int mes(){
	        return mes;
	    }
	     
	    public int ano(){
	        return ano;
	    }
	    
	    public String toString(){
	        return this.dia+"-"+this.mes+"-"+this.ano;
	    }
	    
	    public static Data today(){
			Calendar hoje = Calendar.getInstance();
			return new Data(hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH), hoje.get(Calendar.YEAR));
		}
	    
	    public int Idade(){
	        Calendar today = Calendar.getInstance();
	        int idade = today.get(Calendar.YEAR)-this.ano;
	        if(today.get(Calendar.MONTH)<this.mes) return idade;
	        else if(today.get(Calendar.MONTH)>this.mes) return idade-1;
	        else{
	            if(today.get(Calendar.DAY_OF_MONTH)<=this.dia) return idade;
	            else return idade-1;
	        }
	    }
}