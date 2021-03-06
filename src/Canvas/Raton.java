package Canvas;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Raton extends MouseAdapter {

	private Point posicion;

	public Raton() {

		this.posicion = new Point();
		actualizarPosicion();
	}

	public void dibujar(JLabel label) {
		label.setText("X: " + posicion.getX() + " Y: " + posicion.getY());
	}

	public void actualizar() {
		actualizarPosicion();
	}

	private void actualizarPosicion() {
		final Point posicionInicial = MouseInfo.getPointerInfo().getLocation();
		posicion.setLocation(posicionInicial.getX(), posicionInicial.getY());
	}
}
