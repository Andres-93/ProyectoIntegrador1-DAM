package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Proyecto;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ConsultaProyecto extends JPanel {
	private JTextField textFiltro;
	private JComboBox comboBoxFiltro;
	private JButton btnFiltrarPro;
	private JButton btnDetalles;
	private JButton btnCancelar;
	private JList<Proyecto> listProyectos;
	public ConsultaProyecto() {
		inicializar();
	}
	private void inicializar() {
		setLayout(null);
		setBounds(0,0,700,625);
		
		JLabel lblProyectos = new JLabel("PROYECTOS");
		lblProyectos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProyectos.setForeground(Color.WHITE);
		lblProyectos.setFont(new Font("Sitka Small", Font.BOLD, 50));
		lblProyectos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblProyectos.setBounds(131, 36, 425, 78);
		add(lblProyectos);
		
		JLabel lblFiltrar = new JLabel("FILTRAR");
		lblFiltrar.setForeground(Color.WHITE);
		lblFiltrar.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblFiltrar.setBounds(10, 125, 204, 41);
		add(lblFiltrar);
		
		comboBoxFiltro = new JComboBox();
		comboBoxFiltro.setForeground(Color.BLUE);
		comboBoxFiltro.setFont(new Font("Sylfaen", Font.BOLD, 13));
		comboBoxFiltro.setModel(new DefaultComboBoxModel(new String[] {"Ver Todos", "Nombre de Proyecto", "Curso", "Grupo", "A\u00F1o", "Ciclo", "Nombre de Alumno", "Numero de expediente"}));
		comboBoxFiltro.setBounds(52, 172, 162, 41);
		add(comboBoxFiltro);
		
		textFiltro = new JTextField();
		textFiltro.setBounds(279, 172, 349, 41);
		add(textFiltro);
		textFiltro.setColumns(10);
		
		btnFiltrarPro = new JButton("");
		btnFiltrarPro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFiltrarPro.setRolloverIcon(new ImageIcon(ConsultaProyecto.class.getResource("/images/botonFiltrarPulsado.png")));
		btnFiltrarPro.setIcon(new ImageIcon(ConsultaProyecto.class.getResource("/images/botonFiltrar.png")));
		btnFiltrarPro.setFocusPainted(false);
		btnFiltrarPro.setContentAreaFilled(false);
		btnFiltrarPro.setBorderPainted(false);
		btnFiltrarPro.setBorder(null);
		btnFiltrarPro.setBounds(198, 224, 188, 55);
		add(btnFiltrarPro);
		
		JLabel L = new JLabel("Lista de Proyectos");
		L.setForeground(Color.WHITE);
		L.setFont(new Font("Sitka Small", Font.BOLD, 20));
		L.setBounds(20, 279, 204, 41);
		add(L);
		
		btnDetalles = new JButton("");
		btnDetalles.setRolloverIcon(new ImageIcon(ConsultaProyecto.class.getResource("/images/botonDetallesPulsado.png")));
		btnDetalles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDetalles.setIcon(new ImageIcon(ConsultaProyecto.class.getResource("/images/botonDetalles.png")));
		btnDetalles.setFocusPainted(false);
		btnDetalles.setContentAreaFilled(false);
		btnDetalles.setBorderPainted(false);
		btnDetalles.setBorder(null);
		btnDetalles.setBounds(39, 546, 188, 55);
		add(btnDetalles);
		
		btnCancelar = new JButton("");
		btnCancelar.setRolloverIcon(new ImageIcon(ConsultaProyecto.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setIcon(new ImageIcon(ConsultaProyecto.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(452, 546, 188, 55);
		add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 334, 640, 201);
		add(scrollPane);
		
		listProyectos = new JList();
		scrollPane.setViewportView(listProyectos);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ConsultaProyecto.class.getResource("/images/FondoAlumnos700X700.png")));
		label.setBounds(0, 0, 700, 614);
		add(label);
	}
	
	public void setControlador(ControladorApp c) {
		btnCancelar.addActionListener(c);
		btnDetalles.addActionListener(c);
		btnFiltrarPro.addActionListener(c);		
	}
	public JButton getBtnFiltrarPro() {
		return btnFiltrarPro;
	}
	public JButton getBtnDetalles() {
		return btnDetalles;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public void mostrarProyectos(ArrayList<Proyecto> pro) {
		
		DefaultListModel<Proyecto> model = new DefaultListModel<Proyecto>();
		
		for(int i = 0 ; i <pro.size(); i++) {
			
			model.addElement(pro.get(i));
		}
		 listProyectos.setModel(model);
	}
	
	public String filtrar() {
		
		String consulta = "";
		if(!textFiltro.getText().equals("")) {
			if(comboBoxFiltro.getSelectedIndex() == 1) {
				consulta = "Select * from proyectos where nombre like '%" + textFiltro.getText() + "%'"; 
			}else if(comboBoxFiltro.getSelectedIndex() == 2) {
				consulta = "Select * from proyectos where curso ="  + textFiltro.getText(); 
			}else if(comboBoxFiltro.getSelectedIndex() == 3) {
				consulta = "Select * from proyectos where grupo like '%" + textFiltro.getText() + "%'"; 
			}else if(comboBoxFiltro.getSelectedIndex() == 4) {
				consulta = "Select * from proyectos where año =" + textFiltro.getText(); 
			}else if(comboBoxFiltro.getSelectedIndex() == 6) {													//FALTA POR CICLOS
				consulta = "Select * from proyectos,alumnos,se_realizan where se_realizan.alumno = alumnos.ID_A  and se_realizan.proyecto = proyectos.id_p and alumnos.nombre like '%" + textFiltro.getText() + "%'";
			}else if(comboBoxFiltro.getSelectedIndex() == 7) {
				consulta = "Select * from proyectos,alumnos,se_realizan where se_realizan.alumno = alumnos.ID_A  and se_realizan.proyecto = proyectos.id_p and alumnos.expediente = " + textFiltro.getText();
			}else if(comboBoxFiltro.getSelectedIndex() == 0) {
				consulta = "Select * from proyectos"; 
			}
		}else {
			JOptionPane.showConfirmDialog(null, "No debe dejar el espacion en blanco","Error",JOptionPane.CANCEL_OPTION);
		}
	return consulta;
	}
	
}
