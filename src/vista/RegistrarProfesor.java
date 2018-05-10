package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controlador.ControladorApp;
import modelo.Profesor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class RegistrarProfesor extends JDialog {
	private JTextField textUsu;
	private JTextField textPass;
	private JButton btnRegistrar;
	public RegistrarProfesor() {
		inicializar();
	}
	private void inicializar() {
		getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(23, 90, 128, 43);
		getContentPane().add(lblUsuario);
		
		textUsu = new JTextField();
		textUsu.setBounds(177, 90, 175, 43);
		getContentPane().add(textUsu);
		textUsu.setColumns(10);
		
		textPass = new JTextField();
		textPass.setBounds(177, 171, 175, 43);
		getContentPane().add(textPass);
		textPass.setColumns(10);
		
		btnRegistrar = new JButton("");
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setRolloverIcon(new ImageIcon(RegistrarProfesor.class.getResource("/images/PulsadoBotonA\u00F1adir.png")));
		btnRegistrar.setIcon(new ImageIcon(RegistrarProfesor.class.getResource("/images/BotonA\u00F1adir.png")));
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setBounds(103, 256, 184, 50);
		getContentPane().add(btnRegistrar);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblContrasea.setBounds(23, 170, 128, 43);
		getContentPane().add(lblContrasea);
		
		JLabel lblRegistrar = new JLabel("REGISTRAR");
		lblRegistrar.setBorder(new LineBorder(Color.WHITE, 4));
		lblRegistrar.setForeground(Color.WHITE);
		lblRegistrar.setFont(new Font("Sitka Text", Font.BOLD, 27));
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setBounds(60, 11, 280, 57);
		getContentPane().add(lblRegistrar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RegistrarProfesor.class.getResource("/images/FondoAlumnos700X700.png")));
		label.setBounds(0, 0, 384, 361);
		getContentPane().add(label);
		setBounds(0, 0, 400, 400);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setControlador(ControladorApp c) {		//Deberemos presentarle todos los botones al controlador
		btnRegistrar.addActionListener(c);
	}
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	
	public Profesor getDatos() {
		
		Profesor profe;
		
		profe = new Profesor(textUsu.getText(), textPass.getText());
		
		return profe;
	}
}
