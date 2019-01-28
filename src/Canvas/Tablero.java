package Canvas;

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

//		System.out.println(celulasOcultas.length + " " + celulasOcultas[0].length);

		// PATRON
//		celulasOcultas[95][47] = 1;
//		celulasOcultas[94][48] = 1;
//		celulasOcultas[96][47] = 1;
//		celulasOcultas[96][48] = 1;
//		celulasOcultas[97][46] = 1;
//		celulasOcultas[98][46] = 1;
//		celulasOcultas[98][47] = 1;
//		celulasOcultas[98][48] = 1;
//		celulasOcultas[98][44] = 1;
//		celulasOcultas[96][44] = 1;
//		celulasOcultas[95][44] = 1;
//		celulasOcultas[94][44] = 1;
//		celulasOcultas[94][45] = 1;

		this.raton = new Raton();
	}

	public void dibujar(Graphics g, boolean vida, int cuadrado) {

		raton.actualizar();
//		raton.dibujar();

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

	public static int obtenerNumeroAleatorio(int min, int max) {
		max++;
		Random aleatorio = new Random();
		return aleatorio.nextInt(max - min) + min;
	}

	public int[][] getCelulasOcultas() {
		return celulasOcultas;
	}

	public void setCelulasOcultas(int[][] celulasOcultas) {
		this.celulasOcultas = celulasOcultas;
	}

	public int[][] getCelulasVisibles() {
		return celulasVisibles;
	}

	public void setCelulasVisibles(int[][] celulasVisibles) {
		this.celulasVisibles = celulasVisibles;
	}

}
