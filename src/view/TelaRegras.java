package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaRegras extends JFrame {
	
	private JLabel imagemMenu;
	private JButton botaoEnter;
	
	public TelaRegras() {
		setSize(480, 480);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(48,48,48));
		setLayout(null);
		
		imagemMenu = new JLabel();
		imagemMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/regrasjpg.jpg")));
		imagemMenu.setBounds(0, 0, 480, 480);
		
		botaoEnter = new JButton("Iniciar Jogo");
		botaoEnter.setBackground(Color.white);
		botaoEnter.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		botaoEnter.setBounds(160, 370, 150, 50);
		
		
		add(botaoEnter);
		add(imagemMenu);
		setVisible(false);
	}

	public JButton getBotaoEnter() {
		return botaoEnter;
	}
	
}
