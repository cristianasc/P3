package Aula12.pluginsFile;

import java.io.*;
import java.util.Scanner;

import Aula5.Data;
import Aula5.Operacoes;
import Aula5.Pessoa;

public class Nokia implements Operacoes{
	
	public void read(String f) {
		String nome="";
		String CC="";
		String data="";
		File fi = new File(f);
		Scanner sc;
		try {
			sc = new Scanner(fi);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Ficheiro inexistente!");
		}
		while (sc.hasNextLine()){
			sc.nextLine();
			nome = sc.nextLine();
			CC = sc.nextLine();
			data = sc.nextLine();
			int cc = Integer.parseInt(CC);
			int dia= Integer.parseInt(data.substring(0,2));
			int mes= Integer.parseInt(data.substring(4,6));
			int ano= Integer.parseInt(data.substring(7,9));
			new Pessoa(nome,cc,new Data(dia, mes, ano));
			 if(sc.hasNextLine())
	             sc.nextLine();
		}
		sc.close();
	}
	
	
	public void write(Pessoa array[], String f) {
		try {
			File fi = new File(f);
            PrintWriter pw = new PrintWriter(fi);
            pw.println("Nokia");
            for(int i=0; i<array.length;i++){
                pw.println(array[i].nome());
                pw.println(array[i].cc());
                pw.println(array[i].data().dia()+"/"+array[i].data().mes()+"/"+array[i].data().ano());
                pw.println();
            }
             
            pw.close();
        } 
         
        catch (FileNotFoundException e) {
            System.out.println("Erro!");
            System.exit(1);
        }
    }
}