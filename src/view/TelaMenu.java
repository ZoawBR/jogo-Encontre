package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TelaMenu extends JFrame{
	
	JButton novoJogoBtn, creditosBtn, sairBtn, rankingBtn, opcaBtn;
	
	JLabel bggif, bg;
	
	private int WIDTH = 480;
	private int HEIGHT = 251;
		
	public TelaMenu() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		setLayout(null);
			
		bggif = new JLabel();
		
		bggif.setIcon(new ImageIcon(getClass().getResource("/giphy.gif")));
		bggif.setBounds(0, 0, WIDTH, HEIGHT);
		
		bg = new JLabel();
		bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png")));
		bg.setBounds(0, 0, WIDTH, HEIGHT);
		
		novoJogoBtn = new JButton("SinglePlayer");
		novoJogoBtn.setBackground(Color.white);
		novoJogoBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		novoJogoBtn.setBounds(283, 40, 150, 30);
	
		opcaBtn = new JButton("Questões");
		opcaBtn.setBackground(Color.white);
		opcaBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		opcaBtn.setBounds(283, 110, 150, 30);
		
		rankingBtn = new JButton("Multiplayer");
		rankingBtn.setBackground(Color.white);
		rankingBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		rankingBtn.setBounds(283, 75, 150, 30);
	
		creditosBtn = new JButton("Creditos");
		creditosBtn.setBackground(Color.white);
		creditosBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		creditosBtn.setBounds(283, 145, 150, 30);
		
		sairBtn = new JButton("Sair");
		sairBtn.setBackground(Color.white);
		sairBtn.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		sairBtn.setBounds(283, 180, 150, 30);
		
		add(novoJogoBtn);
		add(opcaBtn);
		add(rankingBtn);
		add(creditosBtn);
		add(sairBtn);
		add(bg);
		add(bggif);
		
		setVisible(true);
	}

	public JButton getOpcaBtn() {
		return opcaBtn;
	}

	public JButton getNovoJogoBtn() {
		return novoJogoBtn;
	}

	public JButton getCreditosBtn() {
		return creditosBtn;
	}

	public JButton getSairBtn() {
		return sairBtn;
	}

	public JButton getRankingBtn() {
		return rankingBtn;
	}
	
}
