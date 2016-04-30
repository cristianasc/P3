package Aula6;

import java.util.*;
import java.io.*;

public class NovaEmenta {	 
	    final static Scanner sc = new Scanner(System.in);
	     
	    private static Alimento[] alimento = new Alimento[0];
	    private static Prato[] prato = new Prato[0];
	    private static Ementa ementa = new Ementa("Ementa", "UA");
	     
	    public static void main(String[] args) {
	        int opcao;
	        do {
	            do{
	                System.out.println("MENU:");
	                System.out.println("1 - Ingrediente.");
	                System.out.println("2 - Prato.");
	                System.out.println("3 - Ementa");
	                System.out.println("4 - Guardar Ementa em Ficheiro.");
	                System.out.println("5 - Sair.");
	                System.out.print("Opção: ");
	                opcao = sc.nextInt();
	                sc.nextLine();
	            }while(opcao<1 || opcao>5);
	 
	            if(opcao==1){
	                do {
	                	System.out.println("1 - Adicionar Carne.");
	                	System.out.println("2 - Adicionar Peixe.");
	                	System.out.println("3 - Adicionar Cereal.");
	                	System.out.println("4 - Adicionar Legume.");
	                	System.out.print("Opção:");
	                    opcao = sc.nextInt();
	                    sc.nextLine();
	                } while (opcao<1 || opcao>4);
	                if(opcao==1)
	                    addCarne();
	                else if(opcao==2)
	                    addPeixe();
	                else if(opcao==3)
	                    addCereal();
	                else
	                    addLegume();
	            }
	            else if(opcao==2){
	                do {
	                	System.out.println("1 - Criar prato.");
	                	System.out.println("2 - Apagar prato.");
	                	System.out.println("3 - Adicionar ingrediente.");
	                	System.out.println("4 - Remover ingrediente.");
	                	System.out.print("Opção:");
	                    opcao = sc.nextInt();
	                    sc.nextLine();
	                } while (opcao<1 || opcao>4);
	                if(opcao==1)
	                    criarPrato();
	                else if(opcao==2)
	                    apagarPrato();
	                else if(opcao==3)
	                    addIngrediente();
	                else
	                    remIngrediente();
	            }
	            else if (opcao==3){
	                do {
	                	System.out.println("1 - Adicionar prato.");
	                	System.out.println("2 - Remover prato.");
	                	System.out.println("3 - Imprimir ementa.");
	                	System.out.print("Opção:");
	                    opcao = sc.nextInt();
	                    sc.nextLine();
	                } while (opcao<1 || opcao>3);
	                if(opcao==1)
	                    addPrato();
	                if(opcao==2)
	                    remPrato();
	                else
	                    System.out.print(ementa.toString());
	            }
	            else if (opcao==4){
	                    guardarEmenta();             
	            }
	            else
	            	System.out.print("Programa Terminado!");
	        } while (opcao!=5); 
	         
	    }
	     
	    public static void addCarne(){
	        int opcao;
	        do{
	        	System.out.println("Variedade: ");
	        	System.out.println("1 - Vaca");
	        	System.out.println("2 - Porco");
	        	System.out.println("3 - Perú");
	        	System.out.println("4 - Frango");
	        	System.out.println("5 - Outra");
	        	System.out.print("Opção:");
	            opcao=sc.nextInt();
	            sc.nextLine();
	        }while(opcao<1 || opcao>5);
	        System.out.println("Introduza as proteinas do alimento:");
	        double proteinas=sc.nextDouble();
	        sc.nextLine();
	        System.out.println("Introduza as calorias do alimento:");
	        double calorias=sc.nextDouble();
	        sc.nextLine();
	        System.out.println("Introduza o peso do alimento: ");
	        double peso=sc.nextDouble();
	        sc.nextLine();
	        if (opcao==1){
	        	resizeAlimento(new Carne(Carne.VariedadeCarne.vaca,proteinas,calorias,peso));
	        }
	        else if (opcao==2){
		        resizeAlimento(new Carne(Carne.VariedadeCarne.porco,proteinas,calorias,peso));
		    }
	        else if(opcao==3){
		        resizeAlimento(new Carne(Carne.VariedadeCarne.peru,proteinas,calorias,peso));
		    }
	        else if(opcao==4){
		        resizeAlimento(new Carne(Carne.VariedadeCarne.frango,proteinas,calorias,peso));
		    }
	        else{
		        resizeAlimento(new Carne(Carne.VariedadeCarne.outra,proteinas,calorias,peso));
	        }
	    }
	     
