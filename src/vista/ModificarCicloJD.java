package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Alumno;
import modelo.Ciclo;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Cursor;

public class ModificarCicloJD extends JDialog {
	private JTextField textNombre;
	private JTextArea textDescripcion;
	private JButton btnModiCi;
	private JButton btnCancelar;
	public ModificarCicloJD() {
		inicializar();
	}
	private void inicializar() {
		getContentPane().setLayout(null);
		
		JLabel lblModificarCiclo = new JLabel("MODIFICAR CICLO");
		lblModificarCiclo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarCiclo.setForeground(Color.WHITE);
		lblModificarCiclo.setFont(new Font("Sylfaen", Font.BOLD, 44));
		lblModificarCiclo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblModificarCiclo.setBounds(74, 21, 445, 72);
		getContentPane().add(lblModificarCiclo);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Small", Font.BOLD, 20));
		label_1.setBounds(10, 119, 188, 42);
		getContentPane().add(label_1);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setForeground(Color.WHITE);
		lblDescripcion.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblDescripcion.setBounds(10, 213, 188, 42);
		getContentPane().add(lblDescripcion);
		
		textNombre = new JTextField();
		textNombre.setBounds(208, 120, 341, 42);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textDescripcion = new JTextArea();
		textDescripcion.setBounds(208, 213, 341, 159);
		getContentPane().add(textDescripcion);
		
		btnModiCi = new JButton("");
		btnModiCi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModiCi.setRolloverIcon(new ImageIcon(ModificarCicloJD.class.getResource("/images/botonModificarPulsado.png")));
		btnModiCi.setIcon(new ImageIcon(ModificarCicloJD.class.getResource("/images/botonModificar.png")));
		btnModiCi.setFocusPainted(false);
		btnModiCi.setContentAreaFilled(false);
		btnModiCi.setBorderPainted(false);
		btnModiCi.setBorder(null);
		btnModiCi.setBounds(48, 453, 188, 55);
		getContentPane().add(btnModiCi);
		
		btnCancelar = new JButton("");
		btnCancelar.setRolloverIcon(new ImageIcon(ModificarCicloJD.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(ModificarCicloJD.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(331, 453, 188, 55);
		getContentPane().add(btnCancelar);
		setBounds(0, 0, 594, 646);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ModificarCicloJD.class.getResource("/images/FondoAlumnos700X700.png")));
		label.setBounds(0, 0, 578, 607);
		getContentPane().add(label);
	}
	
	public void setControlador(ControladorApp c) {		//Deberemos presentarle todos los botones al controlador
		btnModiCi.addActionListener(c);
		btnCancelar.addActionListener(c);
	}
	public JButton getBtnModiCi() {
		return btnModiCi;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void mostrarDatos(Ciclo ci) throws NullPointerException {
		textNombre.setText(ci.getNombre());
		textDescripcion.setText(ci.getDescripcion());	
	}
	
	public Ciclo getDatos() {
		Ciclo ci;
				
		ci = new Ciclo(textNombre.getText(),textDescripcion.getText());
			
		return ci;
	}
}
