package cl.ipchile.educaparatodos.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class JPAUtil {

    // Se crea una sola conexion para usarla en la aplicacion
    private static final EntityManagerFactory emf = crearEntityManagerFactory();

    private static EntityManagerFactory crearEntityManagerFactory() {

        // Datos para conectarnos a MySQL
        Map<String, String> propiedades = new HashMap<>();

        propiedades.put(
            "jakarta.persistence.jdbc.user",
            "educaparatodos_user"
        );

        // La contraseña se obtiene desde una variable de entorno
        propiedades.put(
            "jakarta.persistence.jdbc.password",
            System.getenv("EDUCA_DB_PASS")
        );

        return Persistence.createEntityManagerFactory(
            "educaparatodosPU",
            propiedades
        );
    }

    // Permite usar la conexion desde otras clases
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    // Cierra la conexion cuando ya no se necesita
    public static void cerrar() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}