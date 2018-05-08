package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Alumno;
import modelo.Ciclo;
import modelo.Proyecto;
import persistencias.AlumnoPersistencia;
import persistencias.CicloPersistencia;
import persistencias.PoryectoPersistencia;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
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

public class ModificarProyectoJD extends JDialog {
	private JTextField textNombre;
	private JTextField textUrl;
	private JSpinner spinnerNota;
	private JSpinner spinnerCurso;
	private JComboBox comboBoxGrupo;
	private JSpinner spinnerAno;
	private JComboBox<Ciclo> comboBoxCiclo;
	private JList<Alumno> listAnadirAl;
	private JList<Alumno> listElimiAl;
	private JButton btnModificarProJD;
	private JButton btnCancelar;
	private JButton btnAnadirAl;
	private JButton btnElimAl;
	public ModificarProyectoJD() {
		inicializar();
	}
	private void inicializar() {
		getContentPane().setLayout(null);
		
		JLabel lblModificarProyecto = new JLabel("MODIFICAR PROYECTO");
		lblModificarProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarProyecto.setForeground(Color.WHITE);
		lblModificarProyecto.setFont(new Font("Sitka Small", Font.BOLD, 45));
		lblModificarProyecto.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblModificarProyecto.setBounds(54, 11, 611, 90);
		getContentPane().add(lblModificarProyecto);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Small", Font.BOLD, 18));
		label_1.setBounds(0, 123, 132, 42);
		getContentPane().add(label_1);
		
		JLabel lblUrlGithub = new JLabel("Url GitHub");
		lblUrlGithub.setHorizontalAlignment(SwingConstants.CENTER);
		lblUrlGithub.setForeground(Color.WHITE);
		lblUrlGithub.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblUrlGithub.setBounds(309, 123, 132, 42);
		getContentPane().add(lblUrlGithub);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblCurso.setBounds(0, 176, 132, 42);
		getContentPane().add(lblCurso);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setForeground(Color.WHITE);
		lblNota.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblNota.setBounds(222, 176, 132, 42);
		getContentPane().add(lblNota);
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblGrupo.setBounds(437, 176, 132, 42);
		getContentPane().add(lblGrupo);
		
		JLabel lblCiclo = new JLabel("Ciclo");
		lblCiclo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiclo.setForeground(Color.WHITE);
		lblCiclo.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblCiclo.setBounds(320, 229, 132, 42);
		getContentPane().add(lblCiclo);
		
		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAo.setForeground(Color.WHITE);
		lblAo.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblAo.setBounds(10, 229, 132, 42);
		getContentPane().add(lblAo);
		
		textNombre = new JTextField();
		textNombre.setBounds(125, 123, 163, 33);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textUrl = new JTextField();
		textUrl.setColumns(10);
		textUrl.setBounds(451, 123, 163, 33);
		getContentPane().add(textUrl);
		
		spinnerNota = new JSpinner();
		spinnerNota.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerNota.setBounds(350, 180, 63, 36);
		getContentPane().add(spinnerNota);
		
		spinnerCurso = new JSpinner();
		spinnerCurso.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinnerCurso.setBounds(142, 180, 70, 36);
		getContentPane().add(spinnerCurso);
		
		comboBoxGrupo = new JComboBox();
		comboBoxGrupo.setModel(new DefaultComboBoxModel(new String[] {"M11", "M12", "T11", "T12"}));
		comboBoxGrupo.setBounds(565, 180, 63, 36);
		getContentPane().add(comboBoxGrupo);
		
		spinnerAno = new JSpinner();
		spinnerAno.setModel(new SpinnerNumberModel(2018, 2018, 2030, 1));
		spinnerAno.setBounds(142, 235, 63, 36);
		getContentPane().add(spinnerAno);
		
		comboBoxCiclo = new JComboBox();
		comboBoxCiclo.setBounds(447, 229, 218, 36);
		getContentPane().add(comboBoxCiclo);
		
		JLabel lbl = new JLabel("A\u00F1adir Alumnos");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lbl.setBounds(0, 293, 172, 42);
		getContentPane().add(lbl);
		
		JLabel lblEliminarAlumnos = new JLabel("Eliminar Alumnos");
		lblEliminarAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarAlumnos.setForeground(Color.WHITE);
		lblEliminarAlumnos.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblEliminarAlumnos.setBounds(336, 293, 218, 42);
		getContentPane().add(lblEliminarAlumnos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 346, 317, 181);
		getContentPane().add(scrollPane);
		
		listAnadirAl = new JList();
		scrollPane.setViewportView(listAnadirAl);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(369, 346, 317, 181);
		getContentPane().add(scrollPane_1);
		
		listElimiAl = new JList();
		scrollPane_1.setViewportView(listElimiAl);
		
		btnModificarProJD = new JButton("");
		btnModificarProJD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarProJD.setRolloverIcon(new ImageIcon(ModificarProyectoJD.class.getResource("/images/botonModificarPulsado.png")));
		btnModificarProJD.setIcon(new ImageIcon(ModificarProyectoJD.class.getResource("/images/botonModificar.png")));
		btnModificarProJD.setFocusPainted(false);
		btnModificarProJD.setContentAreaFilled(false);
		btnModificarProJD.setBorderPainted(false);
		btnModificarProJD.setBorder(null);
		btnModificarProJD.setBounds(64, 538, 188, 55);
		getContentPane().add(btnModificarProJD);
		
		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setRolloverIcon(new ImageIcon(ModificarProyectoJD.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(ModificarProyectoJD.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(440, 538, 188, 55);
		getContentPane().add(btnCancelar);
		
		btnAnadirAl = new JButton("");
		btnAnadirAl.setRolloverIcon(new ImageIcon(ModificarProyectoJD.class.getResource("/images/botonIconoA\u00F1adirPulsado.png")));
		btnAnadirAl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadirAl.setIcon(new ImageIcon(ModificarProyectoJD.class.getResource("/images/BotonIconoA\u00F1adir.png")));
		btnAnadirAl.setFocusPainted(false);
		btnAnadirAl.setContentAreaFilled(false);
		btnAnadirAl.setBorderPainted(false);
		btnAnadirAl.setBorder(null);
		btnAnadirAl.setBounds(205, 287, 53, 58);
		getContentPane().add(btnAnadirAl);
		
		btnElimAl = new JButton("");
		btnElimAl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnElimAl.setRolloverIcon(new ImageIcon(ModificarProyectoJD.class.getResource("/images/BotonIconoEliminarPulsado.png")));
		btnElimAl.setIcon(new ImageIcon(ModificarProyectoJD.class.getResource("/images/BotonIconoElimianr.png")));
		btnElimAl.setFocusPainted(false);
		btnElimAl.setContentAreaFilled(false);
		btnElimAl.setBorderPainted(false);
		btnElimAl.setBorder(null);
		btnElimAl.setBounds(587, 287, 53, 58);
		getContentPane().add(btnElimAl);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 727, 617);
		label.setIcon(new ImageIcon(ModificarProyectoJD.class.getResource("/images/fondo.jpg")));
		getContentPane().add(label);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setBounds(0,0,727,654);
		setLocationRelativeTo(null);
	}
	
	public void setControlador(ControladorApp c) {		//Deberemos presentarle todos los botones al controlador
		btnCancelar.addActionListener(c);
		btnModificarProJD.addActionListener(c);
		btnAnadirAl.addActionListener(c);
		btnElimAl.addActionListener(c);
	}
	public JButton getBtnModificarProJD() {
		return btnModificarProJD;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public JButton getBtnAnadirAl() {
		return btnAnadirAl;
	}
	public JButton getBtnElimAl() {
		return btnElimAl;
	}
	public void mostrarDatos(Proyecto pro) {
				
		textNombre.setText(pro.getNombre());
		textUrl.setText(pro.getUrl());
		mostrarAlumnosEnProyecto(pro);
		
		comboBoxGrupo.setSelectedIndex(obtenerGrupo(pro));
		spinnerAno.setValue(pro.getAño());
		spinnerCurso.setValue(pro.getCurso());
		spinnerNota.setValue(pro.getNota());
		mostrarCiclos(new CicloPersistencia().cargarCiclos());
		

	}
	
	
	public Alumno añadirAlumno() {
		
		Alumno al = listAnadirAl.getSelectedValue();
		return al;
	}
	
	public Alumno eliminarAlumno() {
		
		Alumno al = listElimiAl.getSelectedValue();
		return al;
	}
	
	public void mostrarCiclos(ArrayList<Ciclo> ciclos) {
		
		for(int i = 0; i < ciclos.size();i++) {
			comboBoxCiclo.addItem(ciclos.get(i));
		}
					
	}
	
	private int obtenerGrupo(Proyecto pro) {
		
		int grp = 0;
		
		if(pro.getGrupo().equals("M11")) {
			grp = 0;
		}else if(pro.getGrupo().equals("M12")) {
			grp = 1;
		}else if(pro.getGrupo().equals("T11")) {
			grp = 2;
		}else {
			grp = 3;
		}
				
		return grp;
	}
	public void mostrarAlumnosEnProyecto(Proyecto pro) {
		
		ArrayList<Alumno> alumnos  = new PoryectoPersistencia().cargarAlumnosDePro(pro);
		
		DefaultListModel<Alumno> model = new DefaultListModel<Alumno>();
		
		for(int i = 0 ; i <alumnos.size(); i++) {
			
			model.addElement(alumnos.get(i));
		}
		 listElimiAl.setModel(model);
		 
		 
		
		 
		 ArrayList<Alumno> completo = new AlumnoPersistencia().cargarAlumnos();
		 			
		for(int j = 0; j < alumnos.size(); j++) {	
			for(int k = 0; k < completo.size(); k++) {
				if(completo.get(k).getExpediente() == alumnos.get(j).getExpediente()) {
					completo.remove(k);
				}
			}			
		}
		
		DefaultListModel<Alumno> model2 = new DefaultListModel<Alumno>();
		
		for(int i = 0 ; i <completo.size(); i++) {
			
			model2.addElement(completo.get(i));
		}
		 listAnadirAl.setModel(model2);		 
	}		
}
