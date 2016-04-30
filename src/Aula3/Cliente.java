package Aula3;

public class Cliente extends Pessoa{
	private static int num =0;
	private int nrSocio;
	private Data dataInscricao;
	private Videos[] arrVideo = new Videos[0];
	
	public Cliente(String nome, int cc, Data dataInscricao, Data dataNascimento){
		super(nome,cc,dataNascimento);
		nrSocio = num;
		num++;
		this.dataInscricao = dataInscricao;
	}
	
	public int nrSocio(){
		return nrSocio;
	}
	
	public Data dataInscricao(){
		return dataInscricao;
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
