<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>EducaParaTodos | Perfil</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <!-- Encabezado de la pagina -->
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

        <!-- Datos del usuario -->
        <section class="perfil">

            <h2>Mi Perfil</h2>

            <p>
                En esta sección puedes revisar tus datos registrados
                en EducaParaTodos.
            </p>

            <div class="datos-perfil">

                <p>
                    <strong>Nombre:</strong>
                    ${usuario.nombre}
                </p>

                <p>
                    <strong>Correo:</strong>
                    ${usuario.correo}
                </p>

                <p>
                    <strong>Fecha de registro:</strong>
                    ${usuario.fechaRegistro}
                </p>

            </div>

        </section>

    </main>

    <footer>
        <p>EducaParaTodos</p>
        <p>Plataforma educativa gratuita.</p>
        <p>© 2026 EducaParaTodos</p>
    </footer>

</body>

</html>