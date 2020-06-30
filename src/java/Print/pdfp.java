/*EEEEEEE
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Print;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementarn;
import DAO.ProdcutoDAOImplementarn;
import DAO.ProductoDAO;
import Model.Categoria;
import Model.Producto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
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
@WebServlet(name = "pdfp", urlPatterns = {"/pdfp"})
public class pdfp extends HttpServlet {

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
            ProdcutoDAOImplementarn cat = new ProdcutoDAOImplementarn();
            try{
                Document documento = new Document();
                PdfWriter.getInstance(documento, out);
                
                documento.open();
                
                Paragraph par1 = new Paragraph();
                Font ftitulo = new Font(Font.FontFamily.HELVETICA,16,Font.BOLD,BaseColor.BLACK);
                par1.add(new Phrase("Lista de Productos",ftitulo));
                par1.setAlignment(Element.ALIGN_CENTER);
                par1.add(new Phrase(Chunk.NEWLINE));
                par1.add(new Phrase(Chunk.NEWLINE));
                documento.add(par1);
                
                Paragraph par2 = new Paragraph();
                Font fdesc = new Font(Font.FontFamily.HELVETICA,12,Font.NORMAL,BaseColor.BLACK);
                par2.add(new Phrase("Productos segun su estado",fdesc));
                par2.setAlignment(Element.ALIGN_JUSTIFIED);
                par2.add(new Phrase(Chunk.NEWLINE));
                par2.add(new Phrase(Chunk.NEWLINE));
                documento.add(par2);
                
                PdfPTable tabla = new PdfPTable(7);
                PdfPCell celda1 = new PdfPCell(new Paragraph("ID",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda2 = new PdfPCell(new Paragraph("NOMBRE",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda3 = new PdfPCell(new Paragraph("STOCK",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda4 = new PdfPCell(new Paragraph("PRECIO",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda5 = new PdfPCell(new Paragraph("U MEDIDA",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda6 = new PdfPCell(new Paragraph("ESTADO",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLUE)));
                PdfPCell celda7 = new PdfPCell(new Paragraph("CATEGORIA",FontFactory.getFont("Arial",12,Font.BOLD,BaseColor.BLUE)));
                
                tabla.addCell(celda1);
                tabla.addCell(celda2);
                tabla.addCell(celda3);
                tabla.addCell(celda4);
                tabla.addCell(celda5);
                tabla.addCell(celda6);
                tabla.addCell(celda7);
               
                
                
                ProductoDAO producto = new ProdcutoDAOImplementarn(); //To change body of generated methods, choose Tools | Templates.
              List<Producto> listar = producto.Listar();
              
        for ( Producto productoListar : listar) {
            String ids = String.valueOf(productoListar.getId_producto());
            
            String stos = String.valueOf(productoListar.getStock());
            String pres = String.valueOf(productoListar.getPrecio());
           
            String ests = String.valueOf(productoListar.getEstado_producto());
            String cats = String.valueOf(productoListar.getCategoria_id());
            tabla.addCell(ids);
            tabla.addCell(productoListar.getNom_producto());
            tabla.addCell(stos);
            tabla.addCell(pres);
            tabla.addCell( productoListar.getUnidad_de_medida());
            tabla.addCell(ests);
            tabla.addCell(cats);
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
