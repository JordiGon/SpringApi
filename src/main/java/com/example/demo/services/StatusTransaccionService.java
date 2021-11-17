package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.StatusTransaccionModel;
import com.example.demo.repositories.StatusTransaccionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusTransaccionService {
    @Autowired
    StatusTransaccionRepository statusTransaccionRepository;
    //get
    public ArrayList<StatusTransaccionModel> getAll(){
        return (ArrayList<StatusTransaccionModel>) statusTransaccionRepository.findAll();
    }
    //get by id
    public Optional<StatusTransaccionModel> getById(Integer id){
        return statusTransaccionRepository.findById(id);
    }
    //post
    public StatusTransaccionModel postNew(StatusTransaccionModel aux){
        return statusTransaccionRepository.save(aux);
    }
    //delete
    public boolean deleteNow(Integer id){
        try{
            statusTransaccionRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
