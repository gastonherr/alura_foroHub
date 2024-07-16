package com.foroHub.foroTonga.domain.topicos;

import com.foroHub.foroTonga.domain.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    //boolean existsByTitulo(String titulo);
   //boolean existsByMensaje(String mensaje);
}
