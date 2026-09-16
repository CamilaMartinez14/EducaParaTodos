package cl.ipchile.educaparatodos.web;

import cl.ipchile.educaparatodos.dao.CursoDAO;
import cl.ipchile.educaparatodos.dao.InscripcionDAO;
import cl.ipchile.educaparatodos.dao.UsuarioDAO;
import cl.ipchile.educaparatodos.model.Curso;
import cl.ipchile.educaparatodos.model.Inscripcion;
import cl.ipchile.educaparatodos.model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/inscripcion")
public class InscripcionServlet extends HttpServlet {

    private InscripcionDAO inscripcionDAO;
    private UsuarioDAO usuarioDAO;
    private CursoDAO cursoDAO;

    @Override
    public void init() {
        inscripcionDAO = new InscripcionDAO();
        usuarioDAO = new UsuarioDAO();
        cursoDAO = new CursoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recibo el id del curso seleccionado
        Long cursoId = Long.parseLong(request.getParameter("cursoId"));

        // Por ahora utilizo el usuario de prueba
        Long usuarioId = 1L;

        // Reviso si el usuario ya esta inscrito
        boolean yaInscrito = inscripcionDAO
                .existeInscripcion(usuarioId, cursoId);

        if (!yaInscrito) {

            // Busco el usuario y el curso
            Usuario usuario = usuarioDAO.buscarPorId(usuarioId);
            Curso curso = cursoDAO.buscarPorId(cursoId);

            // Si existen creo la inscripcion
            if (usuario != null && curso != null) {

                Inscripcion inscripcion =
                        new Inscripcion(usuario, curso);

                inscripcionDAO.guardarInscripcion(inscripcion);

                // Aumento la popularidad cuando se realiza una nueva inscripcion
                curso.setPopularidad(curso.getPopularidad() + 1);

                // Guardo el nuevo valor del curso
                cursoDAO.editarCurso(curso);
            }
        }

        // Al terminar muestro los cursos del usuario
        response.sendRedirect(
                request.getContextPath() + "/mis-cursos"
        );
    }
}