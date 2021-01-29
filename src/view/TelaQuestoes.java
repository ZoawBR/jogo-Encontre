package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaQuestoes extends JFrame {

	private JLabel questaoLBL, op1LBL, op2LBL, op3LBL, respostaLBL, bg;
	private JButton cadastrarQST, sair, mostrarQst;
	private JTextField questaoFLD, op1FLD,op2FLD,op3FLD, respostaFLD; 
	
	public TelaQuestoes() {
		setSize(400,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setLayout(null);
		
		bg = new JLabel();
		bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgquestoes.jpg")));
		bg.setBounds(0, 0, 400, 200);
		
		questaoLBL = new JLabel("Questão: ");
		questaoLBL.setForeground(Color.white);
		questaoLBL.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		questaoLBL.setBounds(5, 5, 100, 20);
		
		op1LBL = new JLabel("Op1: ");
		op1LBL.setForeground(Color.white);
		op1LBL.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		op1LBL.setBounds(5, 30, 100, 20);
		
		op2LBL = new JLabel("Op2: ");
		op2LBL.setForeground(Color.white);
		op2LBL.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		op2LBL.setBounds(5, 55, 100, 20);
		
		op3LBL = new JLabel("Op3: ");
		op3LBL.setForeground(Color.white);
		op3LBL.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		op3LBL.setBounds(5, 80, 100, 20);
		
		respostaLBL = new JLabel("Resposta: ");
		respostaLBL.setForeground(Color.white);
		respostaLBL.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		respostaLBL.setBounds(5, 105, 100, 20);
		
		cadastrarQST = new JButton("Cadastrar");
		cadastrarQST.setBackground(Color.white);
		cadastrarQST.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		cadastrarQST.setBounds(245, 148, 150, 30);
		 
		mostrarQst = new JButton("Questoes");
		mostrarQst.setBackground(Color.white);
		mostrarQst.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		mostrarQst.setBounds(115, 148, 125, 30);
		
		sair = new JButton("Sair");
		sair.setBackground(Color.white);
		sair.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		sair.setBounds(10, 148, 100, 30);
		
		questaoFLD = new JTextField(25);
		questaoFLD.setBounds(95, 6, 290, 20);
		
		op1FLD = new JTextField(15);
		op1FLD.setBounds(60, 30, 325, 20);

		op2FLD = new JTextField(15);
		op2FLD.setBounds(60, 55, 325, 20);

		op3FLD = new JTextField(15);
		op3FLD.setBounds(60, 80, 325, 20);

		respostaFLD = new JTextField(15);
		respostaFLD.setBounds(105, 105, 280, 20);
		
		add(respostaFLD);
		add(op3FLD);
		add(op2FLD);
		add(op1FLD);
		add(questaoFLD);
		add(cadastrarQST);
		add(sair);
		add(mostrarQst);
		add(questaoLBL);
		add(op1LBL);
		add(op2LBL);
		add(op3LBL);
		add(respostaLBL);
		add(bg);
		setVisible(false);
	}

	public JButton getMostrarQst() {
		return mostrarQst;
	}

	public JTextField getQuestaoFLD() {
		return questaoFLD;
	}

	public void setQuestaoFLD(JTextField questaoFLD) {
		this.questaoFLD = questaoFLD;
	}

	public JTextField getOp1FLD() {
		return op1FLD;
	}

	public void setOp1FLD(JTextField op1fld) {
		op1FLD = op1fld;
	}

	public JButton getSair() {
		return sair;
	}

	public JTextField getOp2FLD() {
		return op2FLD;
	}

	public void setOp2FLD(JTextField op2fld) {
		op2FLD = op2fld;
	}

	public JTextField getOp3FLD() {
		return op3FLD;
	}

	public void setOp3FLD(JTextField op3fld) {
		op3FLD = op3fld;
	}

	public JTextField getRespostaFLD() {
		return respostaFLD;
	}

	public void setRespostaFLD(JTextField respostaFLD) {
		this.respostaFLD = respostaFLD;
	}

	public JButton getCadastrarQST() {
		return cadastrarQST;
	}
	
}
