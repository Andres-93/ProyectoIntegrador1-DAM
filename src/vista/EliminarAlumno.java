package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Alumno;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Cursor;

public class EliminarAlumno extends JPanel {
	private JButton btnEliminarAl;
	private JButton btnCancelar;
	private JList list;

	public EliminarAlumno() {
		inicializar();
	}

	private void inicializar() {

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setLayout(null);

		JLabel lblListaAlumnos = new JLabel("LISTA ALUMNOS:");
		lblListaAlumnos.setForeground(Color.WHITE);
		lblListaAlumnos.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblListaAlumnos.setBounds(97, 178, 204, 41);
		add(lblListaAlumnos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 242, 498, 249);
		add(scrollPane);

		list = new JList();
		scrollPane.setViewportView(list);

		btnEliminarAl = new JButton("");
		btnEliminarAl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarAl
				.setRolloverIcon(new ImageIcon(EliminarAlumno.class.getResource("/images/botonEliminarPulsado.png")));
		btnEliminarAl.setIcon(new ImageIcon(EliminarAlumno.class.getResource("/images/BotonoEliminar.png")));
		btnEliminarAl.setFocusPainted(false);
		btnEliminarAl.setContentAreaFilled(false);
		btnEliminarAl.setBorder(null);
		btnEliminarAl.setBorderPainted(false);
		btnEliminarAl.setBounds(130, 550, 193, 49);
		add(btnEliminarAl);

		JLabel lblEliminarAlumno = new JLabel("ELIMINAR ALUMNO");
		lblEliminarAlumno.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarAlumno.setForeground(Color.WHITE);
		lblEliminarAlumno.setFont(new Font("Sitka Small", Font.BOLD, 50));
		lblEliminarAlumno.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblEliminarAlumno.setBounds(97, 41, 549, 90);
		add(lblEliminarAlumno);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar
				.setRolloverIcon(new ImageIcon(EliminarAlumno.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(EliminarAlumno.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(433, 544, 188, 55);
		add(btnCancelar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EliminarAlumno.class.getResource("/images/FondoAlumnos700X700.png")));
		lblNewLabel.setBounds(0, 0, 700, 626);
		add(lblNewLabel);
	}

	public void setControlador(ControladorApp c) { // Deberemos presentarle todos los botones al controlador
		btnCancelar.addActionListener(c);
		btnEliminarAl.addActionListener(c);
	}

	public JButton getBtnEliminarAl() {
		return btnEliminarAl;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void mostrarAlumnos(ArrayList<Alumno> alumnos) {

		DefaultListModel<Alumno> model = new DefaultListModel<Alumno>();

		for (int i = 0; i < alumnos.size(); i++) {

			model.addElement(alumnos.get(i));
		}
		list.setModel(model);
	}

	// DEMOMENTO SOLO PERMITO ELIMINAR UN ALUMNO SELECCIONANDOLO.
	public Alumno alumnosAEliminar() {

		Alumno al = null;

		al = (Alumno) list.getSelectedValue();

		return al;
	}

}
