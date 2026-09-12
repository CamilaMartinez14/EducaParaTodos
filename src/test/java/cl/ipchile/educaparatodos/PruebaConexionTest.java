package cl.ipchile.educaparatodos;

import cl.ipchile.educaparatodos.dao.CursoDAO;
import cl.ipchile.educaparatodos.dao.LeccionDAO;
import cl.ipchile.educaparatodos.model.Curso;
import cl.ipchile.educaparatodos.model.Leccion;
import org.junit.Test;

public class PruebaConexionTest {

    @Test
    public void guardarLeccion() {

        CursoDAO cursoDAO = new CursoDAO();
        LeccionDAO leccionDAO = new LeccionDAO();

        // Buscamos el curso que ya existe
        Curso curso = cursoDAO.buscarPorId(1L);

        // Creamos una leccion asociada al curso
        Leccion leccion = new Leccion(
                "Conceptos basicos de programacion",
                "En esta leccion se revisan algunos conceptos iniciales de programacion.",
                curso
        );

        leccionDAO.guardarLeccion(leccion);

        System.out.println(
                "Leccion guardada: "
                + leccion.getTitulo()
                + " - Curso: "
                + curso.getNombre()
        );
    }
}