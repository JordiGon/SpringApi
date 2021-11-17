package com.example.demo.repositories;

import com.example.demo.models.VehiculoModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends CrudRepository <VehiculoModel, Integer> {
        
}
