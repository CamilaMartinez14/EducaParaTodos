package cl.ipchile.educaparatodos.dao;

import cl.ipchile.educaparatodos.model.Leccion;
import cl.ipchile.educaparatodos.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class LeccionDAO {

    // Guarda una nueva leccion en la base de datos
    public void guardarLeccion(Leccion leccion) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        em.getTransaction().begin();

        em.persist(leccion);

        em.getTransaction().commit();

        em.close();
    }

    // Busca las lecciones que pertenecen a un curso
    public List<Leccion> buscarPorCurso(Long cursoId) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        List<Leccion> lecciones = em.createQuery(
                "SELECT l FROM Leccion l " +
                "WHERE l.curso.id = :cursoId",
                Leccion.class
        )
        .setParameter("cursoId", cursoId)
        .getResultList();

        em.close();

        return lecciones;
    }
}