package cl.ipchile.educaparatodos;

import cl.ipchile.educaparatodos.dao.CursoDAO;
import cl.ipchile.educaparatodos.model.Curso;
import org.junit.Test;

public class PruebaConexionTest {

    @Test
    public void guardarCurso() {

        // Creamos un curso para probar que se guarde en la base de datos
        Curso curso = new Curso(
                "Introduccion a la Programacion",
                "Programacion",
                "Curso para aprender conceptos basicos de programacion",
                "Basico"
        );

        CursoDAO cursoDAO = new CursoDAO();

        // Guardamos el curso
        cursoDAO.guardarCurso(curso);

        System.out.println("Curso guardado correctamente");
    }
}