package com.foroHub.foroTonga.domain.topicos;

import com.foroHub.foroTonga.domain.usuarios.Usuario;
import com.foroHub.foroTonga.dtos.TopicoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", unique = true, length = 120)
    @NotNull
    private String titulo;

    @Column(name = "mensaje", unique = true, length = 1000)
    @NotNull
    private String mensaje;

    @Column(name = "nombre_curso")
    @NotNull
    private String nombre_curso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioId;

@Column (name = "created_at")
    private LocalDateTime createdAt;

    private Boolean activo;

    public Topico(TopicoDTO topicoDTO) {
    }

    public Topico(String titulo, String mensaje, String nombre_curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.nombre_curso = nombre_curso;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }



    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }

        if (datosActualizarTopico.mensaje() !=null){
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if (datosActualizarTopico.nombre_curso() !=null){
            this.nombre_curso = datosActualizarTopico.nombre_curso();
    }
}

    public void desactivarTopico(Topico topico) {
        topico.activo = false;
    }
}
