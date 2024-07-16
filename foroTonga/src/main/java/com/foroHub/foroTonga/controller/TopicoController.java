package com.foroHub.foroTonga.controller;


import com.foroHub.foroTonga.domain.topicos.DatosActualizarTopico;
import com.foroHub.foroTonga.domain.topicos.Topico;
import com.foroHub.foroTonga.domain.topicos.TopicoRepository;
import com.foroHub.foroTonga.dtos.DatosRespuestaTopico;
import com.foroHub.foroTonga.dtos.TopicoDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TopicoController {

    @Autowired
    public TopicoRepository topicoRepository;

    @GetMapping("/topicos")
    public List<TopicoDTO> mostrarListaTopicos(){
    return topicoRepository.findAll().stream()
            .map(t -> new TopicoDTO(t.getId(), t.getTitulo(), t.getMensaje(), t.getNombre_curso()))
            .collect(Collectors.toList());
}

@PostMapping("/topicos")
public void agregarTopico (@RequestBody @Valid TopicoDTO topicoDTO) {
Topico topico = new Topico(topicoDTO.getTitulo(), topicoDTO.getMensaje(), topicoDTO.getNombre_curso());
    topicoRepository.save(topico);

    //public void agregarTopico (@RequestBody @Valid TopicoDTO topicoDTO) {
       // topicoRepository.save(new Topico(topicoDTO));

}

    @GetMapping("/topicos/{id}")
    public Optional<Topico> mostrarTopico (@PathVariable Long id) {
        var topicoAMostrar = topicoRepository.findById(id);
                return topicoAMostrar;
}

    //@GetMapping("/topicos")
    //public List<Topico> obtenerTodosLosTopicos() {
    //    return topicoRepository.findAll();
    //}


    @PutMapping("/topicos/{id}")
    @Transactional
    public ResponseEntity actualizarTopico (@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                topico.getMensaje(), topico.getNombre_curso(), topico.getUsuarioId(),
                topico.getCreatedAt(), topico.getActivo()));
    }

    @DeleteMapping("/topicos/{id}")
    @Transactional
    public ResponseEntity eliminarTopico (@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }
}





