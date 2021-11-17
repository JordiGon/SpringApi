package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.DiasConsumoModel;
import com.example.demo.repositories.DiasConsumoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiasConsumoService {
    @Autowired
    DiasConsumoRepository diasConsumoRepository;
    //get
    public ArrayList<DiasConsumoModel> getDiasConsumo(){
        return (ArrayList<DiasConsumoModel>) diasConsumoRepository.findAll();
    }
    //getbyid
    public Optional<DiasConsumoModel> getPorId(Integer id){
        return diasConsumoRepository.findById(id);
    }
    //post
    public DiasConsumoModel saveDias(DiasConsumoModel aux){
        return diasConsumoRepository.save(aux);
    }
    //delete
    public boolean eliminarPorId(Integer id){
        try{
            diasConsumoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
