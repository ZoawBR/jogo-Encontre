package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tela extends JFrame{
	
	private Canvas canvas;
	
	private String title;
	private int WIDTH, HEIGHT;
	private JPanel panel, panelAviso;
	private JLabel vidaLbl, municaoLbl,bggif,fpslbl,baseMissao,amarelo,mensagemErroCor,okaycorerradaLbl,vermelho,azul,missaoLbl,
	tres,cinco,sete, mensagemErro, bolaDeFogoLBL, diaLbl, barraLbl, mesLbl;
	private JButton op1, op2, op3;

	public Tela(String title, int WIDTH, int HEIGHT) {
		this.title = title;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		
		setTitle(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setFocusable(true);
		setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 512, 1024, 200);
		panel.setBackground(new Color(48,48,48));
		panel.setBorder(BorderFactory.createLineBorder(Color.white, 4));
		
		
		panelAviso= new JPanel();
		panelAviso.setLayout(null);
		panelAviso.setBounds(0, 212, 1024, 200);
		panelAviso.setBackground(new Color(48,48,48));
		panelAviso.setBorder(BorderFactory.createLineBorder(Color.white, 4));
		
		mensagemErro = new JLabel();
		mensagemErro.setForeground(Color.white);
		mensagemErro.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		mensagemErro.setBounds(10, 10, 690, 15);
		panelAviso.add(mensagemErro);
		
		
		op1 = new JButton("OKAY");
		op1.setBackground(Color.white);
		op1.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		op1.setBounds(250, 70, 500, 30);
		panelAviso.add(op1);
		
		op2 = new JButton("OKAY");
		op2.setBackground(Color.white);
		op2.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		op2.setBounds(250, 105, 500, 30);
		panelAviso.add(op2);
		
		op3 = new JButton("OKAY");
		op3.setBackground(Color.white);
		op3.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		op3.setBounds(250, 140, 500, 30);
		panelAviso.add(op3);
		

		// Tratando Jpanel MIssao
		bggif = new JLabel();
		bggif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifrosto.gif")));
		bggif.setBounds(10, -2, 125, 200);
		panel.add(bggif);
		

		
		//Cores
		azul = new JLabel();
		azul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cor_azul.jpg")));
		azul.setBounds(300, 40, 150, 120);
		panel.add(azul).setVisible(false);
		
		vermelho = new JLabel();
		vermelho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cor_vermelho.jpg")));
		vermelho.setBounds(450, 49, 150, 102);
		panel.add(vermelho).setVisible(false);
		
		amarelo = new JLabel();
		amarelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cor_amarela.jpg")));
		amarelo.setBounds(600, 49, 150, 102);
		panel.add(amarelo).setVisible(false);
		// Fim cores
		
		//Numero
		tres = new JLabel();
		tres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/numero_tres.jpg")));
		tres.setBounds(300, 40, 150, 120);
		panel.add(tres).setVisible(false);
		
		cinco = new JLabel();
		cinco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/numero_cinco.jpg")));
		cinco.setBounds(450, 49, 150, 102);
		panel.add(cinco).setVisible(false);
		
		sete = new JLabel();
		sete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/numero_sete.jpg")));
		sete.setBounds(600, 49, 150, 102);
		panel.add(sete).setVisible(false);
		// Fim numero
		
		// Inicio data
		
		diaLbl = new JLabel();
		diaLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dia.jpg")));
		diaLbl.setBounds(300, 40, 150, 120);
		panel.add(diaLbl).setVisible(false);
		
		barraLbl = new JLabel();
		barraLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.jpg")));
		barraLbl.setBounds(450, 49, 150, 102);
		panel.add(barraLbl).setVisible(false);
		
		mesLbl = new JLabel();
		mesLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mes.jpg")));
		mesLbl.setBounds(600, 49, 150, 102);
		panel.add(mesLbl).setVisible(false);
		
		//fim data
		
		
		vidaLbl = new JLabel("Vida: ");
		vidaLbl.setForeground(Color.white);
		vidaLbl.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		vidaLbl.setBounds(140, 15, 150, 30);
		panel.add(vidaLbl);
		
		bolaDeFogoLBL = new JLabel("Bola De Fogo: ");
		bolaDeFogoLBL.setBounds(140, 75, 150, 20);
		bolaDeFogoLBL.setForeground(Color.white);
		bolaDeFogoLBL.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		panel.add(bolaDeFogoLBL);
		
		municaoLbl = new JLabel("Munição: ");
		municaoLbl.setForeground(Color.white);
		municaoLbl.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		municaoLbl.setBounds(140, 42, 150, 30);
		panel.add(municaoLbl);
		
		missaoLbl = new JLabel("Missão: ");
		missaoLbl.setForeground(Color.white);
		missaoLbl.setFont(new Font("Kristen ITC", Font.PLAIN, 19));
		missaoLbl.setBounds(360,15, 1000, 20);
		panel.add(missaoLbl);
		
		fpslbl = new JLabel("FPS: ");
		fpslbl.setForeground(Color.white);
		fpslbl.setFont(new Font("Kristen ITC", Font.PLAIN, 15));
		fpslbl.setBounds(460, 160, 150, 30);
		panel.add(fpslbl);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(false);
		
		add(panelAviso).setVisible(false);
		add(panel);
		add(canvas);
		pack();
		setVisible(true);

		
	}

	
	public JPanel getPanelAviso() {
		return panelAviso;
	}



	public JButton getOp1() {
		return op1;
	}


	public JButton getOp2() {
		return op2;
	}


	public JButton getOp3() {
		return op3;
	}


	public JLabel getBolaDeFogoLBL() {
		return bolaDeFogoLBL;
	}


	public JLabel getMensagemErro() {
		return mensagemErro;
	}


	public JLabel getDiaLbl() {
		return diaLbl;
	}


	public JLabel getBarraLbl() {
		return barraLbl;
	}


	public JLabel getMesLbl() {
		return mesLbl;
	}


	public JLabel getMissaoLbl() {
		return missaoLbl;
	}


	public void setMissaoLbl(JLabel missaoLbl) {
		this.missaoLbl = missaoLbl;
	}


	public JLabel getTres() {
		return tres;
	}


	public JLabel getCinco() {
		return cinco;
	}


	public JLabel getSete() {
		return sete;
	}


	public JLabel getAmarelo() {
		return amarelo;
	}


	public void setAmarelo(JLabel amarelo) {
		this.amarelo = amarelo;
	}


	public JPanel getPanel() {
		return panel;
	}


	public JLabel getMensagemErroCor() {
		return mensagemErroCor;
	}


	public JLabel getOkaycorerradaLbl() {
		return okaycorerradaLbl;
	}


	public JLabel getVermelho() {
		return vermelho;
	}


	public void setVermelho(JLabel vermelho) {
		this.vermelho = vermelho;
	}


	public JLabel getAzul() {
		return azul;
	}


	public void setAzul(JLabel azul) {
		this.azul = azul;
	}


	public JLabel getFpslbl() {
		return fpslbl;
	}


	public void setFpslbl(JLabel fpslbl) {
		this.fpslbl = fpslbl;
	}


	public JLabel getMunicaoLbl() {
		return municaoLbl;
	}


	public JLabel getVidaLbl() {
		return vidaLbl;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	public JFrame getFrame() {
		return this;
	}
	
}
