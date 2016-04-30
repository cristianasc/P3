package Aula8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Botao extends JToggleButton{
	
	private int i;
	private int j;
	private GUI gui;
	
	public Botao(int i, int j, GUI gui){
		this.i = i;
		this.j = j;
		this.gui = gui;
		setVisible(true);
		
		ActionListener a = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				doit();
			}
		};
		
		addActionListener(a);
	}
	
	private void doit(){
			if(GUI.jogo.jogadorX()){
				setText("X");
			}else{
				setText("0");
			}
			GUI.jogo.set(i, j, (GUI.jogo.jogadorX()) ? 1 : -1, gui);
			this.setEnabled(false);
			GUI.jogo.jogador = (GUI.jogo.jogadorX()) ? -1 : 1;
	}
	
	
}
