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

@WebServlet("/cursos")
public class CursoServlet extends HttpServlet {

    private CursoDAO cursoDAO;

    @Override
    public void init() {
        cursoDAO = new CursoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtengo los cursos activos desde la base de datos
        List<Curso> cursos = cursoDAO.listarCursos();

        // Envio la lista de cursos a la pagina
        request.setAttribute("cursos", cursos);

        // Muestro la vista de cursos
        request.getRequestDispatcher("/cursos.jsp").forward(request, response);
    }
}