package vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class DetalleProyecto extends JDialog {
	private JLabel lblNombres;
	private JLabel lblGit;
	private JLabel lblNoT;
	private JLabel lblAno;
	private JLabel lblGrupo;
	private JLabel lblCiclo;
	private JLabel lblCurso;
	private JList listAl;
	private JButton btnCancelar;
	public DetalleProyecto() {
		inicializar();
		
	}
	private void inicializar() {
		getContentPane().setLayout(null);
		
		JLabel lblDetalles = new JLabel("DETALLES");
		lblDetalles.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalles.setForeground(Color.WHITE);
		lblDetalles.setFont(new Font("Sitka Small", Font.BOLD, 50));
		lblDetalles.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblDetalles.setBounds(100, 25, 471, 78);
		getContentPane().add(lblDetalles);
		
		JLabel lbl1 = new JLabel("Nombre:");
		lbl1.setForeground(Color.WHITE);
		lbl1.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lbl1.setBounds(10, 114, 104, 41);
		getContentPane().add(lbl1);
		
		lblNombres = new JLabel("");
		lblNombres.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombres.setForeground(Color.WHITE);
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombres.setBounds(126, 114, 213, 43);
		getContentPane().add(lblNombres);
		
		JLabel lblGithub = new JLabel("GitHub:");
		lblGithub.setForeground(Color.WHITE);
		lblGithub.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblGithub.setBounds(10, 191, 104, 41);
		getContentPane().add(lblGithub);
		
		lblGit = new JLabel("");
		lblGit.setHorizontalAlignment(SwingConstants.CENTER);
		lblGit.setForeground(Color.WHITE);
		lblGit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGit.setBounds(126, 191, 213, 43);
		getContentPane().add(lblGit);
		
		JLabel lbl2 = new JLabel("Nota: ");
		lbl2.setForeground(Color.WHITE);
		lbl2.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lbl2.setBounds(10, 262, 104, 41);
		getContentPane().add(lbl2);
		
		lblNoT = new JLabel("");
		lblNoT.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoT.setForeground(Color.WHITE);
		lblNoT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNoT.setBounds(126, 262, 213, 43);
		getContentPane().add(lblNoT);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setForeground(Color.WHITE);
		lblAo.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblAo.setBounds(395, 191, 104, 41);
		getContentPane().add(lblAo);
		
		lblAno = new JLabel("");
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setForeground(Color.WHITE);
		lblAno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAno.setBounds(509, 191, 152, 43);
		getContentPane().add(lblAno);
		
		JLabel lblGr = new JLabel("Grupo:");
		lblGr.setForeground(Color.WHITE);
		lblGr.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblGr.setBounds(395, 114, 104, 41);
		getContentPane().add(lblGr);
		
		lblGrupo = new JLabel("");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGrupo.setBounds(482, 114, 192, 43);
		getContentPane().add(lblGrupo);
		
		JLabel ldfh = new JLabel("Ciclo:");
		ldfh.setForeground(Color.WHITE);
		ldfh.setFont(new Font("Sitka Small", Font.BOLD, 18));
		ldfh.setBounds(374, 333, 104, 41);
		getContentPane().add(ldfh);
		
		lblCiclo = new JLabel("");
		lblCiclo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiclo.setForeground(Color.WHITE);
		lblCiclo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCiclo.setBounds(509, 331, 169, 43);
		getContentPane().add(lblCiclo);
		
		JLabel ccurso = new JLabel("Curso:");
		ccurso.setForeground(Color.WHITE);
		ccurso.setFont(new Font("Sitka Small", Font.BOLD, 18));
		ccurso.setBounds(374, 262, 104, 41);
		getContentPane().add(ccurso);
		
		lblCurso = new JLabel("");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setForeground(Color.WHITE);
		lblCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCurso.setBounds(509, 260, 152, 43);
		getContentPane().add(lblCurso);
		
		JLabel lblAlumnosDelProyecto = new JLabel("Alumnos del proyecto:");
		lblAlumnosDelProyecto.setForeground(Color.WHITE);
		lblAlumnosDelProyecto.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblAlumnosDelProyecto.setBounds(10, 333, 237, 41);
		getContentPane().add(lblAlumnosDelProyecto);
		
		btnCancelar = new JButton("");
		btnCancelar.setRolloverIcon(new ImageIcon(DetalleProyecto.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(DetalleProyecto.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(244, 585, 188, 55);
		getContentPane().add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBounds(32, 397, 601, 177);
		getContentPane().add(scrollPane);
		
		listAl = new JList();
		listAl.setOpaque(false);
		scrollPane.setViewportView(listAl);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setIcon(new ImageIcon(DetalleProyecto.class.getResource("/images/fondo.jpg")));
		label.setBounds(0, 0, 684, 661);
		getContentPane().add(label);
		setBounds(0, 0, 700, 700);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
	}
	
	public void setControlador(ControladorApp c) {
		btnCancelar.addActionListener(c);
	}
	
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public void mostrarProyecto(Proyecto pro) {
		
		String ano = pro.getAño() +"";
		String curso = pro.getCurso()+"";
		String nota = pro.getNota() + "";
		
		lblNombres.setText(pro.getNombre());
		lblGit.setText(pro.getUrl());
		lblAno.setText(ano);
		lblCurso.setText(curso);
		lblGrupo.setText(pro.getGrupo());
		lblNoT.setText(nota);
		lblCiclo.setText(new CicloPersistencia().obtenerCiclo(pro.getNombre()));
		
		ArrayList<Alumno> alumnos = new PoryectoPersistencia().cargarAlumnosDePro(pro);
		
		DefaultListModel<Alumno> model = new DefaultListModel<Alumno>();
		
		for(int i = 0 ; i <alumnos.size(); i++) {
			
			model.addElement(alumnos.get(i));
		}
		 listAl.setModel(model);
		
		
		
	}
}

