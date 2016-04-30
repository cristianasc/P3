package Aula11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex1b {

		public static void main(String[] args) throws FileNotFoundException {
			System.out.println("Ficheiro a ler: ");
			Scanner sc = new Scanner(System.in);
			String ficheiro = sc.next();
			sc.close();
			FileWordsCounter fwc = FileWordsCounter.file(new File(ficheiro));
			
			System.out.println("Número Total de Palavras: " + fwc.getNumberOfWords());
			System.out.println("Número de Diferentes Palavras: " + fwc.getNumberOfDiferentWords());
		}

	}