
package com.action;

import com.dao.DaoFormaPago;
import com.model.FormaPago;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.util.ValueStack;
import java.io.IOException;
import java.util.List;


public class FormaPagoAction {
    
     private DaoFormaPago dao = new DaoFormaPago();
    public List <FormaPago> records;
    private String result;
    private String message;
    private FormaPago record; 
    
    
    private int id;
    private String formaPago;
    
    private ValueStack val;   
     private int codigoFormaPago;
     
      public String list() {
          
        try {
            // Fetch Data from Proyecto Table
            records = dao.listar();
           
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }
    
      
      
      public String create() throws IOException {
        record = new FormaPago();

        
        record.setId(this.id);
        record.setFormaPago(formaPago);
       
        
        
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
          FormaPago formaPagos = new FormaPago();
         
         try {
                formaPagos.setId(id);
                formaPagos.setFormaPago(formaPago);
                dao.actualizar(formaPagos);
			result = "OK";
                        return Action.SUCCESS;
             
         } catch (Exception e) {
                result = "ERROR";
                message = e.getMessage();
                System.err.println(e.getMessage());
                return Action.ERROR;
         }
            
     }
     
     public String delete() throws IOException {
		// Delete record
		try {
			dao.eliminar(this.id);
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
            System.out.println("recurso de la jsp:  " + codigoFormaPago);
            record = dao.buscarPorID(codigoFormaPago);
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
         System.out.println("id:  " + record.getId());
         System.out.println("forma de pago:  " + record.getFormaPago());
         
          return Action.SUCCESS;
     }

    public FormaPagoAction() {
    }

    public DaoFormaPago getDao() {
        return dao;
    }

    public void setDao(DaoFormaPago dao) {
        this.dao = dao;
    }

    public List<FormaPago> getRecords() {
        return records;
    }

    public void setRecords(List<FormaPago> records) {
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

    public FormaPago getRecord() {
        return record;
    }

    public void setRecord(FormaPago record) {
        this.record = record;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public ValueStack getVal() {
        return val;
    }

    public void setVal(ValueStack val) {
        this.val = val;
    }

    public int getCodigoFormaPago() {
        return codigoFormaPago;
    }

    public void setCodigoFormaPago(int codigoFormaPago) {
        this.codigoFormaPago = codigoFormaPago;
    }
     
     
     
     
}
