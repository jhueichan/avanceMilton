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

                                <sj:tab id="lista_clientes" target="tabListaClientes" label="Listar Clientes"/>
                               

                                <div id="tabListaClientes">
                                    <h3>
                                        Lista de Clientes
                                    </h3>
                                    <table class="table table-bordered">
                                        <thead>
                                        <th>Rut</th>
                                        <th>Razon Social</th>
                                        <th>Dirección</th>
                                        <th>Ciudad</th>
                                        <th>Contacto</th>
                                        <th>Teléfono</th>
                                        <th>Email</th>
                                        <th>Website</th>
                                        <th>Activo</th>
                                        <th>Forma de Pago</th>
                                        <th>Acciones</th>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="records" var="dato" status="estado">
                                                <tr>
                                                    <!-- los nombre de valores de las propiedades deben ser los mismos que en la clase del modelo-->
                                                    <td ><s:property value="rut" /></td>
                                                    <td ><s:property value="razonSocial" /></td>
                                                    <td ><s:property value="direccion" /></td>
                                                    <td ><s:property value="ciudad.nombre" /></td>
                                                    <td ><s:property value="contacto" /></td>
                                                    <td ><s:property value="telefono" /></td>
                                                   <td><s:property value="email" /></td>
                                                    <td><s:property value="website" /></td>
                                                    <td><s:property value="activo" /></td>
                                                    <td ><s:property value="formaPago.formaPago" /></td>
                                                                                                     
                                                      <td>
                                                        <s:url id="url" action="buscarCliente">
                                                            <s:param name="codigoCliente">
                                                                <s:property value="rut"></s:property>                                                                    
                                                            </s:param>                                                               
                                                        </s:url>
                                                        <s:a href="%{url}" cssClass="fs1" aria-hidden="true">Actualizar</s:a>

                                                        <s:a action="eliminarCliente">
                                                            <s:param name="rut" value="rut" />
                                                            <i class="glyphicon glyphicon-trash"></i>
                                                        </s:a>    
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
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
