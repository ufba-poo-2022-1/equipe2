package com.projeto.rolezin.eventos.repository;

import com.projeto.rolezin.eventos.model.EventosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventosRepository extends JpaRepository<EventosModel, Long> {

}
