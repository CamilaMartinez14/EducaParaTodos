<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>EducaParaTodos | Mis Cursos</title>

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

        <!-- Presentacion de Mis Cursos -->
        <section class="titulo-pagina">
            <h2>Mis Cursos</h2>

            <p>
                En esta sección puedo revisar los cursos
                en los que estoy inscrita.
            </p>
        </section>

        <!-- Cursos asociados al usuario -->
        <section id="cursos">

            <h2>Cursos inscritos</h2>

            <div>

                <c:forEach var="curso" items="${cursos}">

                    <article>

                        <h3>${curso.nombre}</h3>

                        <p>${curso.descripcion}</p>

                        <p>
                            <strong>Tema:</strong> ${curso.tema}
                        </p>

                        <p>
                            <strong>Nivel:</strong> ${curso.nivel}
                        </p>

                        <a href="curso-detalle?id=${curso.id}">
                            Ver curso
                        </a>

                    </article>

                </c:forEach>

                <!-- Se muestra cuando el usuario no tiene cursos -->
                <c:if test="${empty cursos}">
                    <p>
                        Todavía no tienes cursos inscritos.
                    </p>
                </c:if>

            </div>

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