package com.dao;

import com.model.Afp;
import com.model.Ciudad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.model.Empleado;
import com.model.EstadoCivil;
import com.model.Nacionalidad;
import com.model.Prevision;
import com.model.Profesion;
import com.model.Rol;
import com.service.EmpleadoInterface;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;



public class DaoEmpleado implements EmpleadoInterface {
    DaoCiudad daoCiudad= new DaoCiudad();
    DaoNacionalidad daoNacionalidad = new DaoNacionalidad();
    DaoEstadoCivil daoEstadoCivil = new DaoEstadoCivil();
    DaoAfp daoAfp = new DaoAfp();
    DaoPrevision daoPrevision = new DaoPrevision();
    DaoProfesion daoProfesion = new DaoProfesion();
    DaoRol daoRol = new DaoRol();     
    PreparedStatement pStmt; 
    CallableStatement csts;
    
    public DaoEmpleado() {          
      
    }
    
    
    
 public Empleado ValidarUsuario(String User, String Clave) throws Exception {

        CallableStatement Cstm = null;
        ResultSet Rst = null;
        Empleado empleado = new Empleado();
        Rol r = new Rol();
        try{         
            String Comando = "call pa_ValidarUsuario(?,?)";
            Cstm = dbConnection.prepareCall(Comando);
            Cstm.setString(1, User);
            Cstm.setString(2, Clave);
            Rst = Cstm.executeQuery();
            while(Rst.next()){
                             
            }
            System.out.println("exito login en ----> ValidarEmpleado ");
        }catch(Exception e){
            System.out.println("error login en ----> ValidarEmpleado");
        }
        return empleado;
    }

    @Override
    public boolean eliminar(String rut) throws Exception {
        String deleteQuery = "DELETE FROM EMPLEADO WHERE RUT = ?";
        try {
            pStmt = dbConnection.prepareStatement(deleteQuery);
            pStmt.setString(1, rut);
            pStmt.executeUpdate();
            return  true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List <Empleado> listar() throws Exception {
     List<Empleado> empleados = new ArrayList<Empleado>();
   	String query = "SELECT * FROM EMPLEADO ORDER BY RUT";
	try {              
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
                while (rs.next()) {
	        Empleado empleado = new Empleado();
               
                empleado.setRut(rs.getString(1));
                empleado.setNombres(rs.getString(2));
                empleado.setApellidos(rs.getString(3));
                empleado.setDireccion(rs.getString(4));
                Ciudad ciudad=daoCiudad.buscarPorID(rs.getInt(5));
                empleado.setCiudad_id(ciudad);
                Nacionalidad nacionalidad= daoNacionalidad.buscarPorID(rs.getInt(6));
                empleado.setNacionalidad_id(nacionalidad);                
                empleado.setFechaNac(rs.getString(7));                
                EstadoCivil estado=daoEstadoCivil.buscarPorID(rs.getInt(8));
                empleado.setEstado_civil_id(estado);
                empleado.setCargasFam(rs.getString(9));
                Afp afp= daoAfp.buscarPorID(rs.getInt(10));
                empleado.setAfp_id(afp);
                Prevision prevision=daoPrevision.buscarPorID(rs.getInt(11));
                empleado.setPrevision_id(prevision);                
                empleado.setTelefono(rs.getString(12));
                empleado.setEmail(rs.getString(13));
                Profesion  profesion= daoProfesion.buscarPorID(rs.getInt(14));
                empleado.setProfesion_id(profesion);
                Rol rol= daoRol.buscarPorID(rs.getInt(15));
                empleado.setRol_id(rol);                
                empleado.setPassword(rs.getString(16));
                empleados.add(empleado);
                
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return empleados;        
    }

    
    
    
    @Override
    public boolean ingresar(Empleado empleado) throws Exception {
     Empleado emp = new Empleado();
        
        //System.out.println("el empleado vive en la ciudad de : "+emp.getCiudad().getNombre());
         
        try {
            csts = dbConnection.prepareCall("{call insertar_empleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            csts.setString(1, empleado.getRut());
            csts.setString(2, empleado.getNombres());
            csts.setString(3, empleado.getApellidos());
            csts.setString(4, empleado.getDireccion());
            csts.setInt(5,empleado.getCiudad_id().getId());            
            csts.setInt(6, empleado.getNacionalidad_id().getId());
            csts.setString(7,empleado.getFechaNac());        
            csts.setInt(8,empleado.getEstado_civil_id().getId());    
            csts.setString(9, empleado.getCargasFam());            
            csts.setInt(10, empleado.getAfp_id().getId());
            csts.setInt(11, empleado.getPrevision_id().getId());
            csts.setString(12, empleado.getTelefono());
            csts.setString(13, empleado.getEmail());
            csts.setInt(14, empleado.getProfesion_id().getId());
            csts.setInt(15, empleado.getRol_id().getId());
            csts.setString(16, empleado.getPassword());
            csts.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Empleado empleado) throws Exception {
         
        try {
            csts = dbConnection.prepareCall("{call actualizar_empleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");           
            
            
            csts.setString(1, empleado.getNombres());
            csts.setString(2, empleado.getApellidos());
            csts.setString(3, empleado.getDireccion());
            csts.setInt(4,empleado.getCiudad_id().getId());            
            csts.setInt(5, empleado.getNacionalidad_id().getId());
            csts.setString(6,empleado.getFechaNac());        
            csts.setInt(7,empleado.getEstado_civil_id().getId());    
            csts.setString(8, empleado.getCargasFam());            
            csts.setInt(9, empleado.getAfp_id().getId());
            csts.setInt(10, empleado.getPrevision_id().getId());
            csts.setString(11, empleado.getTelefono());
            csts.setString(12, empleado.getEmail());
            csts.setInt(13, empleado.getProfesion_id().getId());
            csts.setInt(14, empleado.getRol_id().getId());
            csts.setString(15, empleado.getPassword());
            csts.setString(16, empleado.getRut());
            
            csts.executeUpdate();
          return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Empleado buscarPorID(String rut) throws Exception {
     Empleado empleado =new Empleado();
     String query = "SELECT * FROM EMPLEADO WHERE RUT = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setString(1,rut);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
                empleado.setRut(rs.getString(1));
                empleado.setNombres(rs.getString(2));
                empleado.setApellidos(rs.getString(3));
                empleado.setDireccion(rs.getString(4)); 
                Ciudad ciudad=daoCiudad.buscarPorID(rs.getInt(5));
                empleado.setCiudad_id(ciudad);
                Nacionalidad nacionalidad= daoNacionalidad.buscarPorID(rs.getInt(6));
                empleado.setNacionalidad_id(nacionalidad); 
                SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yy");     
                empleado.setFechaNac(sm.format(rs.getDate(7)));                    
                EstadoCivil estado=daoEstadoCivil.buscarPorID(rs.getInt(8));
                empleado.setEstado_civil_id(estado);
                empleado.setCargasFam(rs.getString(9));
                Afp afp= daoAfp.buscarPorID(rs.getInt(10));
                empleado.setAfp_id(afp);
                Prevision prevision=daoPrevision.buscarPorID(rs.getInt(11));
                empleado.setPrevision_id(prevision);                
                empleado.setTelefono(rs.getString(12));
                empleado.setEmail(rs.getString(13));
                Profesion  profesion= daoProfesion.buscarPorID(rs.getInt(14));
                empleado.setProfesion_id(profesion);
                Rol rol= daoRol.buscarPorID(rs.getInt(15));
                empleado.setRol_id(rol);                
                empleado.setPassword(rs.getString(16));
                
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  empleado;   
    
    }

 
    
    
}
