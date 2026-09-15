package cl.ipchile.educaparatodos.web;

import cl.ipchile.educaparatodos.dao.UsuarioDAO;
import cl.ipchile.educaparatodos.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Por ahora utilizo el usuario de prueba de la base de datos
        Long usuarioId = 1L;

        // Busco los datos del usuario
        Usuario usuario = usuarioDAO.buscarPorId(usuarioId);

        // Envio el usuario a la pagina de perfil
        request.setAttribute("usuario", usuario);

        request.getRequestDispatcher("/perfil.jsp")
                .forward(request, response);
    }
}