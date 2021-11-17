package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.TipoCuentaModel;
import com.example.demo.repositories.TipoCuentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoCuentaService {
    @Autowired
    TipoCuentaRepository tipoCuentaRepository;
    //get all
    public ArrayList<TipoCuentaModel> obtenerTipoCuentas(){
        return (ArrayList <TipoCuentaModel>) tipoCuentaRepository.findAll();
    }

    //Save
    public TipoCuentaModel guardarTipoCuenta (TipoCuentaModel tipocuenta){
        return ( tipoCuentaRepository.save(tipocuenta));
    }

    //get id
    public Optional <TipoCuentaModel> obtenerPorId(Integer id){
        return tipoCuentaRepository.findById(id);
    }

    //delete
    public boolean eliminarTipoCuenta ( Integer id ){
        try {
            tipoCuentaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
