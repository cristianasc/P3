package Aula8Ex2;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class GUI extends JFrame{
	
	QQSM qqsm;
	Pergunta ask;
	
	public static void main(String args[]) throws IOException{
		GUI gui = new GUI();
		gui.setVisible(true);
		
	}
	
	public GUI() throws IOException{
		super("Quem Quer Ser Milionário?");
		
		qqsm = new QQSM(new File("questions.txt"));
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1500, 444);
		//this.setVisible(true);
		this.setContentPane(panel());
		//super.invalidate();
		//super.validate();
		//super.repaint();
		
	}

	
	public JPanel panel() throws IOException{
		
		ask = (qqsm).getRandomAsk();
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.setVisible(true);
		
		//imagem
		JPanel west = new JPanel();
		west.setVisible(true);
			BufferedImage picture = ImageIO.read(new File(ask.urlImage()));
			JLabel label1 = new JLabel(new ImageIcon(picture));
			west.add(label1);
		
		panel1.add(west, BorderLayout.WEST);
		
		
		
		//pergunta e premio
		JPanel east = new JPanel(new BorderLayout());
		east.setLayout(new GridLayout(2, 1));
		east.setVisible(true);
		
		JPanel label = new JPanel(new BorderLayout());
		label.setLayout(new BorderLayout());
		
		JLabel label2 = new JLabel(qqsm.getPrize()+"€");
		label2.setVisible(true);

		
		label.add(label2, BorderLayout.NORTH);
		east.add(label, BorderLayout.CENTER);
		
		JPanel textArea = new JPanel(new BorderLayout());
		
		JTextArea text = new JTextArea(ask.toString());
		text.setVisible(true);
		text.setFont(new Font("Courier New", 2 , 16));
		textArea.add(text);
		east.add(textArea, BorderLayout.CENTER);
		
		panel1.add(east);
		
		//botoes
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(2,2));
		
		JPanel ajudas = new JPanel();
		
		//ajudas
		JPanel panelajuda = new JPanel();
		panelajuda.setLayout(new BorderLayout());
		JPanel paneltelefone = new JPanel();
		paneltelefone.setLayout(new BorderLayout());
		JPanel panel5050 = new JPanel();
		panel5050.setLayout(new BorderLayout());
		
		ButtonGroup bg1 = new ButtonGroup();
		JButton ajuda = new JButton("Ajuda Publico");
		if(qqsm.getPublico()){
		bg1.add(ajuda);
		panelajuda.add(ajuda);
		}
		JButton telefone = new JButton("Telefone");
		if(qqsm.getCall()){
		bg1.add(telefone);
		paneltelefone.add(telefone);
		}
		JButton fiftyfifty = new JButton("50-50");
		if(qqsm.getFiftyfifty()){
		bg1.add(fiftyfifty);
		panel5050.add(fiftyfifty);
		}
		
		ajudas.add(panelajuda);
		ajudas.add(paneltelefone);
		ajudas.add(panel5050);
		south.add(ajudas);
		
		//Desistir e confirmar
		JPanel panel3 = new JPanel();
		
		ButtonGroup bg2 = new ButtonGroup();
		JButton desistir = new JButton("Desistir");
		JButton confirmar = new JButton("Confirmar");
		
		bg2.add(desistir);
		bg2.add(confirmar);
		
		panel3.add(desistir);
		panel3.add(confirmar);
		
		panel3.setVisible(true);
		ajudas.setVisible(true);
		
		south.add(panel3, BorderLayout.SOUTH);
		
		//opçoes
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(1,2));
		ButtonGroup bg3 = new ButtonGroup();
		for(String askText : ask.options()){
			JRadioButton radio = new JRadioButton(askText);
			bg3.add(radio);
			panel5.add(radio);
		}
		
		
		panel5.add(panel3);
		south.add(panel5, BorderLayout.WEST);
		
		
		
		//eventos
		telefone.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		    	telefone.setVisible(false);
		    	
		   		String help = "";
		   		boolean verdadeira = false, falsa = false;
		   		for (Enumeration<AbstractButton> buttons = bg3.getElements(); buttons.hasMoreElements();) {
		               AbstractButton button = buttons.nextElement();

		               if (button.getText().equals(ask.answer()) && !verdadeira){
		               	help += button.getText()+" - "+((int)(20+Math.random()*(70-Integer.parseInt(ask.level())*10)))+"%\n";
		               	verdadeira = true;
		               }else if(!falsa){
		               	help += button.getText()+" - "+((int)(Math.random()*(40-Integer.parseInt(ask.level())*10)))+"%\n";
		               	falsa = true;
		               }
		               if(verdadeira && falsa){
		               	break;
		               }
		           }
		   		
		   		JOptionPane.showMessageDialog(getContentPane(),help);
		} });
		
		
		ajuda.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		    	ajuda.setVisible(false);
		   		qqsm.setPublico();
		   		
		   		String help = "";
		   		
		   		for (Enumeration<AbstractButton> buttons = bg3.getElements(); buttons.hasMoreElements();) {
		               AbstractButton button = buttons.nextElement();

		               if (button.getText().equals(ask.answer())){
		               	help += button.getText()+" - "+((int)(20+Math.random()*(70-Integer.parseInt(ask.level())*10)))+"%\n";
		               }else{
		               	help += button.getText()+" - "+((int)(Math.random()*(40-Integer.parseInt(ask.level())*10)))+"%\n";
		               }
		           }
		   		
		   		JOptionPane.showMessageDialog(getContentPane(), help);
		} });
		
		fiftyfifty.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		    	fiftyfifty.setVisible(false);
		   		qqsm.setFiftyFifty();
		   		
		   		int i=0;
		   		
		   		for (Enumeration<AbstractButton> buttons = bg3.getElements(); buttons.hasMoreElements();) {
		               AbstractButton button = buttons.nextElement();

		               if (!button.getText().equals(ask.answer()) && i!=2){
		                   button.setVisible(false);
		               	i++;
		               }
		               
		               if(i==2){
		               	break;
		               }
		           }
		} });

		desistir.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		          JOptionPane.showMessageDialog(getContentPane(),
		          "Desistiu!");
		          System.exit(0);
		} });
		
		confirmar.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		    	   for (Enumeration<AbstractButton> buttons = bg3.getElements(); buttons.hasMoreElements();) {
			             AbstractButton button = buttons.nextElement();

			             if (button.isSelected()) {
			            	 if(ask.answer().equals(button.getText())){
			         			JOptionPane.showMessageDialog(getContentPane(),
			                             "Resposta correta!");
			         			try {
									setContentPane(panel());
								} catch (IOException e1) {
									e1.printStackTrace();
								}
			         			setVisible(true);
			         			getContentPane().doLayout();
			         		    update(getGraphics());
			         		}else{
			         			JOptionPane.showMessageDialog(getContentPane(),
			                             "Resposta errada!");
			         		}
			             }
			         }
		} });
		
		south.setVisible(true);
		panel1.add(south, BorderLayout.SOUTH);
		return panel1;
	}

}
