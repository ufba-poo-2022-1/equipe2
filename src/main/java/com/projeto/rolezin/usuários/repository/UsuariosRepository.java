package com.projeto.rolezin.usuários.repository;

import com.projeto.rolezin.usuários.model.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuariosRepository extends JpaRepository<UsuariosModel,Long> {


    @Query("select u from UsuariosModel u where u.login = ?1 and u.senha = ?2")
    UsuariosModel findByLoginAndSenha(String login, String senha);
}
