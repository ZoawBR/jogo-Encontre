package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaMostrarQuestoes extends JFrame{
	private JTable jTable;
	private JScrollPane jScrollPane;
	private JButton sair;
	private JLabel bg;
	
	public TelaMostrarQuestoes() {
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setLayout(null);
		
		bg = new JLabel();
		bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mostrarbg.jpg")));
		bg.setBounds(0, 0, 500, 500);
		
		sair = new JButton("Sair");
		sair.setBackground(Color.white);
		sair.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		sair.setBounds(120, 465, 250, 30);
		
		jScrollPane = new JScrollPane();
		jScrollPane.setBounds(5, 45, 490, 400);
		add(jScrollPane);
		
		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"Pergunta", "Opção 1", "Opção 2", "Opção 3", "Resposta"
				}
				
		));
		
		jTable.setEnabled(false);
		
		jScrollPane.setViewportView(jTable);
		
		
		add(jScrollPane);
		add(sair);
		add(bg);
		setVisible(false);
	}

	public JButton getSair() {
		return sair;
	}

	public JTable getjTable() {
		return jTable;
	}
	
	
	
}
