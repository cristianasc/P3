package Aula12;


import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ex1 {
	static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
    	
    	List<Object> list = new ArrayList<>();
        
        Class<?> c = Class.forName("Aula4.Circulo");
        System.out.println("Nome: "+c.getSimpleName());
        
        for(Class<?> cl : c.getInterfaces()){
            System.out.println("Interface: "+cl.getSimpleName());
        }
        
        System.out.println("Superclasse: "+c.getSuperclass());
        
        for(Constructor<?> cl : c.getConstructors()){
            System.out.println("Construtor: "+cl.getName());
        }
        
        for(Method cl : c.getMethods()){
            System.out.println("Métodos: "+cl.getName());
        }
        
        for(Field cl : c.getFields()){
            System.out.println("Atributos (public): "+cl.getName());
        }
        
        for(Field cl : c.getDeclaredFields()){
            System.out.println("Atributos (private): "+cl.getName());
        }
        
        int escolha;
        boolean end=false;
        do{
            do{
                System.out.println("Qual o construtor que queres utilizar?");
                int i=1;
                for(Constructor<?> cl : c.getConstructors()){
                    System.out.println("Construtor "+ i +": "+cl.getName());
                    i++;
                }
                System.out.println("Sair ("+ i +")");
                System.out.print("Escolha: ");
                escolha = sc.nextInt();
                sc.nextLine();
                if(escolha==i)
                    end=true;
            }while(escolha<1 || escolha>c.getConstructors().length+1);
            
            if(!end){
                Constructor <?> c1 = c.getConstructors()[escolha-1];
                
                Class <?>[] paramT=c1.getParameterTypes(); 
                Object []arg=new Object[paramT.length];
                
                for(int i=0; i < paramT.length; i++){
        			System.out.print((paramT[i]).getSimpleName()+": ");
        			
        			switch(paramT[i].getSimpleName()){
        				case "double":
        					arg[i] = sc.nextDouble();
        					break;
        				case "int":
        					arg[i] = sc.nextInt();
        					break;
        				case "char":
        					arg[i] = sc.next().charAt(0);
        					break;
        				case "String":
        					arg[i] = sc.next();
        					break;
        			}
        		}
                
                Object ins = c1.newInstance(arg);
                list.add(ins);
            }
        }while(!end);
        list.forEach(System.out::println);
        end=false;
        
        do{
            do{
                System.out.println("\nEscolha um objeto criado: ");
                Iterator<Object> itOb=list.iterator();
                int i=1;
                while(itOb.hasNext()){
                    System.out.println(String.valueOf(itOb.next())+" ("+i+")");
                    i++;
                }
                System.out.println("Sair ("+i+")");
                System.out.println("Escolha:");
                escolha =sc.nextInt();
                sc.nextLine();
                if(escolha==i)
                    end=true;
            }while(escolha<1 || escolha>1+list.size());
           
            int escolha2;
            if(!end){
                System.out.println("\nEscolha um método: ");
                int i=1;
                for(Method m: c.getMethods()){
                    System.out.println(m.getName()+" ("+i+")");
                    i++;
                }
                System.out.println("Sair ("+i+")");
                System.out.println("Escolha:");
                escolha2 =sc.nextInt();
                sc.nextLine();
                 
                Method m = c.getMethods()[escolha2-1];
                m.setAccessible(true);
                
                Class <?>[] paramT=m.getParameterTypes(); 
                Object []arg=new Object[paramT.length];
                
                for(int j=0; j < paramT.length; j++){
        			System.out.print((paramT[j]).getSimpleName()+": ");
        			
        			switch(paramT[j].getSimpleName()){
        				case "double":
        					arg[j] = sc.nextDouble();
        					break;
        				case "int":
        					arg[j] = sc.nextInt();
        					break;
        				case "char":
        					arg[j] = sc.next().charAt(0);
        					break;
        				case "String":
        					arg[j] = sc.next();
        					break;
        			}
        		}
                 
                m.invoke(list.get(escolha2-1),arg);
            }
        }while(!end);
    }
}
