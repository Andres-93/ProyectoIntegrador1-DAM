package persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Alumno;

public class AlumnoPersistencia {

	AccesoDB conexion = new AccesoDB("org.sqlite.JDBC", "jdbc:sqlite:C:\\Users\\PcCom\\Desktop\\sqlite\\SQLiteDatabaseBrowserPortable\\Data\\Prueba.db");

	Connection con;
		
	public void añadirAlumno(Alumno alu) {
		
		PreparedStatement st = null;
		
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
			
            st = con.prepareStatement("insert into alumnos (nombre, numExpediente) values (?,?)");
            st.setString(1, alu.getNombre());
            st.setInt(2, alu.getExpediente());
            st.execute();
            JOptionPane.showConfirmDialog(null, "Usuario guardado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Usuario ya existente");
        }catch(ClassNotFoundException er) {
        	er.printStackTrace();
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Los 3 campos deben estar rellenos debidamente", "Error", JOptionPane.CANCEL_OPTION);
        }finally {
			try {
				if(st != null) {
					st.close();
				}
				if(con != null) {
					conexion.desconectar(con);
				}
			}catch(SQLException e) {
				 System.out.println("No se pudo cerrar");
			}
        }
	}
	
	
	public ArrayList<Alumno> cargarAlumnos() {
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno al;
		Statement st = null;
        ResultSet rs = null;
		
		
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
			
            st = con.createStatement();
            rs = st.executeQuery("Select * from alumnos");
           
           while(rs.next()) {      	   
        	   al = new Alumno(rs.getString(2), rs.getInt(3));
        	   alumnos.add(al);      	   
           }
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error");
        }catch(ClassNotFoundException er) {
        	er.printStackTrace();
        }
		catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
        }finally {	
			try {
				if(rs != null) {
					rs.close();
				}
				if(st != null) {
					st.close();
				}
				if(con != null) {
					conexion.desconectar(con);
				}			
			}catch(SQLException e) {
				 System.out.println("No se pudo cerrar");
			}	
        }
		return alumnos;
	}
	
	
	
	public void eliminarAlumno(Alumno al) {
		
		 PreparedStatement st = null;
		
			
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
			
            st = con.prepareStatement("Delete from alumnos where numExpediente =?");
            st.setInt(1, al.getExpediente());
            st.execute();
            JOptionPane.showConfirmDialog(null, "Usuario eliminado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch(ClassNotFoundException er) {
	        	er.printStackTrace();
	        }catch(Exception e) {        
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	        }finally {
	        	
	        	try {
	        		if(st != null) {
	        			st.close();
	        		}
	        		if (con != null) {
	        			conexion.desconectar(con);
	        		}	    	
	    		}catch(SQLException e) {
	    			 System.out.println("No se pudo cerrar");
	    		}		        	
	        }				
	}	
	
	public void modificarAlumno(Alumno al, int id) {
				
		PreparedStatement sm = null;
				
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
									
			sm = con.prepareStatement("update alumnos set nombre = ?,numExpediente = ? where ID_A = ?");
            sm.setString(1, al.getNombre());
            sm.setInt(2, al.getExpediente());
            sm.setInt(3, id);
            sm.execute();
            JOptionPane.showConfirmDialog(null, "Usuario modificado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch(ClassNotFoundException er) {
	        	er.printStackTrace();
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	        }finally {
	        	
	        	try {
	        		if(sm != null) {
	        			sm.close();
	        		}
	        		if (con != null) {
	        			conexion.desconectar(con);
	        		}	    	
	    		}catch(SQLException e) {
	    			 System.out.println("No se pudo cerrar");
	    		}		        	
	        }		
				
					
	}
	
	public int obtenerID(Alumno al) {
		
		int id = 0;
		
		PreparedStatement sm = null;
				
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
									
			sm = con.prepareStatement("select ID_A from alumnos where numExpediente = ?");
            sm.setInt(1, al.getExpediente());
            ResultSet rs = sm.executeQuery();
            
            id = rs.getInt(1);
            
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch(ClassNotFoundException e) {
	        	e.printStackTrace();
	        }catch(Exception er) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	        }finally {
	        	
	        	try {
	        		if(sm != null) {
	        			sm.close();
	        		}
	        		if (con != null) {
	        			conexion.desconectar(con);
	        		}	    	
	    		}catch(SQLException e) {
	    			 System.out.println("No se pudo cerrar");
	    		}		        	
	        }			
		return id;
	}
}
