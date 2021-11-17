package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.DiasModel;
import com.example.demo.repositories.DiasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiasService {
    @Autowired
    DiasRepository diasRepository;

    //get
    public ArrayList<DiasModel> obtenerDias(){
        return (ArrayList<DiasModel>) diasRepository.findAll();
    }
    //get by id
    public Optional<DiasModel> obtenerPorId(Integer id){
        return diasRepository.findById(id);
    }
    //save
    public DiasModel guardarDia(DiasModel aux){
        return diasRepository.save(aux);
    }
    //delete
    public boolean eliminarDia(Integer id){
        try{
            diasRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    // put 
    public DiasModel ActualizarDia(DiasModel aux, Integer id){
        DiasModel catched = diasRepository.findById(id).get();
        catched.setDescripcion(aux.getDescripcion());
        return diasRepository.save(catched);
    }
}
