package controller;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import model.Bau;

public class ControleBau extends Thread{
	private Random r;
	private Game game;
	private Bau bau;
	
	private ArrayList<String> poderes;

	public ControleBau(Game game, Bau bau) {
		this.bau = bau;
		this.game = game;
		this.poderes = new ArrayList<String>();
		
		poderes.add("boladefogo");
	
		r = new Random();
		this.start();
	}
	
	public void tick() {
		abrirBau();
	}
	
	public void abrirBau() {
		String sortearItem = poderes.get(r.nextInt(poderes.size()));
		if (game.getKeyPrincipal().abrirBau == true && bau.isBauAberto() == false &&
				ControladorDeColisoes.colisaoPlayer(criarRectangle()) == true) {
			if (sortearItem.equals("boladefogo")) {
				ControladorDeObjetos.getPlayer().setBolas(ControladorDeObjetos.getPlayer().getBolas()+1);
			}
			bau.setBauAberto(true);
			bau.animar();
		}
	}
	
	public Rectangle criarRectangle() {
		return new Rectangle(bau.getPosX(), bau.getPosY(), bau.getWidth(), bau.getHeight());
	}
	
	public void draw(Graphics g) {
		g.drawImage(bau.getSprites()[bau.getAparencia()], bau.getPosX(),
				bau.getPosY(), bau.getHeight(), bau.getWidth(), null);
	}
	
}
