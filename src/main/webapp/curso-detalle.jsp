<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EducaParaTodos | Detalle del curso</title>
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
            <a href="administracion">Administración</a>
        </nav>
    </header>

    <main>

        <!-- Informacion del curso -->
        <section class="detalle-curso">

            <a class="volver" href="cursos">← Volver a cursos</a>

            <h2>${curso.nombre}</h2>

            <p>${curso.descripcion}</p>

            <div class="datos-curso">
                <p>
                    <strong>Tema:</strong>
                    ${curso.tema}
                </p>

                <p>
                    <strong>Nivel:</strong>
                    ${curso.nivel}
                </p>
            </div>

        </section>

        <!-- Lecciones relacionadas con el curso -->
        <section class="lecciones">
            <h2>Lecciones del curso</h2>

            <c:forEach var="leccion" items="${lecciones}">
                <article>
                    <h3>${leccion.titulo}</h3>
                    <p>${leccion.contenido}</p>
                </article>
            </c:forEach>

            <!-- Se muestra si el curso aun no tiene lecciones -->
            <c:if test="${empty lecciones}">
                <p>Este curso todavía no tiene lecciones disponibles.</p>
            </c:if>

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