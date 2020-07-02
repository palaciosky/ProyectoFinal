<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="WEB-INF/vistas-parciales/css-js.jspf" %>
     </head>
    <body style="
          /* Ubicación de la imagen */

background-image: url(img/background.jpg);

/* Para dejar la imagen de fondo centrada, vertical y

horizontalmente */

background-position: center center;

/* Para que la imagen de fondo no se repita */

background-repeat: no-repeat;

/* La imagen se fija en la ventana de visualización para que la altura de la imagen no supere a la del contenido */

background-attachment: fixed;

/* La imagen de fondo se reescala automáticamente con el cambio del ancho de ventana del navegador */

background-size: cover;

/* Se muestra un color de fondo mientras se está cargando la imagen

de fondo o si hay problemas para cargarla   */

background-color: #66999;
          " >
        div
        <div class="modal-dialog text-center" >
        <div class="col-sm-8 main-section" >
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="img/user.png" th:src="img/user.png}"/>
                    
                    <h1 style="filter: blur(6px);" >Bienvenido!</h1>
                </div>
                <form class="col-12" action="Login" method="POST" >
                    <div class="form-group" id="user-group"  >
                        <input type="text" name="inputEmail" class="form-control" placeholder="Correo" />
                    </div>
                    <div class="form-group" id="contrasena-group">
                        <input type="password" name="inputPassword" class="form-control" placeholder="Contrasea" />
                    </div>
                    <button type="submit" class="btn btn-primary"><i class="fas fa-sign-in-alt"  ></i>  Ingresar </button>
                </form>
                <br>
                <div th:if="${param.error}" class="alert alert-danger" role="alert">
		          <a href="#" title="¿No tienes cuenta?">¿No tienes cuenta?  </a>
          
		        </div>
		        <div th:if="${param.logout}" class="alert alert-success" role="alert">
		           <a href="#" title="Olvide mi contraseña">Olvidé mi contraseña</a>
		        </div>
            </div>
        </div>
    </div>
</body>
</html>
