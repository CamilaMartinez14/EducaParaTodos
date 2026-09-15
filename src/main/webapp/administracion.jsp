<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

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
            <a href="administracion">Administración</a>
        </nav>
    </header>

    <main>

        <!-- Presentacion de Administracion -->
        <section class="titulo-pagina">
            <h2>Administración</h2>

            <p>
                Desde esta sección se pueden registrar y administrar
                los cursos disponibles en EducaParaTodos.
            </p>
        </section>


        <!-- Formulario para agregar un curso -->
        <section class="administracion">

            <h2>Agregar curso</h2>

            <form action="administracion" method="post">

                <input type="hidden" name="accion" value="guardar">

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

                <select id="nivel"
                        name="nivel"
                        required>

                    <option value="">Seleccionar</option>
                    <option value="Basico">Básico</option>
                    <option value="Intermedio">Intermedio</option>
                    <option value="Avanzado">Avanzado</option>

                </select>

                <label for="descripcion">Descripción</label>

                <textarea id="descripcion"
                          name="descripcion"
                          rows="4"
                          required></textarea>

                <button type="submit">
                    Guardar curso
                </button>

            </form>

        </section>


        <!-- Cursos registrados -->
        <section class="administracion">

            <h2>Cursos registrados</h2>

            <c:forEach var="curso" items="${cursos}">

                <article class="curso-admin">

                    <h3>${curso.nombre}</h3>

                    <!-- Formulario para editar -->
                    <form action="administracion" method="post">

                        <input type="hidden"
                               name="accion"
                               value="editar">

                        <input type="hidden"
                               name="id"
                               value="${curso.id}">

                        <label>Nombre</label>
                        <input type="text"
                               name="nombre"
                               value="${curso.nombre}"
                               required>

                        <label>Tema</label>
                        <input type="text"
                               name="tema"
                               value="${curso.tema}"
                               required>

                        <label>Nivel</label>

                        <select name="nivel" required>

                            <option value="Basico"
                                ${curso.nivel == 'Basico' ? 'selected' : ''}>
                                Básico
                            </option>

                            <option value="Intermedio"
                                ${curso.nivel == 'Intermedio' ? 'selected' : ''}>
                                Intermedio
                            </option>

                            <option value="Avanzado"
                                ${curso.nivel == 'Avanzado' ? 'selected' : ''}>
                                Avanzado
                            </option>

                        </select>

                        <label>Descripción</label>

                        <textarea name="descripcion"
                                  rows="3"
                                  required>${curso.descripcion}</textarea>

                        <button type="submit">
                            Guardar cambios
                        </button>

                    </form>


                    <!-- Desactiva el curso sin borrarlo de la BD -->
                    <form action="administracion" method="post"
                          class="form-desactivar">

                        <input type="hidden"
                               name="accion"
                               value="desactivar">

                        <input type="hidden"
                               name="id"
                               value="${curso.id}">

                        <button type="submit">
                            Desactivar curso
                        </button>

                    </form>

                </article>

            </c:forEach>


            <!-- Se muestra si no existen cursos activos -->
            <c:if test="${empty cursos}">
                <p>No hay cursos activos para administrar.</p>
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