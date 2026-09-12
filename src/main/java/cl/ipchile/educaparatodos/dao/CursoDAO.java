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

    // Busca cursos activos segun su tema
    public List<Curso> buscarPorTema(String tema) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        List<Curso> cursos = em.createQuery(
                "SELECT c FROM Curso c WHERE c.tema = :tema AND c.activo = true",
                Curso.class
        )
        .setParameter("tema", tema)
        .getResultList();

        em.close();

        return cursos;
    }

    // Busca cursos activos segun su nivel
    public List<Curso> buscarPorNivel(String nivel) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        List<Curso> cursos = em.createQuery(
                "SELECT c FROM Curso c WHERE c.nivel = :nivel AND c.activo = true",
                Curso.class
        )
        .setParameter("nivel", nivel)
        .getResultList();

        em.close();

        return cursos;
    }

    // Ordena los cursos activos desde el mas popular
    public List<Curso> listarPorPopularidad() {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        List<Curso> cursos = em.createQuery(
                "SELECT c FROM Curso c WHERE c.activo = true ORDER BY c.popularidad DESC",
                Curso.class
        ).getResultList();

        em.close();

        return cursos;
    }

    // Desactiva varios cursos segun su popularidad
    public int desactivarCursosPorPopularidad(int limite) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        em.getTransaction().begin();

        int cantidad = em.createQuery(
                "UPDATE Curso c SET c.activo = false " +
                "WHERE c.popularidad < :limite AND c.activo = true"
        )
        .setParameter("limite", limite)
        .executeUpdate();

        em.getTransaction().commit();

        em.close();

        return cantidad;
    }
}