package com.example.demo.repositories;

import com.example.demo.models.BitacoraDeCambiosModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraDeCambiosRepository extends CrudRepository<BitacoraDeCambiosModel, Integer> {
    
}
