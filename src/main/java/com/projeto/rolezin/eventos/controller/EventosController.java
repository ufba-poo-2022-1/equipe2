package com.projeto.rolezin.eventos.controller;

import com.projeto.rolezin.eventos.model.EventosModel;
import com.projeto.rolezin.eventos.repository.EventosRepository;
import com.projeto.rolezin.utils.EndpointUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/eventos")
public class EventosController {
EventosRepository eventosRepository;
EndpointUtils endpointUtils;
    @Autowired
    public EventosController(EventosRepository eventosRepository,  EndpointUtils endpointUtils ){
        this.eventosRepository = eventosRepository;
        this.endpointUtils = endpointUtils;
    }

    @GetMapping()
    public ResponseEntity<?> ListEvents() {
        return endpointUtils.returnObjectOrNotFound(eventosRepository.findAll());
    }

    @GetMapping("/filtrarNome")
    public List<EventosModel> findEventByNome(@RequestParam("nome") String nome) {
        return this.eventosRepository.findEventoByNomeContains(nome);
    }

    @GetMapping("/filtrarCategoria")
    public List<EventosModel> findEventByCategoria(@RequestParam("categoria") String categoria) {
        return this.eventosRepository.findEventoByCategoriaContains(categoria);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getEventById(@PathVariable long id) {
        return endpointUtils.returnObjectOrNotFound(eventosRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createEvent(@Valid @RequestBody EventosModel evento) {

        eventosRepository.save(evento);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<?> UpdateEvent(@PathVariable("id") Long id, @RequestBody EventosModel evento) {

        if (!eventosRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        evento.setIdEventos(id);

        evento = eventosRepository.save(evento);

        return ResponseEntity.ok(evento);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> DeleteEvent(@PathVariable("id") Long id){

        if (!eventosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        eventosRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
