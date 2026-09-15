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

    <!-- Presentacion de Administracion -->
    <section class="titulo-pagina">

        <h2>Administración</h2>

        <p>
            Desde esta sección se pueden registrar y administrar
            los cursos y usuarios de EducaParaTodos.
        </p>

    </section>


    <!-- AGREGAR CURSO -->
    <section class="administracion">

        <h2>Agregar curso</h2>

        <form action="administracion" method="post">

            <input type="hidden"
                   name="accion"
                   value="guardar">

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


    <!-- CURSOS REGISTRADOS -->
    <section class="administracion">

        <h2>Cursos registrados</h2>

        <c:forEach var="curso" items="${cursos}">

            <article class="curso-admin">

                <h3>${curso.nombre}</h3>

                <!-- Editar curso -->
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


                <!-- Desactivar curso -->
                <form action="administracion"
                      method="post"
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


        <c:if test="${empty cursos}">
            <p>No hay cursos activos para administrar.</p>
        </c:if>

    </section>


    <!-- AGREGAR USUARIO -->
    <section class="administracion">

        <h2>Agregar usuario</h2>

        <p>
            Desde aquí se puede registrar un nuevo usuario
            en la plataforma.
        </p>

        <form action="administracion" method="post">

            <input type="hidden"
                   name="accion"
                   value="guardarUsuario">

            <label for="nombreUsuario">
                Nombre
            </label>

            <input type="text"
                   id="nombreUsuario"
                   name="nombreUsuario"
                   required>

            <label for="correoUsuario">
                Correo
            </label>

            <input type="email"
                   id="correoUsuario"
                   name="correoUsuario"
                   required>

            <button type="submit">
                Guardar usuario
            </button>

        </form>

    </section>


    <!-- USUARIOS REGISTRADOS -->
    <section class="administracion">

        <h2>Usuarios registrados</h2>

        <p>
            Aquí se pueden revisar y modificar los usuarios
            que se encuentran activos.
        </p>


        <c:forEach var="usuario" items="${usuarios}">

            <article class="curso-admin">

                <h3>${usuario.nombre}</h3>

                <!-- Editar usuario -->
                <form action="administracion" method="post">

                    <input type="hidden"
                           name="accion"
                           value="editarUsuario">

                    <input type="hidden"
                           name="usuarioId"
                           value="${usuario.id}">

                    <label>Nombre</label>

                    <input type="text"
                           name="nombreUsuario"
                           value="${usuario.nombre}"
                           required>

                    <label>Correo</label>

                    <input type="email"
                           name="correoUsuario"
                           value="${usuario.correo}"
                           required>

                    <p>
                        <strong>Fecha de registro:</strong>
                        ${usuario.fechaRegistro}
                    </p>

                    <button type="submit">
                        Guardar cambios
                    </button>

                </form>


                <!-- Se desactiva pero no se elimina de la BD -->
                <form action="administracion"
                      method="post"
                      class="form-desactivar">

                    <input type="hidden"
                           name="accion"
                           value="desactivarUsuario">

                    <input type="hidden"
                           name="usuarioId"
                           value="${usuario.id}">

                    <button type="submit">
                        Desactivar usuario
                    </button>

                </form>

            </article>

        </c:forEach>


        <c:if test="${empty usuarios}">

            <p>
                No hay usuarios activos para administrar.
            </p>

        </c:if>

    </section>

</main>


<footer>

    <p>EducaParaTodos</p>

    <p>
        Plataforma educativa gratuita.
    </p>

    <p>
        © 2026 EducaParaTodos
    </p>

</footer>

</body>
</html>