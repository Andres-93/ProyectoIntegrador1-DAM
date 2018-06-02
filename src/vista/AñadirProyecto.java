package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

import controlador.ControladorApp;
import modelo.Alumno;
import modelo.Ciclo;
import modelo.Proyecto;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Cursor;

public class AñadirProyecto extends JPanel {
	private JTextField textNombre;
	private JTextField textUrl;
	private JSpinner spinnerNota;
	private JSpinner spinnerAno;
	private JComboBox<String> comboBoxGrupo;
	private JComboBox comboBoxCiclo;
	private JList<Alumno> listAlumnos;
	private JButton btnAnadir;
	private JSpinner spinnerCurso;

	public AñadirProyecto() {
		inicializar();
	}

	private void inicializar() {
		setLayout(null);
		setBounds(0, 0, 700, 625);

		JLabel lblAadirProyecto = new JLabel("A\u00D1ADIR PROYECTO");
		lblAadirProyecto.setBorder(new LineBorder(Color.WHITE, 2));
		lblAadirProyecto.setFont(new Font("Sitka Text", Font.BOLD, 42));
		lblAadirProyecto.setForeground(Color.WHITE);
		lblAadirProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirProyecto.setBounds(132, 11, 431, 73);
		add(lblAadirProyecto);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(10, 131, 104, 29);
		add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(112, 131, 177, 29);
		add(textNombre);
		textNombre.setColumns(10);

		JLabel lblUrlGithub = new JLabel("URL GITHUB");
		lblUrlGithub.setHorizontalAlignment(SwingConstants.CENTER);
		lblUrlGithub.setForeground(Color.WHITE);
		lblUrlGithub.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUrlGithub.setBounds(317, 131, 104, 29);
		add(lblUrlGithub);

		textUrl = new JTextField();
		textUrl.setColumns(10);
		textUrl.setBounds(461, 131, 177, 29);
		add(textUrl);

		JLabel lblNota = new JLabel("NOTA");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setForeground(Color.WHITE);
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNota.setBounds(10, 186, 104, 29);
		add(lblNota);

		spinnerNota = new JSpinner();
		spinnerNota.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerNota.setBounds(112, 184, 63, 36);
		add(spinnerNota);

		JLabel lblAo = new JLabel("A\u00D1O");
		lblAo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAo.setForeground(Color.WHITE);
		lblAo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAo.setBounds(10, 331, 104, 29);
		add(lblAo);

		spinnerAno = new JSpinner();
		spinnerAno.setModel(new SpinnerNumberModel(2018, 2018, 2040, 1));
		spinnerAno.setBounds(112, 329, 63, 36);
		add(spinnerAno);

		JLabel lblCruso = new JLabel("CURSO");
		lblCruso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCruso.setForeground(Color.WHITE);
		lblCruso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCruso.setBounds(10, 262, 104, 29);
		add(lblCruso);

		JLabel lblGrupo = new JLabel("GRUPO");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGrupo.setBounds(317, 195, 104, 29);
		add(lblGrupo);

		comboBoxGrupo = new JComboBox();
		comboBoxGrupo.setModel(new DefaultComboBoxModel(new String[] { "M11", "M12", "T11", "T12" }));
		comboBoxGrupo.setBounds(461, 192, 63, 36);
		add(comboBoxGrupo);

		JLabel lblCiclo = new JLabel("CICLO");
		lblCiclo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiclo.setForeground(Color.WHITE);
		lblCiclo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCiclo.setBounds(317, 271, 104, 29);
		add(lblCiclo);

		comboBoxCiclo = new JComboBox();
		comboBoxCiclo.setBounds(461, 268, 218, 36);
		add(comboBoxCiclo);

		JLabel lblAlumnos = new JLabel("ALUMNOS");
		lblAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumnos.setForeground(Color.WHITE);
		lblAlumnos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAlumnos.setBounds(26, 390, 104, 29);
		add(lblAlumnos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 440, 470, 163);
		add(scrollPane);

		listAlumnos = new JList();
		scrollPane.setViewportView(listAlumnos);

		btnAnadir = new JButton("");
		btnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadir.setRolloverIcon(
				new ImageIcon(AñadirProyecto.class.getResource("/images/a\u00F1adirPoryectoPulsado.png")));
		btnAnadir.setIcon(new ImageIcon(AñadirProyecto.class.getResource("/images/a\u00F1adirProyecto.png")));
		btnAnadir.setFocusPainted(false);
		btnAnadir.setContentAreaFilled(false);
		btnAnadir.setBorder(null);
		btnAnadir.setBorderPainted(false);
		btnAnadir.setBounds(344, 352, 193, 49);
		add(btnAnadir);

		spinnerCurso = new JSpinner();
		spinnerCurso.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinnerCurso.setBounds(112, 255, 70, 36);
		add(spinnerCurso);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AñadirProyecto.class.getResource("/images/FondoAlumnos700X700.png")));
		label.setBounds(0, 0, 700, 625);
		add(label);
	}

	public void setControlador(ControladorApp c) { // Deberemos presentarle todos los botones al controlador
		btnAnadir.addActionListener(c);
	}

	public void mostrarAlumnos(ArrayList<Alumno> alumnos) {

		DefaultListModel<Alumno> model = new DefaultListModel<Alumno>();

		for (int i = 0; i < alumnos.size(); i++) {

			model.addElement(alumnos.get(i));
		}
		listAlumnos.setModel(model);
	}

	public void mostrarCiclos(ArrayList<Ciclo> ciclos) {

		for (int i = 0; i < ciclos.size(); i++) {
			comboBoxCiclo.addItem(ciclos.get(i));
		}

	}

	public Proyecto getDatos() {

		Proyecto pro;

		ArrayList<Alumno> listaAl = new ArrayList<Alumno>();

		for (Alumno aux : listAlumnos.getSelectedValuesList()) {
			listaAl.add(aux);
		}

		Ciclo ci = (Ciclo) comboBoxCiclo.getSelectedItem();

		String grupo = comboBoxGrupo.getSelectedItem().toString();

		pro = new Proyecto(textNombre.getText(), listaAl, textUrl.getText(), (int) spinnerNota.getValue(),
				(int) spinnerAno.getValue(), (int) spinnerCurso.getValue(), grupo, ci);

		return pro;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public void pruebas() {
		System.out.println("spinerNota:  " + spinnerNota.getValue());
		System.out.println("spinerAno:  " + spinnerAno.getValue());
		System.out.println("ComboBoxGrupo:  " + comboBoxGrupo.getSelectedItem());

	}
}
