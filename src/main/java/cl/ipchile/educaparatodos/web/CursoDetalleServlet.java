package cl.ipchile.educaparatodos.web;

import cl.ipchile.educaparatodos.dao.CursoDAO;
import cl.ipchile.educaparatodos.dao.LeccionDAO;
import cl.ipchile.educaparatodos.model.Curso;
import cl.ipchile.educaparatodos.model.Leccion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/curso-detalle")
public class CursoDetalleServlet extends HttpServlet {

    private CursoDAO cursoDAO;
    private LeccionDAO leccionDAO;

    @Override
    public void init() {
        cursoDAO = new CursoDAO();
        leccionDAO = new LeccionDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recibo el id del curso seleccionado
        String idRecibido = request.getParameter("id");

        // Si no viene un id vuelvo a la lista de cursos
        if (idRecibido == null || idRecibido.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/cursos");
            return;
        }

        Long cursoId = Long.parseLong(idRecibido);

        // Busco el curso seleccionado
        Curso curso = cursoDAO.buscarPorId(cursoId);

        // Si el curso no existe vuelvo a la lista
        if (curso == null) {
            response.sendRedirect(request.getContextPath() + "/cursos");
            return;
        }

        // Busco las lecciones relacionadas con el curso
        List<Leccion> lecciones = leccionDAO.buscarPorCurso(cursoId);

        // Envio la informacion a la pagina
        request.setAttribute("curso", curso);
        request.setAttribute("lecciones", lecciones);

        request.getRequestDispatcher("/curso-detalle.jsp")
                .forward(request, response);
    }
}