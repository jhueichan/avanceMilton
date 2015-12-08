package com.action;

import com.dao.DaoCiudad;
import com.dao.DaoCliente;
import com.dao.DaoFormaPago;
import com.model.Ciudad;
import com.model.Cliente;
import com.model.FormaPago;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import java.io.IOException;
import java.util.List;


public class ClienteAction {
    
    private DaoCliente dao = new DaoCliente();
    public List <Cliente> records;
    private String result;
    private String message;
    private Cliente record; 
    
     private String rut, razonSocial, direccion, contacto, telefono, email, website, activo;
     private Ciudad ciudad;
     private FormaPago formaPago;
     
     private ValueStack val;   
     private String codigoCliente;
     
     public DaoCiudad  daoCiud = new DaoCiudad();
     public List<Ciudad> listaCiudad;
     public DaoFormaPago daoFormas = new DaoFormaPago();
     public List<FormaPago> listaFormaPago;
     
      public String execute() throws Exception {
//        val = ActionContext.getContext().getValueStack();
//        dao.eliminar(codigoEmpleado);
//        val.push(record);
        return ActionSupport.SUCCESS;
    }
     
     public String list() {
          
        try {
            // Fetch Data from Proyecto Table
            records = dao.listar();
            result = "OK";
            listaCiudad = daoCiud.listar();
            listaFormaPago= daoFormas.listar();
          
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }
     
     public int IdCiudad;
     public int IdFormaPago;
     
     public String create() throws IOException {
        record = new Cliente();

        
        record.setRut(this.rut);
        record.setRazonSocial(this.razonSocial);
        record.setDireccion(this.direccion);
        
        Ciudad miCiudad = new Ciudad();
        miCiudad.setId(IdCiudad);
        record.setCiudad(miCiudad);
        
        record.setContacto(this.contacto);
        record.setTelefono(this.telefono);
        record.setEmail(this.email);
        record.setWebsite(this.website);
        record.setActivo(this.activo);
        
        FormaPago miFormaPago = new FormaPago();
        miFormaPago.setId(IdFormaPago);
        record.setFormaPago(miFormaPago);
        
        
        
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
                record.setRut(this.rut);
                record.setRazonSocial(this.razonSocial);
                record.setDireccion(this.direccion);
                
                Ciudad miciudad = new Ciudad();
                miciudad.setId(IdCiudad);
                record.setCiudad(miciudad);
        
                record.setContacto(this.contacto);
                record.setTelefono(this.telefono);
                record.setEmail(this.email);
                record.setWebsite(this.website);
                record.setActivo(this.activo);
        
                FormaPago miformaPago = new FormaPago();
                miformaPago.setId(IdFormaPago);
                record.setFormaPago(miformaPago);
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
			dao.eliminar(this.rut);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}
     
     public String buscaCliente() throws IOException {
        try {
            System.out.println("recurso de la jsp:  " + codigoCliente);
            record = dao.buscarPorID(codigoCliente);
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
         System.out.println("rut:  " + record.getRut());
         System.out.println("razon social:  " + record.getRazonSocial());
         System.out.println("direccion:  " + record.getDireccion());
         System.out.println("ciudad:  " + record.getCiudad().getId());
         System.out.println("contacto:  " + record.getContacto());
         System.out.println("telefono:  " + record.getTelefono());
         System.out.println("email:  " + record.getEmail());
         System.out.println("website:  " + record.getWebsite());
         System.out.println("activo:  " + record.getActivo());
         System.out.println("forma pago:  " + record.getFormaPago().getId());
          return Action.SUCCESS;
     }

    public DaoCliente getDao() {
        return dao;
    }

    public void setDao(DaoCliente dao) {
        this.dao = dao;
    }

    public List<Cliente> getRecords() {
        return records;
    }

    public void setRecords(List<Cliente> records) {
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

    public Cliente getRecord() {
        return record;
    }

    public void setRecord(Cliente record) {
        this.record = record;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public ValueStack getVal() {
        return val;
    }

    public void setVal(ValueStack val) {
        this.val = val;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public DaoCiudad getDaoCiu() {
        return daoCiud;
    }

    public void setDaoCiu(DaoCiudad daoCiu) {
        this.daoCiud = daoCiu;
    }

    public List<Ciudad> getListaCiudad() {
        return listaCiudad;
    }

    public void setListaCiudad(List<Ciudad> listaCiudad) {
        this.listaCiudad = listaCiudad;
    }

    public DaoFormaPago getDaoForma() {
        return daoFormas;
    }

    public void setDaoForma(DaoFormaPago daoForma) {
        this.daoFormas = daoForma;
    }

    public List<FormaPago> getListaFormaPago() {
        return listaFormaPago;
    }

    public void setListaFormaPago(List<FormaPago> listaFormaPago) {
        this.listaFormaPago = listaFormaPago;
    }

    public int getIdCiudad() {
        return IdCiudad;
    }

    public void setIdCiudad(int IdCiudad) {
        this.IdCiudad = IdCiudad;
    }

    public int getIdFormaPago() {
        return IdFormaPago;
    }

    public void setIdFormaPago(int IdFormaPago) {
        this.IdFormaPago = IdFormaPago;
    }
     
     
}