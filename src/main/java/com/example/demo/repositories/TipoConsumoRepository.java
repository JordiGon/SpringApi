package com.example.demo.repositories;

import com.example.demo.models.TipoConsumoModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoConsumoRepository extends CrudRepository<TipoConsumoModel, Integer>{
    
}
