package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Alumno;

import java.awt.Cursor;

public class ModificarAlumno extends JDialog {
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textExp;
	private JButton btnModificarJD;
	private JButton btnCancelar;

	public ModificarAlumno() {
		inicializar();
	}

	private void inicializar() {
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Nombre");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sitka Small", Font.BOLD, 20));
		label.setBounds(60, 134, 188, 42);
		getContentPane().add(label);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblApellidos.setBounds(60, 235, 188, 42);
		getContentPane().add(lblApellidos);

		JLabel lblNumeroDeExpediente = new JLabel("Numero de Expediente");
		lblNumeroDeExpediente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDeExpediente.setForeground(Color.WHITE);
		lblNumeroDeExpediente.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblNumeroDeExpediente.setBounds(45, 343, 262, 42);
		getContentPane().add(lblNumeroDeExpediente);

		textNombre = new JTextField();
		textNombre.setBounds(330, 125, 221, 42);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(330, 235, 221, 42);
		getContentPane().add(textApellidos);

		textExp = new JTextField();
		textExp.setColumns(10);
		textExp.setBounds(330, 343, 221, 42);
		getContentPane().add(textExp);

		btnCancelar = new JButton("");
		btnCancelar
				.setRolloverIcon(new ImageIcon(ModificarAlumno.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(ModificarAlumno.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(363, 551, 188, 55);
		getContentPane().add(btnCancelar);

		JLabel lblModificarAlumno = new JLabel("MODIFICAR ALUMNO");
		lblModificarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarAlumno.setForeground(Color.WHITE);
		lblModificarAlumno.setFont(new Font("Sylfaen", Font.BOLD, 44));
		lblModificarAlumno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblModificarAlumno.setBounds(45, 23, 506, 72);
		getContentPane().add(lblModificarAlumno);

		btnModificarJD = new JButton("");
		btnModificarJD
				.setRolloverIcon(new ImageIcon(ModificarAlumno.class.getResource("/images/botonModificarPulsado.png")));
		btnModificarJD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarJD.setIcon(new ImageIcon(ModificarAlumno.class.getResource("/images/botonModificar.png")));
		btnModificarJD.setFocusPainted(false);
		btnModificarJD.setContentAreaFilled(false);
		btnModificarJD.setBorderPainted(false);
		btnModificarJD.setBorder(null);
		btnModificarJD.setBounds(71, 551, 188, 55);
		getContentPane().add(btnModificarJD);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ModificarAlumno.class.getResource("/images/FondoAlumnos700X700.png")));
		lblNewLabel.setBounds(0, 0, 584, 668);
		getContentPane().add(lblNewLabel);
		setBounds(0, 0, 594, 646);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
	}

	public void setControlador(ControladorApp c) { // Deberemos presentarle todos los botones al controlador
		btnModificarJD.addActionListener(c);
		btnCancelar.addActionListener(c);
	}

	public JButton getBtnModificarJD() {
		return btnModificarJD;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void hacerVisible() {
		setVisible(true);
	}

	public void mostrarDatos(Alumno al) throws NullPointerException {
		textNombre.setText(al.getNombre());
		textExp.setText(al.getExpediente() + "");

	}

	public Alumno getDatos() {

		Alumno alumno = null;
		try {
			alumno = new Alumno(textNombre.getText(), Integer.parseInt(textExp.getText()));
		} catch (NumberFormatException e) {
			JOptionPane.showConfirmDialog(null, "Error, el expediente deben ser unicamente numeros",
					"Error al introducir datos", JOptionPane.CANCEL_OPTION);
		}

		return alumno;
	}
}
