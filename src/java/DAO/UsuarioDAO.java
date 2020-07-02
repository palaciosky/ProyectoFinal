/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Palacios
 */
public interface UsuarioDAO {
     public ArrayList<Usuario> startSesion(String user, String clave);
     public List<Usuario> Listar();
    public List<Usuario> Listar2();
    public Usuario editarUs(int id_pro_edit);
    public boolean guardaUs(Usuario usuario);
    public boolean borrarUs(int id_us_edit);
}
