package controller;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

import model.Porta;

public class ControlePorta {
	private static String textoJlabelPorta;
	
	private Porta porta;
	private boolean avisoMostrou = false;
	public ControlePorta(Porta porta) {
		this.porta = porta;
	}

	
	public void tick(){
		verificarValidacaoJogador();
		verificarSePassouFase();
	}
	
	public void verificarSePassouFase() {
		if (ControladorDeObjetos.getPlayer().getObjetivos() == 3  && porta.isEntrou() == true) {
			porta.setEntrou(false);
			ControladorDeObjetos.getPlayer().setRespondendo(true);
			ControladorDeObjetos.getPlayer().setPosX(ControladorDeObjetos.getPlayer().getPosX()-15);

			if (Game.isFase1() == true && Game.isFase2() == false) {
				ControladorDeObjetos.iniciarFase2();
			}else if (Game.isFase2() == true && Game.isFase1() == false) {
				ControladorDeObjetos.iniciarFase3();
			}
			else if (Game.isFase2() == false && Game.isFase1() == false) {
				ControladorDeObjetos.getPorta().setPosX(10000);
				
			}
		}else if (ControladorDeObjetos.getPlayer().getObjetivos() < 3  && porta.isEntrou() == true && avisoMostrou == false) {
			ControleJpanel.mudarJpanelPorta(textoJlabelPorta);
			avisoMostrou = true;
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(porta.getSprites()[porta.getAparencia()], porta.getPosX(),
				porta.getPosY(), porta.getHeight(), porta.getWidth(), null);
	}
	
	
	public void verificarValidacaoJogador() {
		if (ControladorDeColisoes.colisaoPlayer(colisaoPlayer()) == true) {
			porta.setEntrou(true); 
		}else {
			porta.setEntrou(false); 
		}
	}
	
	public Rectangle colisaoPlayer() {
		Rectangle thisporta = new Rectangle(porta.getPosX(), porta.getPosY(), 
				porta.getWidth(), porta.getHeight());
		return thisporta;
		
	}


	public boolean isAvisoMostrou() {
		return avisoMostrou;
	}


	public void setAvisoMostrou(boolean avisoMostrou) {
		this.avisoMostrou = avisoMostrou;
	}


	public static String getTextoJlabelPorta() {
		return textoJlabelPorta;
	}


	public static void setTextoJlabelPorta(String textoJlabelPorta) {
		ControlePorta.textoJlabelPorta = textoJlabelPorta;
	}
	
	
}