	    public static void addPeixe(){
	        int opcao;
	        do{
	            System.out.println("Escolha o tipo de peixe: ");
	            System.out.println("1 - Congelado");
	            System.out.println("2 - Fresco");
	            System.out.print("Opção:");
	            opcao=sc.nextInt();
	            sc.nextLine();
	        }while(opcao<1 || opcao>2);
	        System.out.print("Introduza as proteinas do alimento:");
	        double proteinas=sc.nextDouble();
	        sc.nextLine();
	        System.out.print("Introduza as calorias do alimento:");
	        double calorias=sc.nextDouble();
	        sc.nextLine();
	        System.out.print("Introduza o peso do alimento:");
	        double pessoas=sc.nextDouble();
	        sc.nextLine();
	        if(opcao==1){
	        	resizeAlimento(new Peixe(Peixe.TipoPeixe.congelado,proteinas,calorias,pessoas));
	        }
	        else{
	        	resizeAlimento(new Peixe(Peixe.TipoPeixe.fresco,proteinas,calorias,pessoas));
	        }
	        	
	    }
	     
	    public static void addCereal(){
	         
	        System.out.println("Nome do cereal: ");
	        String nome=sc.nextLine();
	        System.out.println("Introduza as proteinas do alimento:");
	        double proteinas=sc.nextDouble();
	        sc.nextLine();
	        System.out.println("Introduza as calorias do alimento:");
	        double calorias=sc.nextDouble();
	        sc.nextLine();
	        System.out.println("Introduza o peso do alimento:");
	        double peso=sc.nextDouble();
	        sc.nextLine();
	         
	        resizeAlimento(new Cereal(nome,proteinas,calorias,peso));
	    }
	     
	    public static void addLegume(){
	         
	        System.out.print("Nome do legume: ");
	        String nome=sc.nextLine();
	        System.out.print("Introduza as proteinas do alimento:");
	        double proteinas=sc.nextDouble();
	        sc.nextLine();
	        System.out.print("Introduza as calorias do alimento:");
	        double calorias=sc.nextDouble();
	        sc.nextLine();
	        System.out.print("Introduza o peso do alimento:");
	        double peso=sc.nextDouble();
	        sc.nextLine();
	         
	        resizeAlimento(new Legume(nome,proteinas,calorias,peso));
	    }
	     
	    public static void criarPrato(){
	        int opcao;
	        do{
	        	System.out.print("1 - Normal");
	        	System.out.print("2 - Dieta");
	        	System.out.print("3 - Vegetariano");
	        	System.out.print("Opção:");
	            opcao = sc.nextInt();
	            sc.nextLine();
	        }while(opcao<1 || opcao>3);
	        System.out.println("Nome:");
	        String nome = sc.nextLine();
	        if (opcao==1){
	            resizePrato(new Prato(nome));
	        }
	        else if(opcao==2){
	            System.out.print("Máximo de calorias:");
	            int maxCal = sc.nextInt();
	            sc.nextLine();
	            resizePrato(new PratoDieta(nome, maxCal));
	        }
	        else{
	            resizePrato(new PratoVegetariano(nome));
	        }
	    }
	    
	    private static String listarPratos(){
	        String pratos="";
	        for(int i=0;i<prato.length;i++){
	            pratos+="\n"+(i+1)+" - "+prato[i].toString();
	        }
	        return pratos;
	    }
	    
	    private static String listIngredientes(){
	        String alimentos="";
	        for(int i=0;i<alimento.length;i++){
	            alimentos+="\n"+(i+1)+" - "+alimento[i].toString();
	        }
	        return alimentos;
	    }
	     
	    public static void apagarPrato(){
	        int nr;
	        do{
	            System.out.println("Apagar prato número:");
	            System.out.print(listarPratos());
	            System.out.print("Opção:");
	            nr=sc.nextInt();
	            sc.nextLine();
	        }while(nr<1 || nr>prato.length);
	        nr--;
	        Prato[] p = new Prato[prato.length-1];
	        for(int i=0;i<prato.length;i++){
	        	p[nr]=null;
	        }
	        prato = p;
	         
	    }
	 
