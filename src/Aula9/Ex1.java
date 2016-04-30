package Aula9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ex1 {
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduza a frase:");
		String frase = sc.nextLine();
		ScannerAbeirense scanner = new ScannerAbeirense(frase);
		System.out.print(scanner.nextLine());
		
		File ficheiro = new File("test.txt");
		ScannerAbeirense fich = new ScannerAbeirense(ficheiro);
		
		while(fich.hasNext()){
			System.out.print(fich.nextLine());
		}
		
		fich.close();
	}
}
