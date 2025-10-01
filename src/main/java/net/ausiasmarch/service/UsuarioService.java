package net.ausiasmarch.service;

import java.util.List;
import net.ausiasmarch.dao.UsuarioDAO;
import net.ausiasmarch.model.UsuarioBean;

public class UsuarioService {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    // GET por ID
    public UsuarioBean get(Long id) {
        return usuarioDAO.get(id);
    }

    // GET ALL
    public List<UsuarioBean> getAll() {
        return usuarioDAO.getAll();
    }

    // CREATE
    public void create(UsuarioBean usuario) {
        usuarioDAO.insert(usuario);
    }

    // UPDATE
    public void update(UsuarioBean usuario) {
        usuarioDAO.update(usuario);
    }

    // DELETE
    public void delete(Long id) {
        usuarioDAO.delete(id);
    }
    
}
