package cl.ipchile.educaparatodos.web;

import cl.ipchile.educaparatodos.dao.CursoDAO;
import cl.ipchile.educaparatodos.dao.UsuarioDAO;
import cl.ipchile.educaparatodos.model.Curso;
import cl.ipchile.educaparatodos.model.Usuario;

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
    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        cursoDAO = new CursoDAO();
        usuarioDAO = new UsuarioDAO();
    }

    // Muestra los cursos y usuarios activos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Curso> cursos = cursoDAO.listarCursos();
        List<Usuario> usuarios = usuarioDAO.listarUsuarios();

        request.setAttribute("cursos", cursos);
        request.setAttribute("usuarios", usuarios);

        request.getRequestDispatcher("/administracion.jsp")
                .forward(request, response);
    }

    // Recibe las acciones realizadas desde Administracion
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        // Acciones de cursos
        if ("guardar".equals(accion)) {

            guardarCurso(request);

        } else if ("editar".equals(accion)) {

            editarCurso(request);

        } else if ("desactivar".equals(accion)) {

            desactivarCurso(request);

        // Acciones de usuarios
        } else if ("guardarUsuario".equals(accion)) {

            guardarUsuario(request);

        } else if ("editarUsuario".equals(accion)) {

            editarUsuario(request);

        } else if ("desactivarUsuario".equals(accion)) {

            desactivarUsuario(request);
        }

        response.sendRedirect(
                request.getContextPath() + "/administracion"
        );
    }

    // Guarda un curso nuevo
    private void guardarCurso(HttpServletRequest request) {

        String nombre = request.getParameter("nombre");
        String tema = request.getParameter("tema");
        String nivel = request.getParameter("nivel");
        String descripcion = request.getParameter("descripcion");

        Curso curso = new Curso(
                nombre,
                tema,
                descripcion,
                nivel
        );

        cursoDAO.guardarCurso(curso);
    }

    // Edita un curso que ya existe
    private void editarCurso(HttpServletRequest request) {

        Long id = Long.parseLong(
                request.getParameter("id")
        );

        Curso curso = cursoDAO.buscarPorId(id);

        if (curso != null) {

            curso.setNombre(
                    request.getParameter("nombre")
            );

            curso.setTema(
                    request.getParameter("tema")
            );

            curso.setNivel(
                    request.getParameter("nivel")
            );

            curso.setDescripcion(
                    request.getParameter("descripcion")
            );

            cursoDAO.editarCurso(curso);
        }
    }

    // Desactiva un curso sin borrarlo de la base de datos
    private void desactivarCurso(HttpServletRequest request) {

        Long id = Long.parseLong(
                request.getParameter("id")
        );

        cursoDAO.desactivarCurso(id);
    }

    // Guarda un usuario nuevo
    private void guardarUsuario(HttpServletRequest request) {

        String nombre = request.getParameter("nombreUsuario");
        String correo = request.getParameter("correoUsuario");

        Usuario usuario = new Usuario(nombre, correo);

        usuarioDAO.guardarUsuario(usuario);
    }

    // Edita los datos de un usuario
    private void editarUsuario(HttpServletRequest request) {

        Long id = Long.parseLong(
                request.getParameter("usuarioId")
        );

        Usuario usuario = usuarioDAO.buscarPorId(id);

        if (usuario != null) {

            usuario.setNombre(
                    request.getParameter("nombreUsuario")
            );

            usuario.setCorreo(
                    request.getParameter("correoUsuario")
            );

            usuarioDAO.editarUsuario(usuario);
        }
    }

    // Desactiva el usuario pero conserva su registro
    private void desactivarUsuario(HttpServletRequest request) {

        Long id = Long.parseLong(
                request.getParameter("usuarioId")
        );

        usuarioDAO.desactivarUsuario(id);
    }
}