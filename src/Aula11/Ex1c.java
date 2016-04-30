package Aula11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex1c {
		public static void main(String[] args) throws FileNotFoundException {
			System.out.println("Ficheiro a ler: ");
			Scanner sc = new Scanner(System.in);
			String ficheiro = sc.next();
			sc.close();
			FileWordsList fwc = FileWordsList.file(new File(ficheiro));
			
			fwc.key();
		
		}
}
