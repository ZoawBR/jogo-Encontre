
package controller;

import java.io.IOException;
import java.util.LinkedList;

import model.Personagem;
import model.Som;
import model.Tiro;

public class ControleTiro {
	private Tiro tiro;
	static LinkedList<Tiro> tiros = new LinkedList<>();
	private Som som;
	private Personagem player;
	private Thread thread;
	
	public ControleTiro(Personagem player) {
		som = ControladorDeObjetos.getSom();
		this.player = player;
		thread = new Thread();
		thread.start();
	}
	
	public void adicionarTiro(String caminho) {
		if (player.getMunicao() > 0) {
			try {
				tiro = new Tiro(caminho);				
				tiros.addFirst(tiro);
				player.setMunicao(player.getMunicao()-1);
				som.somTiroPlay();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			som.somSemMunicao();
		}
	}
	

	public void tick() {
		for (int i = 0; i < tiros.size(); i++) {
			Tiro tiro = tiros.removeFirst();
			tiro.mover();
			tiros.addLast(tiro);
		}

	}
	
	
	public static LinkedList<Tiro> getTiros() {
		return tiros;
	}

	public Tiro getTiro() {
		return tiro;
	}

	public void setTiro(Tiro tiro) {
		this.tiro = tiro;
	}
	
	

}
