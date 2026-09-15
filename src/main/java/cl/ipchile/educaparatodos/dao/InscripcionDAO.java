package cl.ipchile.educaparatodos.dao;

import cl.ipchile.educaparatodos.model.Curso;
import cl.ipchile.educaparatodos.model.Inscripcion;
import cl.ipchile.educaparatodos.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class InscripcionDAO {

    // Guarda una nueva inscripcion en la base de datos
    public void guardarInscripcion(Inscripcion inscripcion) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        em.getTransaction().begin();

        em.persist(inscripcion);

        em.getTransaction().commit();

        em.close();
    }

    // Busca los cursos en los que esta inscrito un usuario
    public List<Curso> buscarCursosPorUsuario(Long usuarioId) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        List<Curso> cursos = em.createQuery(
                "SELECT i.curso FROM Inscripcion i " +
                "WHERE i.usuario.id = :usuarioId",
                Curso.class
        )
        .setParameter("usuarioId", usuarioId)
        .getResultList();

        em.close();

        return cursos;
    }

    // Revisa si el usuario ya esta inscrito en un curso
    public boolean existeInscripcion(Long usuarioId, Long cursoId) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        Long cantidad = em.createQuery(
                "SELECT COUNT(i) FROM Inscripcion i " +
                "WHERE i.usuario.id = :usuarioId " +
                "AND i.curso.id = :cursoId",
                Long.class
        )
        .setParameter("usuarioId", usuarioId)
        .setParameter("cursoId", cursoId)
        .getSingleResult();

        em.close();

        return cantidad > 0;
    }
}