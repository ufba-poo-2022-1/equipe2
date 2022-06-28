package com.projeto.rolezin.atracoes.repository;

import com.projeto.rolezin.atracoes.model.AtracoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtracoesRepository extends JpaRepository<AtracoesModel, Long> {
}
