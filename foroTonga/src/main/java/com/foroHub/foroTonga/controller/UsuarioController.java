package com.foroHub.foroTonga.controller;

import com.foroHub.foroTonga.domain.usuarios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
}
