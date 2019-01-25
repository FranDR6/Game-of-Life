package VersionCanvas;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 5300880680876136593L;

	protected int ALTO = 800;
	protected int ANCHO = 800;

	public Ventana(vistaCanvas dibujo) {
		configurarVentana(dibujo);
	}

	private void configurarVentana(vistaCanvas dibujo) {
		setTitle("Juego de la Vida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		add(dibujo, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
