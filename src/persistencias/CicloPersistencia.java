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

	AccesoDB conexion = new AccesoDB("org.sqlite.JDBC", "jdbc:sqlite:Prueba.db");

	Connection con;
	
	public void añadirCiclo(Ciclo ci) {
		
		  PreparedStatement st = null;
		
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
			
            st = con.prepareStatement("insert into ciclos (nombre, descripcion) values (?,?)");
            st.setString(1, ci.getNombre());
            st.setString(2, ci.getDescripcion());
            st.execute();
            JOptionPane.showConfirmDialog(null, "Ciclo guardado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Ciclo ya existente");
        }catch(ClassNotFoundException er) {
        	er.printStackTrace();
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Los 2 campos deben estar rellenos debidamente", "Error", JOptionPane.CANCEL_OPTION);
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
	
	public ArrayList<Ciclo> cargarCiclos() {
		
		ArrayList<Ciclo> ciclos = new ArrayList<Ciclo>();
		Ciclo ci;
		Statement st = null;
        ResultSet rs = null;
			
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
			
           st = con.createStatement();
           rs = st.executeQuery("Select * from ciclos");
           
           while(rs.next()) {      	   
        	   ci = new Ciclo(rs.getString(2), rs.getString(3));
        	   ciclos.add(ci);      	   
           }
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error");
        }catch(ClassNotFoundException er) {
        	er.printStackTrace();
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
        }finally {
        	
        	try {
        		if(rs != null) {
        			rs.close();
        		}
        		if(st != null) {
        			st.close();
        		}
        		if (con != null) {
        			conexion.desconectar(con);
        		}	    	
    		}catch(SQLException e) {
    			 System.out.println(e.getMessage());
    		}		        	
        }				
		return ciclos;
	}
	
	public void eliminarCiclo(Ciclo ci) {
		
		PreparedStatement st = null;
								
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
			
            st = con.prepareStatement("Delete from ciclos where nombre =?");
            st.setString(1, ci.getNombre());
            st.execute();
            JOptionPane.showConfirmDialog(null, "Ciclo eliminado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
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
	
	public int obtenerID(String ci) {
		
		int id = 0;
		PreparedStatement sm = null;
		ResultSet rs = null;
						
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
									
			sm = con.prepareStatement("select id_c from ciclos where nombre = ?");
            sm.setString(1, ci);
            rs = sm.executeQuery();
            
            id = rs.getInt(1);
            
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch(ClassNotFoundException er) {
	        	er.printStackTrace();
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	        }finally {	        	
	        	try {
	        		if(rs!= null) {
	        			rs.close();
	        		}
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

	public void modificarAlumno(Ciclo ci, int id) {
	
		PreparedStatement sm = null;
						
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
									
			sm = con.prepareStatement("update ciclos set nombre = ?,descripcion = ? where id_c = ?");
	        sm.setString(1, ci.getNombre());
	        sm.setString(2, ci.getDescripcion());
	        sm.setInt(3, id);
	        sm.execute();
	        JOptionPane.showConfirmDialog(null, "Ciclo modificado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
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
	
	public String obtenerCiclo(String nombre) {
		
		PreparedStatement sm = null;
		ResultSet rs = null;
		Ciclo ci = null;
		int id = 0;
		String nombreCiclo="";
						
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
									
			sm = con.prepareStatement("select ciclo from proyectos where nombre = ?");
            sm.setString(1, nombre);
            rs = sm.executeQuery();
            
            while(rs.next()) {
            	id = rs.getInt(1);
            }
            
            if(rs!= null) {
    			rs.close();
    		}
            if(sm != null) {
    			sm.close();
    		}
            
            sm = con.prepareStatement("select nombre from ciclos where id_c = ?");
            sm.setInt(1, id);
            rs = sm.executeQuery();
            
            while(rs.next()) {
            	nombreCiclo = rs.getString(1);
            }
            
            
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch(ClassNotFoundException er) {
	        	er.printStackTrace();
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	        }finally {	        	
	        	try {
	        		if(rs!= null) {
	        			rs.close();
	        		}
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
						
		return nombreCiclo;
	}
	
}
