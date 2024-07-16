package com.foroHub.foroTonga.domain.topicos;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id,
                                    String titulo,
                                    String mensaje,
                                    String nombre_curso) {
}
