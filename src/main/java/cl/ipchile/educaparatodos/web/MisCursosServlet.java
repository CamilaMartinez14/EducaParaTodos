package cl.ipchile.educaparatodos.web;

import cl.ipchile.educaparatodos.dao.InscripcionDAO;
import cl.ipchile.educaparatodos.model.Curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/mis-cursos")
public class MisCursosServlet extends HttpServlet {

    private InscripcionDAO inscripcionDAO;

    @Override
    public void init() {
        inscripcionDAO = new InscripcionDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Por ahora utilizo el usuario de prueba registrado en la base de datos
        Long usuarioId = 1L;

        // Busco los cursos en los que esta inscrito el usuario
        List<Curso> cursos = inscripcionDAO.buscarCursosPorUsuario(usuarioId);

        request.setAttribute("cursos", cursos);

        request.getRequestDispatcher("/mis-cursos.jsp")
                .forward(request, response);
    }
}