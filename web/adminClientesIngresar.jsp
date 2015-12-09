<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Control de Clientes</title>
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

                                <sj:tab id="ingreso_clientes" target="tabIngresoClientes" label="Ingresar Clientes"/>
                                <div id="tabIngresoClientes">
                                    <s:form action="ingresarCliente" theme="bootstrap" label="Ingrese Clientes">
                                        <s:textfield
                                            label="Rut"
                                            name="rut"
                                            title="Debe ingresar un rut válido"
                                            type="text"
                                            size="9"
                                            pattern="\d{3,8}[\d|kK]{1}"
                                            maxLength="9"
                                            required="true"/>
                                        <s:textfield
                                            title="Debe ingresar una razón social"
                                            type="text"
                                            size="15"
                                            pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'- {2,50}]+"
                                            maxLength="50"
                                            required="true"
                                            label="Razón Social"
                                            name="razonSocial"
                                            />
                                        <s:textfield
                                            title="Debe ingresar dirección"
                                            type="text"
                                            size="20"
                                            pattern="[a-zA-Z0-9áÁéÉÍíóÓúÚ ]+"
                                            maxLength="50"
                                            required="true"
                                            label="Dirección"
                                            name="direccion"/>
                                        <s:select 
                                            label="Ciudad"
                                            list="listaCiudad"
                                            listValue="nombre"
                                            name="IdCiudad"
                                            listKey="id" />
                                        <s:textfield
                                            title="Debe ingresar un nombre de contacto"
                                            type="text"
                                            size="15"
                                            pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'- {2,50}]+"
                                            maxLength="50"
                                            required="true"
                                            label="Contacto"
                                            name="contacto"/>
                                        <s:textfield
                                            title="Debe ingresar un teléfono"
                                            type="tel"
                                            size="10"
                                            maxLength="10"
                                            pattern="\S{5,10}" 
                                            required="true"
                                            label="Teléfono"
                                            name="telefono"/>
                                        <s:textfield
                                            title="Debe ingresar un correo electrónico"
                                            type="email"
                                            size="20"
                                            maxLength="50"
                                            pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"
                                            required="true"
                                            label="Email"
                                            name="email"/>
                                        <s:textfield
                                            title="Debe ingresar una dirección web"
                                            
                                            pattern="[a-zA-Z0-9.]+"
                                            size="20"
                                            maxLength="50"                                            
                                            required="true"
                                            label="Website"
                                            name="website"/>
                                        <s:textfield
                                            
                                            label="Activo (SI: S / NO: N)"
                                            name="activo"
                                            title="SI: S / NO: N"
                                            maxLength="1"
                                            size="1"
                                            pattern="[snSN]"
                                            required="true"/>
                                        <s:select 
                                            label="Forma de Pago"
                                            list="listaFormaPago"
                                            listValue="formaPago"
                                            name="IdFormaPago"
                                            listKey="id" />
                                        <br>    
                                        <s:submit value="Grabar datos" cssClass="btn btn-primary"/>
                                    </s:form>
                                </div>

                                
                                
                             
                                
                                
                              </sj:tabbedpanel>    
                        </div>
                        
                      </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
