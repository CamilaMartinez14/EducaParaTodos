package cl.ipchile.educaparatodos.web;

import cl.ipchile.educaparatodos.dao.CursoDAO;
import cl.ipchile.educaparatodos.model.Curso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/administracion")
public class AdministracionServlet extends HttpServlet {

    private CursoDAO cursoDAO;

    @Override
    public void init() {
        cursoDAO = new CursoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recibo los datos ingresados en el formulario
        String nombre = request.getParameter("nombre");
        String tema = request.getParameter("tema");
        String nivel = request.getParameter("nivel");
        String descripcion = request.getParameter("descripcion");

        // Creo el curso con los datos del formulario
        Curso curso = new Curso(
                nombre,
                tema,
                descripcion,
                nivel
        );

        // Guardo el curso en la base de datos
        cursoDAO.guardarCurso(curso);

        // Despues de guardar vuelvo a la lista de cursos
        response.sendRedirect(request.getContextPath() + "/cursos");
    }
}