package controller;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import model.Fase;
import model.Fase2_Single;
import model.Fase3_Single;
import model.Inimigo;
import model.Personagem;
import model.Porta;
import model.Som;
import view.TelaGameOver;
import view.TelaMenu;

public class ControladorDeObjetos {
		
		private static List<Rectangle> colisao;
		private static Personagem player;
		private static ArrayList<Inimigo> inimigos;
		private static Som som;
		private static Game game;
		private static Porta porta;
		private static ControleJpanel controleJpanel;
		private static TelaGameOver telaOver;
		private static TelaMenu telaMenu;
		
		
		public static void iniciarFase2() {
			ControleJpanel.limparJlabel();
			Game.setFase1(false);
			Game.setFase2(true);
			Fase.setFaseAtual(null);
			Fase.setFaseAtual(new Fase2_Single(game));
		}
		
		public static void iniciarFase3() {
			ControleJpanel.limparJlabel();
			Game.setFase2(false);
			Fase.setFaseAtual(null);
			Fase.setFaseAtual(new Fase3_Single(game));
		}

		public static ControleJpanel getControleJpanel() {
			return controleJpanel;
		}


		public static void setControleJpanel(ControleJpanel controleJpanel) {
			ControladorDeObjetos.controleJpanel = controleJpanel;
		}

		public static Porta getPorta() {
			return porta;
		}


		public static TelaMenu getTelaMenu() {
			return telaMenu;
		}

		public static void setTelaMenu(TelaMenu telaMenu) {
			ControladorDeObjetos.telaMenu = telaMenu;
		}

		public static TelaGameOver getTelaOver() {
			return telaOver;
		}

		public static void setTelaOver(TelaGameOver telaOver) {
			ControladorDeObjetos.telaOver = telaOver;
		}

		public static void setPorta(Porta porta) {
			ControladorDeObjetos.porta = porta;
		}

		public static Game getGame() {
			return game;
		}

		public static void setGame(Game game) {
			ControladorDeObjetos.game = game;
		}
		
		public static Som getSom() {
			return som;
		}

		public static void setSom(Som som) {
			ControladorDeObjetos.som = som;
		}

		public static Personagem getPlayer() {
			return player;
		}

		public static ArrayList<Inimigo> getInimigos() {
			return inimigos;
		}

		public static void setInimigos(ArrayList<Inimigo> inimigos) {
			ControladorDeObjetos.inimigos = inimigos;
		}

		public static void setPlayer(Personagem player) {
			ControladorDeObjetos.player = player;
		}

		public static List<Rectangle> getColisao() {
			return colisao;
		}

		public static void setColisao(List<Rectangle> colisao) {
			ControladorDeObjetos.colisao = colisao;
		}

		
		
		
		
	
}
