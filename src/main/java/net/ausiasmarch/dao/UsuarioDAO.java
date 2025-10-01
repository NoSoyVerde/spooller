package net.ausiasmarch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.ausiasmarch.connection.HikariConfiguration;
import net.ausiasmarch.exception.ResourceNotFoundException;
import net.ausiasmarch.model.UsuarioBean;

public class UsuarioDAO {

    // Obtener un usuario por ID
    public UsuarioBean get(Long id) {
        String strSQL = "SELECT * FROM usuario WHERE id=?";
        UsuarioBean oUsuarioBean = null;

        try (Connection oConnection = HikariConfiguration.getConnection();
             PreparedStatement oPreparedStatement = oConnection.prepareStatement(strSQL)) {

            oPreparedStatement.setLong(1, id);

            try (ResultSet oResultSet = oPreparedStatement.executeQuery()) {
                if (oResultSet.next()) {
                    oUsuarioBean = mapResultSetToUsuario(oResultSet);
                } else {
                    throw new ResourceNotFoundException("Usuario con id " + id + " no encontrado.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error accediendo a la base de datos", e);
        }

        return oUsuarioBean;
    }

    // Obtener todos los usuario
    public List<UsuarioBean> getAll() {
        String strSQL = "SELECT * FROM usuario";
        List<UsuarioBean> usuario = new ArrayList<>();

        try (Connection oConnection = HikariConfiguration.getConnection();
             PreparedStatement oPreparedStatement = oConnection.prepareStatement(strSQL);
             ResultSet oResultSet = oPreparedStatement.executeQuery()) {

            while (oResultSet.next()) {
                usuario.add(mapResultSetToUsuario(oResultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error accediendo a la base de datos", e);
        }

        return usuario;
    }

    // Insertar un usuario
    public boolean insert(UsuarioBean oUsuarioBean) {
        String strSQL = "INSERT INTO usuario (username, password, nombre, apellido1, apellido2) VALUES (?, ?, ?, ?, ?)";
        try (Connection oConnection = HikariConfiguration.getConnection();
             PreparedStatement oPreparedStatement = oConnection.prepareStatement(strSQL)) {

            oPreparedStatement.setString(1, oUsuarioBean.getUsername());
            oPreparedStatement.setString(2, oUsuarioBean.getPassword()); // Siempre vacío
            oPreparedStatement.setString(3, oUsuarioBean.getNombre());
            oPreparedStatement.setString(4, oUsuarioBean.getApellido1());
            oPreparedStatement.setString(5, oUsuarioBean.getApellido2());

            return oPreparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error insertando el usuario en la base de datos", e);
        }
    }

    // Actualizar un usuario
    public boolean update(UsuarioBean oUsuarioBean) {
        String strSQL = "UPDATE usuario SET username=?, password=?, nombre=?, apellido1=?, apellido2=? WHERE id=?";
        try (Connection oConnection = HikariConfiguration.getConnection();
             PreparedStatement oPreparedStatement = oConnection.prepareStatement(strSQL)) {

            oPreparedStatement.setString(1, oUsuarioBean.getUsername());
            oPreparedStatement.setString(2, oUsuarioBean.getPassword()); // Siempre vacío
            oPreparedStatement.setString(3, oUsuarioBean.getNombre());
            oPreparedStatement.setString(4, oUsuarioBean.getApellido1());
            oPreparedStatement.setString(5, oUsuarioBean.getApellido2());
            oPreparedStatement.setLong(6, oUsuarioBean.getId());

            int rowsUpdated = oPreparedStatement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new ResourceNotFoundException("Usuario con id " + oUsuarioBean.getId() + " no encontrado para actualizar.");
            }

            return true;

        } catch (SQLException e) {
            throw new RuntimeException("Error actualizando el usuario en la base de datos", e);
        }
    }

    // Eliminar un usuario
    public boolean delete(Long id) {
        String strSQL = "DELETE FROM usuario WHERE id=?";
        try (Connection oConnection = HikariConfiguration.getConnection();
             PreparedStatement oPreparedStatement = oConnection.prepareStatement(strSQL)) {

            oPreparedStatement.setLong(1, id);
            int rowsDeleted = oPreparedStatement.executeUpdate();
            if (rowsDeleted == 0) {
                throw new ResourceNotFoundException("Usuario con id " + id + " no encontrado para eliminar.");
            }

            return true;

        } catch (SQLException e) {
            throw new RuntimeException("Error eliminando el usuario en la base de datos", e);
        }
    }

    // Método privado para mapear ResultSet a UsuarioBean
    private UsuarioBean mapResultSetToUsuario(ResultSet oResultSet) throws SQLException {
        UsuarioBean oUsuarioBean = new UsuarioBean();
        oUsuarioBean.setId(oResultSet.getLong("id"));
        oUsuarioBean.setUsername(oResultSet.getString("username"));
        oUsuarioBean.setPassword(oResultSet.getString("password")); // Se añade
        oUsuarioBean.setNombre(oResultSet.getString("nombre"));
        oUsuarioBean.setApellido1(oResultSet.getString("apellido1"));
        oUsuarioBean.setApellido2(oResultSet.getString("apellido2"));
        return oUsuarioBean;
    }
    
    
}
