package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.TipoConsumoModel;
import com.example.demo.repositories.TipoConsumoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TipoConsumoService {
    @Autowired
    TipoConsumoRepository tipoConsumoRepository;
    public ArrayList<TipoConsumoModel> getAll(){
        return (ArrayList<TipoConsumoModel>) tipoConsumoRepository.findAll();
    }
    //get by id
    public Optional<TipoConsumoModel> getById(Integer id){
        return tipoConsumoRepository.findById(id);
    }
    //post
    public TipoConsumoModel postNew(TipoConsumoModel aux){
        return tipoConsumoRepository.save(aux);
    }
    //delete
    public boolean deleteNow(Integer id){
        try{
            tipoConsumoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
