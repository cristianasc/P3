package Aula8;

import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame{
	public static JogoDoGalo jogo;
	public static void main(String[] args) {
	GUI gui = new GUI();
	jogo = new JogoDoGalo();
	
	}
		
	public GUI(){
		
		JFrame frame = new JFrame("Jogo do Galo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(3,3));
		for(int i=0; i<=2; i++)
	    	for(int j=0; j<=2; j++)
	    		content.add(new Botao(i, j, this));
		frame.setContentPane(content);
		frame.setVisible(true);
	}
	
	public void resultado(){
			String resultado;
			if(jogo.vencedor()==1){
				resultado = "O jogador X venceu!";
			}else if(jogo.vencedor()==-1){
				resultado = "O jogador O venceu!";
			}else if(jogo.vencedor()==0){
				resultado = "Empate!";
			}else{
				return;
			}
			message(resultado);
			System.exit(0);
	}
	
	private void message(String resultado){
		JOptionPane.showMessageDialog(getContentPane(), resultado);
	}
	
}
