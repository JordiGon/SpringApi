package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.VehiculoModel;
import com.example.demo.services.VehiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    VehiculoService vehiculoService;

    @GetMapping()
    public ArrayList<VehiculoModel> obtenerVehiculos(){
        return vehiculoService.obtenerVehiculos();
    }


    @PostMapping()
    public VehiculoModel guardarVehiculo (@RequestBody VehiculoModel vehiculo){
        return this.vehiculoService.guardarVehiculo(vehiculo);
    }

    @GetMapping(path = "/{id}")
    public Optional<VehiculoModel> obtenerVehiculo(@PathVariable("id") Integer id){
        return this.vehiculoService.obtenerPorId(id);
    }


    @DeleteMapping(path = "/{id}")
    public String eliminarPorId (@PathVariable("id") Integer id){
        boolean ok = this.vehiculoService.eliminarVehiculo(id);
        if(ok){
            return "Se elimino el vehiculo con id: " + id;
        }else{
            return "No se pudo eliminar el vehiculo con id: "+ id;
        }
    }
}
