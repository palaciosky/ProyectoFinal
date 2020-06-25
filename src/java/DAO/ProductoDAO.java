/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Producto;
import java.util.List;

/**
 *
 * @author Palacios
 */
public interface ProductoDAO {
    public List<Producto> Listar();
    public List<Producto> Listar2();
    public Producto editarPro(int id_pro_edit);
    public boolean guardaPro(Producto producto);
    public boolean borrarPro(int id_pro_edit);
}
