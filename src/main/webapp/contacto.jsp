<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>EducaParaTodos | Contacto</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<header>

    <h1>EducaParaTodos</h1>

    <nav>
        <a href="index.jsp">Inicio</a>
        <a href="cursos">Cursos</a>
        <a href="mis-cursos">Mis Cursos</a>
        <a href="perfil">Perfil</a>
        <a href="contacto.jsp">Contacto</a>
        <a href="administracion">Administración</a>
    </nav>

</header>


<main>

    <!-- Seccion de contacto -->
    <section class="contacto">

        <h2>Contacto</h2>

        <p>
            Si tienes alguna consulta sobre EducaParaTodos
            puedes escribirnos mediante este formulario.
        </p>

        <form>

            <label for="nombreContacto">
                Nombre
            </label>

            <input type="text"
                   id="nombreContacto"
                   name="nombreContacto"
                   required>

            <label for="correoContacto">
                Correo
            </label>

            <input type="email"
                   id="correoContacto"
                   name="correoContacto"
                   required>

            <label for="mensajeContacto">
                Mensaje
            </label>

            <textarea id="mensajeContacto"
                      name="mensajeContacto"
                      rows="5"
                      required></textarea>

            <button type="submit">
                Enviar mensaje
            </button>

        </form>

    </section>

</main>


<footer>

    <p>EducaParaTodos</p>

    <p>Plataforma educativa gratuita.</p>

    <p>© 2026 EducaParaTodos</p>

</footer>

</body>

</html>