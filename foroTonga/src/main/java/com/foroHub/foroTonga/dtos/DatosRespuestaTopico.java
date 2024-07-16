package com.foroHub.foroTonga.dtos;

import com.foroHub.foroTonga.domain.usuarios.Usuario;
import java.time.LocalDateTime;

public record DatosRespuestaTopico(Long id,
                                   String titulo,
                                   String mensaje,
                                   String nombreCurso,
                                   Usuario usuarioId,
                                   LocalDateTime createdAt,
                                   Boolean activo) {


}
