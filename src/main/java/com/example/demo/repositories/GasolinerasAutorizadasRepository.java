package com.example.demo.repositories;

import com.example.demo.models.GasolinerasAutorizadasModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasolinerasAutorizadasRepository extends CrudRepository<GasolinerasAutorizadasModel, Integer>{
    
}
