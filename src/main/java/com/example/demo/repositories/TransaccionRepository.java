package com.example.demo.repositories;

import com.example.demo.models.TransaccionModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends CrudRepository<TransaccionModel, Integer>{
    
}
