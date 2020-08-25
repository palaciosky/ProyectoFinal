<%-- 
    Document   : listarventas
    Created on : 07-28-2020, 10:20:42 AM
    Author     : Palacios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Ventas</title>
         <%@include file="../WEB-INF/vistas-parciales/css-js.jspf" %>
    </head>
    <body>
        <%@include file="../WEB-INF/vistas-parciales/encabezado.jspf" %>
      
             <h3 class="glyphicon glyphicon-shopping-cart"> Gestor de Ventas y Facturación</h3>
             <br><h5>Seleccione si desea vender un nuevo producto o registro o Revisar su historial de facturación</h5>
             <br>
             
        <div class="row" >
            <button type="button" class="btn btn-success btn-lg active  glyphicon glyphicon-tag col md-4 xs-8" style="padding-bottom:  5%"> <br>Vender Producto</button>
            <div class=".">
                .
            </div>  
            <button type="button" class="btn btn-secondary btn-lg active  glyphicon glyphicon-list col md-4 xs-8" style="padding-bottom:  5%" > <br>Registro Facturas</button>
        </div>
       
        <%@include file="../WEB-INF/vistas-parciales/pie.jspf" %>   
    </body>
</html>