	    public static void addIngrediente(){
	        int nrPrato;
	        int nrIng;
	        do{
	            System.out.println("Alterar prato núemro:");
	            System.out.print(listarPratos());
	            System.out.print("Opção:");
	            nrPrato=sc.nextInt();
	            sc.nextLine();
	        }while(nrPrato<1 || nrPrato>prato.length);
	        nrPrato--;
	        do{
	            System.out.println("Adicionar ingrediente número:");
	            System.out.print(listIngredientes());
	            System.out.print("Opção:");
	            nrIng=sc.nextInt();
	            sc.nextLine();
	        }while(nrIng<1 || nrIng>alimento.length);
	        nrIng--;
	        if(prato[nrPrato].addIngrediente(alimento[nrIng]))
	            System.out.println("Adicionado com sucesso!");
	        else
	            System.out.println("ERRO!");
	         
	    }
	     
	    public static void remIngrediente(){
	        int nrPrato;
	        int nrIng;
	        do{
	            System.out.print("Alterar parto núemro:");
	            System.out.print(listarPratos());
	            System.out.print("Opção:");
	            nrPrato=sc.nextInt();
	            sc.nextLine();
	        }while(nrPrato<1 || nrPrato>prato.length);
	        nrPrato--;
	        do{
	        	System.out.print("Apagar ingrediente número:");
	            System.out.print(listIngredientes());
	            System.out.print("Opção:");
	            nrIng=sc.nextInt();
	            sc.nextLine();
	        }while(nrIng<1 || nrIng>alimento.length);
	        nrIng--;
	        if(!prato[nrPrato].exists(alimento[nrIng]))
	        	System.out.print("Não existe!");
	        else{
	            prato[nrPrato].del(alimento[nrIng]);
	            System.out.print("Apagado com sucesso!");
	        }
	    }
	     
	    public static void addPrato(){
	        int nrPrato;
	        do{
	        	System.out.println("Adicionar prato número:");
	            System.out.print(listarPratos());
	            System.out.print("Opção:");
	            nrPrato=sc.nextInt();
	            sc.nextLine();
	        }while(nrPrato<1 || nrPrato>prato.length);
	        nrPrato--;
	        int dia;
	        do{
	        	System.out.println("Dia do prato:");
	        	System.out.println("1 - Segunda");
	        	System.out.println("2 - Terça");
	        	System.out.println("3 - Quarta");
	        	System.out.println("4 - Quinta");
	        	System.out.println("5 - Sexta");
	        	System.out.println("6 - Sábado");
	        	System.out.println("7 - Domingo");
	        	System.out.print("Opção:");
	        	dia=sc.nextInt();
	            sc.nextLine();
	        }while(dia<1 || dia>6);
	        dia--;
	        if (dia==1){
	        	ementa.addPrato(prato[nrPrato], Ementa.DiaSemana.Segunda);
	        }
	        else if (dia==2){
	        	ementa.addPrato(prato[nrPrato], Ementa.DiaSemana.Terca);
	        }
	        else if (dia==3){
	        	ementa.addPrato(prato[nrPrato], Ementa.DiaSemana.Quarta);
	        }
	        else if (dia==4){
	        	ementa.addPrato(prato[nrPrato], Ementa.DiaSemana.Quinta);
	        }
	        else if (dia==5){
	        	ementa.addPrato(prato[nrPrato], Ementa.DiaSemana.Sexta);
	        }
	        else if (dia==6){
	        	ementa.addPrato(prato[nrPrato], Ementa.DiaSemana.Sabado);
	        }
	        else if (dia==7){
	        	ementa.addPrato(prato[nrPrato], Ementa.DiaSemana.Domingo);
	        }
	       
	         
	    }
	 
	    public static void remPrato(){
	        int nrPrato;
	        do{
	        	System.out.println("Apagar prato número:");
	            System.out.print(listarPratos());
	            System.out.print("Opção:");
	            nrPrato=sc.nextInt();
	            sc.nextLine();
	        }while(nrPrato<1 || nrPrato>prato.length);
	        nrPrato--;
	        int k;
	        do{
	        	System.out.println("O prato encontra-se no dia");
	        	System.out.println("1 - Segunda");
	        	System.out.println("2 - Terça");
	        	System.out.println("3 - Quarta");
	        	System.out.println("4 - Quinta");
	            System.out.println("5 - Sexta");
	            System.out.println("6 - Sábado");
	            System.out.println("7 - Domingo");
	            System.out.print("Opção:");
	            k=sc.nextInt();
	            sc.nextLine();
	        }while(k<1 || k>6);
	        k--;
	         
	        ementa.remove(prato[nrPrato], k);
	         
	    }
	       
