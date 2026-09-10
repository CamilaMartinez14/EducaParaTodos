package cl.ipchile.educaparatodos;

import cl.ipchile.educaparatodos.dao.CursoDAO;
import cl.ipchile.educaparatodos.model.Curso;
import java.util.List;
import org.junit.Test;

public class PruebaConexionTest {

    @Test
    public void buscarCursoPorNivel() {

        CursoDAO cursoDAO = new CursoDAO();

        // Buscamos los cursos que tienen nivel Basico
        List<Curso> cursos = cursoDAO.buscarPorNivel("Basico");

        for (Curso curso : cursos) {
            System.out.println(
                    "Curso encontrado: "
                    + curso.getNombre()
                    + " - Nivel: "
                    + curso.getNivel()
            );
        }
    }
}