
package com.action;
import java.sql.Date;
import com.dao.DaoAfp;
import com.dao.DaoAsistencia;
import com.dao.DaoCiudad;
import com.dao.DaoCliente;
import com.dao.DaoEmpleado;
import com.dao.DaoEstadoCivil;
import com.dao.DaoFormaPago;
import com.dao.DaoNacionalidad;
import com.dao.DaoPrevision;
import com.dao.DaoProfesion;
import com.dao.DaoProveedor;
import com.dao.DaoRol;
import com.model.Afp;
import com.model.Asistencia;
import com.model.Ciudad;
import com.model.Cliente;
import com.model.Empleado;
import com.model.EstadoCivil;
import com.model.FormaPago;
import com.model.Nacionalidad;
import com.model.Prevision;
import com.model.Profesion;
import com.model.Proveedor;
import com.model.Rol;
import java.util.List;

public class Main {
    private static Object daoCiudad;

    public static void main(String[] args) throws Exception {
        
        
    
//    DaoCiudad daoCiudad = new DaoCiudad();
//    DaoNacionalidad daoNacionalidad = new DaoNacionalidad();
//    DaoEstadoCivil daoEstadoCivil = new DaoEstadoCivil();
//    DaoAfp daoAfp = new DaoAfp();
//    DaoPrevision daoPrevision = new DaoPrevision();
//    DaoProfesion daoProfesion = new DaoProfesion();
//    DaoRol daoRol = new DaoRol();
    
//       List <Empleado> lisEmp  =  daoEmp.listar();
//       
//        for (Empleado emp : lisEmp) {
//            
//            System.out.println("el nombre del empleado es:  "+emp.getNombres()); 
//            System.out.println("el rut del empleado es:  "+emp.getRut());
//             System.out.println("el rut del empleado es:  "+emp.getAfp_id().getNombre());
//                System.out.println("el rut del empleado es:  "+emp.getCargasFam());
//                System.out.println("el rut del empleado es:  "+emp.getDireccion());
//                System.out.println("el rut del empleado es:  "+emp.getEmail());
//                System.out.println("el rut del empleado es:  "+emp.getPassword());
//                System.out.println("el rut del empleado es:  "+emp.getTelefono());
//                System.out.println("el rut del empleado es:  "+emp.getCiudad_id().getNombre());
//                System.out.println("el rut del empleado es:  "+emp.getEstado_civil_id().getNombre());
//                System.out.println("el rut del empleado es:  "+emp.getFechaNac());
//                System.out.println("el rut del empleado es:  "+emp.getNacionalidad_id().getNacionalidad());
//                System.out.println("el rut del empleado es:  "+emp.getPrevision_id().getPrevision());
//                System.out.println("el rut del empleado es:  "+emp.getRol_id().getNombres());
//                System.out.println("el rut del empleado es:  "+emp.getProfesion_id().getProfesion());
//                
//      
//        }
//        
//        DaoCliente daoCli = new DaoCliente();
//        List<Cliente> lisCli = daoCli.listar();
//    
//        for(Cliente cli:lisCli){
//            System.out.println("el rut del cliente es:  "+cli.getRut());
//        }
  
        DaoEmpleado daoEmp=  new DaoEmpleado();
        
        Empleado emp = daoEmp.buscarPorID("140050040");
        System.out.println("Empleado 17234983" + emp.getEmail());
        System.out.println("fecha nac" + emp.getFechaNac());
        emp.setEmail("innknk@gmail.com");
         
        daoEmp.actualizar(emp);        
        System.out.println("Empleado 17234983" + emp.getEmail());
            
        
        DaoAsistencia daoAs = new DaoAsistencia();
        
        
        
        
        
    }
    
    
    
}
