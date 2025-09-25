package net.ausiasmarch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.ausiasmarch.connection.HikariConfiguration;
import net.ausiasmarch.model.UsuarioBean;

public class UsuarioDAO {

    private Connection oConnection = null;

    public UsuarioDAO(Connection oConnection) {
        this.oConnection = oConnection;
    }

    // Obtener un usuario por ID
    public UsuarioBean get(Long id) {
        String strSQL = "SELECT * FROM usuario WHERE id=?";
        UsuarioBean oUsuarioBean = null;

        try (PreparedStatement oPreparedStatement = this.oConnection.prepareStatement(strSQL)) {
            oPreparedStatement.setLong(1, id);

            try (ResultSet oResultSet = oPreparedStatement.executeQuery()) {
                if (oResultSet.next()) {
                    oUsuarioBean = mapResultSetToUsuario(oResultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return oUsuarioBean;
    }

    // Obtener todos los usuarios
    public List<UsuarioBean> getAll() {
        String strSQL = "SELECT * FROM usuario";
        List<UsuarioBean> usuarios = new ArrayList<>();

        try (Connection oConnection = HikariConfiguration.getConnection();
                PreparedStatement oPreparedStatement = oConnection.prepareStatement(strSQL);
                ResultSet oResultSet = oPreparedStatement.executeQuery()) {

            while (oResultSet.next()) {
                usuarios.add(mapResultSetToUsuario(oResultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    // Insertar un usuario
    public boolean insert(UsuarioBean oUsuarioBean) {
        String strSQL = "INSERT INTO usuario (username, nombre, apellido1, apellido2) VALUES (?, ?, ?, ?)";
        try (Connection oConnection = HikariConfiguration.getConnection();
                PreparedStatement oPreparedStatement = oConnection.prepareStatement(strSQL)) {

            oPreparedStatement.setString(1, oUsuarioBean.getUsername());
            oPreparedStatement.setString(2, oUsuarioBean.getNombre());
            oPreparedStatement.setString(3, oUsuarioBean.getApellido1());
            oPreparedStatement.setString(4, oUsuarioBean.getApellido2());

            return oPreparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Actualizar un usuario
    public boolean update(UsuarioBean oUsuarioBean) {
        String strSQL = "UPDATE usuario SET username=?, nombre=?, apellido1=?, apellido2=? WHERE id=?";
        try (Connection oConnection = HikariConfiguration.getConnection();
                PreparedStatement oPreparedStatement = oConnection.prepareStatement(strSQL)) {

            oPreparedStatement.setString(1, oUsuarioBean.getUsername());
            oPreparedStatement.setString(2, oUsuarioBean.getNombre());
            oPreparedStatement.setString(3, oUsuarioBean.getApellido1());
            oPreparedStatement.setString(4, oUsuarioBean.getApellido2());
            oPreparedStatement.setLong(5, oUsuarioBean.getId());

            return oPreparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar un usuario
    public boolean delete(Long id) {
        String strSQL = "DELETE FROM usuario WHERE id=?";
        try (Connection oConnection = HikariConfiguration.getConnection();
                PreparedStatement oPreparedStatement = oConnection.prepareStatement(strSQL)) {

            oPreparedStatement.setLong(1, id);
            return oPreparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método privado para mapear ResultSet a UsuarioBean
    private UsuarioBean mapResultSetToUsuario(ResultSet oResultSet) throws SQLException {
        UsuarioBean oUsuarioBean = new UsuarioBean();
        oUsuarioBean.setId(oResultSet.getLong("id"));
        oUsuarioBean.setUsername(oResultSet.getString("username"));
        oUsuarioBean.setNombre(oResultSet.getString("nombre"));
        oUsuarioBean.setApellido1(oResultSet.getString("apellido1"));
        oUsuarioBean.setApellido2(oResultSet.getString("apellido2"));
        return oUsuarioBean;
    }
}
