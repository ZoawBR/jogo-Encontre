package model;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Som {
	
	private AudioClip somMusicaAmbienteMenu, somMusicaAmbienteGame, somBipMenu, somTiro, semMunicao, somMorteMonstro, somRecarregarArma,
	sommortePlayer, somfogo, somFase3;
	// BUSCAR MUSICAS AKI https://www.freesfx.co.uk/Category/Horror/223
	// EFEITOS GRITO https://www.freesfx.co.uk/Category/Screams/263
	// COROI QUE MEDO https://www.freesfx.co.uk/Category/Screams/263
	public Som(){
		try {
			System.out.println("Abriu");
			somBipMenu = Applet.newAudioClip(Som.class.getResource("/som/menu.wav").toURI().toURL());
			somMusicaAmbienteGame = Applet.newAudioClip(Som.class.getResource("/som/somClimatizaçãoSuspense2.wav").toURI().toURL());
			somMusicaAmbienteMenu = Applet.newAudioClip(Som.class.getResource("/som/somViolino.wav").toURI().toURL());
			somTiro = Applet.newAudioClip(Som.class.getResource("/som/tiro.wav").toURI().toURL());
			semMunicao = Applet.newAudioClip(Som.class.getResource("/som/sem_municao.wav").toURI().toURL());
			somMorteMonstro = Applet.newAudioClip(Som.class.getResource("/som/monstro_morte.wav").toURI().toURL());
			somRecarregarArma = Applet.newAudioClip(Som.class.getResource("/som/recarregando_arma.wav").toURI().toURL());
			sommortePlayer = Applet.newAudioClip(Som.class.getResource("/som/morte_player.wav").toURI().toURL());
			somfogo = Applet.newAudioClip(Som.class.getResource("/som/som_fogo.wav").toURI().toURL());
			somFase3 = Applet.newAudioClip(Som.class.getResource("/som/som_fase3.wav").toURI().toURL());

		}catch (Exception e) {
			System.out.println("Não abriu");
		}
	}

	public void somMusicaAmbienteGamePlay(){somMusicaAmbienteGame.play();}
	public void somMusicaAmbienteGameStop(){somMusicaAmbienteGame.stop();}
	
	public void somMusicaAmbienteMenuPlay(){somMusicaAmbienteMenu.play();}
	public void somMusicaAmbienteMenuStop(){somMusicaAmbienteMenu.stop();}
	
	public void somFase3Play(){somFase3.loop();}
	public void somFase3Stop(){somFase3.stop();}
	
	public void somBipMenuPlay() {somBipMenu.play();}
	public void somBipMenuStop() {somBipMenu.stop();}
	
	public void somTiroPlay() {somTiro.play();}
	public void somTiroStop() {somTiro.stop();}
	
	public void somBolaFogoPlay() {somfogo.play();}
	public void somBolaFogoStop() {somfogo.stop();}
	
	public void somSemMunicao() {semMunicao.play();}
	
	public void somMonstroMortePlay() {somMorteMonstro.play();}
	
	public void somRecarregandoArma() {somRecarregarArma.play();}
	
	public void somMortePlayer() {sommortePlayer.play();}
}