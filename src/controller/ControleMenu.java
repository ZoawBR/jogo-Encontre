package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Som;
import view.TelaCreditos;
import view.TelaGameOver;
import view.TelaMenu;
import view.TelaMenuDificuldade;
import view.TelaQuestoes;
import view.TelaRegras;

public class ControleMenu implements MouseListener, ActionListener{
	
	private TelaMenu menu;
	
	private TelaMenuDificuldade telaMenuDificuldade;
	private TelaRegras telaRegras;
	private TelaCreditos telaCredtiros;
	private TelaQuestoes telaquestoes;
	private TelaGameOver telaOver;
	private Som som;
		
	public ControleMenu(TelaMenu menu) {
		this.menu = menu;
		telaMenuDificuldade = new TelaMenuDificuldade();
		telaRegras = new TelaRegras();
		telaCredtiros = new TelaCreditos();
		telaquestoes = new TelaQuestoes(); 
		telaOver = new TelaGameOver();
		ControladorDeObjetos.setTelaOver(telaOver);
		ControladorDeObjetos.setTelaMenu(menu);
		som = new Som();
		
		ControladorDeObjetos.setSom(som);
		som.somMusicaAmbienteMenuPlay();
				
		menu.getNovoJogoBtn().addMouseListener(this);
		menu.getRankingBtn().addMouseListener(this);
		menu.getCreditosBtn().addMouseListener(this);
		menu.getSairBtn().addMouseListener(this);
		menu.getOpcaBtn().addMouseListener(this);
		
		telaMenuDificuldade.getFacilButton().addMouseListener(this);
		telaMenuDificuldade.getMedioButton().addMouseListener(this);
		telaMenuDificuldade.getDificilButton().addMouseListener(this);
		
		telaRegras.getBotaoEnter().addMouseListener(this);
		
		telaCredtiros.getEventBn().addMouseListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == menu.getNovoJogoBtn()) {
			menu.getNovoJogoBtn().setBackground(Color.GRAY);
			ControladorDeObjetos.getSom().somBipMenuPlay();
		}
		
		if (e.getSource() == menu.getOpcaBtn()) {
			menu.getOpcaBtn().setBackground(Color.GRAY);
			ControladorDeObjetos.getSom().somBipMenuPlay();
		}
		
		if (e.getSource() == menu.getRankingBtn()) {
			menu.getRankingBtn().setBackground(Color.GRAY);
			ControladorDeObjetos.getSom().somBipMenuPlay();
		}
		
		if (e.getSource() == menu.getCreditosBtn()) {
			menu.getCreditosBtn().setBackground(Color.GRAY);
			ControladorDeObjetos.getSom().somBipMenuPlay();
		}
		if (e.getSource() == menu.getSairBtn()) {
			menu.getSairBtn().setBackground(Color.GRAY);
			ControladorDeObjetos.getSom().somBipMenuPlay();
		}
		
		if (e.getSource() == telaMenuDificuldade.getFacilButton()) {
			telaMenuDificuldade.getFacilButton().setBackground(Color.GRAY);
			ControladorDeObjetos.getSom().somBipMenuPlay();
		}
		if (e.getSource() == telaMenuDificuldade.getMedioButton()) {
			telaMenuDificuldade.getMedioButton().setBackground(Color.GRAY);
			ControladorDeObjetos.getSom().somBipMenuPlay();
		}
		if (e.getSource() == telaMenuDificuldade.getDificilButton()) {
			telaMenuDificuldade.getDificilButton().setBackground(Color.GRAY);
			ControladorDeObjetos.getSom().somBipMenuPlay();
		}
		if (e.getSource() == telaRegras.getBotaoEnter()) {
			telaRegras.getBotaoEnter().setBackground(Color.GRAY);
			ControladorDeObjetos.getSom().somBipMenuPlay();
		}
		if (e.getSource() == telaCredtiros.getEventBn()) {
			telaCredtiros.getEventBn().setBackground(Color.GRAY);
			ControladorDeObjetos.getSom().somBipMenuPlay();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == menu.getNovoJogoBtn()) {
			menu.getNovoJogoBtn().setBackground(Color.white);
			ControladorDeObjetos.getSom().somBipMenuStop();
		}
		
		if (e.getSource() == menu.getOpcaBtn()) {
			menu.getOpcaBtn().setBackground(Color.white);
			ControladorDeObjetos.getSom().somBipMenuStop();
		}
		
		if (e.getSource() == menu.getRankingBtn()) {
			menu.getRankingBtn().setBackground(Color.white);
			ControladorDeObjetos.getSom().somBipMenuStop();		
			}
		
		if (e.getSource() == menu.getCreditosBtn()) {
			menu.getCreditosBtn().setBackground(Color.white);
			ControladorDeObjetos.getSom().somBipMenuStop();		
			}
		if (e.getSource() == menu.getSairBtn()) {
			menu.getSairBtn().setBackground(Color.white);
			ControladorDeObjetos.getSom().somBipMenuStop();		
			}
		
		if (e.getSource() == telaMenuDificuldade.getFacilButton()) {
			telaMenuDificuldade.getFacilButton().setBackground(Color.white);
			ControladorDeObjetos.getSom().somBipMenuStop();		
		}
		if (e.getSource() == telaMenuDificuldade.getMedioButton()) {
			telaMenuDificuldade.getMedioButton().setBackground(Color.white);
			ControladorDeObjetos.getSom().somBipMenuStop();		
		}
		if (e.getSource() == telaMenuDificuldade.getDificilButton()) {
			telaMenuDificuldade.getDificilButton().setBackground(Color.white);
			ControladorDeObjetos.getSom().somBipMenuStop();		
		}
		if (e.getSource() == telaRegras.getBotaoEnter()) {
			telaRegras.getBotaoEnter().setBackground(Color.white);
			ControladorDeObjetos.getSom().somBipMenuStop();		
		}
		if (e.getSource() == telaCredtiros.getEventBn()) {
			telaCredtiros.getEventBn().setBackground(Color.white);
			ControladorDeObjetos.getSom().somBipMenuPlay();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == menu.getNovoJogoBtn()) {
			menu.setVisible(false);
			telaMenuDificuldade.setVisible(true);
		}
		if (e.getSource() == menu.getOpcaBtn()) {
			menu.setVisible(false);
			telaquestoes.setVisible(true);
			new ControleQuestao(telaquestoes, menu);
		}
		if (e.getSource() == menu.getRankingBtn()) {
			
		}
		if (e.getSource() == menu.getCreditosBtn()) {
			menu.setVisible(false);
			telaCredtiros.setVisible(true);
		}
		if (e.getSource() == menu.getSairBtn()) {
			System.exit(0);
		}
		if (e.getSource() == telaRegras.getBotaoEnter()) {
			telaRegras.setVisible(false);
			ControladorDeObjetos.getSom().somMusicaAmbienteMenuStop();
			new ControleGame();

		}
		if (e.getSource() == telaMenuDificuldade.getFacilButton()) {
			telaMenuDificuldade.setVisible(false);
			ControladorDeDificuldade.modoFacil();
			telaRegras.setVisible(true);
		}
		if (e.getSource() == telaMenuDificuldade.getMedioButton()) {
			telaMenuDificuldade.setVisible(false);
			telaRegras.setVisible(true);

		}
		if (e.getSource() == telaMenuDificuldade.getDificilButton()) {
			telaMenuDificuldade.setVisible(false);
			ControladorDeDificuldade.modoDificil();
			telaRegras.setVisible(true);

		}
		if (e.getSource() == telaCredtiros.getEventBn()) {
			menu.setVisible(true);
			telaCredtiros.setVisible(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
