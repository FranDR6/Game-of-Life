package VersionCanvas;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.invoke.CallSite;
import java.util.Random;

public class Tablero {

	private int[][] celulasOcultas;
	private int[][] celulasVisibles;

	private Raton raton;

	public Tablero(int i, int j) {
		super();
		this.celulasOcultas = new int[i][j];
		this.celulasVisibles = new int[i][j];

		for (int x = 0; x < celulasOcultas.length; x++) {
			for (int y = 0; y < celulasOcultas[x].length; y++) {
				celulasOcultas[x][y] = obtenerNumeroAleatorio(0, 1);
			}
		}

		this.raton = new Raton();
	}

	public void dibujar(Graphics g, boolean vida, int cuadrado) {

		raton.actualizar();
		raton.dibujar();

		if (vida) {

			actualizarCelulas();

			for (int i = 0; i < celulasOcultas.length; i++) {
				for (int j = 0; j < celulasOcultas[i].length; j++) {

					g.setColor(obtenerColor(celulasVisibles[i][j]));
					g.fillRect(i * cuadrado, j * cuadrado, cuadrado, cuadrado);
				}
			}
		}
	}

	private void actualizarCelulas() {
		for (int i = 0; i < celulasOcultas.length; i++) {
			for (int j = 0; j < celulasOcultas[i].length; j++) {
				celulasVisibles[i][j] = isLife(i, j);
			}
		}
		
		for (int i = 0; i < celulasOcultas.length; i++) {
			for (int j = 0; j < celulasOcultas[i].length; j++) {
				celulasOcultas[i][j] = celulasVisibles[i][j];
			}
		}
//		celulasOcultas = celulasVisibles;
	}

	private Color obtenerColor(int numero) {
		if (numero == 1) {
			return Color.WHITE;
		} else {
			return Color.BLACK;
		}
	}

	private int isLife(int x, int y) {
		int contador = 0;

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i < 0 || j < 0 || i > celulasOcultas.length - 1 || j > celulasOcultas[i].length - 1
						|| (i == x && j == y)) {
					continue;
				}
				if (celulasOcultas[i][j] == 1) {
					contador++;
				}
			}
		}

		return obtenerVida(x, y, contador);
	}

	private int obtenerVida(int x, int y, int contador) {
		switch (celulasOcultas[x][y]) {
		case 0:
			if (contador == 3) {
				return 1;
			} else {
				return 0;
			}
		case 1:
			if (contador == 2 || contador == 3) {
				return 1;
			} else {
				return 0;
			}
		default:
			return 0;
		}
	}

	private static int obtenerNumeroAleatorio(int min, int max) {
		max++;
		Random aleatorio = new Random();
		return aleatorio.nextInt(max - min) + min;
	}

}
