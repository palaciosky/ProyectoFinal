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

/**
 *
 * @author Palacios
 */
public class NUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Frameset//EN\" \"http://www.w3.org/TR/html4/frameset.dtd\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NUser</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        RequestDispatcher link;
        link = request.getRequestDispatcher("/Vistas-Registros/RegUsuarios.jsp");
        link.forward(request, response);
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
        
        String nom_u = request.getParameter("txtNomUs");
        String ape_u = request.getParameter("txtApeUs");
        String cor_u = request.getParameter("txtCorUs");
        String us_u = request.getParameter("txtusrUs");
        String cla_u = request.getParameter("txtclUs");
        int t_u = Integer.parseInt(request.getParameter("txttpUs"));
        int e_u = Integer.parseInt(request.getParameter("txtesUs"));
        String pr_u = request.getParameter("txtprUs");
        String re_u = request.getParameter("txtreUs");
        
        
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
        
        RequestDispatcher exit;
        exit = request.getRequestDispatcher("/log.jsp");
        exit.forward(request, response);
        
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
