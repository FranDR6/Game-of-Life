package VersionCanvas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Tablero {

	private int[][] celulas;

	public Tablero(int i, int j) {
		super();
		this.celulas = new int[i][j];
	}

	public void dibujar(Graphics g) {

		for (int i = 0; i < celulas.length; i++) {
			for (int j = 0; j < celulas[i].length; j++) {

				switch (obtenerNumeroAleatorio(0, 1)) {
				case 0:
					g.setColor(Color.WHITE);
					break;
				case 1:
					g.setColor(Color.BLACK);
					break;
				}

				g.fillRect(i * 20, j * 20, 20, 20);
			}
		}
	}

	private static int obtenerNumeroAleatorio(int min, int max) {
		max++;
		Random aleatorio = new Random();
		return aleatorio.nextInt(max - min) + min;
	}

}
