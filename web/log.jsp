<%-- 
    Document   : log
    Created on : 06-26-2020, 03:42:59 PM
    Author     : Palacios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="WEB-INF/vistas-parciales/css-js.jspf" %>
    </head>
    <body class="text-center" >
        <form action="Login" method="POST">
            <h1>Log In</h1>
            <label for="inputEmail" >Correo Electronico</label>
            <input type="email"  name="inputEmail" id="inputEmails" placeholder="Correo Electronico">
            <%-- soy un separador --%>
            <label for="inputPassword" >Contraseña</label>
            <input type="password"  name="inputPassword" id="inputPasswords" placeholder="Contraseña">
            
            <div class="checkbox mb-3">
        <label>
          <!--<input type="checkbox" value="remember-me"> Remember me -->
          <a href="#" title="¿No tienes cuenta?">¿No tienes cuenta? | </a>
          <a href="#" title="Olvide mi contraseña">Olvidé mi contraseña</a>
        </label>
      </div>
            
      <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
            
        </form>
    </body>
</html>
