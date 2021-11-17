package com.example.demo.repositories;

import com.example.demo.models.EmpleadosModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends CrudRepository <EmpleadosModel, Integer>{
    
}
