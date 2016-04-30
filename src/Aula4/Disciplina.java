package Aula4;

public class Disciplina {
	private String nomeDisciplina;
	private String areaCientifica;
	private int ects;
	private Professor responsavel;
	private Estudante[] aluno = new Estudante[0];
	
	public Disciplina(String nomeDisciplina, String areaCientifica, int ects, Professor responsavel){
		this.nomeDisciplina=nomeDisciplina;
		this.areaCientifica=areaCientifica;
		this.ects=ects;
		this.responsavel=responsavel;
	}
	
	public String nomeDisciplina(){
		return nomeDisciplina;
	}
	
	public String areaCientifica(){
		return areaCientifica;
	}
	
	public int ects(){
		return ects;
	}
	
	public Professor responsavel(){
		return responsavel;
	}
	
	public Estudante[] getAlunos(){
		return aluno;
	}
	
	 public Estudante[] getAlunos(String tipo){
	        Estudante arr[] = new Estudante[0];
	        
	        for(int i=0;i<aluno.length;i++){
	            if(aluno[i].getClass().getSimpleName().equals(tipo)){
	                arr=addBol(arr, aluno[i]);
	            }
	        }
	         
	        return arr;
	    }
	     
	 private Estudante[] addBol(Estudante[] arr, Estudante bolseiro){
	    	Estudante[] arr1=new Estudante[arr.length+1];
	        for(int i=0;i<arr.length;i++){
	            arr1[i]=arr[i];
	        }
	        arr1[arr.length] = bolseiro;
	        arr = arr1;
	        return arr;
	 }
	
	
	public boolean addAluno(Estudante est){
		if(alunoInscrito(est.nMec())) return false;
		
		for(int i=0;i<aluno.length;i++){
			if (aluno[i]==null){
				aluno[i]=est;
			}
		}
		Estudante arr2[]= new Estudante[aluno.length+1];
		for(int i=0; i<aluno.length;i++){
			arr2[i]=aluno[i];
		}
		arr2[aluno.length]= est;
		aluno = arr2;
		return true;
	}
	
	public boolean alunoInscrito(int nMec){
		for(int i=0; i<aluno.length;i++){
			if(nMec==aluno[i].nMec()){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean delAluno(int nMec){
		if(!alunoInscrito(nMec)) return false;
		
		for(int i=0;i<aluno.length;i++){
			if (aluno[i].nMec()==nMec){
				aluno[i]=null;
			}
		}
		int j=0;
		Estudante arr2[]=new Estudante[aluno.length-1];
		for(int i=0; i<aluno.length;i++){
			if(aluno[i]!=null)
				arr2[j++]=aluno[i];
		}
		aluno = arr2;
		return true;
		
	}
	
	public int numAlunos(){
		return aluno.length;
	}
	
	@Override
	public String toString(){
		return "Nome da Disciplina: "+nomeDisciplina()+" ("+ects()+ " ECTS) da Área de "+areaCientifica()+ "\nProfessor Responsável: "+responsavel()+", Número Funcionario:"+ responsavel.nrFunc()+"\nAdmissão em data: "+responsavel.dataAdmissao()+"\nExistem "+numAlunos()+" alunos inscritos.";
	}
	
}
