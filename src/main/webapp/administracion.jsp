<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EducaParaTodos | Administración</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <!-- Encabezado de la pagina -->
    <header>
        <h1>EducaParaTodos</h1>

        <nav>
            <a href="index.jsp">Inicio</a>
            <a href="cursos">Cursos</a>
            <a href="mis-cursos.jsp">Mis Cursos</a>
            <a href="perfil.jsp">Perfil</a>
            <a href="contacto.jsp">Contacto</a>
            <a href="administracion.jsp">Administración</a>
        </nav>
    </header>

    <main>

        <!-- Presentacion de administracion -->
        <section class="titulo-pagina">
            <h2>Administración</h2>

            <p>
                Desde esta sección se podrán administrar los cursos
                disponibles en EducaParaTodos.
            </p>
        </section>

        <!-- Formulario para registrar cursos -->
        <section class="administracion">
            <h2>Agregar curso</h2>

            <form action="administracion" method="post">

                <label for="nombre">Nombre del curso</label>
                <input type="text"
                       id="nombre"
                       name="nombre"
                       required>

                <label for="tema">Tema</label>
                <input type="text"
                       id="tema"
                       name="tema"
                       required>

                <label for="nivel">Nivel</label>
                <select id="nivel" name="nivel" required>
                    <option value="">Seleccionar</option>
                    <option value="Basico">Básico</option>
                    <option value="Intermedio">Intermedio</option>
                    <option value="Avanzado">Avanzado</option>
                </select>

                <label for="descripcion">Descripción</label>
                <textarea id="descripcion"
                          name="descripcion"
                          rows="4"></textarea>

                <button type="submit">Guardar curso</button>

            </form>
        </section>

    </main>

    <!-- Pie de pagina -->
    <footer>
        <p>EducaParaTodos</p>
        <p>Plataforma educativa gratuita.</p>
        <p>© 2026 EducaParaTodos</p>
    </footer>

</body>
</html>