package Aula8Ex2;
import java.io.*;
import java.util.*;

public class InfoFile {
	
		private LinkedList<Pergunta> array = new LinkedList<Pergunta>();
		
		public InfoFile(File file) throws FileNotFoundException{
				FileReader fileReader = new FileReader(file);
				Scanner reader = new Scanner(fileReader);
				while(reader.hasNextLine()){
					parseLine(reader.nextLine());
				}
		}
		
		private void parseLine(String line){
			String[] atributos = line.split("&&");
			String options[] = {atributos[2], atributos[3], atributos[4], atributos[5]};
			array.add(new Pergunta(atributos[6],atributos[1], atributos[0], options, atributos[2]));
		}
		
		public Pergunta[] getAsks(){
			return array.toArray(new Pergunta[0]);
		}
}
