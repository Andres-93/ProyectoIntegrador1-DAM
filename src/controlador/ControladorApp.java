package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


import persistencias.AlumnoPersistencia;
import persistencias.CicloPersistencia;
import persistencias.PoryectoPersistencia;
import persistencias.ProfesorPersistencia;
import vista.AñadirCiclo;
import vista.AñadirProyecto;
import vista.ConsultaAlumnoNuevo;
import vista.ConsultaCiclos;
import vista.ConsultaProyecto;
import vista.DetalleProyecto;
import vista.ModificarAlumnos;
import vista.EliminarAlumno;
import vista.EliminarCiclo;
import vista.EliminarProyecto;
import vista.ModificarAlumno;
import vista.ModificarCicloJD;
import vista.ModificarCliclo;
import vista.ModificarProyecto;
import vista.ModificarProyectoJD;
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
	private ModificarAlumnos panel5;
	private RegistrarProfesor panel6;
	private AñadirCiclo panel7;
	private ModificarAlumno panel8;
	private EliminarCiclo panel9;
	private ModificarCliclo panel10;
	private ModificarCicloJD panel11;
	private ConsultaAlumnoNuevo panel12;
	private AñadirProyecto panel13;
	private EliminarProyecto panel14;
	private ModificarProyecto panel15;
	private ModificarProyectoJD panel16;
	private ConsultaCiclos panel17;
	private ConsultaProyecto panel18;
	private DetalleProyecto panel19;
					
	

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
	
	public void setPanel5(ModificarAlumnos panel5) {
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
	
	public void setPanel12(ConsultaAlumnoNuevo panel12) {
		this.panel12 = panel12;
	}
	
	public void setPanel13(AñadirProyecto panel13) {
		this.panel13 = panel13;
	}
	
	public void setPanel14(EliminarProyecto panel14) {
		this.panel14 = panel14;
	}
	
	public void setPanel15(ModificarProyecto panel15) {
		this.panel15 = panel15;
	}
	
	public void setPanel16(ModificarProyectoJD panel16) {
		this.panel16 = panel16;
	}

	public void setPanel17(ConsultaCiclos panel17) {
		this.panel17 = panel17;
	}

	public void setPanel18(ConsultaProyecto panel18) {
		this.panel18 = panel18;
	}
	
	public void setPanel19(DetalleProyecto panel19) {
		this.panel19 = panel19;
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
			
		}else if(e.getSource().equals(panel3.getBtnCancelar()) || e.getSource().equals(panel4.getBtnCancelar()) || e.getSource().equals(panel5.getButton()) || e.getSource().equals(panel7.getBtnCancelCicloA()) || e.getSource().equals(panel9.getBtnCanceloar()) || e.getSource().equals(panel10.getBtnCancelar()) || e.getSource().equals(panel12.getBtnCancelar()) || e.getSource().equals(panel14.getBtnCancelar()) || e.getSource().equals(panel15.getBtnCancelar()) || e.getSource().equals(panel17.getBtnCancelar()) || e.getSource().equals(panel18.getBtnCancelar())) {
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
			new ProfesorPersistencia().añadirProfesor(panel6.getDatos());	
			panel6.dispose();
		}
			
			
			//TODO																	
		}else if(e.getSource().equals(panel3.getBtnAnadir())) {
			if(panel3.getDatos() != null) {
				new AlumnoPersistencia().añadirAlumno(panel3.getDatos());
			}
			
			
		} else if(e.getSource().equals(panel4.getBtnEliminarAl())) {
			if(panel4.alumnosAEliminar() != null) {
				new AlumnoPersistencia().eliminarAlumno(panel4.alumnosAEliminar());
				panel4.mostrarAlumnos(new AlumnoPersistencia().cargarAlumnos());
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un alumno para eliminarle");
			}
			
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
				JOptionPane.showMessageDialog(null, "Debe seleccionar un alumno para modificarle");
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
			new CicloPersistencia().modificarAlumno(panel11.getDatos(), new CicloPersistencia().obtenerID(panel10.cicloSelecionado().getNombre()));
			panel11.setVisible(false);
			panel10.mostrarCiclos(new CicloPersistencia().cargarCiclos());
			
		}else if(e.getSource().equals(vistaP.getMntConsultar())) {
			vistaP.setPanel(panel12);
			panel12.mostrarAlumnos(new AlumnoPersistencia().cargarAlumnos());
			
		}else if(e.getSource().equals(vistaP.getMntAadirPro())) {
			vistaP.setPanel(panel13);
			panel13.mostrarAlumnos(new AlumnoPersistencia().cargarAlumnos());
			panel13.mostrarCiclos(new CicloPersistencia().cargarCiclos());
			
			
		}else if(e.getSource().equals(panel13.getBtnAnadir())) {
			new PoryectoPersistencia().añadirProyecto(panel13.getDatos());
			
		}else if( e.getSource().equals(vistaP.getMntEliminarPro())) {
			vistaP.setPanel(panel14);
			panel14.mostrarProyectos(new PoryectoPersistencia().cargarProyectos());
			
		}else if(e.getSource().equals(panel14.getBtnEliminarPro())) {
			new PoryectoPersistencia().eliminarProyecto(panel14.ProyectoAEliminar());
			
		}else if(e.getSource().equals(vistaP.getMntConsultaPro())) {
			vistaP.setPanel(panel15);
			panel15.mostrarProyectos(new PoryectoPersistencia().cargarProyectos());
			
		}else if(e.getSource().equals(panel15.getBtnModificarPro())) {
			panel16.mostrarDatos(panel15.obtenerSelecionado());
			panel16.setVisible(true);
			
		}else if(e.getSource().equals(panel16.getBtnCancelar())) {
			panel16.dispose();
			
		}else if(e.getSource().equals(panel16.getBtnAnadirAl())) {
			new PoryectoPersistencia().vincularAlumno(panel16.añadirAlumno(),new PoryectoPersistencia().obtenerID(panel15.obtenerSelecionado()));			//Pruebas
			panel16.mostrarDatos(panel15.obtenerSelecionado());
			
		}else if(e.getSource().equals(panel16.getBtnElimAl())) {
			new PoryectoPersistencia().desvincularAlumno(panel16.eliminarAlumno(), new PoryectoPersistencia().obtenerID(panel15.obtenerSelecionado()));
			panel16.mostrarDatos(panel15.obtenerSelecionado());
			
		}else if(e.getSource().equals(panel16.getBtnModificarProJD())) {
			new PoryectoPersistencia().modificarProyecto(panel16.getDatos(), new PoryectoPersistencia().obtenerID(panel15.obtenerSelecionado()),new CicloPersistencia().obtenerID(panel16.obtenerNombreCiclo()));
			panel16.dispose();
			panel15.mostrarProyectos(new PoryectoPersistencia().cargarProyectos());
			
		}else if(e.getSource().equals(panel5.getBtnFiltrar())) {
			panel5.filtrar();
			
		}else if(e.getSource().equals(vistaP.getMntConsultaCiclo())) {
			vistaP.setPanel(panel17);
			panel17.mostrarCiclos(new CicloPersistencia().cargarCiclos());
			
		}else if(e.getSource().equals(vistaP.getMntmConsultarProyecto())) {
			vistaP.setPanel(panel18);
			panel18.mostrarProyectos(new PoryectoPersistencia().cargarProyectos());
			
		}else if(e.getSource().equals(panel18.getBtnFiltrarPro())){			
			if(!panel18.filtrar().equals("")){
				panel18.mostrarProyectos(new PoryectoPersistencia().cargarProyectosFiltrado(panel18.filtrar()));						
			}
			
		}else if(e.getSource().equals(panel10.getBtnFiltrarCiclos())) {
			panel10.filtrar();
			
		}else if(e.getSource().equals(panel18.getBtnDetalles())) {
			panel19.mostrarProyecto(panel18.proyectoSeleccionado());
			panel19.setVisible(true);
			
		}else if(e.getSource().equals(panel19.getBtnCancelar())) {
			panel19.dispose();
		}
	}
}
