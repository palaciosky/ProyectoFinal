/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.ProductoDAO;
import DAO.ProdcutoDAOImplementarn;
import Model.Producto;
import java.util.List;


/**
 *
 * @author Palacios
 */
public class Prueba2 {
    public static void main(String[] args) {
        Prueba2 evaluar = new Prueba2();
        evaluar.listarProductos();
       // evaluar.editarCategoria();
        evaluar.guardaProducto();
        //evaluar.eliminarCategoria();
    }

    private void listarProductos() {
       ProductoDAO categoria = new ProdcutoDAOImplementarn(); //To change body of generated methods, choose Tools | Templates.
       List<Producto> listar = categoria.Listar();
        System.out.println("LISTADO DE CATEGORIAS");
        for ( Producto categoriaListar : listar) {
            System.out.println("ID: "+categoriaListar.getId_producto()
            + " NOMBRE: "+ categoriaListar.getNom_producto()
            + " STOCK: "+categoriaListar.getStock()
            +" PRECIO: "+categoriaListar.getPrecio()
            +" UNIDAD: "+categoriaListar.getUnidad_de_medida());
        }
    }
private void guardaProducto() {
       ProductoDAO categoria = new ProdcutoDAOImplementarn(); //To change body of generated methods, choose Tools | Templates. 
       Producto guarda_pro = new Producto();
       guarda_pro.setNom_producto("Bebidas");
       guarda_pro.setStock(7);
       guarda_pro.setPrecio(1);
       guarda_pro.setUnidad_de_medida("L");
       guarda_pro.setEstado_producto(1);
       guarda_pro.setCategoria_id(5);
       categoria.guardaPro(guarda_pro);
    }  
    
}
