package com.foroHub.foroTonga.dtos;

public class UsuarioDTO {

    private Long id;

    private String login;

    private String clave;

    public UsuarioDTO(Long id, String login, String clave) {
        this.id = id;
        this.login = login;
        this.clave = clave;
    }
}
