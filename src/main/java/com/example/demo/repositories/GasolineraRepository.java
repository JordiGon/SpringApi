package com.example.demo.repositories;

import com.example.demo.models.GasolineraModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasolineraRepository extends CrudRepository<GasolineraModel, Integer>{ 
    
}
