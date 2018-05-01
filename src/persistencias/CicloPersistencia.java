package persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Alumno;
import modelo.Ciclo;

public class CicloPersistencia {

	AccesoDB conexion = new AccesoDB("org.sqlite.JDBC", "jdbc:sqlite:C:\\Users\\PcCom\\Desktop\\sqlite\\SQLiteDatabaseBrowserPortable\\Data\\Prueba.db");

	Connection con;
	
	public void añadirCiclo(Ciclo ci) {
		
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
		}catch(SQLException | ClassNotFoundException e) {
			e.getMessage();
		}
		//QUEDA SABER COMO CONTROLAR QUE EL USUARIO NO PUEDA METER DOS CICLOS IGUALES, (TAL VEZ IMPIDIENDO QUE TENGAN EL MISMO NOMBRRE, guardado actualmente como UNIQUE);
		try {
            PreparedStatement st = con.prepareStatement("insert into ciclos (nombre, descripcion) values (?,?)");
            st.setString(1, ci.getNombre());
            st.setString(2, ci.getDescripcion());
            st.execute();
            JOptionPane.showConfirmDialog(null, "Ciclo guardado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Ciclo ya existente");
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Los 2 campos deben estar rellenos debidamente", "Error", JOptionPane.CANCEL_OPTION);
        }
		try {
			conexion.desconectar(con);
		}catch(SQLException e) {
			 System.out.println("No se pudo cerrar");
		}
	}
	
	public ArrayList<Ciclo> cargarCiclos() {
		
		ArrayList<Ciclo> ciclos = new ArrayList<Ciclo>();
		Ciclo ci;
		
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
		}catch(SQLException | ClassNotFoundException e) {
			e.getMessage();
		}	
		
		try {
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("Select * from ciclos");
           
           while(rs.next()) {      	   
        	   ci = new Ciclo(rs.getString(2), rs.getString(3));
        	   ciclos.add(ci);      	   
           }
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error");
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
        }
		
		try {
			conexion.desconectar(con);
		}catch(SQLException e) {
			 System.out.println("No se pudo cerrar");
		}		
		return ciclos;
	}
	
	public void eliminarCiclo(Ciclo ci) {
		
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
		}catch(SQLException | ClassNotFoundException e) {
			e.getMessage();
		}
		
		
		try {
            PreparedStatement st = con.prepareStatement("Delete from ciclos where nombre =?");
            st.setString(1, ci.getNombre());
            st.execute();
            JOptionPane.showConfirmDialog(null, "Ciclo eliminado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	        }		
		
		
		
		try {
			conexion.desconectar(con);
		}catch(SQLException e) {
			 System.out.println("No se pudo cerrar");
		}			
	}
	
	public int obtenerID(Ciclo ci) {
		
		int id = 0;
		
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
		}catch(SQLException | ClassNotFoundException e) {
			e.getMessage();
		}
				
		try {
									
			PreparedStatement sm = con.prepareStatement("select id_c from ciclos where nombre = ?");
            sm.setString(1, ci.getNombre());
            ResultSet rs = sm.executeQuery();
            
            id = rs.getInt(1);
            
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	        }		
				
		try {
			conexion.desconectar(con);
		}catch(SQLException e) {
			 System.out.println("No se pudo cerrar");
		}	
		
		return id;
	}

	public void modificarAlumno(Ciclo ci, int id) {
	
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
		}catch(SQLException | ClassNotFoundException e) {
			e.getMessage();
		}
				
		try {
									
			PreparedStatement sm = con.prepareStatement("update ciclos set nombre = ?,descripcion = ? where id_c = ?");
	        sm.setString(1, ci.getNombre());
	        sm.setString(2, ci.getDescripcion());
	        sm.setInt(3, id);
	        sm.execute();
	        JOptionPane.showConfirmDialog(null, "Ciclo modificado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	        }		
				
		try {
			conexion.desconectar(con);
		}catch(SQLException e) {
			 System.out.println("No se pudo cerrar");
		}			
}
	
	
}
