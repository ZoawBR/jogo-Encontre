package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaGameOver extends JFrame {
		
	private JLabel gameOverLBL, bggameover;
	private JButton retornarMenu;
	
	public TelaGameOver() {
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setLayout(null);
		
		bggameover = new JLabel();
		bggameover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bggameover.jpg")));
		bggameover.setBounds(0, 0, 500, 500);
		
		gameOverLBL = new JLabel("GAME OVER");
		gameOverLBL.setForeground(Color.white);
		gameOverLBL.setFont(new Font("Kristen ITC", Font.PLAIN, 50));
		gameOverLBL.setBounds(95, -100, 500, 500);
		
		retornarMenu = new JButton("Retornar ao Menu");
		retornarMenu.setBackground(Color.white);
		retornarMenu.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		retornarMenu.setBounds(120, 250, 250, 30);
		
		add(retornarMenu);
		add(gameOverLBL);
		add(bggameover);
		setVisible(false);
	}

	public JLabel getGameOverLBL() {
		return gameOverLBL;
	}

	public void setGameOverLBL(JLabel gameOverLBL) {
		this.gameOverLBL = gameOverLBL;
	}

	public JButton getRetornarMenu() {
		return retornarMenu;
	}

	public void setRetornarMenu(JButton retornarMenu) {
		this.retornarMenu = retornarMenu;
	}
	
	
	
}
