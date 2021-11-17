package com.example.demo.repositories;

import com.example.demo.models.TipoCuentaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCuentaRepository extends CrudRepository<TipoCuentaModel, Integer>{
    
}
