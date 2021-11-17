package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.EmpleadosModel;
import com.example.demo.repositories.EmpleadosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosService {
    @Autowired
    EmpleadosRepository empleadosRepository;

    //get
    public ArrayList<EmpleadosModel> getAll(){
        return (ArrayList<EmpleadosModel>) empleadosRepository.findAll();
    }
    //get by id
    public Optional<EmpleadosModel> getEmpleado(Integer id){
        return empleadosRepository.findById(id);
    }
    //eliminar
    public boolean deleteEmpleado(Integer id){
        try{
            empleadosRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    // post
    public EmpleadosModel newEmpleado(EmpleadosModel aux){
        return empleadosRepository.save(aux);
    }
}
