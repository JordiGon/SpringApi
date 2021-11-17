package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.TransaccionModel;
import com.example.demo.repositories.TransaccionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {
    @Autowired
    TransaccionRepository transaccionRepository;
    public ArrayList<TransaccionModel> getAll(){
        return (ArrayList<TransaccionModel>) transaccionRepository.findAll();
    }
    //get by id
    public Optional<TransaccionModel> getById(Integer id){
        return transaccionRepository.findById(id);
    }
    //post
    public TransaccionModel postNew(TransaccionModel aux){
        return transaccionRepository.save(aux);
    }
    //delete
    public boolean deleteNow(Integer id){
        try{
            transaccionRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
