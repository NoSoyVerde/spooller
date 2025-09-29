package net.ausiasmarch.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import net.ausiasmarch.model.UsuarioBean;
import net.ausiasmarch.service.UsuarioService;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {

    private UsuarioService usuarioService = new UsuarioService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");

        try {
            if (idParam != null && !idParam.isEmpty()) {
                // GET por ID
                Long id = Long.parseLong(idParam);
                UsuarioBean usuario = usuarioService.get(id);
                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("/form-update.jsp").forward(request, response);
            } else {
                // GET all
                request.setAttribute("usuarios", usuarioService.getAll());
                request.getRequestDispatcher("/getAllUsuarios.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String method = request.getParameter("_method");

        try {
            if ("PUT".equalsIgnoreCase(method)) {
                // UPDATE
                UsuarioBean usuario = new UsuarioBean();
                usuario.setId(Long.parseLong(request.getParameter("id")));
                usuario.setUsername(request.getParameter("username"));
                usuario.setPassword(""); // Campo password vacío
                usuario.setNombre(request.getParameter("nombre"));
                usuario.setApellido1(request.getParameter("apellido1"));
                usuario.setApellido2(request.getParameter("apellido2"));
                usuarioService.update(usuario);

            } else if ("DELETE".equalsIgnoreCase(method)) {
                // DELETE
                Long id = Long.parseLong(request.getParameter("id"));
                usuarioService.delete(id);

            } else {
                // CREATE
                UsuarioBean usuario = new UsuarioBean();
                usuario.setUsername(request.getParameter("username"));
                usuario.setPassword(""); // Campo password vacío
                usuario.setNombre(request.getParameter("nombre"));
                usuario.setApellido1(request.getParameter("apellido1"));
                usuario.setApellido2(request.getParameter("apellido2"));
                usuarioService.create(usuario);
            }

            response.sendRedirect("UsuarioController");

        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
