package com.projeto.rolezin.usuários.repository;

import com.projeto.rolezin.usuários.model.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<UsuariosModel,Long> {
}
