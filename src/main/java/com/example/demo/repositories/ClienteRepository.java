package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


import com.example.demo.models.ClienteModel;
@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Integer>{

}
