package com.projeto.rolezin.usuários.controller;

import com.projeto.rolezin.usuários.model.UsuariosModel;
import com.projeto.rolezin.usuários.repository.UsuariosRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosRepository usuariosRepository;

    @GetMapping
    public List<UsuariosModel> ChecagemDeUsuario(){
        return this.usuariosRepository.findAll();
    }

    @GetMapping("/{Id}")
    public UsuariosModel ChamarUsuario(@PathVariable("Id") Long Id){
        return this.usuariosRepository.findById(Id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuariosModel CriarUsuario(@Valid @RequestBody UsuariosModel user){
        return this.usuariosRepository.save(user);
    }

    @PatchMapping("/{Id}")
    public ResponseEntity<UsuariosModel> AtualizarUsuario(@PathVariable("Id") Long Id, @RequestBody UsuariosModel user) {
        if (!usuariosRepository.existsById(Id)) {
            return ResponseEntity.notFound().build();
        }

        user.setUserId(Id);

        user=usuariosRepository.save(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> DeletarUsuario(@PathVariable("Id") Long Id){

        if (!usuariosRepository.existsById(Id)) {
            return ResponseEntity.notFound().build();
        }

        usuariosRepository.deleteById(Id);
        return ResponseEntity.noContent().build();
    }
}
