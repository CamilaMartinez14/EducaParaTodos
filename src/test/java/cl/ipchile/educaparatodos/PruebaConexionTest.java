package cl.ipchile.educaparatodos;

import cl.ipchile.educaparatodos.util.JPAUtil;
import jakarta.persistence.EntityManager;
import org.junit.Test;

public class PruebaConexionTest {

    @Test
    public void probarConexion() {

        // Probamos la conexion con la base de datos
        EntityManager em = JPAUtil
                .getEntityManagerFactory()
                .createEntityManager();

        System.out.println("Conexion realizada correctamente");

        em.close();
        JPAUtil.cerrar();
    }
}