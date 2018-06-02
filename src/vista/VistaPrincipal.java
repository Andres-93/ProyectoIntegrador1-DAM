package vista;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controlador.ControladorApp;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.JSeparator;

public class VistaPrincipal extends JFrame {
	private JScrollPane scrollPane;
	private JMenu mnMenuAlumnos;
	private JMenuItem mntModificarAl;
	private JMenuBar menuBar;
	private JMenuItem mntmAadirAl;
	private JMenuItem mntmEliminar;
	private JMenu mnCiclos;
	private JSeparator separator;
	private JMenu mnProyectos;
	private JSeparator separator_1;
	private JMenuItem mntModificarPro;
	private JMenuItem mntAadirPro;
	private JMenuItem mntEliminarPro;
	private JMenuItem mtnModificarCi;
	private JMenuItem mntAadirCi;
	private JMenuItem mntEliminarCi;
	private JSeparator separator_2;
	private JMenu mnMenuRegistrar;
	private JMenuItem mntRegistrarProfesor;
	private JMenuItem mntConsultar;
	private JMenuItem mntConsultaCiclo;
	private JMenuItem mntmConsultarProyecto;

	public VistaPrincipal() {
		inicializar();
	}

	private void inicializar() {

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		getContentPane().setLayout(null);
		setBounds(0, 0, 700, 685);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 700, 700);
		getContentPane().add(scrollPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		menuBar.setAutoscrolls(true);
		menuBar.setMargin(new Insets(0, 5, 0, 5));
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(0, 153, 255));
		menuBar.setForeground(new Color(51, 102, 204));
		setJMenuBar(menuBar);

		mnMenuAlumnos = new JMenu("Alumnos");
		mnMenuAlumnos.setBorder(new LineBorder(Color.WHITE));
		mnMenuAlumnos.setBackground(new Color(0, 0, 204));
		mnMenuAlumnos.setForeground(Color.WHITE);
		mnMenuAlumnos.setFont(new Font("Segoe UI", Font.BOLD, 22));
		menuBar.add(mnMenuAlumnos);

		mntConsultar = new JMenuItem("Consultar");
		mntConsultar.setBackground(new Color(0, 153, 255));
		mntConsultar.setForeground(Color.WHITE);
		mntConsultar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntConsultar.setBorder(null);
		mnMenuAlumnos.add(mntConsultar);

		mntModificarAl = new JMenuItem("Modificar");
		mntModificarAl.setBorder(null);
		mntModificarAl.setForeground(Color.WHITE);
		mntModificarAl.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntModificarAl.setBackground(new Color(0, 153, 255));
		mnMenuAlumnos.add(mntModificarAl);

		mntmAadirAl = new JMenuItem("A\u00F1adir");
		mntmAadirAl.setBorderPainted(true);
		mntmAadirAl.setBorder(null);
		mntmAadirAl.setForeground(Color.WHITE);
		mntmAadirAl.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmAadirAl.setBackground(new Color(0, 153, 255));
		mnMenuAlumnos.add(mntmAadirAl);

		mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.setForeground(Color.WHITE);
		mntmEliminar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmEliminar.setBorder(null);
		mntmEliminar.setBackground(new Color(0, 153, 255));
		mnMenuAlumnos.add(mntmEliminar);

		separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 153, 255), 7));
		menuBar.add(separator);

		mnProyectos = new JMenu("Proyectos");
		mnProyectos.setBorder(new LineBorder(Color.WHITE));
		mnProyectos.setFont(new Font("Segoe UI", Font.BOLD, 22));
		mnProyectos.setForeground(Color.WHITE);
		mnProyectos.setBackground(new Color(0, 0, 204));
		menuBar.add(mnProyectos);

		mntmConsultarProyecto = new JMenuItem("Consultar");
		mntmConsultarProyecto.setBackground(new Color(0, 153, 255));
		mntmConsultarProyecto.setForeground(Color.WHITE);
		mntmConsultarProyecto.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnProyectos.add(mntmConsultarProyecto);

		mntModificarPro = new JMenuItem("Modificar");
		mntModificarPro.setForeground(Color.WHITE);
		mntModificarPro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntModificarPro.setBackground(new Color(0, 153, 255));
		mnProyectos.add(mntModificarPro);

		mntAadirPro = new JMenuItem("A\u00F1adir");
		mntAadirPro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntAadirPro.setForeground(Color.WHITE);
		mntAadirPro.setBackground(new Color(0, 153, 255));
		mnProyectos.add(mntAadirPro);

		mntEliminarPro = new JMenuItem("Eliminar");
		mntEliminarPro.setForeground(Color.WHITE);
		mntEliminarPro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntEliminarPro.setBackground(new Color(0, 153, 255));
		mnProyectos.add(mntEliminarPro);

		separator_1 = new JSeparator();
		separator_1.setBorder(new LineBorder(new Color(0, 153, 255), 7));
		menuBar.add(separator_1);

		mnCiclos = new JMenu("Ciclos");
		mnCiclos.setBorder(new LineBorder(Color.WHITE));
		mnCiclos.setBackground(new Color(0, 0, 204));
		mnCiclos.setForeground(Color.WHITE);
		mnCiclos.setFont(new Font("Segoe UI", Font.BOLD, 22));
		menuBar.add(mnCiclos);

		mntConsultaCiclo = new JMenuItem("Consultar");
		mntConsultaCiclo.setBackground(new Color(0, 153, 255));
		mntConsultaCiclo.setForeground(Color.WHITE);
		mntConsultaCiclo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnCiclos.add(mntConsultaCiclo);

		mtnModificarCi = new JMenuItem("Modificar");
		mtnModificarCi.setBackground(new Color(0, 153, 255));
		mtnModificarCi.setForeground(Color.WHITE);
		mtnModificarCi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnCiclos.add(mtnModificarCi);

		mntAadirCi = new JMenuItem("A\u00F1adir");
		mntAadirCi.setBackground(new Color(0, 153, 255));
		mntAadirCi.setForeground(Color.WHITE);
		mntAadirCi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnCiclos.add(mntAadirCi);

		mntEliminarCi = new JMenuItem("Eliminar");
		mntEliminarCi.setBackground(new Color(0, 153, 255));
		mntEliminarCi.setForeground(Color.WHITE);
		mntEliminarCi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnCiclos.add(mntEliminarCi);

		separator_2 = new JSeparator();
		separator_2.setBorder(new LineBorder(new Color(0, 153, 255), 8));
		menuBar.add(separator_2);

		mnMenuRegistrar = new JMenu("Registrar");
		mnMenuRegistrar.setBorder(new LineBorder(Color.WHITE));
		mnMenuRegistrar.setBackground(new Color(0, 0, 204));
		mnMenuRegistrar.setForeground(Color.WHITE);
		mnMenuRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 22));
		menuBar.add(mnMenuRegistrar);

		mntRegistrarProfesor = new JMenuItem("Registrar Profesor");
		mntRegistrarProfesor.setBackground(new Color(0, 153, 255));
		mntRegistrarProfesor.setForeground(Color.WHITE);
		mntRegistrarProfesor.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnMenuRegistrar.add(mntRegistrarProfesor);
		setResizable(false);
	}

	public void permisosProfesor(boolean permitir) {

		if (permitir) {
			mntmAadirAl.setEnabled(true);
			mntmEliminar.setEnabled(true);
			mntAadirPro.setEnabled(true);
			mntEliminarPro.setEnabled(true);
			mntAadirCi.setEnabled(true);
			mntEliminarCi.setEnabled(true);
			mntRegistrarProfesor.setEnabled(true);
			mntModificarAl.setEnabled(true);
			mtnModificarCi.setEnabled(true);
			mntModificarPro.setEnabled(true);
		} else {
			mntmAadirAl.setEnabled(false);
			mntmEliminar.setEnabled(false);
			mntAadirPro.setEnabled(false);
			mntEliminarPro.setEnabled(false);
			mntAadirCi.setEnabled(false);
			mntEliminarCi.setEnabled(false);
			mntRegistrarProfesor.setEnabled(false);
			mntModificarAl.setEnabled(false);
			mtnModificarCi.setEnabled(false);
			mntModificarPro.setEnabled(false);
		}

	}

	public void setControlador(ControladorApp c) { // Deberemos presentarle todos los botones al controlador
		mntModificarAl.addActionListener(c);
		mntmAadirAl.addActionListener(c);
		mntmEliminar.addActionListener(c);
		mntModificarPro.addActionListener(c);
		mntAadirPro.addActionListener(c);
		mntEliminarPro.addActionListener(c);
		mtnModificarCi.addActionListener(c);
		mntAadirCi.addActionListener(c);
		mntEliminarCi.addActionListener(c);
		mntRegistrarProfesor.addActionListener(c);
		mntConsultar.addActionListener(c);
		mntConsultaCiclo.addActionListener(c);
		mntmConsultarProyecto.addActionListener(c);
	}

	public JMenuItem getMntmConsultarProyecto() {
		return mntmConsultarProyecto;
	}

	public JMenuItem getMntConsultaCiclo() {
		return mntConsultaCiclo;
	}

	public JMenuItem getMntRegistrarProfesor() {
		return mntRegistrarProfesor;
	}

	public JMenuItem getMntConsultarCi() {
		return mtnModificarCi;
	}

	public JMenuItem getMntAadirCi() {
		return mntAadirCi;
	}

	public JMenuItem getMntEliminarCi() {
		return mntEliminarCi;
	}

	public JMenuItem getMntConsultaPro() {
		return mntModificarPro;
	}

	public JMenuItem getMntAadirPro() {
		return mntAadirPro;
	}

	public JMenuItem getMntEliminarPro() {
		return mntEliminarPro;
	}

	public JMenuItem getMntConsultaAl() {
		return mntModificarAl;
	}

	public JMenuItem getMntmAadirAl() {
		return mntmAadirAl;
	}

	public JMenuItem getMntmEliminar() {
		return mntmEliminar;
	}

	public void setPanel(JPanel panel) {
		scrollPane.setViewportView(panel);
	}

	public void hacerMenuVisible(boolean si) {
		menuBar.setVisible(si);
	}

	public JMenuItem getMntConsultar() {
		return mntConsultar;
	}

	public void hacerVisible() {
		this.setVisible(true);
		setLocationRelativeTo(null);
		menuBar.setVisible(false);

	}
}
