package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.ControladorDeObjetos;
import controller.ControleBolaDeFogo;
import controller.ControleJpanel;
import controller.ControleTiro;
import controller.Game;

public class Fase3_Single extends Fase {


	public static List<Rectangle> colisao;
	
	private static Personagem player = ControladorDeObjetos.getPlayer();
	private static TileMap terra_camada1, colisao_camada2;
	public static ArrayList<Inimigo> inimigos;
	public static ArrayList<Municao> municoes;
	public static ArrayList<Cura> curas;
	public static Porta porta;
	public static ArrayList<Bau> baus;
	public static Chefao chefao;
	public static ArrayList<DataIndependencia> datas;
	
	private ControleJpanel controladorJpanel;
	
	public Fase3_Single(Game game) {
		super(game);
		
		Game.setFase1(false);
		Game.setFase2(false);
		
		inimigos = new ArrayList<Inimigo>();
		municoes = new ArrayList<Municao>();
		curas = new ArrayList<Cura>();
		baus = new ArrayList<Bau>();
		datas = new ArrayList<DataIndependencia>();

		player.setPosX(1*32);
		player.setPosY(13*32);
		player.setMunicao(30);
		player.setHealth(100);
		player.setObjetivos(1);
		ControladorDeObjetos.setPlayer(player);
		ControleJpanel.mudarJpanelMissaoDataBarra();
		try {
			inimigos.add(new Inimigo("x", game, "vilao.png" , 0, 4, 3, 1*32,1*32));
			inimigos.add(new Inimigo("-x", game,"vilao.png" , 0, 4, 3, 6*32,10*32));
			inimigos.add(new Inimigo("-x", game,"vilao.png" , 0, 4, 3, 13*32,1*32));
			inimigos.add(new Inimigo("y", game,"vilao.png" , 0, 4, 3, 11*32,10*32));
			inimigos.add(new Inimigo("x", game,"vilao.png" , 0, 4, 3, 20*32,1*32));
			inimigos.add(new Inimigo("-y", game,"vilao.png" , 0, 4, 3, 20*32,14*32));
			inimigos.add(new Inimigo("y", game,"vilao.png" , 0, 4, 3, 15*32,8*32));
			inimigos.add(new Inimigo("-x", game,"vilao.png" , 0, 4, 3, 6*32,14*32));
			inimigos.add(new Inimigo("-x", game,"vilao.png" , 0, 4, 3, 5*32,7*32));
			inimigos.add(new Inimigo("y", game,"vilao.png" , 0, 4, 3, 7*32,1*32));
			inimigos.add(new Inimigo("-y", game,"vilao.png" , 0, 4, 3, 2*32,3*32));
			inimigos.add(new Inimigo("x", game,"vilao.png" , 0, 4, 3, 5*32,8*32));
			ControladorDeObjetos.setInimigos(inimigos);
			
			curas.add(new Cura("itens.png", 3, 5, 1, 23*32, 6*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 29*32, 6*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 5*32, 12*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 6*32, 3*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 14*32, 2*32));
			curas.add(new Cura("itens.png", 3, 5, 1, 14*32, 9*32));

			municoes.add(new Municao("itens.png", 2, 5, 1, 1*32, 11*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 1*32, 4*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 6*32, 6*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 14*32, 9*32));
			municoes.add(new Municao("itens.png", 2, 5, 1, 22*32, 10*32));
			
			datas.add(new DataIndependencia("missao3.png", 0, 6, 1, 1*32, 1*32, 11, false));
			datas.add(new DataIndependencia("missao3.png", 1, 6, 1, 20*32, 1*32, 9, true));
			datas.add(new DataIndependencia("missao3.png", 2, 6, 1, 1*32, 6*32, 25, false));
			datas.add(new DataIndependencia("missao3.png", 3, 6, 1, 9*32, 12*32, 10, false));
			datas.add(new DataIndependencia("missao3.png", 4, 6, 1, 7*32, 1*32, 12, false));
			datas.add(new DataIndependencia("missao3.png", 5, 6, 1, 11*32, 14*32, 7, true));

			baus.add(new Bau(game, "itens.png", 0, 5, 1, 23*32, 14*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 26*32, 14*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 13*32, 5*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 9*32,12*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 18*32, 3*32));
			baus.add(new Bau(game, "itens.png", 0, 5, 1, 16*32, 12*32));

			chefao = new Chefao(game,"chefao.png",0,1,1,25*32, 1*32);
			porta = new Porta(game,"porta.png", 0, 2, 1, 21*32, 12*32);

			ControladorDeObjetos.setPorta(porta);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		terra_camada1 = new TileMap(32, 16, 32, 32,"tiled.png", "terraFASE3.txt", true);
		colisao_camada2 = new TileMap(32, 16, 32, 32, "tiled.png", "colisaoFASE3.txt",true);
		terra_camada1.montarMapa();
		colisao_camada2.montarMapa();
		ControladorDeObjetos.getSom().somMusicaAmbienteGameStop();
		ControladorDeObjetos.getSom().somFase3Play();

		colisao = colisao_camada2.montarColi();
		ControladorDeObjetos.setColisao(colisao);
		
		controladorJpanel = ControladorDeObjetos.getControleJpanel();
	}

	@Override
	public void tick() {
		controladorJpanel.atualizarJpanel();
		ControleJpanel.mudarJpanelMissaoData();
//		ControleJpanel.tirarAviso();
		player.getControlePlayer().tick();
		porta.getControlePorta().tick();
		chefao.getControleChefao().tick();
		for (Inimigo inimigo : inimigos) {
			inimigo.getControleInimigo().tick();
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
		
		for (DataIndependencia data: datas) {
			data.getControleDataIndependencia().tick();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(terra_camada1.getMapa(), 0,0, null);
		g.drawImage(colisao_camada2.getMapa(), 0,0, null);
		
		for (Tiro tiro : ControleTiro.getTiros()) {
			tiro.draw(g);
		}
		
		porta.getControlePorta().draw(g);
		chefao.getControleChefao().draw(g);
		
		for (DataIndependencia data: datas) {
			if (data.isData_coletada()) {
				data.setWidth(0);
				data.setHeight(0);
				data = null;
			}else {
				data.getControleDataIndependencia().draw(g);	
			}	
		}
		
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

	public static Chefao getChefao() {
		return chefao;
	}

	public static void setChefao(Chefao chefao) {
		Fase3_Single.chefao = chefao;
	}

	
}
