/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Print;

import DAO.ProdcutoDAOImplementarn;
import DAO.ProductoDAO;
import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementarn;
import Model.Producto;
import Model.Usuario;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Palacios
 */
@WebServlet(name = "pdfu", urlPatterns = {"/pdfu"})
public class pdfu extends HttpServlet {

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
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();
                try  {
            UsuarioDAO cat = new UsuarioDAOImplementarn();
            try{
                Document documento = new Document();
                documento.setPageSize(PageSize.A4.rotate());
                
                PdfWriter.getInstance(documento, out);
                
                documento.open();
                
                Paragraph par1 = new Paragraph();
                Font ftitulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLACK);
                par1.add(new Phrase("Lista de Usuarios",ftitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);
                
                Paragraph par2 = new Paragraph();
                Font fdesc = new Font(Font.FontFamily.HELVETICA,12,Font.NORMAL,BaseColor.BLACK);
                par2.add(new Phrase("Usuarios segun su estado",fdesc));
                par2.setAlignment(Element.ALIGN_JUSTIFIED);
                par2.add(new Phrase(Chunk.NEWLINE));
                par2.add(new Phrase(Chunk.NEWLINE));
                documento.add(par2);
                
                PdfPTable tabla = new PdfPTable(11);
                PdfPCell celda1 = new PdfPCell(new Paragraph("ID",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda2 = new PdfPCell(new Paragraph("NOMBRE",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda3 = new PdfPCell(new Paragraph("APELLIDO",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda4 = new PdfPCell(new Paragraph("CORREO",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda5 = new PdfPCell(new Paragraph("USUARIO",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda6 = new PdfPCell(new Paragraph("CLAVE",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda7 = new PdfPCell(new Paragraph("TIPO",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda8 = new PdfPCell(new Paragraph("ESTADO",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda9 = new PdfPCell(new Paragraph("PREGUNTA",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda10 = new PdfPCell(new Paragraph("REPUESTA",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda11 = new PdfPCell(new Paragraph("FECHA",FontFactory.getFont("Arial",10,Font.BOLD,BaseColor.BLUE)));
                
                
                tabla.addCell(celda1);
                tabla.addCell(celda2);
                tabla.addCell(celda3);
                tabla.addCell(celda4);
                tabla.addCell(celda5);
                tabla.addCell(celda6);
                tabla.addCell(celda7);
                tabla.addCell(celda8);
                tabla.addCell(celda9);
                tabla.addCell(celda10);
                tabla.addCell(celda11);
               
                
                
                UsuarioDAO usuario = new UsuarioDAOImplementarn(); //To change body of generated methods, choose Tools | Templates.
              List<Usuario> listar = usuario.Listar();
              
        for ( Usuario usuarioListar : listar) {
            String ids = String.valueOf(usuarioListar.getId());
            
            String nom = String.valueOf(usuarioListar.getNombre());
            String ape = String.valueOf(usuarioListar.getApellido());
            String cor = String.valueOf(usuarioListar.getCorreo());
            String usu = String.valueOf(usuarioListar.getUsuario());
            String pas = String.valueOf(usuarioListar.getClave());
            String tip = String.valueOf(usuarioListar.getTipo());
            String est = String.valueOf(usuarioListar.getEstado());
            String pre = String.valueOf(usuarioListar.getPregunta());
            String res = String.valueOf(usuarioListar.getRespuesta());
            String fet = String.valueOf(usuarioListar.getFecharegistro());
            tabla.addCell(ids);
            tabla.addCell(nom);
            tabla.addCell(ape);
            tabla.addCell(cor);
            tabla.addCell(usu);
            tabla.addCell(pas);
            tabla.addCell(tip);
            tabla.addCell(est);
            tabla.addCell(pre);
            tabla.addCell(res);
            tabla.addCell(fet);
            
        }
                
                 documento.add(tabla);//agrega todas las celdas a la tabla
                documento.close();//su accion termina cierra el documento
                
                
                
            }catch(DocumentException ex){
            ex.getMessage();
            }
           
        } finally{
        out.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
