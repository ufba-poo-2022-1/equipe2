package com.projeto.rolezin.locais.repository;

import com.projeto.rolezin.locais.model.LocaisModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocaisRepository extends PagingAndSortingRepository<LocaisModel, Long> {
}
