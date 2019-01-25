package control;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.border.MatteBorder;

public class Principal extends Vista {

	int lado = 50;
	int[][] tableroOculto = new int[lado][lado];
	int[][] tableroVisible = new int[lado][lado];
	JButton[][] botonera = new JButton[lado][lado];

	public Principal() {
		super();
		crearBotonera();
		listenerEmpezar();
	}

	private void crearBotonera() {
		panelBotonera.setLayout(new GridLayout(lado, lado));
		for (int x = 0; x < botonera.length; x++) {
			for (int y = 0; y < botonera.length; y++) {
				botonera[x][y] = new JButton();
				botonera[x][y].setName(x + " " + y);
				botonera[x][y].setBackground(Color.BLACK);
				botonera[x][y].setBorder(new MatteBorder(1, 1, 1, 1, Color.white));
				botonera[x][y].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton boton = (JButton) e.getSource();
						String[] coordenadas = boton.getName().split(" ");
						int x = Integer.valueOf(coordenadas[0]);
						int y = Integer.valueOf(coordenadas[1]);

						if (tableroOculto[x][y] == 0) {
							botonera[x][y].setBackground(Color.WHITE);
							tableroOculto[x][y] = 1;
						} else {
							botonera[x][y].setBackground(Color.BLACK);
							tableroOculto[x][y] = 0;
						}
					}
				});
				panelBotonera.add(botonera[x][y]);
			}
		}
		actualizarPantalla();
	}

	private void listenerEmpezar() {
		btnEmpezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pausa();
			}
		});
	}

	private void actualizarColores(int[][] tablero) {
		for (int x = 0; x < tablero.length; x++) {
			for (int y = 0; y < tablero.length; y++) {
				if (tablero[x][y] == 1) {
					botonera[x][y].setBackground(Color.WHITE);
					botonera[x][y].setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));
				} else {
					botonera[x][y].setBackground(Color.BLACK);
					botonera[x][y].setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
				}
			}
		}
	}

	public void iniciar() {
		// MODIFICA EL TABLERO VISIBLE A PARTIR DEL OCULTO
		for (int x = 0; x < tableroOculto.length; x++) {
			for (int y = 0; y < tableroOculto.length; y++) {
				tableroVisible[x][y] = isVivo(x, y, tableroOculto);
			}
		}

		// HACEMOS QUE TABLERO OCULTO SEA IGUAL AL VISIBLE
		for (int i = 0; i < botonera.length; i++) {
			for (int j = 0; j < botonera.length; j++) {
				tableroOculto[i][j] = tableroVisible[i][j];
			}
		}

		actualizarColores(tableroVisible);
		actualizarPantalla();
	}

	public static int isVivo(int x, int y, int[][] tablero) {
		int contador = 0;
		if (tablero[x][y] == 1) { // CUANDO ESTA VIVA
			for (int i = x - 1; i < x + 2; i++) {
				for (int j = y - 1; j < y + 2; j++) {
					if (i < 0 || j < 0 || i > tablero.length - 1 || j > tablero.length - 1 || (i == x && j == y)) {
						continue;
					}
					if (tablero[i][j] == 1) {
						contador++;
					}
				}
			}
			if (contador == 2 || contador == 3) { // CONDICON PARA MANTENERSE VIVA
				return 1;
			} else {
				return 0;
			}
		} else { // CUANDO ESTA MUERTA
			for (int i = x - 1; i < x + 2; i++) {
				for (int j = y - 1; j < y + 2; j++) {
					if (i < 0 || j < 0 || i > tablero.length - 1 || j > tablero.length - 1 || (i == x && j == y)) {
						continue;
					}
					if (tablero[i][j] == 1) {
						contador++;
					}
				}
			}

			if (contador == 3) { // CONDICION PARA RENACER
				return 1;
			} else {
				return 0;
			}

		}
	}

	private void actualizarPantalla() {
		SwingUtilities.updateComponentTreeUI(getContentPane());
	}

	void Pausa() {
		@SuppressWarnings("rawtypes")
		final SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				try {
					Thread.sleep(80);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				iniciar();
				Pausa();
				return null;
			}
		};
		worker.execute();
	}

}
