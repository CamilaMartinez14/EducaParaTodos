package cl.ipchile.educaparatodos;

import cl.ipchile.educaparatodos.dao.UsuarioDAO;
import java.time.LocalDate;
import org.junit.Test;

public class PruebaConexionTest {

    @Test
    public void desactivarUsuariosPorFecha() {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Desactivamos usuarios registrados antes del año 2026
        LocalDate fechaLimite = LocalDate.of(2026, 1, 1);

        int cantidad = usuarioDAO.desactivarUsuariosPorFecha(fechaLimite);

        System.out.println(
                "Usuarios desactivados: " + cantidad
        );
    }
}