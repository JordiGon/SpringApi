package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.RestriccionHorarioModel;
import com.example.demo.repositories.RestriccionHorarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestriccionHorarioService {
    @Autowired
    RestriccionHorarioRepository restriccionHorarioRepository;

    //get all
    public ArrayList<RestriccionHorarioModel> obtenerRestricciones(){
        return (ArrayList<RestriccionHorarioModel>) restriccionHorarioRepository.findAll();
    }
    //insert
    public RestriccionHorarioModel InsertarRestriccion(RestriccionHorarioModel aux){
        return (restriccionHorarioRepository.save(aux));
    }
    //get by id
    public Optional<RestriccionHorarioModel> ObtenerPorId(Integer id){
        return (restriccionHorarioRepository.findById(id));
    }
    //delete by id
    public boolean eliminarRestriccion(Integer id){
        try{
            restriccionHorarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    //put
    
    public RestriccionHorarioModel Actualizar(RestriccionHorarioModel aux, Integer id){
           RestriccionHorarioModel getter = restriccionHorarioRepository.findById(id).get();
           getter.setHora_fin(aux.getHora_fin()); 
           getter.setHora_inicio(aux.getHora_inicio());
           return (restriccionHorarioRepository.save(getter));
    }
}
