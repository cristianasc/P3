package Aula13;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Ex2 {
	public static void main(String[] args) {
		SortedMap<String,Map<String, Integer>> h = new TreeMap<>();
		
		File f = new File("Policarpo.txt");
		Scanner readf = null;
		try {
			readf = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Ficheiro não encontrado.");
            System.exit(1);
		}
		
		String line = readf.next().toLowerCase();
		while(readf.hasNext()){ 
			String nLine= readf.next().toLowerCase();
			for(String l : nLine.split("[\t||\n||.||,||:||'||,||;||?||!||-||*||{||}||=||+||&||/||(||)||[||]||\"||'||“||”||‘||’]")){
				if (l.length()>=3){
					if (h.containsKey(line)){
                        Map <String, Integer> s = h.get(line);
                        if (s.containsKey(l)){
                            s.put(l, s.get(l)+1);
                        }
                        else{
                            s.put(l, 1);
                        }
     
                    }
                    else{
                        Map <String, Integer> s = new HashMap<>();
                        s.put(l,1);
                        h.put(line, s);
                    }
                    line=l;
                }
            }
        }
         
        readf.close();
        for (Entry<String, Map<String, Integer>> s: h.entrySet()){
        	System.out.println(s);
        }
	}
}

