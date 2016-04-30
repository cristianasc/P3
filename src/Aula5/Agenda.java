package Aula5;
import java.util.*;

public class Agenda {
	static Scanner sc = new Scanner(System.in);
	
	public Pessoa[] addPessoa(Pessoa[] arr){
		System.out.print("Introduza o seu nome:");
		String nome = sc.nextLine();
		System.out.print("Introduza o seu número de cartão:");
		int cc = sc.nextInt();
		System.out.print("Introduza o ano em que nasceu:");
		int ano = sc.nextInt();
		System.out.print("Introduza o mes em que nasceu:");
		int mes = sc.nextInt();
		System.out.print("Introduza o dia em que nasceu:");
		int dia = sc.nextInt();
		
		Data d = new Data(dia,mes,ano);
		Pessoa p = new Pessoa(nome,cc,d);
		
		Pessoa arr2[]= new Pessoa[arr.length+1];
		for(int i=0; i<arr.length;i++){
			arr2[i]=arr[i];
		}
		arr2[arr.length]= p;
		return arr2;
	} 
	
	public Pessoa[] delPessoa(Pessoa[] arr){
		System.out.print("Número de CC da pessoa que deseja apagar:");
		int cc = sc.nextInt();
		
		for(int i=0; i<arr.length;i++){
			if (arr[i].cc()==cc)
				arr[i] = null;
		}
		return arr;
	}
	
	public void list(Pessoa[] arr){
		
		System.out.println("Listagem:");
		for(int i=0; i<arr.length;i++)
			System.out.println(arr[i].nome()+", "+arr[i].cc() +", "+arr[i].data().toString());
	}
	
	public void ordenarNome(Pessoa[] arr){
		Pessoa temp;
        boolean ord = false;
        int f = arr.length-1;
        do{
            ord = false;
            for(int i=0;i<f;i++){
                if(arr[i] != null && arr[i].nome().compareTo(arr[i+1].nome())>0){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    ord = true;
                }
            }
            f--;
        }while(ord);
	}
	
	public void ordenarcc(Pessoa[] arr){
		Pessoa temp;
        boolean ord = false;
        int f = arr.length-1;
        do{
        	ord = false;
            for(int i=0;i<f;i++){
                if(arr[i] != null && arr[i].cc()>arr[i+1].cc()){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    ord = true;
                }
            }
            f--;
        }while(ord);
	}
	
}
