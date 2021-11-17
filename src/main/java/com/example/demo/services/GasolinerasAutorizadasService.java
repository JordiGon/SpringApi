package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.GasolinerasAutorizadasModel;
import com.example.demo.repositories.GasolinerasAutorizadasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GasolinerasAutorizadasService {
    @Autowired
    GasolinerasAutorizadasRepository gasolinerasAutorizadasRepository;
    //get
    public ArrayList<GasolinerasAutorizadasModel> getAll(){
        return (ArrayList<GasolinerasAutorizadasModel>) gasolinerasAutorizadasRepository.findAll();
    }
    //get by id
    public Optional<GasolinerasAutorizadasModel> getById(Integer id){
        return gasolinerasAutorizadasRepository.findById(id);
    }
    //post
    public GasolinerasAutorizadasModel postNew(GasolinerasAutorizadasModel aux){
        return gasolinerasAutorizadasRepository.save(aux);
    }
    //delete
    public boolean deleteNow(Integer id){
        try{
            gasolinerasAutorizadasRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
