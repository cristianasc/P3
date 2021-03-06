package Aula5;
import java.io.*;
import java.util.Scanner;

public class CSV {
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
			String frase = sc.nextLine();
			nome = frase.substring(0, frase.indexOf('\t'));
			CC = frase.substring(frase.indexOf('\t')+1, frase.lastIndexOf('\t'));
			data = frase.substring(frase.lastIndexOf('\t')+1, frase.length());
			
			
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

	public void write(Pessoa array[], String f){ 
		try {
			File fi = new File(f);
            PrintWriter pw = new PrintWriter(fi);
            pw.println("CSV");
            for(int i=0; i<array.length;i++){
                pw.print(array[i].nome()+ "\t");
                pw.print(array[i].cc()+"\t");
                pw.println(array[i].data().dia()+"/"+array[i].data().mes()+"/"+array[i].data().ano());
                pw.print("\n");
            }
             
            pw.close();
        } 
         
        catch (FileNotFoundException e) {
            System.out.println("Erro!");
            System.exit(1);
        }
	}
}
