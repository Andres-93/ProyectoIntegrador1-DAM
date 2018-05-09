package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Alumno;
import persistencias.AlumnoPersistencia;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;

public class ModificarAlumnos extends JPanel {
	private JTextField textFiltro;
	private JComboBox comboBox;
	private JButton btnCancelar;
	private JList list;
	private JButton btnModificar;
	private JButton btnFiltrar;
	public ModificarAlumnos() {
		inicializar();
	}
	private void inicializar() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setLayout(null);
		setBounds(0,0,700,625);
		JLabel lblConsultarAlumnos = new JLabel("MODIFICAR ALUMNOS");
		lblConsultarAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarAlumnos.setForeground(Color.WHITE);
		lblConsultarAlumnos.setFont(new Font("Sitka Small", Font.BOLD, 50));
		lblConsultarAlumnos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblConsultarAlumnos.setBounds(38, 44, 630, 90);
		add(lblConsultarAlumnos);
		
		JLabel label = new JLabel("LISTA ALUMNOS:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sitka Small", Font.BOLD, 20));
		label.setBounds(38, 295, 204, 41);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 333, 540, 217);
		add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblFiltrar = new JLabel("FILTRAR:");
		lblFiltrar.setForeground(Color.WHITE);
		lblFiltrar.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblFiltrar.setBounds(48, 145, 115, 41);
		add(lblFiltrar);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "N\u00BA Expediente"}));
		comboBox.setBounds(94, 182, 115, 41);
		add(comboBox);
		
		textFiltro = new JTextField();
		textFiltro.setBounds(339, 182, 255, 41);
		add(textFiltro);
		textFiltro.setColumns(10);
		
		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setRolloverIcon(new ImageIcon(ModificarAlumnos.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(ModificarAlumnos.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(426, 561, 188, 55);
		add(btnCancelar);
		
		btnModificar = new JButton("");
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setRolloverIcon(new ImageIcon(ModificarAlumnos.class.getResource("/images/botonModificarPulsado.png")));
		btnModificar.setIcon(new ImageIcon(ModificarAlumnos.class.getResource("/images/botonModificar.png")));
		btnModificar.setFocusPainted(false);
		btnModificar.setContentAreaFilled(false);
		btnModificar.setBorderPainted(false);
		btnModificar.setBorder(null);
		btnModificar.setBounds(116, 561, 188, 55);
		add(btnModificar);
		
		btnFiltrar = new JButton("");
		btnFiltrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFiltrar.setRolloverIcon(new ImageIcon(ModificarAlumnos.class.getResource("/images/botonFiltrarPulsado.png")));
		btnFiltrar.setIcon(new ImageIcon(ModificarAlumnos.class.getResource("/images/botonFiltrar.png")));
		btnFiltrar.setFocusPainted(false);
		btnFiltrar.setContentAreaFilled(false);
		btnFiltrar.setBorderPainted(false);
		btnFiltrar.setBorder(null);
		btnFiltrar.setBounds(211, 243, 188, 55);
		add(btnFiltrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ModificarAlumnos.class.getResource("/images/FondoAlumnos700X700.png")));
		lblNewLabel.setBounds(0, 0, 700, 625);
		add(lblNewLabel);
	}
	
	public void setControlador(ControladorApp c) {		//Deberemos presentarle todos los botones al controlador
		btnCancelar.addActionListener(c);
		btnModificar.addActionListener(c);
		btnFiltrar.addActionListener(c);
	}
	public JButton getButton() {
		return btnCancelar;
	}
		
	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	
	public JButton getBtnFiltrar() {
		return btnFiltrar;
	}
	public void mostrarAlumnos(ArrayList<Alumno> alumnos) {
		
		DefaultListModel<Alumno> model = new DefaultListModel<Alumno>();
		
		for(int i = 0 ; i <alumnos.size(); i++) {
			
			model.addElement(alumnos.get(i));
		}
		 list.setModel(model);
	}
	
	public Alumno obtenerSeleccionado() {
		
		Alumno al;
		
		al = (Alumno) list.getSelectedValue();
		
		return al;
	}
	
	public void filtrar() {
		
		ArrayList<Alumno> lista;
		
		String consulta = "";
		
		if(comboBox.getSelectedIndex() == 0) {
			consulta = "Select * from alumnos where nombre like '%" + textFiltro.getText() + "%'";
		}else {
			consulta = "Select * from alumnos where numExpediente ="  + textFiltro.getText() ;
		}

		lista = new AlumnoPersistencia().cargarAlumnosFiltrado(consulta);
		
		mostrarAlumnos(lista);
		
	}
}
