package Aula12;

import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;

import Aula5.Pessoa;
import Aula5.Agenda;

public class Ex3 {
	static Scanner sc = new Scanner(System.in);
	private static ArrayList<IPlugin> plgs = new ArrayList<IPlugin>();
	
	public static void main(String args[]) throws ClassNotFoundException{
		File proxyList = new File("src/Aula12/pluginsFile"); 
		ArrayList<IPluginEx3> plgs = new ArrayList<IPluginEx3>(); 
		for (String f: proxyList.list()) {
			try {
				plgs.add(PluginManagerEx3.load("Aula12.pluginsFile."+f.substring(0,f.lastIndexOf('.')))); 
			}catch (Exception e) { 
				e.printStackTrace();
			} 
		}
		
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
	            		Class<?> c = Class.forName("Nokia");
	            		IPluginEx3 nokia = null;
	            		for(IPluginEx3 rw : plgs){
	            			if(c.getClass() == c)
	            				nokia = rw;
	            		}
	            	
		            	nokia.read(fin);
	            		
	            	}
	            	else if (fin.equals("CSV.txt")){
	            		Class<?> c = Class.forName("CVS");
	            		IPluginEx3 csv = null;
	            		for(IPluginEx3 rw : plgs){
	            			if(c.getClass() == c)
	            				csv = rw;
	            		}
	            	
		            	csv.read(fin);
	            	}
	            	else if (fin.equals("vCard.txt")){
	            		Class<?> c = Class.forName("vCard");
	            		IPluginEx3 vCard = null;
	            		for(IPluginEx3 rw : plgs){
	            			if(c.getClass() == c)
	            				vCard = rw;
	            		}
	            	
		            	vCard.read(fin);
	            	}
	            	else
	            		System.out.println("Não existe esse ficheiro!");
	            	break;
	            case 7:
	            	System.out.print("Insira o nome do ficheiro (Nokia.txt,CSV.txt,vCard.txt):");
	            	sc.nextLine();
	            	String fout = sc.nextLine(); 
	            	if(fout.equals("Nokia")){
	            		Class<?> c = Class.forName("Nokia");
	            		IPluginEx3 nokia = null;
	            		for(IPluginEx3 rw : plgs){
	            			if(c.getClass() == c)
	            				nokia = rw;
	            		}
	            		nokia.write(arr,fout);
	            	}
	            	else if (fout.equals("CSV")){
	            		Class<?> c = Class.forName("CVS");
	            		IPluginEx3 csv = null;
	            		for(IPluginEx3 rw : plgs){
	            			if(c.getClass() == c)
	            				csv = rw;
	            		}
		            	csv.write(arr,fout);
	            	}
	            	else if (fout.equals("vCard")){
	            		Class<?> c = Class.forName("vCard");
	            		IPluginEx3 vCard = null;
	            		for(IPluginEx3 rw : plgs){
	            			if(c.getClass() == c)
	            				vCard = rw;
	            		}
		            	vCard.write(arr,fout);
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