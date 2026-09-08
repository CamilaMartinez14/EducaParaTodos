package cl.ipchile.educaparatodos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    // Id del curso
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Datos principales del curso
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tema;

    private String descripcion;

    // Nivel de dificultad del curso
    private String nivel;

    // Cantidad de personas inscritas
    private int popularidad;

    // Sirve para saber si el curso sigue activo
    private boolean activo;

    // Constructor vacio que necesita JPA
    public Curso() {
    }

    // Constructor para crear un curso
    public Curso(String nombre, String tema, String descripcion, String nivel) {
        this.nombre = nombre;
        this.tema = tema;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.popularidad = 0;
        this.activo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}