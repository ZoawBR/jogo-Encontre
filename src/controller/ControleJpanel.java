package controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import model.Personagem;
import model.Porta;
import model.Questao;
import model.XML_dados_questoes;

public class ControleJpanel implements ActionListener{

	public static Game game;
	public static  Personagem player;
	static String resposta;

	public ControleJpanel(Game game, Personagem player) {
		this.game = game;
		this.player=player;

		game.getTela().getOp1().addActionListener(this);
		game.getTela().getOp2().addActionListener(this);
		game.getTela().getOp3().addActionListener(this);
		
		ControladorDeObjetos.getTelaOver().getRetornarMenu().addActionListener(this);
	}

	public void atualizarJpanel() {
		game.getTela().getVidaLbl().setText("Vidas: " + game.getChances());
		game.getTela().getMunicaoLbl().setText("Munição: " + player.getMunicao());
		game.getTela().getBolaDeFogoLBL().setText("Bola(s) de fogo: " + player.getBolas());
		game.getTela().getFpslbl().setText("FPS: " + game.getTicker());

	}

	public static void mudarJpanelMissaoVermelho() {
		game.getTela().getVermelho().setVisible(true);
	}
	public static void mudarJpanelMissaoAzul() {
		game.getTela().getAzul().setVisible(true);
	}
	public static void mudarJpanelMissaoAmarelo() {
		game.getTela().getAmarelo().setVisible(true);
	}

	public static void mudarJpanelMissao3() {
		game.getTela().getTres().setVisible(true);
	}
	public static void mudarJpanelMissao5() {
		game.getTela().getCinco().setVisible(true);
	}
	public static void mudarJpanelMissao7() {
		game.getTela().getSete().setVisible(true);
	}

	public static void mudarJpanelMissaoDataDia() {
		game.getTela().getDiaLbl().setVisible(true);
	}
	public static void mudarJpanelMissaoDataBarra() {
		game.getTela().getBarraLbl().setVisible(true);
	}
	public static void mudarJpanelMissaoDataMes() {
		game.getTela().getMesLbl().setVisible(true);
	}

	public static void limparJlabel() {
		game.getTela().getAzul().setVisible(false);
		game.getTela().getVermelho().setVisible(false);
		game.getTela().getAmarelo().setVisible(false);
		game.getTela().getSete().setVisible(false);
		game.getTela().getTres().setVisible(false);
		game.getTela().getCinco().setVisible(false);
		game.getTela().getDiaLbl().setVisible(false);
		game.getTela().getMesLbl().setVisible(false);
		game.getTela().getBarraLbl().setVisible(false);
	}

	public static void mudarJpanelMissao() {
		game.getTela().getMissaoLbl().setText("Missao: Encontre 3 cores primarias!");
	}

	public static void mudarJpanelMissaoNumero() {
		game.getTela().getMissaoLbl().setText("Missao: Encontre 3 numeros primos!");
	}

	public static void mudarJpanelMissaoData() {
		game.getTela().getMissaoLbl().setText("Missao: Encontre os numeros respectivos a data da independencia do brasil!");
	}

	// mudar tudpooooo
	public static void tirarAviso() {
		Porta porta = ControladorDeObjetos.getPorta();
		if (game.getKeyPrincipal().tirarAviso && ControladorDeColisoes.colisaoPlayer(new Rectangle(porta.getPosX(), porta.getPosY(), porta.getWidth(), porta.getHeight()))) {
			game.getTela().getPanelAviso().setVisible(false);
			ControladorDeObjetos.getPlayer().setRespondendo(false);
		}
	}

	public static void mudarJpanelMissaoQst() {
		game.getTela().getPanelAviso().setVisible(true);
		player.setRespondendo(true);
		XML_dados_questoes.LerDados();
		Random r = new Random();
		Questao qst = XML_dados_questoes.getPerguntas().get(r.nextInt(XML_dados_questoes.getPerguntas().size()));
		resposta = qst.getOpCorreta();
		game.getTela().getMensagemErro().setText(qst.getPergunta());
		game.getTela().getOp1().setText(qst.getOp1());
		game.getTela().getOp2().setText(qst.getOp2());
		game.getTela().getOp3().setText(qst.getOp3());

	}

	public static void mudarJpanelPorta(String string) {
		game.getTela().getPanelAviso().setVisible(true);
		game.getTela().getMensagemErro().setText("Missao incompleta. Faltam " + (-ControladorDeObjetos.getPlayer().getObjetivos() + 3) + string);
		game.getKeyPrincipal().setKeys(new boolean[256]);
	}
	// mudar tudpooooo

	public static void gameOver() {
		game.getTela().setVisible(false);
		ControladorDeObjetos.getTelaOver().setVisible(true);
		game.setFase1(true);
		game.setFase2(false);
		ControladorDeObjetos.getSom().somFase3Stop();
		ControladorDeObjetos.getSom().somMusicaAmbienteGameStop();
		ControladorDeObjetos.getSom().somMusicaAmbienteMenuPlay();
		game.stop();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == game.getTela().getOp1()) {
			if (game.getTela().getOp1().getText().equalsIgnoreCase(resposta)) {
			}else {
				game.setChances(game.getChances()-1);
			}
			game.getTela().getPanelAviso().setVisible(false);

		}
		if (e.getSource() == game.getTela().getOp2()) {
			if (game.getTela().getOp2().getText().equalsIgnoreCase(resposta)) {
			}else {
				game.setChances(game.getChances()-1);
			}
			game.getTela().getPanelAviso().setVisible(false);

		}
		if (e.getSource() == game.getTela().getOp3()) {
			if (game.getTela().getOp3().getText().equalsIgnoreCase(resposta)) {
			}else {
				game.setChances(game.getChances()-1);
			}
			game.getTela().getPanelAviso().setVisible(false);
		}
		
		if(game.getChances() < 0) {
			gameOver();
		}
		player.setRespondendo(false);

	
		if(e.getSource() == ControladorDeObjetos.getTelaOver().getRetornarMenu()) {
			ControladorDeObjetos.getTelaOver().setVisible(false);
			ControladorDeObjetos.getTelaMenu().setVisible(true);
		}
	}

}
