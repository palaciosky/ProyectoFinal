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
    <%--<% 
      //HttpSession sesion = request.getSession(false);
      String nombre = (String) session.getAttribute("userd");
      String usuar = (String)session.getAttribute("userd2");
      String names = (String)session.getAttribute("name");
      try{
      if(nombre == null){
            out.print("<center><h2><font color='blue'> Error Cuatrosientoscuatro...</font><hr><h2></center>");
            response.sendRedirect("log.jsp");
        }else if(nombre!=null){
%> --%>
<!DOCTYPE html>

    <body style="background: rgba(246,255,229,1);
background: -moz-linear-gradient(left, rgba(246,255,229,1) 0%, rgba(255,255,255,1) 28%, rgba(253,255,222,1) 55%, rgba(252,252,199,1) 65%, rgba(253,255,222,1) 91%, rgba(255,255,242,1) 100%);
background: -webkit-gradient(left top, right top, color-stop(0%, rgba(246,255,229,1)), color-stop(28%, rgba(255,255,255,1)), color-stop(55%, rgba(253,255,222,1)), color-stop(65%, rgba(252,252,199,1)), color-stop(91%, rgba(253,255,222,1)), color-stop(100%, rgba(255,255,242,1)));
background: -webkit-linear-gradient(left, rgba(246,255,229,1) 0%, rgba(255,255,255,1) 28%, rgba(253,255,222,1) 55%, rgba(252,252,199,1) 65%, rgba(253,255,222,1) 91%, rgba(255,255,242,1) 100%);
background: -o-linear-gradient(left, rgba(246,255,229,1) 0%, rgba(255,255,255,1) 28%, rgba(253,255,222,1) 55%, rgba(252,252,199,1) 65%, rgba(253,255,222,1) 91%, rgba(255,255,242,1) 100%);
background: -ms-linear-gradient(left, rgba(246,255,229,1) 0%, rgba(255,255,255,1) 28%, rgba(253,255,222,1) 55%, rgba(252,252,199,1) 65%, rgba(253,255,222,1) 91%, rgba(255,255,242,1) 100%);
background: linear-gradient(to right, rgba(246,255,229,1) 0%, rgba(255,255,255,1) 28%, rgba(253,255,222,1) 55%, rgba(252,252,199,1) 65%, rgba(253,255,222,1) 91%, rgba(255,255,242,1) 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f6ffe5', endColorstr='#fffff2', GradientType=1 );" >
        <%@include file="WEB-INF/vistas-parciales/encabezado.jspf" %>
        <div class="" >
            <h1>Hola Bienvenido a este Registro  </h1>
            <h4><%= names %></h4>
            
        <br>
        <br>
        <br>
           
        </div>
        
        <%@include file="WEB-INF/vistas-parciales/pie.jspf" %>
    </body>
</html>

