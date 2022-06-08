package com.projeto.rolezin.locais.controller;

import com.projeto.rolezin.locais.model.LocaisModel;
import com.projeto.rolezin.locais.repository.LocaisRepository;
import com.projeto.rolezin.utils.EndpointUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/locais")
public class LocaisController {

    LocaisRepository locaisRepository;
    EndpointUtils endpointUtils;

    @Autowired
    public LocaisController(LocaisRepository locaisRepository,  EndpointUtils endpointUtils ){
        this.locaisRepository = locaisRepository;
        this.endpointUtils = endpointUtils;
    }

    @GetMapping()
    public ResponseEntity<?> ListLocals() {
        return endpointUtils.returnObjectOrNotFound(locaisRepository.findAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getLocalById(@PathVariable long id) {
        return endpointUtils.returnObjectOrNotFound(locaisRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> criarLocal(@Valid @RequestBody LocaisModel local) {

        locaisRepository.save(local);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PatchMapping
    public ResponseEntity<?> AtualizarLocal(@PathVariable("id") Long id, @RequestBody LocaisModel local) {

        if (!locaisRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        locaisRepository.save(local);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = {"id"})
    public ResponseEntity<?> DeletarLocal(@PathVariable("id") Long id){

        if (!locaisRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        locaisRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
