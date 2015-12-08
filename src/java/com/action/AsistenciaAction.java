package com.action;

import com.dao.DaoAsistencia;
import com.dao.DaoEmpleado;
import java.io.IOException;
import java.util.List;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import java.sql.Date;
import com.model.Empleado;
import com.model.Asistencia;

public class AsistenciaAction {
     private DaoAsistencia dao = new DaoAsistencia();
     public List <Asistencia> records;
     private String result;
     private String message;
     private Asistencia record;
     
     private int id;
     public String rutDesdeLaJsp;
     private Empleado rut_empleado;
     private String fecha_entrada;
     private String fecha_salida;
     
     private ValueStack val;   
     private String codigoAsistencia;
     
     public String execute() throws Exception {
//        val = ActionContext.getContext().getValueStack();
//        dao.eliminar(codigoEmpleado);
//        val.push(record);
        return ActionSupport.SUCCESS;
    }
    
     public DaoEmpleado  daoEmp = new DaoEmpleado();
     public List<Empleado> listaEmpleados;
     
     public String list() {
          
        try {
            // Fetch Data from Proyecto Table
            records = dao.listar();
            result = "OK";
            listaEmpleados = daoEmp.listar();
            
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }
    
     
    public String idEmp; 
     
    public String create() throws IOException {
      record = new Asistencia();

        
        record.setId(this.id);
        
        Empleado miEmp = new Empleado();
        miEmp.setRut(idEmp);
        record.setRut_empleado(miEmp);
        
        record.setFecha_entrada(this.fecha_entrada);
        record.setFecha_salida(this.fecha_salida);
               
        try {
            // Create new record
            dao.ingresar(record);
            result = "OK";

        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }
    
    
    public String update() throws IOException {
        try {
                record.setId(this.id);
                
                Empleado miemp = new Empleado();
                miemp.setRut(idEmp);
                record.setRut_empleado(miemp);
                
                record.setFecha_entrada(this.fecha_entrada);
                record.setFecha_salida(this.fecha_salida);
                
                
			// Update existing record
			dao.actualizar(record);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public String delete() throws IOException {
		// Delete record
		try {
			dao.eliminar(this.rutDesdeLaJsp);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}
        
        public String buscaAsistencia() throws IOException {
        try {
            System.out.println("recurso de la jsp:  " + codigoAsistencia);
            record = dao.buscarPorID(codigoAsistencia);
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        System.out.println("id:  " + record.getId());
        System.out.println("rut empleado:  " + record.getRut_empleado().getRut());
        System.out.println("fecha entrada:  " + record.getFecha_entrada());
        System.out.println("fecha salida:  " + record.getFecha_salida());
       
       
        return Action.SUCCESS;
        
    }

    public DaoAsistencia getDao() {
        return dao;
    }

    public void setDao(DaoAsistencia dao) {
        this.dao = dao;
    }

    public List<Asistencia> getRecords() {
        return records;
    }

    public void setRecords(List<Asistencia> records) {
        this.records = records;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Asistencia getRecord() {
        return record;
    }

    public void setRecord(Asistencia record) {
        this.record = record;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRutDesdeLaJsp() {
        return rutDesdeLaJsp;
    }

    public void setRutDesdeLaJsp(String rutDesdeLaJsp) {
        this.rutDesdeLaJsp = rutDesdeLaJsp;
    }

    public Empleado getRut_empleado() {
        return rut_empleado;
    }

    public void setRut_empleado(Empleado rut_empleado) {
        this.rut_empleado = rut_empleado;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public ValueStack getVal() {
        return val;
    }

    public void setVal(ValueStack val) {
        this.val = val;
    }

    public String getCodigoAsistencia() {
        return codigoAsistencia;
    }

    public void setCodigoAsistencia(String codigoAsistencia) {
        this.codigoAsistencia = codigoAsistencia;
    }

    public DaoEmpleado getDaoEmp() {
        return daoEmp;
    }

    public void setDaoEmp(DaoEmpleado daoEmp) {
        this.daoEmp = daoEmp;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }
    
    
}