	    public static void guardarEmenta(){
	        String file;
	        File f;
	        System.out.print("Ficheiro:");
	        file = sc.nextLine();
	        f = new File(file);
	         
	        PrintWriter fwriter;
	        try {
	            fwriter = new PrintWriter(f);
	             
	            fwriter.println("Ingredientes:");
	            for(Alimento a: alimento){
	                fwriter.println(a.getClass().getSimpleName()+", Calorias: "+a.TotalCalorias()+", Peso:"+a.peso()+", Proteinas:"+a.TotalProteinas());
	                if(a instanceof Carne){
	                    fwriter.println(", Variedade: "+((Carne)a).var()+".");
	                }
	                if(a instanceof Peixe){
	                    fwriter.println(", Tipo: "+((Peixe)a).tipo()+".");
	                }
	                if(a instanceof Cereal){
	                    fwriter.println(", Cereal: "+((Cereal)a).nomeCereal()+".");
	                }
	                if(a instanceof Legume){
	                    fwriter.println(", Legume: "+((Legume)a).nomeLegume()+".");
	                }
	            }
	     
	            fwriter.println();
	            fwriter.println("Pratos:");
	            for(Prato p: prato){
	                if(p instanceof PratoDieta){
	                    p = (PratoDieta)p;
	                    fwriter.println("Prato de Dieta: \nMáximo de Calorias: "+((PratoDieta) p).maxCalorias()+", Nome:"+((PratoDieta) p).nomePrato()+".");
	                    for(Alimento a: p.Alimentos()){
	                    	fwriter.println(a.getClass().getSimpleName()+", Calorias: "+a.TotalCalorias()+", Peso:"+a.peso()+", Proteinas:"+a.TotalProteinas());
	    	                if(a instanceof Carne){
	    	                    fwriter.println(", Variedade: "+((Carne)a).var()+".");
	    	                }
	    	                if(a instanceof Peixe){
	    	                    fwriter.println(", Tipo: "+((Peixe)a).tipo()+".");
	    	                }
	    	                if(a instanceof Cereal){
	    	                    fwriter.println(", Cereal: "+((Cereal)a).nomeCereal()+".");
	    	                }
	    	                if(a instanceof Legume){
	    	                    fwriter.println(", Legume: "+((Legume)a).nomeLegume()+".");
	    	                }
	                    }
	                }
	                else if(p instanceof PratoVegetariano){
	                    p = (PratoVegetariano)p;
	                    fwriter.println("Prato Vegetariano: "+((PratoVegetariano) p).nomePrato());
	                    for(Alimento a: p.Alimentos()){
	                    	fwriter.println(a.getClass().getSimpleName()+", Calorias: "+a.TotalCalorias()+", Peso:"+a.peso()+", Proteinas:"+a.TotalProteinas());
	    	                if(a instanceof Carne){
	    	                    fwriter.println(", Variedade: "+((Carne)a).var()+".");
	    	                }
	    	                if(a instanceof Peixe){
	    	                    fwriter.println(", Tipo: "+((Peixe)a).tipo()+".");
	    	                }
	    	                if(a instanceof Cereal){
	    	                    fwriter.println(", Cereal: "+((Cereal)a).nomeCereal()+".");
	    	                }
	    	                if(a instanceof Legume){
	    	                    fwriter.println(", Legume: "+((Legume)a).nomeLegume()+".");
	    	                }
	                    }
	                }
	                else{
	                    fwriter.println("Prato Normal: "+p.nomePrato());
	                    for(Alimento a: p.Alimentos()){
	                    	fwriter.println(a.getClass().getSimpleName()+", Calorias: "+a.TotalCalorias()+", Peso:"+a.peso()+", Proteinas:"+a.TotalProteinas());
	    	                if(a instanceof Carne){
	    	                    fwriter.println(", Variedade: "+((Carne)a).var()+".");
	    	                }
	    	                if(a instanceof Peixe){
	    	                    fwriter.println(", Tipo: "+((Peixe)a).tipo()+".");
	    	                }
	    	                if(a instanceof Cereal){
	    	                    fwriter.println(", Cereal: "+((Cereal)a).nomeCereal()+".");
	    	                }
	    	                if(a instanceof Legume){
	    	                    fwriter.println(", Legume: "+((Legume)a).nomeLegume()+".");
	    	                }
	                    }
	                }
	            }
	            fwriter.println();
	            fwriter.println("Ementa:");
	            for(int k=0;k<7;k++){
	                fwriter.println("d"+k);
	                fwriter.println("Pratos:");
	                for(Prato p: ementa.getPratPorDia(k)){
	                    if(p instanceof PratoDieta){
	                        p = (PratoDieta)p;
	                        fwriter.println("Prato de Dieta: "+((PratoDieta) p).maxCalorias()+", Nome: "+((PratoDieta) p).nomePrato());
	                        for(Alimento a: p.Alimentos()){
	                        	fwriter.println(a.getClass().getSimpleName()+", Calorias: "+a.TotalCalorias()+", Peso:"+a.peso()+", Proteinas:"+a.TotalProteinas());
		    	                if(a instanceof Carne){
		    	                    fwriter.println(", Variedade: "+((Carne)a).var()+".");
		    	                }
		    	                if(a instanceof Peixe){
		    	                    fwriter.println(", Tipo: "+((Peixe)a).tipo()+".");
		    	                }
		    	                if(a instanceof Cereal){
		    	                    fwriter.println(", Cereal: "+((Cereal)a).nomeCereal()+".");
		    	                }
		    	                if(a instanceof Legume){
		    	                    fwriter.println(", Legume: "+((Legume)a).nomeLegume()+".");
		    	                }
	                        }
	                    }
	                    else if(p instanceof PratoVegetariano){
	                        p = (PratoVegetariano)p;
	                        fwriter.println("Prato Vegetariano: Nome: "+((PratoVegetariano) p).nomePrato());
	                        for(Alimento a: p.Alimentos()){
	                        	fwriter.println(a.getClass().getSimpleName()+", Calorias: "+a.TotalCalorias()+", Peso:"+a.peso()+", Proteinas:"+a.TotalProteinas());
		    	                if(a instanceof Carne){
		    	                    fwriter.println(", Variedade: "+((Carne)a).var()+".");
		    	                }
		    	                if(a instanceof Peixe){
		    	                    fwriter.println(", Tipo: "+((Peixe)a).tipo()+".");
		    	                }
		    	                if(a instanceof Cereal){
		    	                    fwriter.println(", Cereal: "+((Cereal)a).nomeCereal()+".");
		    	                }
		    	                if(a instanceof Legume){
		    	                    fwriter.println(", Legume: "+((Legume)a).nomeLegume()+".");
		    	                }
	                        }
	                    }
	                    else{
	                        fwriter.println("Prato Normal: "+p.nomePrato());
	                        for(Alimento a: p.Alimentos()){
	                        	fwriter.println(a.getClass().getSimpleName()+", Calorias: "+a.TotalCalorias()+", Peso:"+a.peso()+", Proteinas:"+a.TotalProteinas());
		    	                if(a instanceof Carne){
		    	                    fwriter.println(", Variedade: "+((Carne)a).var()+".");
		    	                }
		    	                if(a instanceof Peixe){
		    	                    fwriter.println(", Tipo: "+((Peixe)a).tipo()+".");
		    	                }
		    	                if(a instanceof Cereal){
		    	                    fwriter.println(", Cereal: "+((Cereal)a).nomeCereal()+".");
		    	                }
		    	                if(a instanceof Legume){
		    	                    fwriter.println(", Legume: "+((Legume)a).nomeLegume()+".");
		    	                }
	                        }
	                    }
	                }
	            }
	 
	            fwriter.close();
	        } catch (FileNotFoundException e) {
	            System.out.print("Ficheiro não encontrado!");
	        }
	         
	         
	    }
	    
	    private static void resizeAlimento(Alimento a){
	        Alimento []c = new Alimento[alimento.length+1];
	        for(int i=0;i<alimento.length;i++){
	            c[i]=alimento[i];
	        }
	        c[alimento.length]=a;
	        alimento = c;
	    }
	     
	    private static void resizePrato(Prato p){
	        Prato []c = new Prato[prato.length+1];
	        for(int i=0;i<prato.length;i++){
	            c[i]=prato[i];
	        }
	        c[prato.length]=p;
	        prato = c;
	    }
 }

