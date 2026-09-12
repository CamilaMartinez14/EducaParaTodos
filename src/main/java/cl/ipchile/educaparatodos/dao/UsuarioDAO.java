package cl.ipchile.educaparatodos.dao;

import cl.ipchile.educaparatodos.model.Usuario;
import cl.ipchile.educaparatodos.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class UsuarioDAO {

    // Lista solamente los usuarios que estan activos
    public List<Usuario> listarUsuarios() {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        List<Usuario> usuarios = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.activo = true",
                Usuario.class
        ).getResultList();

        em.close();

        return usuarios;
    }

    // Guarda un usuario nuevo en la base de datos
    public void guardarUsuario(Usuario usuario) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        em.getTransaction().begin();

        em.persist(usuario);

        em.getTransaction().commit();

        em.close();
    }

    // Busca un usuario utilizando su id
    public Usuario buscarPorId(Long id) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        Usuario usuario = em.find(Usuario.class, id);

        em.close();

        return usuario;
    }

    // Edita los datos de un usuario que ya existe
    public void editarUsuario(Usuario usuario) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        em.getTransaction().begin();

        em.merge(usuario);

        em.getTransaction().commit();

        em.close();
    }

    // Desactiva un usuario sin eliminarlo de la base de datos
    public void desactivarUsuario(Long id) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, id);

        if (usuario != null) {
            usuario.setActivo(false);
        }

        em.getTransaction().commit();

        em.close();
    }

    // Desactiva varios usuarios segun una fecha de registro
    public int desactivarUsuariosPorFecha(LocalDate fecha) {

        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        em.getTransaction().begin();

        int cantidad = em.createQuery(
                "UPDATE Usuario u SET u.activo = false " +
                "WHERE u.fechaRegistro < :fecha AND u.activo = true"
        )
        .setParameter("fecha", fecha)
        .executeUpdate();

        em.getTransaction().commit();

        em.close();

        return cantidad;
    }
}