package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ClienteModel;
import com.example.demo.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    //get alll
    public ArrayList <ClienteModel>  obtenerClientes(){
        return(ArrayList <ClienteModel>) clienteRepository.findAll();
    }    
    //save
    public ClienteModel guardarCliente(ClienteModel cliente){
        return( clienteRepository.save(cliente));
    }
    //Get id
    public Optional <ClienteModel> obtenerPorId(Integer id){
        return clienteRepository.findById(id);
    }
    
    //delete
    public boolean eliminarCliente (Integer id){
        try{
            clienteRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    //put
}
