package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.GasolineraModel;
import com.example.demo.repositories.GasolineraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GasolineraService {
    @Autowired
    GasolineraRepository gasolineraRepository;

    public ArrayList<GasolineraModel> obtenerTodos(){
        return (ArrayList<GasolineraModel>) gasolineraRepository.findAll();
    }

    public Optional<GasolineraModel> obtenerPorId(Integer id){
        return gasolineraRepository.findById(id);
    }

    public GasolineraModel nuevaGasolinera(GasolineraModel aux){
        return gasolineraRepository.save(aux);
    }

    public boolean eliminarGasolinera(Integer id){
        try{
            gasolineraRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
