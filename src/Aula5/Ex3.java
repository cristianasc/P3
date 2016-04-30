package Aula5;

import java.util.Scanner;

public class Ex3 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		Agenda agenda = new Agenda();
		Pessoa[] arr = new Pessoa[0];
		int a;
        do{
        	
        	System.out.println("1 - Adicionar.");
        	System.out.println("2 - Eliminar.");
        	System.out.println("3 - Listar.");
        	System.out.println("4 - Ordenar a lista por Nome.");
        	System.out.println("5 - Ordenar a lista por cc.");
        	System.out.println("6 - Listar de um ficheiro.");
        	System.out.println("7 - Adicionar um ficheiro.");
        	System.out.println("8 - Sair.");
        	a = sc.nextInt();
        	sc.nextLine();
         
	        switch(a){
	            case 1:
	            	arr = agenda.addPessoa(arr); break;
	            case 2:
	                arr = agenda.delPessoa(arr); break;
	            case 3:
	            	agenda.list(arr); break;
	            case 4:
	                agenda.ordenarNome(arr); break;
	            case 5:
	                agenda.ordenarcc(arr); break;
	            case 6:
	            	System.out.print("Insira o nome do ficheiro (Nokia.txt,CSV.txt,vCard.txt):");
	            	String fin = sc.nextLine(); 
	            	if(fin.equals("Nokia.txt")){
	            		Nokia n = new Nokia();
	            		n.read(fin);
	            	}
	            	else if (fin.equals("CSV.txt")){
		            	CSV n = new CSV();
		            	n.read(fin);
	            	}
	            	else if (fin.equals("vCard.txt")){
		            	vCard n = new vCard();
		            	n.read(fin);
	            	}
	            	else
	            		System.out.println("Não existe esse ficheiro!");
	            	break;
	            case 7:
	            	System.out.print("Insira o nome do ficheiro (Nokia.txt,CSV.txt,vCard.txt):");
	            	sc.nextLine();
	            	String fout = sc.nextLine(); 
	            	if(fout.equals("Nokia")){
	            		Nokia n = new Nokia();
	            		n.write(arr,fout);
	            	}
	            	else if (fout.equals("CSV")){
		            	CSV n = new CSV();
		            	n.write(arr,fout);
	            	}
	            	else if (fout.equals("vCard")){
		            	vCard n = new vCard();
		            	n.write(arr,fout);
	            	}
	            	else
	            		System.out.println("Não existe esse ficheiro!");
	            	break;
	            case 8:
	                break;
	            }
        }while(a!=8);
	}
}
