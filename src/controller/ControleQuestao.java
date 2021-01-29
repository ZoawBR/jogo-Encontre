package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Questao;
import model.XML_dados_questoes;
import view.TelaMenu;
import view.TelaMostrarQuestoes;
import view.TelaQuestoes;

public class ControleQuestao implements ActionListener{
	private static Object[] lista;
	private TelaQuestoes tela;
	private TelaMenu menu;
	private TelaMostrarQuestoes mostrar;
	private XML_dados_questoes dados_questoes;
	
	public ControleQuestao(TelaQuestoes telaQuestao, TelaMenu menu) {
		this.tela = telaQuestao;
		this.menu = menu;
		this.mostrar = new TelaMostrarQuestoes();
		this.dados_questoes = new XML_dados_questoes();
		telaQuestao.getCadastrarQST().addActionListener(this);
		telaQuestao.getSair().addActionListener(this);
		telaQuestao.getMostrarQst().addActionListener(this);
		mostrar.getSair().addActionListener(this);
	}
	
	public void porXMLTela() throws FileNotFoundException, IOException {
		XML_dados_questoes.LerDados();
		ArrayList<Questao> questoes = XML_dados_questoes.getPerguntas();
		DefaultTableModel model = ((DefaultTableModel) mostrar.getjTable().getModel());
		model.setNumRows(0);
		Object [] fila = new Object[5];

		for (Questao questao : questoes) {
			fila[0] = questao.getPergunta();
			fila[1] = questao.getOp1();
			fila[2] = questao.getOp2();
			fila[3] = questao.getOp3();
			fila[4] = questao.getOpCorreta();
			model.addRow(fila);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tela.getCadastrarQST()) {
			Questao qst = new Questao(tela.getQuestaoFLD().getText(),
					tela.getOp1FLD().getText(),
					tela.getOp2FLD().getText(),
					tela.getOp3FLD().getText(),
					tela.getRespostaFLD().getText());
					XML_dados_questoes.LerDados();
					XML_dados_questoes.getPerguntas().add(qst);
					XML_dados_questoes.SalvarDados();
				tela.getQuestaoFLD().setText("");
				tela.getOp1FLD().setText("");
				tela.getOp2FLD().setText("");
				tela.getOp3FLD().setText("");
				tela.getRespostaFLD().setText("");
		}
		
		if (e.getSource() == tela.getSair()) {
			menu.setVisible(true);
			tela.setVisible(false);
		}
		if (e.getSource() == tela.getMostrarQst()) {
			mostrar.setVisible(true);
			tela.setVisible(false);
			
			try {
				porXMLTela();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == mostrar.getSair()) {
			mostrar.setVisible(false);
			tela.setVisible(true);
		}
	}
	
}
