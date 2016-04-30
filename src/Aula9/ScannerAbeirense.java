package Aula9;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScannerAbeirense implements Iterator<String>, Closeable{
	private Scanner sc;
	private String frase;
	private File file;
	
	public ScannerAbeirense(String frase){
		sc = new Scanner(frase);
	}
	
	public ScannerAbeirense(File file) throws FileNotFoundException{
		sc = new Scanner(file);
	
	}
	
	public String troca(String frase){
		System.out.print(frase);
		frase = frase.replace('V', 'B');
		frase = frase.replace('v', 'b');
		
		return frase;
	}
	
	
	@Override
	public void close() throws IOException {
		sc.close();
	}

	@Override
	public boolean hasNext() {
		return sc.hasNext();
	}

	@Override
	public String next() {
		return troca(sc.next());
	}
	
	public String nextLine() {
		return troca(sc.nextLine());
	}

	@Override
	public void remove() {
		
	}
	
	
	
	
}
