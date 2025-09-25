package net.ausiasmarch.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import net.ausiasmarch.model.UsuarioBean;
import net.ausiasmarch.service.UsuarioService;

@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {

    @Override
    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, java.io.IOException {

        String idParam = request.getParameter("id");
        Long id = Long.parseLong(idParam);
        UsuarioService oUsuarioService = new UsuarioService();
        try {
            UsuarioBean usuario = oUsuarioService.get(id);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("/usuario.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }

    }
}
