package com.example.demo.repositories;

import com.example.demo.models.RestriccionHorarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RestriccionHorarioRepository extends CrudRepository<RestriccionHorarioModel, Integer>{
    
}
