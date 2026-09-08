package cl.ipchile.educaparatodos.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {

    // Id de la inscripcion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuario que se inscribe
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Curso en el que se inscribe
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    // Fecha en que se realizo la inscripcion
    private LocalDate fechaInscripcion;

    // Progreso que lleva el usuario en el curso
    private int progreso;

    // Constructor vacio que necesita JPA
    public Inscripcion() {
    }

    // Constructor para realizar una inscripcion
    public Inscripcion(Usuario usuario, Curso curso) {
        this.usuario = usuario;
        this.curso = curso;
        this.fechaInscripcion = LocalDate.now();
        this.progreso = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }
}