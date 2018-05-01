package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ejecutable.Conexion;
import persistencias.AlumnoPersistencia;
import persistencias.CicloPersistencia;
import persistencias.ProfesorPersistencia;
import vista.AñadirCiclo;
import vista.ConsultaAlumnos;
import vista.EliminarAlumno;
import vista.EliminarCiclo;
import vista.ModificarAlumno;
import vista.ModificarCicloJD;
import vista.ModificarCliclo;
import vista.PanelLogin;
import vista.PanelPrincipal;
import vista.RegistrarProfesor;
import vista.VistaPrincipal;
import vista.añadirAlumnos;



public class ControladorApp implements ActionListener{
	
	private VistaPrincipal vistaP;
	private PanelPrincipal panel1;
	private PanelLogin panel2;
	private añadirAlumnos panel3;
	private EliminarAlumno panel4;
	private ConsultaAlumnos panel5;
	private RegistrarProfesor panel6;
	private AñadirCiclo panel7;
	private ModificarAlumno panel8;
	private EliminarCiclo panel9;
	private ModificarCliclo panel10;
	private ModificarCicloJD panel11;
					
	

	public ControladorApp(VistaPrincipal vistaP) {
		this.vistaP = vistaP;
		
	}

	public void setPanel1(PanelPrincipal panel1) {
		this.panel1 = panel1;
	}

	public void setPanel2(PanelLogin panel2) {
		this.panel2 = panel2;
	}
	
	public void setPanel3(añadirAlumnos panel3) {
		this.panel3 = panel3;
	}
	
	public void setPanel4(EliminarAlumno panel4) {
		this.panel4 = panel4;
	}
	
	public void setPanel5(ConsultaAlumnos panel5) {
		this.panel5 = panel5;
	}
	
	public void setPanel6(RegistrarProfesor panel6) {
		this.panel6 = panel6;
	}
	
	public void setPanel7(AñadirCiclo panel7) {
		this.panel7 = panel7;
	}
	
	public void setPanel8(ModificarAlumno panel8) {
		this.panel8 = panel8;
	}
	
	public void setPanel9(EliminarCiclo panel9) {
		this.panel9 = panel9;
	}
	
	public void setPanel10(ModificarCliclo panel10) {
		this.panel10 = panel10;
	}
	
	public void setPanel11(ModificarCicloJD panel11) {
		this.panel11 = panel11;
	}


