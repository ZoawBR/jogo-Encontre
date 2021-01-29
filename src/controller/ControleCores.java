package controller;

import java.awt.Graphics;
import java.awt.Rectangle;

import model.Cores;

public class ControleCores {

	private Cores cor;
	
	private Rectangle rec;
	public ControleCores(Cores cor) {
		this.cor = cor;
	}
	

	public void tick(){
		verificarColisao();
	}

	public void verificarColisao() {
		ControlePorta.setTextoJlabelPorta(" cores");
		rec = new Rectangle(cor.getPosX(), cor.getPosY(), cor.getWidth(), cor.getHeight());
		if (ControladorDeColisoes.colisaoPlayer(rec)) {
			if (cor.isCor_primaria()) {
				cor.setCor_coletada(true);
				if (cor.getCor().equalsIgnoreCase("vermelho")) {
					ControleJpanel.mudarJpanelMissaoVermelho();
				}
				if (cor.getCor().equalsIgnoreCase("azul")) {
					ControleJpanel.mudarJpanelMissaoAzul();
				}
				if (cor.getCor().equalsIgnoreCase("amarelo")) {
					ControleJpanel.mudarJpanelMissaoAmarelo();
				}
				ControladorDeObjetos.getPlayer().setObjetivos(ControladorDeObjetos.getPlayer().getObjetivos() + 1);
				ControladorDeObjetos.getPorta().getControlePorta().setAvisoMostrou(false);
			}else if (cor.isCor_primaria() == false){

				if (cor.isUsado() == false) {
					ControleJpanel.mudarJpanelMissaoQst();
					cor.setUsado(true);
				}
			}

		}else{
			ControleJpanel.mudarJpanelMissao();
		}
	}
	
	
	public void draw(Graphics g) {
		g.drawImage(cor.getSprites()[cor.getAparencia()], cor.getPosX(),
				cor.getPosY(), cor.getHeight(), cor.getWidth(), null);
	}
	
}
