package controller;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.LinkedList;

import model.BolaDeFogo;
import model.Personagem;
import model.Som;

public class ControleBolaDeFogo {
	private BolaDeFogo bolaDeFogo;
	static LinkedList<BolaDeFogo> bolas = new LinkedList<>();
	private Som som;
	private Personagem player;
	
	public ControleBolaDeFogo(Personagem player) {
		som = ControladorDeObjetos.getSom();
		this.player = player;
	}
	
	public void adicionarTiro(String caminho) {
		if (player.getBolas() > 0) {
			try {
				bolaDeFogo = new BolaDeFogo(caminho);				
				bolas.addFirst(bolaDeFogo);
				player.setBolas(player.getBolas()-1);
				som.somBolaFogoPlay();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			som.somSemMunicao();
		}
	}
	

	public void tick() {
		for (int i = 0; i < bolas.size(); i++) {
			BolaDeFogo bolaDeFogo = bolas.removeFirst();
			bolaDeFogo.mover();
			bolaDeFogo.animar();
			bolas.addLast(bolaDeFogo);
		}

	}
	
	public Rectangle criarRectangle() {
		return new Rectangle(bolaDeFogo.getPosX(), bolaDeFogo.getPosY(), bolaDeFogo.getWidth(), bolaDeFogo.getHeight());
	}
	

	public BolaDeFogo getBolaDeFogo() {
		return bolaDeFogo;
	}

	public void setBolaDeFogo(BolaDeFogo bolaDeFogo) {
		this.bolaDeFogo = bolaDeFogo;
	}

	public static LinkedList<BolaDeFogo> getBolas() {
		return bolas;
	}

	public static void setBolas(LinkedList<BolaDeFogo> bolas) {
		ControleBolaDeFogo.bolas = bolas;
	}
	
	
}
