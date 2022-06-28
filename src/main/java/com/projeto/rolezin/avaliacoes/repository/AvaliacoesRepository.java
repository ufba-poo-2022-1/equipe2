package com.projeto.rolezin.avaliacoes.repository;

import com.projeto.rolezin.avaliacoes.model.AvaliacoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacoesRepository extends JpaRepository<AvaliacoesModel,Long> {
}

