package Aula4;
import java.util.*;

public class Ex3 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		Cliente[] arrCliente = new Cliente[0];
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
	            	arrCliente = addCliente(arrCliente);
	            	break;
	            case 2:
	            	arrCliente = delCliente(arrCliente);
	            	break;
	            case 3:
	            	arrVideo = addVideo(arrVideo); break;
	            case 4:
	            	arrVideo = delVideo(arrVideo); break;
	            case 5:
	                 listVideos(arrVideo); break;
	            case 6:
	                 arrEmprestimo = checkout(arrEmprestimo, arrCliente, arrVideo, quotas, count); break;
	            case 7:
	                 arrEmprestimo = checkin(arrEmprestimo, arrVideo); break;
	            case 8:
	                 listUtiReq(arrEmprestimo); break;
	            case 9:
	            	listVideoDisp(arrVideo,arrEmprestimo,arrCliente); break;
	            case 10:
	                 listRating(arrVideo); break;
	            case 11:
	                 listHistorico(arrCliente); break;
	            }
	    }while(a!=12);
	}
	
	private static Cliente[] addCliente(Cliente[] arr){
		Cliente arr2[]= new Cliente[arr.length+1];
	
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
		
		sc.nextLine();
		
		System.out.print("Estudante ou Funcionario? - Insira 1 para estudante e 2 para Funcionario.");
		int tipo = sc.nextInt();
		
		if(tipo==1){
		System.out.print("Número Mecanográfico:");
		int mec = sc.nextInt();
		
		System.out.print("Curso:");
		String curso = sc.nextLine();
		
		sc.nextLine();
		
		System.out.println("Estudante adicionado com sucesso!");
		
		Data dataNasc = new Data(diaN,mesN,anoN);
		Data dataI = new Data(diaI,mesI,anoI);
		Aluno e = new Aluno(mec,curso,nome,cc,dataI,dataNasc);
		
		for(int i=0; i<arr.length;i++){
			arr2[i]=arr[i];
		}
		arr2[arr.length]= e;
		}
		
		else if(tipo==2){
			System.out.print("Número Funcionario:");
			int nrFunc = sc.nextInt();
			
			System.out.print("NIF:");
			int nif = sc.nextInt();
			
			System.out.println("Estudante adicionado com sucesso!");
			
			Data dataNasc = new Data(diaN,mesN,anoN);
			Data dataI = new Data(diaI,mesI,anoI);
			Funcionario e = new Funcionario(nrFunc,nif,nome,cc,dataI,dataNasc);
			
			for(int i=0; i<arr.length;i++){
				arr2[i]=arr[i];
			}
			arr2[arr.length]= e;
			}
		else
			System.out.print("Tipo inválido!");
		return arr2;
	}
		
	private static Cliente[] delCliente(Cliente[] arr){
		System.out.print("Número de CC do cliente que deseja eliminar: ");
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
	
	
	
	private static Emprestimo[] checkout(Emprestimo[] arr, Cliente[] arr1, Videos[] arr2, int quotas, int count){
		System.out.print("Número de sócio:");
		int nrSocio = sc.nextInt();
		System.out.print("ID do filme a requisitar:");
		int id = sc.nextInt();
		
		for(int i=0; i<arr1.length;i++){
			if (arr1[i].nrSocio()==nrSocio){
				count++;
			}
		}
		if(count==quotas){
			System.out.print("Não é possivel requisitar mais livros.");
		}
		
		for(int i=0; i<arr.length; i++){
			for(int k=0; k<arr1.length;k++){
				for(int h= 0; h<arr2.length;h++){
					if(arr1[k].nrSocio()==nrSocio && arr[i].ID()==id){
						arr1[k].historicoVideo(arr2[h]);
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
	
	private static void listVideoDisp(Videos[] arr, Emprestimo arr1[], Cliente arr2[]){
		System.out.print("Número de sócio:");
		int nrSocio = sc.nextInt();
		
		int idade=-1;
				
		for(int i=0; i<arr2.length; i++){
			if(arr2[i].nrSocio()==nrSocio){
				idade = arr2[i].data().Idade();
				}
			
			else
				System.out.print("Não existe esse número de sócio.");
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
	
	private static void listHistorico(Cliente[] arr){
		System.out.print("Número de sócio:");
		int nrSocio = sc.nextInt();
		
		for(int i=0; i<arr.length;i++){
			if(arr[i].nrSocio()==nrSocio){
				Videos[] video = arr[i].hist();
					System.out.println(video[i].ID());		
			}
		}
	}
	
	
}
     