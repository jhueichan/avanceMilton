<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Administración de Empleados</title>
        <%@include file="header.txt"%>
        <%@include file="footer.txt" %>
        <sj:head jqueryui="true" jquerytheme="start"/>

    </head>
    <body>
        <div id="wrapper">
            <%@include file="menu.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">

                            <sj:tabbedpanel id="tabs" cssClass="listas">

                                <sj:tab id="modificar_clientes" target="tabActualizarClientes" label="Actualizar Clientes"/>
                                
                                

                                <div id="tabActualizarClientes">                                
                                    <s:form action="actualizarCliente"  theme="bootstrap">   
                                        <s:textfield name="rut" label="Rut" value="%{record.rut}"  readonly="true"></s:textfield>
                                        <s:textfield name="razonSocial" label="Razon Social" value="%{record.razonSocial}" title="Debe ingresar una razón social"
                                            type="text"
                                            size="15"
                                            pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'- {2,50}]+"
                                            maxLength="50"
                                            required="true"></s:textfield>
                                        <s:textfield name="direccion" label="Direccion" value="%{record.direccion}" title="Debe ingresar dirección"
                                            type="text"
                                            size="20"
                                            pattern="[a-zA-Z0-9áÁéÉÍíóÓúÚ ]+"
                                            maxLength="50"
                                            required="true"></s:textfield> 
                                        
                                         <s:textfield name="IdCiudad" label="Ciudad" value="%{record.ciudad.id}"></s:textfield>
                                         
                                        <s:textfield name="contacto" label="Nombre de Contacto" value="%{record.contacto}"  title="Debe ingresar un nombre de contacto"
                                            type="text"
                                            size="15"
                                            pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'- {2,50}]+"
                                            maxLength="50"
                                            required="true"></s:textfield>
                                         
                                        <s:textfield name="telefono" label="Teléfono" value="%{record.telefono}"  title="Debe ingresar un teléfono"
                                            type="tel"
                                            size="10"
                                            maxLength="10"
                                            pattern="\S{5,10}" 
                                            required="true"></s:textfield>
                                         
                                        <s:textfield name="email"   label="Email"  value="%{record.email}" title="Debe ingresar un correo electrónico"
                                            type="email"
                                            size="20"
                                            maxLength="50"
                                            pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"
                                            required="true"></s:textfield>
                                        <s:textfield name="website" label="Sitio Web" value="%{record.website}"  title="Debe ingresar una dirección web"
                                            label="Website"
                                            pattern="[a-zA-Z0-9.]+"
                                            size="20"
                                            maxLength="50"                                            
                                            required="true" ></s:textfield>
                                        <s:textfield name="activo" label="Activo" value="%{record.activo}" title="Activo: S - No Activo: N"
                                            maxLength="1"
                                            size="1"
                                            pattern="[snSN]"
                                            required="true"></s:textfield>
                                          
                                          
                                          
                                       
                                        <s:textfield name="IdformaPago" label="Forma de Pago" value="%{record.formaPago.id}" readonly="true"></s:textfield>

                                        
                                        
                                        
                                                                               
                                       
                                        <s:submit value="Actualizar"></s:submit>
                                    </s:form>
                                </div> 
                            </sj:tabbedpanel>    
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
