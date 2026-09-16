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

        // Obtengo los datos utilizados para buscar los cursos
        String tema = request.getParameter("tema");
        String nivel = request.getParameter("nivel");
        String orden = request.getParameter("orden");

        List<Curso> cursos;

        // Si se escribe un tema busco los cursos por ese tema
        if (tema != null && !tema.trim().isEmpty()) {

            cursos = cursoDAO.buscarPorTema(tema.trim());

        // Si se selecciona un nivel busco los cursos por nivel
        } else if (nivel != null && !nivel.trim().isEmpty()) {

            cursos = cursoDAO.buscarPorNivel(nivel);

        // Si se selecciona popularidad los ordeno desde el mas popular
        } else if ("popularidad".equals(orden)) {

            cursos = cursoDAO.listarPorPopularidad();

        // Si no se selecciona nada muestro todos los cursos activos
        } else {

            cursos = cursoDAO.listarCursos();
        }

        // Envio los cursos encontrados a la pagina
        request.setAttribute("cursos", cursos);

        // Mantengo los valores utilizados en la busqueda
        request.setAttribute("temaBuscado", tema);
        request.setAttribute("nivelBuscado", nivel);
        request.setAttribute("ordenSeleccionado", orden);

        // Muestro la pagina de cursos
        request.getRequestDispatcher("/cursos.jsp").forward(request, response);
    }
}