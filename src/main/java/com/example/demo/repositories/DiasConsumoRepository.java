package com.example.demo.repositories;

import com.example.demo.models.DiasConsumoModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DiasConsumoRepository extends CrudRepository<DiasConsumoModel, Integer>{
    
}
