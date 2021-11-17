package com.example.demo.repositories;

import com.example.demo.models.StatusTransaccionModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusTransaccionRepository extends CrudRepository<StatusTransaccionModel, Integer>{
    
}
