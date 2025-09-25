package net.ausiasmarch.service;

import java.sql.SQLException;

import net.ausiasmarch.dao.UsuarioDAO;
import net.ausiasmarch.model.*;

public class UsuarioService {

    public UsuarioBean get(Long id) throws SQLException {

        // Es mejor crear la conexion a nivel de servicio y pasarla al DAO

        UsuarioDAO oUsuarioDao = new UsuarioDAO();
        UsuarioBean oUsuarioBean = oUsuarioDao.get(id);
        return oUsuarioBean;
    }

}