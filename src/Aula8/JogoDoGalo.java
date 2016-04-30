package Aula8;

public class JogoDoGalo {
	private int[][] tabuleiro;
	private int nJogadas; 
	protected int jogador;
	private GUI gui;
	
	public JogoDoGalo(){
		tabuleiro = new int[3][3];
		for(int i=0; i<tabuleiro.length; i++){
			for(int j=0; j<tabuleiro[i].length; j++){
				tabuleiro[i][j] = 0;
			}
		}
		this.nJogadas = 0;
		this.jogador = 1;
	}
	
	public void set(int i, int j, int jogador, GUI gui){
	    this.tabuleiro[(i)][(j)] = jogador;
	    this.nJogadas += 1;
	    this.gui = gui;
	    if (isFinished() || vencedor()==1 || vencedor()==-1){
	    	gui.resultado();
	    }
	    
	    
	}
	
	public boolean isFinished(){
		for(int i=0; i<tabuleiro.length; i++){
			for(int j=0; j<tabuleiro[i].length; j++){
				if(tabuleiro[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean jogadorX(){
		return jogador == 1;
	}
	
	public int nJogadas(){
		return nJogadas;
	}
	
	public int vencedor(){
		for(int i = 0; i<tabuleiro.length; i++){
			if((tabuleiro[i][0]+tabuleiro[i][1]+tabuleiro[i][2])==3){
				return 1;
			}else if((tabuleiro[i][0]+tabuleiro[i][1]+tabuleiro[i][2])==-3){
				return -1;
			}
		}
		for(int j = 0; j<tabuleiro.length; j++){
			if(tabuleiro[0][j]+tabuleiro[1][j]+tabuleiro[2][j]==3){
				return 1;
			}else if(tabuleiro[0][j]+tabuleiro[1][j]+tabuleiro[2][j]==-3){
				return -1;
			}
		}
		
		if(tabuleiro[0][0]+tabuleiro[1][1]+tabuleiro[2][2]==3){
			return 1;
		}else if(tabuleiro[0][0]+tabuleiro[1][1]+tabuleiro[2][2]==-3){
			return -1;
		}else if(tabuleiro[0][2]+tabuleiro[1][1]+tabuleiro[2][0]==3){
			return 1;
		}else if(tabuleiro[0][2]+tabuleiro[1][1]+tabuleiro[2][0]==-3){
			return -1;
		}
		
		return 0;
	}
}
