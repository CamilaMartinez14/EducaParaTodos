package cl.ipchile.educaparatodos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lecciones")
public class Leccion {

    // Id de la leccion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Datos de la leccion
    @Column(nullable = false)
    private String titulo;

    private String contenido;

    // Cada leccion pertenece a un curso
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // Constructor vacio que necesita JPA
    public Leccion() {
    }

    // Constructor para crear una leccion
    public Leccion(String titulo, String contenido, Curso curso) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}