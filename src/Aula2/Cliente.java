package Aula2;

public class Cliente {
	private static int num =0;
	private int nrSocio;
	private String nome;
	private int cc;
	private Data dataInscricao;
	private Data dataNascimento;
	private Videos[] arrVideo = new Videos[0];
	
	public Cliente(String nome, int cc, Data dataInscricao, Data dataNascimento){
		nrSocio = num;
		num++;
		this.nome = nome; 
		this.cc = cc;
		this.dataInscricao = dataInscricao;
		this.dataNascimento = dataNascimento; 
	}
	
	public int cc(){
		return cc;
	}
	
	public int nrSocio(){
		return nrSocio;
	}
	
	public String nome(){
		return nome;
	}
	
	public Data dataInscricao(){
		return dataInscricao;
	}
	
	public Data dataNascimento(){
		return dataNascimento;
	}
	
	public void historicoVideo(Videos novo){
        Videos[] video = new Videos[arrVideo.length+1];
        for(int i=0;i<arrVideo.length;i++){
            video[i] = arrVideo[i];
        }
        video[arrVideo.length] = novo;
        arrVideo=video;
    }
	
	public Videos[] hist(){
		return arrVideo;
	}
	
	
}
