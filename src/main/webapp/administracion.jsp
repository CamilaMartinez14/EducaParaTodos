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

    <div class="admin-nuevo">

        <!-- AGREGAR CURSO -->
        <section class="admin-panel">
            <h2>Agregar curso</h2>
            <p>Completa los datos para registrar un nuevo curso.</p>

            <form action="administracion" method="post">

                <input type="hidden" name="accion" value="guardar">

                <label for="nombre">Nombre del curso</label>
                <input
                    type="text"
                    id="nombre"
                    name="nombre"
                    placeholder="Ejemplo: Programación Web"
                    required>

                <div class="admin-fila">
                    <div>
                        <label for="tema">Tema</label>
                        <input
                            type="text"
                            id="tema"
                            name="tema"
                            placeholder="Ejemplo: Programación"
                            required>
                    </div>

                    <div>
                        <label for="nivel">Nivel</label>
                        <select id="nivel" name="nivel" required>
                            <option value="">Seleccionar</option>
                            <option value="Basico">Básico</option>
                            <option value="Intermedio">Intermedio</option>
                            <option value="Avanzado">Avanzado</option>
                        </select>
                    </div>
                </div>

                <label for="descripcion">Descripción</label>
                <textarea
                    id="descripcion"
                    name="descripcion"
                    rows="3"
                    placeholder="Escribe una descripción del curso..."
                    required></textarea>

                <button type="submit">Guardar curso</button>

            </form>
        </section>

        <!-- AGREGAR USUARIO -->
        <section class="admin-panel">
            <h2>Agregar usuario</h2>
            <p>Registra un nuevo usuario en la plataforma.</p>

            <form action="administracion" method="post">

                <input
                    type="hidden"
                    name="accion"
                    value="guardarUsuario">

                <label for="nombreUsuario">Nombre</label>
                <input
                    type="text"
                    id="nombreUsuario"
                    name="nombreUsuario"
                    placeholder="Ejemplo: Camila Martinez"
                    required>

                <label for="correoUsuario">Correo</label>
                <input
                    type="email"
                    id="correoUsuario"
                    name="correoUsuario"
                    placeholder="Ejemplo: correo@ejemplo.cl"
                    required>

                <button type="submit">Guardar usuario</button>

            </form>
        </section>

    </div>


    <!-- CURSOS REGISTRADOS -->
    <section class="admin-listado">

        <div class="admin-titulo-listado">
            <h2>Cursos registrados</h2>
            <p>
                Aquí puedes revisar y modificar la información
                de los cursos activos.
            </p>
        </div>

        <div class="admin-tarjetas">

            <c:forEach var="curso" items="${cursos}">

                <article class="admin-tarjeta">

                    <h3>${curso.nombre}</h3>

                    <div class="admin-resumen">
                        <p>
                            <strong>Tema:</strong> ${curso.tema}
                        </p>

                        <p>
                            <strong>Nivel:</strong> ${curso.nivel}
                        </p>

                        <p>
                            <strong>Descripción:</strong>
                            ${curso.descripcion}
                        </p>
                    </div>

                    <!-- El formulario se puede abrir cuando se necesite editar -->
                    <details class="admin-editar">

                        <summary>Editar</summary>

                        <form action="administracion" method="post">

                            <input
                                type="hidden"
                                name="accion"
                                value="editar">

                            <input
                                type="hidden"
                                name="id"
                                value="${curso.id}">

                            <label>Nombre</label>
                            <input
                                type="text"
                                name="nombre"
                                value="${curso.nombre}"
                                required>

                            <label>Tema</label>
                            <input
                                type="text"
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
                            <textarea
                                name="descripcion"
                                rows="3"
                                required>${curso.descripcion}</textarea>

                            <button type="submit">
                                Guardar cambios
                            </button>

                        </form>

                    </details>

                    <!-- Desactivacion logica del curso -->
                    <form
                        action="administracion"
                        method="post"
                        class="admin-desactivar">

                        <input
                            type="hidden"
                            name="accion"
                            value="desactivar">

                        <input
                            type="hidden"
                            name="id"
                            value="${curso.id}">

                        <button type="submit">
                            Desactivar curso
                        </button>

                    </form>

                </article>

            </c:forEach>

        </div>

        <c:if test="${empty cursos}">
            <p>No hay cursos activos para administrar.</p>
        </c:if>

    </section>


    <!-- USUARIOS REGISTRADOS -->
    <section class="admin-listado">

        <div class="admin-titulo-listado">
            <h2>Usuarios registrados</h2>
            <p>
                Aquí se pueden revisar y modificar los usuarios
                que se encuentran activos.
            </p>
        </div>

        <div class="admin-tarjetas">

            <c:forEach var="usuario" items="${usuarios}">

                <article class="admin-tarjeta">

                    <h3>${usuario.nombre}</h3>

                    <div class="admin-resumen">
                        <p>
                            <strong>Correo:</strong> ${usuario.correo}
                        </p>

                        <p>
                            <strong>Fecha de registro:</strong>
                            ${usuario.fechaRegistro}
                        </p>
                    </div>

                    <!-- Edicion del usuario -->
                    <details class="admin-editar">

                        <summary>Editar</summary>

                        <form action="administracion" method="post">

                            <input
                                type="hidden"
                                name="accion"
                                value="editarUsuario">

                            <input
                                type="hidden"
                                name="usuarioId"
                                value="${usuario.id}">

                            <label>Nombre</label>
                            <input
                                type="text"
                                name="nombreUsuario"
                                value="${usuario.nombre}"
                                required>

                            <label>Correo</label>
                            <input
                                type="email"
                                name="correoUsuario"
                                value="${usuario.correo}"
                                required>

                            <button type="submit">
                                Guardar cambios
                            </button>

                        </form>

                    </details>

                    <!-- Desactivacion logica del usuario -->
                    <form
                        action="administracion"
                        method="post"
                        class="admin-desactivar">

                        <input
                            type="hidden"
                            name="accion"
                            value="desactivarUsuario">

                        <input
                            type="hidden"
                            name="usuarioId"
                            value="${usuario.id}">

                        <button type="submit">
                            Desactivar usuario
                        </button>

                    </form>

                </article>

            </c:forEach>

        </div>

        <c:if test="${empty usuarios}">
            <p>No hay usuarios activos para administrar.</p>
        </c:if>

    </section>

</main>

<footer>
    <p>EducaParaTodos</p>
    <p>Plataforma educativa gratuita.</p>
    <p>© 2026 EducaParaTodos</p>
</footer>

</body>
</html>