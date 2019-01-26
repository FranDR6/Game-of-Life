package VersionCanvas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class VentanaBotones extends JFrame {

	private JPanel contentPane;

	public JButton btnIniciar;
	public JButton btnPausar;

	public VentanaBotones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setBounds(0, 0, 256, 124);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnPausar = new JButton("Pausar");
		btnPausar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnPausar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(20)
						.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGap(20).addComponent(btnPausar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(70, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(20)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPausar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnIniciar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(195, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}
}
