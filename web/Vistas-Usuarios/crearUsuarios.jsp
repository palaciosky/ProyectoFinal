<%-- 
    Document   : crearUsuarios
    Created on : 07-02-2020, 08:18:47 AM
    Author     : Palacios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<jsp:useBean id="usuario" scope="session" class="Model.Usuario" />
<%
String id_us= "";
String nombre_us = "";
String apellido_us = "";
String correo_us = "";
String usuario_us = "";
String clave_us = "";
String tipo_us = "";
String estado_us = "";
String preg_us = "";
String resp_us = "";

if (request.getParameter("jeñal")!=null) {
        id_us = request.getParameter("id_u");
        nombre_us = request.getParameter("nombre_u");
        apellido_us = request.getParameter("apellido_u");
        correo_us = request.getParameter("correo_u");
        usuario_us = request.getParameter("usuario_u");
        clave_us = request.getParameter("clave_u");
        tipo_us = request.getParameter("tipo_u");
        estado_us = request.getParameter("estado_u");
        preg_us = request.getParameter("pre_u");
        resp_us = request.getParameter("re_u");
    }else{
    id_us = String.valueOf(usuario.getId());//Id definido a cero desde el constructor
    nombre_us = usuario.getNombre();
    apellido_us = usuario.getApellido();
    correo_us = usuario.getCorreo();
    usuario_us = usuario.getUsuario();
    clave_us = usuario.getClave();
    tipo_us = String.valueOf(usuario.getTipo());
    estado_us = String.valueOf(usuario.getEstado());
    preg_us = usuario.getPregunta();
    resp_us = usuario.getRespuesta();
    
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
        <body class="d-flex flex-column" >
         <%@include file="../WEB-INF/vistas-parciales/encabezado.jspf" %>
        <h1>Registrar Nuevo Usuario!</h1>
        <form action="<%= request.getContextPath() %>/Usuarios" method="post">
           
            <input type="hidden" name="id_us" value="<%= id_us%>"  >
            <div class="form-group">
                <label for="txtNomUs" class="col-sm-2 control label" >Nombre:</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtNomUs" value="<%= nombre_us %>" required />
                </div>        
            </div>
            
            <div class="form-group">
                <label for="txtApeUs" class="col-sm-2 control label" >Apellido</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtApeUs" value="<%= apellido_us %>" required />
                </div>        
            </div>
                
            <div class="form-group">
                <label for="txtCorUs" class="col-sm-2 control label" >E mail</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtCorUs" value="<%= correo_us %>" required />
                </div>        
            </div>                
              
            <div class="form-group">
                <label for="txtusrUs" class="col-sm-2 control label" >Usuario</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtusrUs" value="<%= usuario_us %>" required />
                </div>        
            </div> 
                
            <div class="form-group">
                <label for="txtclUs" class="col-sm-2 control label" >Clave</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtclUs" value="<%= clave_us %>" required />
                </div>        
            </div> 
                
            <div class="form-group">
                <label for="txttpUs" class="col-sm-2 control label" >Tipo</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txttpUs" value="<%= tipo_us %>" required />
                </div>        
            </div> 
                
            <div class="form-group">
                <label for="txtesUs" class="col-sm-2 control label" >Estado</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtesUs" value="<%= estado_us %>" required />
                </div>        
            </div> 
                <br>
                <br>
            <div class="form-group">
                <label for="txtprUs" class="col-sm-2 control label" >Pregunta</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtprUs"  placeholder="No olvidar su pregunta" required />
                </div>        
            </div> 
                
            <div class="form-group">
                <label for="txtreUs" class="col-sm-2 control label" >Repuesta</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtreUs"  placeholder="No olvidar su repuesta" required />
                </div>        
            </div>
            <div>
                <div class="col-sm-offset-2 col-sm-10">
                    <%
                       if (request.getParameter("jeñal")!=null) {
                    %>
                    <input type="submit" class="btn btn-default btn-sm" name="btnEditar" value="Editar"/>
                    <%
                    }else{
                    %>
                    <input type="submit" class="btn btn-default btn-sm" name="btnGuardar" value="Guardar"/>    
                    <%
                    }
                    %>
                
                </div>
                
            </div>
        
                
           
            
        </form>
          <%@include file="../WEB-INF/vistas-parciales/pie.jspf" %>               
    </body>
</html>
