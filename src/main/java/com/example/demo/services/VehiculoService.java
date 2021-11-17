package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.VehiculoModel;
import com.example.demo.repositories.VehiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {
    @Autowired
    VehiculoRepository vehiculoRepository;

    public ArrayList<VehiculoModel> obtenerVehiculos(){
        return (ArrayList <VehiculoModel>) vehiculoRepository.findAll();
    }

    //Save
    public VehiculoModel guardarVehiculo (VehiculoModel vehiculo){
        return ( vehiculoRepository.save(vehiculo));
    }

    //get id
    public Optional <VehiculoModel> obtenerPorId(Integer id){
        return vehiculoRepository.findById(id);
    }

    //delete
    public boolean eliminarVehiculo ( Integer id ){
        try {
            vehiculoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
