/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementarn;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Palacios
 */
public class Usuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  protected void listaUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UsuarioDAO usuario = new UsuarioDAOImplementarn();
        //Crear instancia de sesion se le da true para crear la sesion
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("listass", usuario.Listar());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Usuarios/listarUsuarios.jsp");
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("opcion");
        
        if (parametro.equals("crear")) {
            String pag = "/Vistas-Usuarios/crearUsuarios.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pag);
            dispatcher.forward(request, response);
            
        }else if(parametro.equals("listar")){
            this.listaUsuarios(request, response);
            
        }else if(parametro.equals("modificar")){
             int id_user = Integer.parseInt(request.getParameter("id_us"));
             String nom_user = request.getParameter("nombre_us");
             String ape_user = request.getParameter("apellido_us");
             String correo = request.getParameter("correo_us");
             String user_user = request.getParameter("usuario_us"); 
             String clave = request.getParameter("clave_us"); 
             int tipo = Integer.parseInt(request.getParameter("tipo_us"));
             int estado = Integer.parseInt(request.getParameter("estado_us"));
             String pregunta = request.getParameter("preg_us"); 
             String repuesta = request.getParameter("resp_us"); 
             
             String pag = "/Vistas-Usuarios/crearUsuarios.jsp?id_u="+id_user+"&&nombre_u="+nom_user+"&&apellido_u="+ape_user+"&&correo_u="+correo+"&&usuario_u="+user_user+"&&clave_u="+clave+"&&tipo_u="+tipo+"&&estado_u="+estado+"&&pre_u="+pregunta+"&&re_u="+repuesta+"&&jeñal=1";
             RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pag);
             dispatcher.forward(request, response);
        
        }else if(parametro.equals("eliminar")){
            int del_id = Integer.parseInt(request.getParameter("id"));
            UsuarioDAO usz = new UsuarioDAOImplementarn();
            usz.borrarUs(del_id);
            this.listaUsuarios(request, response);
        }
        
        
        
        this.listaUsuarios(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuario = new Usuario();
        int id_usuario = Integer.parseInt(request.getParameter("id_us"));
        String nom_u = request.getParameter("txtNomUs");
        String ape_u = request.getParameter("txtApeUs");
        String cor_u = request.getParameter("txtCorUs");
        String us_u = request.getParameter("txtusrUs");
        String cla_u = request.getParameter("txtclUs");
        int t_u = Integer.parseInt(request.getParameter("txttpUs"));
        int e_u = Integer.parseInt(request.getParameter("txtesUs"));
        String pr_u = request.getParameter("txtprUs");
        String re_u = request.getParameter("txtreUs");
        
        usuario.setId(id_usuario);
        usuario.setNombre(nom_u);
        usuario.setApellido(ape_u);
        usuario.setCorreo(cor_u);
        usuario.setUsuario(us_u);
        usuario.setClave(cla_u);
        usuario.setTipo(t_u);
        usuario.setEstado(e_u);
        usuario.setPregunta(pr_u);
        usuario.setRespuesta(re_u);
        
        UsuarioDAO guardarUs = new UsuarioDAOImplementarn();
        guardarUs.guardaUs(usuario);
        
   
        this.listaUsuarios(request, response);
   
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
