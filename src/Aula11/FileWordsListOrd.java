package Aula11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class FileWordsListOrd{
	private static TreeMap<String, Integer> hash = new TreeMap<>();
	private Integer numberOfWords = 1;
	
	private FileWordsListOrd(File file) throws FileNotFoundException{
		Scanner reader = new Scanner(file);
		while(reader.hasNext()){
			String word = reader.next();
			if(!hash.containsKey(word))
				hash.put(word, numberOfWords);
			else{
				int number = hash.get(word);
				number++;
				hash.put(word, number);
			}
		}
		reader.close();
	}
	
	public static FileWordsListOrd file(File file) throws FileNotFoundException{
		return new FileWordsListOrd(file);
	}
	
	public static void key(){
		for (Entry<String, Integer> entry : hash.entrySet()) {
		    String key = entry.getKey();
		    Object value = entry.getValue();
		    System.out.println(key + "\t" + value);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberOfWords == null) ? 0 : numberOfWords.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileWordsListOrd other = (FileWordsListOrd) obj;
		if (numberOfWords == null) {
			if (other.numberOfWords != null)
				return false;
		} else if (!numberOfWords.equals(other.numberOfWords))
			return false;
		return true;
	}
}
