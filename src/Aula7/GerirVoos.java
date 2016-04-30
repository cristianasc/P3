package Aula7;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class GerirVoos{
	public static void main(String[] args) {
	    AssociativeArray<String> companhias = new AssociativeArray<String>(30);
	    Stack<Voo> voo = new Stack<Voo>();
	    readCompanhias(companhias);
	    readVoo(voo, companhias);
	    System.out.print(printVoos(voo));
	    guardarVoos(voo);
	    guardarCidades(voo);
	    guardarVoosBinario(voo);
	    lerVoosBinario();
	    
		
	}
	
	public static void readCompanhias(AssociativeArray<String> companhias){
		File file = new File("companhias.txt");
		Scanner sc;
		
		try{
			sc = new Scanner(file);
			sc.nextLine();
			while(sc.hasNextLine()){
				String comp = sc.nextLine();
				String[] companhia = comp.split("\t");
				if (companhia==null) break;
				else companhias.set(companhia[0], companhia[1]);	
			}
			sc.close();
			
		}catch(FileNotFoundException e){
			System.out.print("Ficheiro não encontrado");
		}
	}
	
	
	
	public static void readVoo(Stack<Voo> voo, AssociativeArray<String> companhias){
        File file = new File("voos.txt");
        Scanner sc;
        
        try{
        	
        	sc = new Scanner(file);
        	sc.nextLine();
        	while(sc.hasNextLine()){
        		String informacao = sc.nextLine();
        		String[] info = informacao.split("\t");
        		if (info==null) break;
        		if (info.length==3){
        			voo.push(new Voo(new Hora(Integer.parseInt(info[0].split(":")[0]),Integer.parseInt(info[0].split(":")[1])),info[1],companhias.get(info[1].substring(0, 2)),info[2]));
        		}
        		else
        			voo.push(new Voo(new Hora(Integer.parseInt(info[0].split(":")[0]),Integer.parseInt(info[0].split(":")[1])),info[1],companhias.get(info[1].substring(0, 2)),info[2],new Hora(Integer.parseInt(info[3].split(":")[0]),Integer.parseInt(info[3].split(":")[1]))));	
        	}
        		
        	
        sc.close();
        
        } catch (FileNotFoundException e) {
            System.out.print("Ficheiro não encontrado!");
        	}
	}
	
	public static String printVoos(Stack<Voo> voo){
		String str = "Hora  Voo      Companhia           Origem               Atraso Obs\n";
		Object[] s = voo.totalStack();
        for(int i=s.length-1;i>=0;i--){
            str+=(Voo)s[i]+"\n";
        }
		
		return str;
	}
	
	public static void guardarVoos(Stack<Voo> voo){
		File file = new File("Infopublico.txt");
		PrintWriter sc;
		try{
			sc = new PrintWriter(file);
			sc.print(printVoos(voo));
			sc.close();
			
		}catch(IOException e){
			System.out.print("ERRO!");
		}
	}
	
	public static void guardarCidades(Stack<Voo> voo){
		File file = new File("cidades.txt");
        PrintWriter sc;
         
        try{
            sc = new PrintWriter(file);
            int max;
            String cid;
            HashMap<String, Integer> h = num(voo);
            int size=h.size();
            sc.println("Origem    Voos");
            for(int i=0;i<size;i++){
                max = 0;
                cid = "";
                for(String s : h.keySet()){
                    if(h.containsKey(s)){
                        if(h.get(s)>max){
                            max = h.get(s);
                            cid = s;
                        }
                    }
                }
                h.remove(cid);
                sc.println(cid+": "+max);
            }
             
            sc.close();
        }
        catch(IOException e){
            System.out.println("ERRO!");
        }
         
    }
	
	private static HashMap<String, Integer> num(Stack<Voo> voo){
        HashMap<String, Integer> h= new HashMap<String, Integer>();
        
        Object[] n = voo.totalStack();
        for(int i=n.length-1;i>=0;i--){
            int j=0;
            if(h.containsKey(((Voo)n[i]).origem())){
                  j=h.get(((Voo)n[i]).origem());
            }
            h.put(((Voo)n[i]).origem(), j+1);
        }
 
        return h;
    }
	
	
	public static void guardarVoosBinario(Stack<Voo> voo){
        Path p = Paths.get("/Users/cristianacarvalho/Desktop/UA/2º Ano/P3/P3/Infopublico.bin");
        try{
            Files.write(p, printVoos(voo).getBytes()); 
        }
        catch(IOException e){
        	 System.out.println("ERRO!");
        }
    }
     
    public static byte[] lerVoosBinario(){
        try {
            RandomAccessFile file = new RandomAccessFile("Infopublico.bin", "rw");
            byte []b = new byte[(int) file.length()];
            file.read(b);
            return b;
        } catch (IOException  e) {
        	System.out.println("ERRO!");
        }
        return new byte[0];
    }
	
}
