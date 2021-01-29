package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.ControladorDeObjetos;
import controller.ControleBolaDeFogo;
import controller.ControleJpanel;
import controller.ControleTiro;
import controller.Game;
import javafx.scene.image.Image;


public class Fase1_Single extends Fase{

	public static List<Rectangle> colisao;

	private static Personagem player;
	private static TileMap terra_camada1, colisao_camada2;
	public static ArrayList<Inimigo> inimigos;
	public static ArrayList<Municao> municoes;
	public static ArrayList<Cores> cores;
	public static ArrayList<Cura> curas;
	public static ArrayList<Bau> baus;

	public static Porta porta;
	
	private ControleJpanel controladorJpanel;
	
	public Fase1_Single(Game game) {
		super(game);
		inimigos = new ArrayList<Inimigo>();
		municoes = new ArrayList<Municao>();
		cores = new ArrayList<Cores>();
		curas = new ArrayList<Cura>();
		baus = new ArrayList<Bau>();
		
		try {
			player = new Personagem(game, "personagem.png", 0, 8, 3, 1*32, 14*32);
			ControladorDeObjetos.setPlayer(player);
			
			inimigos.add(new Inimigo("-x",game, "vilao.png" , 0, 4, 3, 6*32, 1*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 1*32, 2*31));
			inimigos.add(new Inimigo("y", game, "vilao.png" , 0, 4, 3, 8*32, 8*31));
			inimigos.add(new Inimigo("-x",game, "vilao.png" , 0, 4, 3, 8*32,10*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 15*32,2*32));
			inimigos.add(new Inimigo("-y",game, "vilao.png" , 0, 4, 3, 24*32,11*32));
			inimigos.add(new Inimigo("y", game, "vilao.png" , 0, 4, 3, 23*32,7*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 26*32,8*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 26*32,10*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 26*32,12*32));
			inimigos.add(new Inimigo("-x",game, "vilao.png" , 0, 4, 3, 30*32,8*32));
			inimigos.add(new Inimigo("-x",game, "vilao.png" , 0, 4, 3, 30*32,14*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 4*32,13*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 17*32,5*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 6*32,1*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 26*32,12*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 11*32,3*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 6*32,4*32));			
			ControladorDeObjetos.setInimigos(inimigos);
			
			cores.add(new Cores("missao.png", 0,7 , 1, 8*32, 1*32,true, "vermelho"));
			cores.add(new Cores("missao.png", 1,7 , 1, 10*32, 8*32, true, "amarelo"));
			cores.add(new Cores("missao.png", 2,7 , 1, 13*32, 10*32, false, "verde"));
			cores.add(new Cores("missao.png", 3,7 , 1, 13*32, 8*32,true, "azul"));
			cores.add(new Cores("missao.png", 4,7 , 1, 30*32, 5*32,false, "laranja"));
			cores.add(new Cores("missao.png", 5,7 , 1, 4*32, 14*32,false, "Preto"));
			cores.add(new Cores("missao.png", 6,7 , 1, 30*32, 1*32,false, "branco"));

			curas.add(new Cura("itens.png", 3, 5, 1, 8*32, 14*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 10*32, 6*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 19*32, 8*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 21*32, 5*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 16*32, 4*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 28*32, 14*32));

			municoes.add(new Municao("itens.png", 2, 5, 1, 5*32, 6*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 5*32, 14*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 21*32, 8*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 22*32, 14*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 19*32, 11*32));

			baus.add(new Bau(game, "itens.png", 0, 5, 1, 2*32, 14*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 6*32, 2*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 11*32, 14*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 25*32, 14*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 25*32, 2*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 16*32, 5*32));

			
			porta = new Porta(game, "porta.png", 0, 2, 1, 28*32, 7*32);
			ControladorDeObjetos.setPorta(porta);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ControladorDeObjetos.getSom().somMusicaAmbienteGameStop();
		ControladorDeObjetos.getSom().somFase3Stop();
				
		ControladorDeObjetos.getSom().somMusicaAmbienteGamePlay();
		
		terra_camada1 = new TileMap(32, 16, 32, 32,"tiled.png", "terraFASE1.txt", true);
		colisao_camada2 = new TileMap(32, 16, 32, 32, "tiled.png", "colisaoFASE1.txt",true);
		terra_camada1.montarMapa();
		colisao_camada2.montarMapa();
		
		colisao = colisao_camada2.montarColi();
		ControladorDeObjetos.setColisao(colisao);
		controladorJpanel = new ControleJpanel(game, player);
		ControladorDeObjetos.setControleJpanel(controladorJpanel);
	}
	
	
	@Override
	public void tick() {
		
		controladorJpanel.atualizarJpanel();
		ControleJpanel.mudarJpanelMissao();
//		ControleJpanel.tirarAviso();
		player.getControlePlayer().tick();
		porta.getControlePorta().tick();
		
		for (Cores cor : cores) {
			cor.getControleMissaoCores().tick();
		}
		
		for (Inimigo inimigo : inimigos) {
			inimigo.getControleInimigo().tick();
		}
		
		for (Municao municao : municoes) {
			municao.getControleMunicaoMapa().tick();
		}
		
		for (Bau bau:baus) {
			bau.getControleBau().tick();
		}
		
		for (Cura cura: curas) {
			cura.getControleCuraMapa().tick();
		}
	
	}

	

	
	@Override
	public void render(Graphics g) {
		g.drawImage(terra_camada1.getMapa(), 0,0, null);
		g.drawImage(colisao_camada2.getMapa(), 0,0, null);
		
		for (Cores cor : cores) {
			if (cor.isCor_coletada()) {
				cor.setWidth(0);
				cor.setHeight(0);
				cor = null;
			}else {
			cor.getControleMissaoCores().draw(g);
			}
		}
		
		
		for (Municao municao : municoes) {
			if (municao.isUsado() == true) {
				municao.setWidth(0);
				municao.setHeight(0);
				municao = null;
			}else {
				municao.getControleMunicaoMapa().draw(g);
			}
		}
		
		for (Cura cura: curas) {
			if (cura.isUsado()) {
				cura.setWidth(0);
				cura.setHeight(0);
				cura = null;
			}else {
				cura.getControleCuraMapa().draw(g);
			}
		}
		
		for (Bau bau:baus) {
			bau.getControleBau().draw(g);
		}
	
		for (Tiro tiro : ControleTiro.getTiros()) {
			tiro.draw(g);
		}
		
		porta.getControlePorta().draw(g);		
		
		player.getControlePlayer().draw(g);
		
		for (Inimigo inimigo : inimigos) {
			if (inimigo.getHealth() == 0) {
				inimigo.setWidth(0);
				inimigo.setHeight(0);
				inimigo = null;

			}else {
			inimigo.getControleInimigo().draw(g);
			}
		}
		for (BolaDeFogo bola : ControleBolaDeFogo.getBolas()) {
			bola.draw(g);
		}
		
	}
	public static ArrayList<Inimigo> getInimigos() {
		return inimigos;
	}
	public static Personagem getPlayer() {
		return player;
	}



	public static List<Rectangle> getColisao() {
		return colisao;
	}



}
