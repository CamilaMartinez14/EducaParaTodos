<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>EducaParaTodos | Cursos</title>

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

        <!-- Presentacion de la pagina de cursos -->
        <section class="titulo-pagina">

            <h2>Cursos disponibles</h2>

            <p>
                Revisa los cursos de EducaParaTodos y encuentra una alternativa
                según el tema o nivel que quieras aprender.
            </p>

        </section>


        <!-- Busqueda de cursos -->
        <section class="busqueda-cursos">

            <h2>Buscar cursos</h2>

            <form action="cursos" method="get">

                <label for="tema">Tema</label>

                <input
                    type="text"
                    id="tema"
                    name="tema"
                    value="${temaBuscado}"
                    placeholder="Ejemplo: Programación">

                <label for="nivel">Nivel</label>

                <select id="nivel" name="nivel">

                    <option value="">Todos</option>

                    <option value="Basico"
                        ${nivelBuscado == 'Basico' ? 'selected' : ''}>
                        Básico
                    </option>

                    <option value="Intermedio"
                        ${nivelBuscado == 'Intermedio' ? 'selected' : ''}>
                        Intermedio
                    </option>

                    <option value="Avanzado"
                        ${nivelBuscado == 'Avanzado' ? 'selected' : ''}>
                        Avanzado
                    </option>

                </select>

                <button type="submit">Buscar</button>

            </form>

        </section>


        <!-- Cursos obtenidos desde la base de datos -->
        <section id="cursos">

            <h2>Nuestros cursos</h2>

            <div>

                <c:forEach var="curso" items="${cursos}">

                    <article>

                        <h3>${curso.nombre}</h3>

                        <p>
                            ${curso.descripcion}
                        </p>

                        <p>
                            <strong>Tema:</strong> ${curso.tema}
                        </p>

                        <p>
                            <strong>Nivel:</strong> ${curso.nivel}
                        </p>

                        <!-- Envia el id del curso seleccionado -->
                        <a href="curso-detalle?id=${curso.id}">
                            Ver curso
                        </a>

                    </article>

                </c:forEach>


                <!-- Mensaje cuando la busqueda no encuentra cursos -->
                <c:if test="${empty cursos}">

                    <p>
                        No se encontraron cursos con la búsqueda realizada.
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