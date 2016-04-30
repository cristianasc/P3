package Aula2;
import java.util.*;

public class Ex1 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		Estudante[] arrEstudante = new Estudante[0];
		Funcionario[] arrFuncionario = new Funcionario[0]; 
		Videos[] arrVideo = new Videos[0];
		Emprestimo[] arrEmprestimo = new Emprestimo[0];
		int count=0;
		
		System.out.print("Quotas de empréstimo:");
        int quotas =sc.nextInt();
        sc.nextLine();
		
		int a;
	    do{
	    	
	    	System.out.println("1 - Adicionar utilizador.");
	    	System.out.println("2 - Eliminar utilizador.");
	    	System.out.println("3 - Adicionar video.");
	    	System.out.println("4 - Eliminar video.");
	    	System.out.println("5 - Verificar disponibilidade de video no catálogo.");
	    	System.out.println("6 - Efetuar empréstimo.");
	    	System.out.println("7 - Efetuar devolução.");
	    	System.out.println("8 - Identificar utilizador que requisitou determinado video.");
	    	System.out.println("9 - Listar videos diponiveis para determinado utilizador.");
	    	System.out.println("10 - Listar os videos por rating.");
	    	System.out.println("11 - Listar histório de videos requisitados por utilizador.");
	    	System.out.println("12 - Sair.");
	    	a = sc.nextInt();
	    	sc.nextLine();
	     
	        switch(a){
	            case 1:
	            	System.out.print("Tipo de utilizador:");
	            	String tipo = sc.nextLine();
	            	if (tipo.equals("estudante"))
	            		arrEstudante = addEstudante(arrEstudante);
	            	else if (tipo.equals("funcionario"))
	            		arrFuncionario = addFuncionario(arrFuncionario);
	            	else 
	            		System.out.print("Tipo inválido!");
	            	break;
	            case 2:
	            	System.out.print("Tipo de utilizador:");
	            	tipo = sc.nextLine();
	            	if (tipo.equals("estudante"))
	            		arrEstudante = delEstudante(arrEstudante);
	            	else if (tipo.equals("funcionario"))
	            		arrFuncionario = delFuncionario(arrFuncionario);
	            	else 
	            		System.out.print("Tipo inválido!");
	            	break;
	            case 3:
	            	arrVideo = addVideo(arrVideo); break;
	            case 4:
	            	arrVideo = delVideo(arrVideo); break;
	            case 5:
	                 listVideos(arrVideo); break;
	            case 6:
	                 arrEmprestimo = checkout(arrEmprestimo, arrEstudante, arrFuncionario, arrVideo, quotas, count); break;
	            case 7:
	                 arrEmprestimo = checkin(arrEmprestimo, arrVideo); break;
	            case 8:
	                 listUtiReq(arrEmprestimo); break;
	            case 9:
	            	listVideoDisp(arrVideo,arrEmprestimo,arrEstudante,arrFuncionario); break;
	            case 10:
	                 listRating(arrVideo); break;
	            case 11:
	                 listHistorico(arrEstudante,arrFuncionario); break;
	            }
	    }while(a!=12);
	}
	
	private static Estudante[] addEstudante(Estudante[] arr){
		System.out.print("Nome de utilizador:");
		String nome = sc.nextLine();
		
		System.out.print("Data de Nascimento (dd-mm-aaaa):");
		String dataNas = sc.nextLine();
		int diaN = Integer.parseInt(dataNas.substring(0, 1));
		int mesN = Integer.parseInt(dataNas.substring(3, 4));
		int anoN = Integer.parseInt(dataNas.substring(7));
		
		System.out.print("Data de Inscrição: (dd-mm-aaaa):");
		String dataInsc = sc.nextLine();
		int diaI = Integer.parseInt(dataInsc.substring(0, 1));
		int mesI = Integer.parseInt(dataInsc.substring(3, 4));
		int anoI = Integer.parseInt(dataInsc.substring(7));
		
		System.out.print("CC:");
		int cc = sc.nextInt();
		
		System.out.print("Curso:");
		String curso = sc.nextLine();
		
		sc.nextLine();
		
		System.out.print("Número Mecanográfico:");
		int mec = sc.nextInt();

		System.out.println("Estudante adicionado com sucesso!");
		
		Data dataNasc = new Data(diaN,mesN,anoN);
		Data dataI = new Data(diaI,mesI,anoI);
		Estudante e = new Estudante(mec,curso,nome,cc,dataI,dataNasc);
		
		Estudante arr2[]= new Estudante[arr.length+1];
		for(int i=0; i<arr.length;i++){
			arr2[i]=arr[i];
		}
		arr2[arr.length]= e;
		return arr2;
	}
	
	private static Funcionario[] addFuncionario(Funcionario[] arr){
		System.out.print("Nome de utilizador:");
		String nome = sc.nextLine();
		
		System.out.print("Data de Nascimento (dd-mm-aaaa):");
		String dataNas = sc.nextLine();
		int diaN = Integer.parseInt(dataNas.substring(0, 1));
		int mesN = Integer.parseInt(dataNas.substring(3, 4));
		int anoN = Integer.parseInt(dataNas.substring(7));
		
		System.out.print("Data de Inscrição: (dd-mm-aaaa):");
		String dataInsc = sc.nextLine();
		int diaI = Integer.parseInt(dataInsc.substring(0, 1));
		int mesI = Integer.parseInt(dataInsc.substring(3, 4));
		int anoI = Integer.parseInt(dataInsc.substring(7));
		
		System.out.print("CC:");
		int cc = sc.nextInt();
		
		System.out.print("Número de Funcionário:");
		int nrFunc = sc.nextInt();
		
		System.out.print("NIF:");
		int nif = sc.nextInt();
		
		System.out.println("Funcionário adicionado com sucesso!");
		
		Data dataNasc = new Data(diaN,mesN,anoN);
		Data dataI = new Data(diaI,mesI,anoI);
		Funcionario e = new Funcionario(nrFunc,nif,nome,cc,dataI,dataNasc);
		
		Funcionario arr2[]= new Funcionario[arr.length+1];
		for(int i=0; i<arr.length;i++){
			arr2[i]=arr[i];
		}
		arr2[arr.length]= e;
		return arr2;
	}
	
	
	private static Estudante[] delEstudante(Estudante[] arr){
		System.out.print("Número de CC do estudante que deseja eliminar: ");
		int cc = sc.nextInt();
		
		for(int i=0;i<arr.length;i++){
			if (arr[i].cc()==cc)
				arr[i]=null;
		}
		return arr;
	}
	
	private static Funcionario[] delFuncionario(Funcionario[] arr){
		System.out.print("Número de CC do estudante que deseja eliminar: ");
		int cc = sc.nextInt();
		
		for(int i=0;i<arr.length;i++){
			if (arr[i].cc()==cc)
				arr[i]=null;
		}
		return arr;
	}
	
	private static Videos[] addVideo(Videos[] arr){
		System.out.print("Titulo do video:");
		String nome = sc.nextLine();
		
		System.out.print("Categoria do video:");
		String categoria = sc.nextLine();
		
		System.out.print("Idade:");
		String idade = sc.nextLine();
		
		Videos video = new Videos(nome,categoria,idade);
		
		Videos arr2[]= new Videos[arr.length+1];
		for(int i=0; i<arr.length;i++){
			arr2[i]=arr[i];
		}
		arr2[arr.length]= video;
		return arr2;
	}
	
	private static Videos[] delVideo(Videos[] arr){
		System.out.print("Número do ID do video que deseja eliminar: ");
		int id = sc.nextInt();
		
		for(int i=0;i<arr.length;i++){
			if (arr[i].ID()==id)
				arr[i]=null;
		}
		return arr;
	}
	
	private static void listVideos(Videos[] arr){
		System.out.print("Nome do filme:");
		String nome = sc.nextLine();
		
		for(int i=0; i<arr.length;i++){
			if (arr[i].titulo() == nome)
				System.out.print("Existe no catálogo!");
			else
				System.out.print("Não existe no catálogo!");
		}
		
	}
	
	private static Emprestimo[] checkin(Emprestimo[] arr, Videos[] arr1){
		System.out.print("Número de sócio:");
		int nrSocio = sc.nextInt();
		System.out.print("ID do filme a devolver:");
		int id = sc.nextInt();
		
		System.out.print("Rating (1 a 10):");
		int rating = sc.nextInt();
		
		for(int i=0;i<arr1.length;i++){
			arr1[i].ratingTotal(rating);
		}
		
		for(int i=0;i<arr.length;i++){
			if ((arr[i].ID() == id) && (arr[i].nrSocio() == nrSocio))
				arr[i]=null;
		}
		return arr;
	}
	
	
	
	private static Emprestimo[] checkout(Emprestimo[] arr, Estudante[] arr1, Funcionario[] arr2, Videos[] arr3, int quotas, int count){
		System.out.print("Número de sócio:");
		int nrSocio = sc.nextInt();
		System.out.print("ID do filme a requisitar:");
		int id = sc.nextInt();
		
		for(int i=0; i<arr.length;i++){
			if (arr[i].nrSocio()==nrSocio){
				count++;
			}
		}
		if(count==quotas){
			System.out.print("Não é possivel requisitar mais livros.");
		}
		
		for(int i=0; i<arr.length; i++){
			for(int k=0; k<arr1.length;k++){
				for(int j= 0; j<arr2.length;j++){
					for(int h= 0; h<arr3.length;h++){
						if(arr1[k].nrSocio()==nrSocio && arr[i].ID()==id){
							arr1[k].cliente().historicoVideo(arr3[h]);
						}
						else if(arr2[j].nrSocio()==nrSocio && arr[i].ID()==id){
							arr2[j].cliente().historicoVideo(arr3[h]);
						}
					}
				}
			}
		}
		
		
		Emprestimo filme = new Emprestimo(nrSocio, id);
		
		Emprestimo arrTemp[]= new Emprestimo[arr.length+1];
		for(int i=0; i<arr.length;i++){
			arrTemp[i]=arr[i];
		}
		arrTemp[arr.length]= filme;
		return arrTemp;
		
	}
	
	private static void listUtiReq(Emprestimo[] arr){
		System.out.print("ID do filme:");
		int id = sc.nextInt();
		
		for(int i = 0; i<arr.length;i++){
			if(arr[i].ID() == id)
				System.out.print("O sócio " + arr[i].nrSocio() + "requisitou este filme.");
		}
	
	}
	
	private static void listVideoDisp(Videos[] arr, Emprestimo arr1[], Estudante[] arr2, Funcionario[] arr3){
		System.out.print("Número de sócio:");
		int nrSocio = sc.nextInt();
		
		int idade=-1;
				
		for(int i=0; i<arr2.length; i++){
			for(int k=0; k<arr3.length;k++){
				if(arr2[i].nrSocio()==nrSocio){
					idade = arr2[i].dataNascimento().Idade();
				}
				else if(arr3[k].nrSocio()==nrSocio){
					idade = arr3[k].dataNascimento().Idade();
				}
				else
					System.out.print("Não existe esse número de sócio.");
			}
		}
		
		for(int i=0; i<arr1.length; i++){
			for(int k=0; k<arr.length;k++){
				if(arr[k].idade().equals("ALL") && (arr1[i].ID()!=arr[k].ID())){
					System.out.print("\n"+arr[k].ID()+", "+arr[k].titulo()+", "+arr[k].categoria()+", "+arr[k].idade());
				}
				else if(arr[k].idade().equals("M6") && idade > 6 && (arr1[i].ID()!=arr[k].ID())){
					System.out.print("\n"+arr[k].ID()+", "+arr[k].titulo()+", "+arr[k].categoria()+", "+arr[k].idade());
				}
				else if(arr[k].idade().equals("M12") && idade > 12 && (arr1[i].ID()!=arr[k].ID())){
					System.out.print("\n"+arr[k].ID()+", "+arr[k].titulo()+", "+arr[k].categoria()+", "+arr[k].idade());
				}
				else if(arr[k].idade().equals("M16") && idade > 16 && (arr1[i].ID()!=arr[k].ID())){
					System.out.print("\n"+arr[k].ID()+", "+arr[k].titulo()+", "+arr[k].categoria()+", "+arr[k].idade());
				}
				else if(arr[k].idade().equals("M18") && idade > 18 && (arr1[i].ID()!=arr[k].ID())){
					System.out.print("\n"+arr[k].ID()+", "+arr[k].titulo()+", "+arr[k].categoria()+", "+arr[k].idade());
				}
			}
		}
	}
		
		
	private static void listRating(Videos[] arr){
		 boolean troca;
	        int f = arr.length;
	        do{
	            troca = false;
	            for(int i=0;i<f;i++){
	                if(arr[i].ratingMedio()>arr[i+1].ratingMedio()){
	                    Videos temp = arr[i];
	                    arr[i] = arr[i+1];
	                    arr[i+1] = temp;
	                    troca = true;
	                }
	                f--;
	            }
	        }while(troca);
		
			for(int i = 0; i<arr.length;i++){
				if(arr[i].ratingMedio()!= 0)
					System.out.print("\n"+arr[i].ID()+", "+arr[i].titulo()+", "+arr[i].categoria()+", "+arr[i].idade()+", "+arr[i].ratingMedio());
			}
		
	}
	
	private static void listHistorico(Estudante[] arr, Funcionario[] arr1){
		System.out.print("Número de sócio:");
		int nrSocio = sc.nextInt();
		
		for(int i=0; i<arr.length;i++){
			for(int j=0; j<arr1.length;j++){
				if(arr[i].nrSocio()==nrSocio){
					Videos[] video = arr[i].hist();
					System.out.println(video[i].ID());
				}
				else if(arr1[j].nrSocio()==nrSocio){
					Videos[] video = arr1[j].hist();
					System.out.println(video[j].ID());
				}
				else System.out.print("aqui");			
			}
		}
	}
	
	
}
