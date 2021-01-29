package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TelaMenuDificuldade extends JFrame{

	
	private JButton facilButton, dificilButton,medioButton;
	
	public TelaMenuDificuldade() {
		setSize(480,251);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(48,48,48));
		setLayout(null);
		
		facilButton = new JButton("FACIL");
		facilButton.setForeground(Color.black);
		facilButton.setBackground(Color.white);
		facilButton.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		facilButton.setBounds(0, 0, 160, 251);
		
		medioButton = new JButton("MEDIO");
		medioButton.setForeground(Color.black);
		medioButton.setBackground(Color.white);
		medioButton.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		medioButton.setBounds(160, 0, 160, 251);
		
		dificilButton = new JButton("DIFICIL");
		dificilButton.setBackground(Color.white);
		dificilButton.setForeground(Color.black);
		dificilButton.setFont(new Font("Kristen ITC", Font.PLAIN, 25));
		dificilButton.setBounds(320, 0, 160, 251);

		
		add(facilButton);
		add(medioButton);
		add(dificilButton);
		setVisible(false);
	}

	public JButton getFacilButton() {
		return facilButton;
	}

	public void setFacilButton(JButton facilButton) {
		this.facilButton = facilButton;
	}

	public JButton getDificilButton() {
		return dificilButton;
	}

	public void setDificilButton(JButton dificilButton) {
		this.dificilButton = dificilButton;
	}

	public JButton getMedioButton() {
		return medioButton;
	}

	public void setMedioButton(JButton medioButton) {
		this.medioButton = medioButton;
	}

	
}
