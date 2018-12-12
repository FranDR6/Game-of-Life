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

	int lado = 35;
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
				botonera[x][y].setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
				botonera[x][y].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton boton = (JButton) e.getSource();
						String[] coordenadas = boton.getName().split(" ");
						int x = Integer.valueOf(coordenadas[0]);
						int y = Integer.valueOf(coordenadas[1]);
						botonera[x][y].setBackground(Color.WHITE);
						tableroOculto[x][y] = 1;
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

	protected void actualizarColores(int[][] tablero) {
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

	private void iniciar() {
		for (int x = 0; x < tableroOculto.length; x++) {
			for (int y = 0; y < tableroOculto.length; y++) {
				tableroVisible[x][y] = isVivo(x, y, tableroOculto);
			}
		}
		System.arraycopy(tableroVisible, 0, tableroOculto, 0, tableroOculto.length);
		actualizarColores(tableroVisible);
		actualizarPantalla();
	}

	protected int isVivo(int x, int y, int[][] tablero) {
		int contador = 0;
		for (int i = x - 1; i < x + 2; i++) {
			for (int j = y - 1; j < y + 2; j++) {
				if (i < 0 || j < 0 || i > tablero.length - 1 || j > tablero.length - 1) {
					continue;
				}
				if (tablero[i][j] == 1) {
					contador++;
				}
			}
		}
		if (tablero[x][y] == 1) {
			contador--;
			if (contador == 2 || contador == 3) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (contador == 3) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	public void actualizarPantalla() {
		SwingUtilities.updateComponentTreeUI(getContentPane());
	}

	void Pausa() {
		@SuppressWarnings("rawtypes")
		final SwingWorker worker = new SwingWorker() {

			@Override
			protected Object doInBackground() throws Exception {
				try {
					Thread.sleep(50);
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
