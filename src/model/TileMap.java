
package model;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;

public class TileMap {
  
	private int numeroColunas;
	private int numeroLinhas;
	private int colunasTileSet;
	private int tileSize;
	

	private int camada[][];
	private int mapaLargura;
	private int mapaAltura;

	private BufferedImage tileSet;
	private BufferedImage mapa;
	
	private Graphics2D dbg;
	
	private boolean fase;

	

	public TileMap(int numeroColunas, int numeroLinhas, int colunasTileSet, int tileSize,
	              String nomeTileSet, String nomeMapaMatriz, boolean fase) {
		
	  this.numeroColunas = numeroColunas;
	  this.numeroLinhas = numeroLinhas;
	  this.colunasTileSet = colunasTileSet;
	  this.tileSize = tileSize;
	  this.fase = fase;
	  
	  this.mapaLargura = numeroColunas * tileSize;
	  this.mapaAltura = numeroLinhas * tileSize;
	  
	  mapa = new BufferedImage(mapaLargura, mapaAltura, BufferedImage.TYPE_4BYTE_ABGR);
	  dbg = mapa.createGraphics();
	  
		try {
			tileSet = ImageIO.read(getClass().getClassLoader().getResourceAsStream(nomeTileSet));
		} catch (IOException e) {
			System.out.println("Não conseguiu ler Tileset");
			e.printStackTrace();
		}
		
		camada=carregarMatriz(nomeMapaMatriz);
	
	}
	
	public void montarMapa() {
		mapa.createGraphics();

		int tile;
		int tileRow;
		int tileCol;
		for (int i = 0; i < numeroLinhas; i++) {
			for (int j = 0; j < numeroColunas; j++) {
				tile = (camada[i][j] != 0) ? (camada[i][j] - 1) : 0;
				tileRow = (tile / colunasTileSet) | 0;
				tileCol = (tile % colunasTileSet) | 0;
				dbg.drawImage(tileSet, (j * tileSize), (i * tileSize), (j * tileSize) + tileSize,
						(i * tileSize) + tileSize, (tileCol * tileSize), (tileRow * tileSize),
						(tileCol * tileSize) + tileSize, (tileRow * tileSize) + tileSize, null);

			}
		}
	}

	public ArrayList<Rectangle> montarColi() {
		ArrayList<Rectangle> tmp=new ArrayList<>();
		int tile;
		int tileRow;
		int tileCol;
		for (int i = 0; i < numeroLinhas; i++) {
			for (int j = 0; j < numeroColunas; j++) {
				if(camada[i][j] != 0) {
					tmp.add(new Rectangle( (j * 32), (i * 32), 32, 32));
				}
				
			}
		}
		return tmp;
	}
	
	public int[][] carregarMatriz(String nomeMapa) {
		int[][] matz = new int[numeroLinhas][numeroColunas];

		InputStream input = getClass().getClassLoader().getResourceAsStream(nomeMapa);
		BufferedReader br = new BufferedReader(new InputStreamReader(input));

		ArrayList<String> linhas = new ArrayList<>();
		String linha = "";

		try {
			while ((linha = br.readLine()) != null)
				linhas.add(linha);

			int coluna = 0;
			for (int i = 0; i < linhas.size(); i++) {
				StringTokenizer token = new StringTokenizer(linhas.get(i), ",");

				while (token.hasMoreElements()) {
					matz[i][coluna] = Integer.parseInt(token.nextToken());
					coluna++;
				}
				coluna = 0;
			}

		} catch (IOException e) {
			System.out.println("Não carregou Matriz");
			e.printStackTrace();
		}

		return matz;
	}

	public BufferedImage getMapa() {
    return mapa;
  }
	
	public int getMapaLargura() {
		return mapaLargura;
	}
	
	public int getMapaAltura() {
		return mapaAltura;
	}
	public boolean getFase() {
		return fase;
	}
}