	@Override
	public void actionPerformed(ActionEvent e) {	
		//Si entramos como profesores tendremos los permisos, en caso de introducir usuario o contraseña no validos nos lo muestra por un Joption.	
		if(e.getSource().equals(panel2.getBtnBoton())) {					
			if( new ProfesorPersistencia().buscarUsuario(panel2.getDatos())) {			
				vistaP.setPanel(panel1);
				vistaP.hacerMenuVisible(true);
				vistaP.permisosProfesor(true);
			}else {
				JOptionPane.showConfirmDialog(null, "Usuario o contraseña no validos, vuelva a intentarlo","Error al logearse", JOptionPane.CLOSED_OPTION);
			}
			
		//Acceder como alumno, avisamos que unicamente podra realizar consultas.			
		}else if(e.getSource().equals(panel2.getButtonAccesoAlumno())) {				
			int respuesta = JOptionPane.showConfirmDialog(panel2, "Si entra con una cuenta de Alumno unicamente podra realizar consultas. Desea Continuar?","Confirmacion",JOptionPane.YES_NO_OPTION);
			if(respuesta == JOptionPane.YES_OPTION) {
				vistaP.setPanel(panel1);
				vistaP.permisosProfesor(false);
				vistaP.hacerMenuVisible(true);
			}
			
		}else if(e.getSource().equals(panel1.getBtnNewButton())) {
			vistaP.setPanel(panel2);
			vistaP.hacerMenuVisible(false);
			
		}else if(e.getSource().equals(vistaP.getMntmAadirAl())) {
			vistaP.setPanel(panel3);
			
		}else if(e.getSource().equals(panel3.getBtnCancelar()) || e.getSource().equals(panel4.getBtnCancelar()) || e.getSource().equals(panel5.getButton()) || e.getSource().equals(panel7.getBtnCancelCicloA()) || e.getSource().equals(panel9.getBtnCanceloar()) || e.getSource().equals(panel10.getBtnCancelar())) {
			vistaP.setPanel(panel1);	
			
		}else if(e.getSource().equals(vistaP.getMntmEliminar())) {
			vistaP.setPanel(panel4);
			panel4.mostrarAlumnos(new AlumnoPersistencia().cargarAlumnos());
			
		}else if(e.getSource().equals(vistaP.getMntConsultaAl())) {
			vistaP.setPanel(panel5);
			panel5.mostrarAlumnos(new AlumnoPersistencia().cargarAlumnos());
			
		}else if(e.getSource().equals(vistaP.getMntRegistrarProfesor())) {
			panel6.hacerVisible();
			
			
		}else if(e.getSource().equals(panel6.getBtnRegistrar())) {			
		if(panel6.getDatos().getUsuario().equals("")  || panel6.getDatos().getPass().equals("")) {				//POR ALGUN MOTIVOS, AUN SIENDO LOS CAMPOS NOT NULL PERMITE GUARDAR DATOS NULL	
			JOptionPane.showConfirmDialog(null, "Ninguno de los campos debe estar en blanco","Error", JOptionPane.CLOSED_OPTION);
		}
		else {
			new ProfesorPersistencia().añadirProfesor(panel6.getDatos());	//PRUEBAS
		}
			//prof.añadirProfesor(panel6.getDatos()); 						//PRUEBAS
			
			//con.añadirProfesor(panel6.getDatos());																		
		}else if(e.getSource().equals(panel3.getBtnAnadir())) {
			new AlumnoPersistencia().añadirAlumno(panel3.getDatos());
			
			//alu.añadirAlumno(panel3.getDatos());
			
		} else if(e.getSource().equals(panel4.getBtnEliminarAl())) {
			new AlumnoPersistencia().eliminarAlumno(panel4.alumnosAEliminar());
			panel4.mostrarAlumnos(new AlumnoPersistencia().cargarAlumnos());
			
		}else if(e.getSource().equals(vistaP.getMntAadirCi())) {
			vistaP.setPanel(panel7);
			
		}else if(e.getSource().equals(panel7.getBtnAnadirCiclo())) {
			if(panel7.getDatos().getNombre().equals("")) {
				JOptionPane.showConfirmDialog(null, "No puede dejar el nombre en blanco","Error", JOptionPane.CLOSED_OPTION);
			}else {
				new CicloPersistencia().añadirCiclo(panel7.getDatos());
			}
					
		} else if(e.getSource().equals(panel5.getBtnModificar())) {
			
			try {
				panel8.mostrarDatos(panel5.obtenerSeleccionado());
				panel8.hacerVisible();
			}catch(NullPointerException error) {
				JOptionPane.showConfirmDialog(null, "Debe seleccionar un alumno para modificarle","Error",JOptionPane.CANCEL_OPTION);
			}
			
		}else if(e.getSource().equals(panel8.getBtnModificarJD())) {			
			new AlumnoPersistencia().modificarAlumno(panel8.getDatos(),new AlumnoPersistencia().obtenerID(panel5.obtenerSeleccionado()));
			panel8.setVisible(false);
			panel5.mostrarAlumnos(new AlumnoPersistencia().cargarAlumnos());					//Tras modificar el usuario volveremos a cargar la lista actualizada de alumns.	
			
		}else if(e.getSource().equals(panel9.getBtnEliminarCiclo())) {
			new CicloPersistencia().eliminarCiclo(panel9.ciclossAEliminar());
			panel9.mostrarCiclos(new CicloPersistencia().cargarCiclos());
			
		}else if(e.getSource().equals(vistaP.getMntEliminarCi())) {
			vistaP.setPanel(panel9);
			panel9.mostrarCiclos(new CicloPersistencia().cargarCiclos());
			
		}else if(e.getSource().equals(vistaP.getMntConsultarCi())) {
			vistaP.setPanel(panel10);
			panel10.mostrarCiclos(new CicloPersistencia().cargarCiclos());
			
		}else if(e.getSource().equals(panel10.getBtnModificarCi())) {
			try {
			panel11.mostrarDatos(panel10.cicloSelecionado());
			panel11.hacerVisible();
			}catch(NullPointerException error) {
				JOptionPane.showConfirmDialog(null, "Debe seleccionar un ciclo para modificarle","Error",JOptionPane.CANCEL_OPTION);
			}
			
		}else if(e.getSource().equals(panel11.getBtnCancelar())) {
			panel11.setVisible(false);
			
		}else if(e.getSource().equals(panel11.getBtnModiCi())) {
			new CicloPersistencia().modificarAlumno(panel11.getDatos(), new CicloPersistencia().obtenerID(panel10.cicloSelecionado()));
			panel11.setVisible(false);
			panel10.mostrarCiclos(new CicloPersistencia().cargarCiclos());
		}
	}
}
