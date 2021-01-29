package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaCreditos extends JFrame{
	
	private JLabel gifLBL, imgLBL;
	private JButton eventBn;
	
	public TelaCreditos() {
		setSize(480, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setLayout(null);
		
		imgLBL = new JLabel();
		imgLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/creditos.jpg")));
		imgLBL.setBounds(-1, -2, 480, 300);
		
		gifLBL = new JLabel();
		gifLBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifrosto.gif")));
		gifLBL.setBounds(20, 0, 150, 300);

		
		eventBn = new JButton("Sair");
		eventBn.setBackground(Color.white);
		eventBn.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		eventBn.setBounds(180, 250, 100, 40);
		
		add(gifLBL);
		add(eventBn);
		add(imgLBL);
		setVisible(false);
	}

	public JLabel getGifLBL() {
		return gifLBL;
	}

	public void setGifLBL(JLabel gifLBL) {
		this.gifLBL = gifLBL;
	}

	public JLabel getImgLBL() {
		return imgLBL;
	}

	public void setImgLBL(JLabel imgLBL) {
		this.imgLBL = imgLBL;
	}

	public JButton getEventBn() {
		return eventBn;
	}

	public void setEventBn(JButton eventBn) {
		this.eventBn = eventBn;
	}
	
}
