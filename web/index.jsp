<%-- 
    Document   : index
    Created on : 06-14-2020, 02:15:24 PM
    Author     : Palacios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Inventario</title>
        <%@include file="WEB-INF/vistas-parciales/css-js.jspf" %>
    </head>
<% 
      //HttpSession sesion = request.getSession(false);
      String nombre = (String) session.getAttribute("userd");
      
      if(nombre == null){
            
            response.sendRedirect("log.jsp");
        }else if(nombre!=null){
%>
<!DOCTYPE html>

    <body>
        <%@include file="WEB-INF/vistas-parciales/encabezado.jspf" %>
        <h1>Bienvenido a este Registro!</h1>
        <br>
        <br>
        <br>
        
        <%@include file="WEB-INF/vistas-parciales/pie.jspf" %>
    </body>
</html>
<%
                }
   %>
