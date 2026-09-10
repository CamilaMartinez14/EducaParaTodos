package cl.ipchile.educaparatodos.dao;

import cl.ipchile.educaparatodos.model.Curso;
import cl.ipchile.educaparatodos.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CursoDAO {

    // Lista los cursos que estan activos
    public List<Curso> listarCursos() {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        List<Curso> cursos = em.createQuery(
                "SELECT c FROM Curso c WHERE c.activo = true",
                Curso.class
        ).getResultList();

        em.close();

        return cursos;
    }

    // Guarda un curso nuevo en la base de datos
    public void guardarCurso(Curso curso) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        em.getTransaction().begin();

        em.persist(curso);

        em.getTransaction().commit();

        em.close();
    }

    // Busca un curso utilizando su id
    public Curso buscarPorId(Long id) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        Curso curso = em.find(Curso.class, id);

        em.close();

        return curso;
    }

    // Edita los datos de un curso que ya existe
    public void editarCurso(Curso curso) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        em.getTransaction().begin();

        em.merge(curso);

        em.getTransaction().commit();

        em.close();
    }

    // Desactiva un curso sin eliminarlo de la base de datos
    public void desactivarCurso(Long id) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        em.getTransaction().begin();

        Curso curso = em.find(Curso.class, id);

        if (curso != null) {
            curso.setActivo(false);
        }

        em.getTransaction().commit();

        em.close();
    }
}