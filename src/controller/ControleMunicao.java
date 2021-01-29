package controller;

import java.awt.Graphics;
import java.awt.Rectangle;

import model.Municao;

public class ControleMunicao {
	private Municao municao;
	
	public ControleMunicao(Municao municao) {
		this.municao = municao;
	}
	
	public void tick() {
		verificarColisao();
	}
	
	public void verificarColisao() {
		if (ControladorDeColisoes.colisaoPlayer(colisaoPlayer())) {
			ControladorDeObjetos.getPlayer().setMunicao(ControladorDeObjetos.getPlayer().getMunicao()+ municao.getMunicao());
			ControladorDeObjetos.getSom().somRecarregandoArma();
			municao.setUsado(true);
		}
	}
	
	
	
	public void draw(Graphics g) {
		g.drawImage(municao.getSprites()[municao.getAparencia()], municao.getPosX(),
				municao.getPosY(), municao.getHeight(), municao.getWidth(), null);
	}
	
	public Rectangle colisaoPlayer() {
		Rectangle thismunicao = new Rectangle(municao.getPosX()+10, municao.getPosY()+10, 
				municao.getWidth()-20, municao.getHeight()-10);
		return thismunicao;
		
	}

}
