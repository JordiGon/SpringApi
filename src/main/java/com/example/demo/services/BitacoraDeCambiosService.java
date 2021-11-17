package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.BitacoraDeCambiosModel;
import com.example.demo.repositories.BitacoraDeCambiosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BitacoraDeCambiosService {
    @Autowired
    BitacoraDeCambiosRepository bitacoraDeCambiosRepository;

    public ArrayList<BitacoraDeCambiosModel> getAll(){
        return (ArrayList<BitacoraDeCambiosModel>) bitacoraDeCambiosRepository.findAll();
    }
    //get by id
    public Optional<BitacoraDeCambiosModel> getById(Integer id){
        return bitacoraDeCambiosRepository.findById(id);
    }
    //post
    public BitacoraDeCambiosModel postNew(BitacoraDeCambiosModel aux){
        return bitacoraDeCambiosRepository.save(aux);
    }
    //delete
    public boolean deleteNow(Integer id){
        try{
            bitacoraDeCambiosRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
