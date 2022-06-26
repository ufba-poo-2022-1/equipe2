package com.projeto.rolezin.atracoes.controller;

import com.projeto.rolezin.atracoes.model.AtracoesModel;
import com.projeto.rolezin.atracoes.repository.AtracoesRepository;
import com.projeto.rolezin.utils.EndpointUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/eventos/atracoes")
public class AtracoesController {

    AtracoesRepository atracoesRepository;
    EndpointUtils endpointUtils;

    @Autowired
    public AtracoesController(AtracoesRepository atracoesRepository, EndpointUtils endpointUtils ){
        this.atracoesRepository = atracoesRepository;
        this.endpointUtils = endpointUtils;
    }

    @GetMapping()
    public ResponseEntity<?> ListAtracoes() {
        return endpointUtils.returnObjectOrNotFound(atracoesRepository.findAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getAtracaoById(@PathVariable long id) {
        return endpointUtils.returnObjectOrNotFound(atracoesRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> criarAtracao(@Valid @RequestBody AtracoesModel atracao) {

        atracoesRepository.save(atracao);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<?> AtualizarAtracao(@PathVariable("id") Long id, @RequestBody AtracoesModel atracao) {

        if (!atracoesRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        atracoesRepository.save(atracao);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = {"id"})
    public ResponseEntity<?> DeletarAtracao(@PathVariable("id") Long id){

        if (!atracoesRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        atracoesRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
