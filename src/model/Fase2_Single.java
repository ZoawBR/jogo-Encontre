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

public class Fase2_Single extends Fase {

	public static List<Rectangle> colisao;
	
	private static Personagem player = ControladorDeObjetos.getPlayer();
	private static TileMap terra_camada1, colisao_camada2;
	public static ArrayList<Inimigo> inimigos;
	public static ArrayList<Municao> municoes;
	public static ArrayList<Cura> curas;
	public static ArrayList<NumerosPrimos> numeros;
	public static Porta porta;
	public static ArrayList<Bau> baus;

	
	private ControleJpanel controladorJpanel;
	
	public Fase2_Single(Game game) {
		super(game);

		Game.setFase1(false);
		Game.setFase2(true);
		ControladorDeObjetos.setGame(game);
		inimigos = new ArrayList<Inimigo>();
		municoes = new ArrayList<Municao>();
		curas = new ArrayList<Cura>();
		numeros = new ArrayList<NumerosPrimos>();
		baus = new ArrayList<Bau>();

		player.setPosX(1*32);
		player.setPosY(14*32);
		player.setHealth(100);
		player.setObjetivos(0);
		ControladorDeObjetos.setPlayer(player);
		
		ControladorDeObjetos.getSom().somMusicaAmbienteGameStop();
		ControladorDeObjetos.getSom().somFase3Stop();
				
		ControladorDeObjetos.getSom().somMusicaAmbienteGamePlay();
		try {
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 1*32,1*32));
			inimigos.add(new Inimigo("-x", game,"vilao.png" , 0, 4, 3, 6*32,10*32));
			inimigos.add(new Inimigo("y", game, "vilao.png" , 0, 4, 3, 10*32,5*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 14*32,12*32));
			inimigos.add(new Inimigo("-y", game,"vilao.png" , 0, 4, 3, 15*32,9*32));
			inimigos.add(new Inimigo("y", game, "vilao.png" , 0, 4, 3, 21*32,4*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 21*32,11*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 17*32,13*32));
			inimigos.add(new Inimigo("y", game, "vilao.png" , 0, 4, 3, 28*32,4*32));
			inimigos.add(new Inimigo("-x", game,"vilao.png" , 0, 4, 3, 30*32,14*32));
			inimigos.add(new Inimigo("-y", game,"vilao.png" , 0, 4, 3, 1*32,8*32));
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 9*32,14*32));
			inimigos.add(new Inimigo("y", game, "vilao.png" , 0, 4, 3, 7*32,2*32));
			inimigos.add(new Inimigo("-x", game,"vilao.png" , 0, 4, 3, 13*32,8*32));
			inimigos.add(new Inimigo("x", game,"vilao.png" , 0, 4, 3, 9*32,7*32));
			inimigos.add(new Inimigo("-x", game,"vilao.png" , 0, 4, 3, 22*32,7*32));
			inimigos.add(new Inimigo("y", game,"vilao.png" , 0, 4, 3, 19*32,1*32));
			
			ControladorDeObjetos.setInimigos(inimigos);
			
			curas.add(new Cura("itens.png", 3, 5, 1, 6*32, 8*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 9*32, 10*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 18*32, 4*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 1*32, 1*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 16*32, 4*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 27*32, 12*32));

			municoes.add(new Municao("itens.png", 2, 5, 1, 2*32, 2*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 10*32, 14*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 15*32, 4*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 22*32, 11*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 5*32, 2*32));
			
			numeros.add(new NumerosPrimos(3,"missao2.png",0,7,1,30*32, 14*32, true));
			numeros.add(new NumerosPrimos(4,"missao2.png",1,7,1,30*32, 1*32,false));
			numeros.add(new NumerosPrimos(5,"missao2.png",2,7,1,21*32, 1*32,true));
			numeros.add(new NumerosPrimos(6,"missao2.png",3,7,1,16*32, 11*32,false));
			numeros.add(new NumerosPrimos(7,"missao2.png",4,7,1,7*32, 3*32,true));
			numeros.add(new NumerosPrimos(8,"missao2.png",5,7,1,7*32, 12*32,false));
			numeros.add(new NumerosPrimos(9,"missao2.png",6,7,1,1*32, 4*32,false));
			
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 12*32, 1*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 6*32, 10*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 15*32, 9*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 19*32,4*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 28*32, 14*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 30*32, 3*32));

			
			porta = new Porta(game,"porta.png", 0, 2, 1, 30*32, 8*32);
			ControladorDeObjetos.setPorta(porta);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		terra_camada1 = new TileMap(32, 16, 32, 32,"tiled.png", "terraFASE2.txt", true);
		colisao_camada2 = new TileMap(32, 16, 32, 32, "tiled.png", "colisaoFASE2.txt",true);
		terra_camada1.montarMapa();
		colisao_camada2.montarMapa();
		
		colisao = colisao_camada2.montarColi();
		ControladorDeObjetos.setColisao(colisao);
		
		controladorJpanel = ControladorDeObjetos.getControleJpanel();

	}

	@Override
	public void tick() {
		controladorJpanel.atualizarJpanel();
		ControleJpanel.mudarJpanelMissaoNumero();
//		ControleJpanel.tirarAviso();
		player.getControlePlayer().tick();
		porta.getControlePorta().tick();
		
		for (Inimigo inimigo : inimigos) {
			inimigo.getControleInimigo().tick();
		}
		
		for (NumerosPrimos numero : numeros) {
			numero.getControleMissaoNumeros().tick();
		}

		for (Municao municao : municoes) {
			municao.getControleMunicaoMapa().tick();
		}
		
		for (Cura cura: curas) {
			cura.getControleCuraMapa().tick();
		}

		for (Bau bau:baus) {
			bau.getControleBau().tick();
		}
		
	
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(terra_camada1.getMapa(), 0,0, null);
		g.drawImage(colisao_camada2.getMapa(), 0,0, null);
		
		for (NumerosPrimos numero: numeros) {
			if (numero.isNum_coletada()) {
				numero.setWidth(0);
				numero.setHeight(0);
				numero = null;
			}else {
				numero.getControleMissaoNumeros().draw(g);
			}
		}
		
		for (Tiro tiro : ControleTiro.getTiros()) {
			tiro.draw(g);
		}
		
		player.getControlePlayer().draw(g);
		porta.getControlePorta().draw(g);

		for (Inimigo inimigo : inimigos) {
			if (inimigo.getHealth() == 0) {
				inimigo.setWidth(0);
				inimigo.setHeight(0);
				inimigo = null;
			}else {
			inimigo.getControleInimigo().draw(g);
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
		for (BolaDeFogo bola : ControleBolaDeFogo.getBolas()) {
			bola.draw(g);
		}
		
	}

}
