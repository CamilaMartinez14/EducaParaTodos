package cl.ipchile.educaparatodos.web;

import cl.ipchile.educaparatodos.dao.CursoDAO;
import cl.ipchile.educaparatodos.model.Curso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/administracion")
public class AdministracionServlet extends HttpServlet {

    private CursoDAO cursoDAO;

    @Override
    public void init() {
        cursoDAO = new CursoDAO();
    }

    // Muestra los cursos en Administracion
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Curso> cursos = cursoDAO.listarCursos();

        request.setAttribute("cursos", cursos);

        request.getRequestDispatcher("/administracion.jsp")
                .forward(request, response);
    }

    // Recibe las acciones realizadas desde Administracion
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("guardar".equals(accion)) {

            guardarCurso(request);

        } else if ("editar".equals(accion)) {

            editarCurso(request);

        } else if ("desactivar".equals(accion)) {

            desactivarCurso(request);
        }

        response.sendRedirect(request.getContextPath() + "/administracion");
    }

    // Guarda un curso nuevo
    private void guardarCurso(HttpServletRequest request) {

        String nombre = request.getParameter("nombre");
        String tema = request.getParameter("tema");
        String nivel = request.getParameter("nivel");
        String descripcion = request.getParameter("descripcion");

        Curso curso = new Curso(nombre, tema, descripcion, nivel);

        cursoDAO.guardarCurso(curso);
    }

    // Edita un curso que ya existe
    private void editarCurso(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));

        Curso curso = cursoDAO.buscarPorId(id);

        if (curso != null) {

            curso.setNombre(request.getParameter("nombre"));
            curso.setTema(request.getParameter("tema"));
            curso.setNivel(request.getParameter("nivel"));
            curso.setDescripcion(request.getParameter("descripcion"));

            cursoDAO.editarCurso(curso);
        }
    }

    // Desactiva el curso pero lo mantiene en la base de datos
    private void desactivarCurso(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));

        cursoDAO.desactivarCurso(id);
    }
}