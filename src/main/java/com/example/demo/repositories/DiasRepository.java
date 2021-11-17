package com.example.demo.repositories;

import com.example.demo.models.DiasModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DiasRepository extends CrudRepository <DiasModel, Integer>{
    
}
