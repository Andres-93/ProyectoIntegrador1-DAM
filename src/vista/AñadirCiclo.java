package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Ciclo;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class AñadirCiclo extends JPanel {
	private JTextField textNomCiclo;
	private JButton btnCancelCicloA;
	private JTextArea textDescrpCiclo;
	private JButton btnAnadirCiclo;

	public AñadirCiclo() {
		inicializar();
	}

	private void inicializar() {
		setLayout(null);

		JLabel lblAadirCiclos = new JLabel("A\u00D1ADIR CICLOS");
		lblAadirCiclos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirCiclos.setForeground(Color.WHITE);
		lblAadirCiclos.setFont(new Font("Sitka Small", Font.BOLD, 50));
		lblAadirCiclos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblAadirCiclos.setBounds(97, 62, 521, 90);
		add(lblAadirCiclos);

		JLabel lblNombreDelCiclo = new JLabel("Nombre del Ciclo");
		lblNombreDelCiclo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelCiclo.setForeground(Color.WHITE);
		lblNombreDelCiclo.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblNombreDelCiclo.setBounds(100, 207, 215, 42);
		add(lblNombreDelCiclo);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblDescripcion.setBounds(116, 336, 173, 42);
		add(lblDescripcion);

		btnCancelCicloA = new JButton("");
		btnCancelCicloA
				.setRolloverIcon(new ImageIcon(AñadirCiclo.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelCicloA.setIcon(new ImageIcon(AñadirCiclo.class.getResource("/images/BotonCancelar.png")));
		btnCancelCicloA.setFocusPainted(false);
		btnCancelCicloA.setContentAreaFilled(false);
		btnCancelCicloA.setBorderPainted(false);
		btnCancelCicloA.setBorder(null);
		btnCancelCicloA.setBounds(484, 501, 188, 55);
		add(btnCancelCicloA);

		textNomCiclo = new JTextField();
		textNomCiclo.setColumns(10);
		textNomCiclo.setBounds(405, 219, 245, 36);
		add(textNomCiclo);

		textDescrpCiclo = new JTextArea();
		textDescrpCiclo.setBounds(374, 346, 274, 75);
		add(textDescrpCiclo);

		btnAnadirCiclo = new JButton("");
		btnAnadirCiclo
				.setRolloverIcon(new ImageIcon(AñadirCiclo.class.getResource("/images/PulsadoBotonA\u00F1adir.png")));
		btnAnadirCiclo.setIcon(new ImageIcon(AñadirCiclo.class.getResource("/images/BotonA\u00F1adir.png")));
		btnAnadirCiclo.setFocusPainted(false);
		btnAnadirCiclo.setContentAreaFilled(false);
		btnAnadirCiclo.setBorderPainted(false);
		btnAnadirCiclo.setBorder(null);
		btnAnadirCiclo.setBounds(173, 501, 188, 55);
		add(btnAnadirCiclo);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AñadirCiclo.class.getResource("/images/FondoAlumnos700X700.png")));
		label.setBounds(0, 0, 700, 625);
		add(label);
	}

	public void setControlador(ControladorApp c) { // Deberemos presentarle todos los botones al controlador
		btnCancelCicloA.addActionListener(c);
		btnAnadirCiclo.addActionListener(c);
	}

	public JButton getBtnCancelCicloA() {
		return btnCancelCicloA;
	}

	public JButton getBtnAnadirCiclo() {
		return btnAnadirCiclo;
	}

	public Ciclo getDatos() {

		Ciclo ci;

		ci = new Ciclo(textNomCiclo.getText().toUpperCase(), textDescrpCiclo.getText());

		return ci;
	}

}
