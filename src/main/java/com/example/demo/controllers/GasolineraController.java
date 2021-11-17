package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.GasolineraModel;
import com.example.demo.services.GasolineraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gasolineras")
public class GasolineraController {
    @Autowired
    GasolineraService gasolineraService;

    @GetMapping()
    public ArrayList<GasolineraModel> getAll(){
        return gasolineraService.obtenerTodos();
    }

    @GetMapping(path = "/{id}")
    public Optional<GasolineraModel> getById(@PathVariable("id") Integer id){
        return this.gasolineraService.obtenerPorId(id);
    }

    @PostMapping()
    public GasolineraModel newGasolinera(@RequestBody GasolineraModel aux){
        return this.gasolineraService.nuevaGasolinera(aux);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteGasolinera(@PathVariable ("id") Integer id){
        boolean ok = this.gasolineraService.eliminarGasolinera(id);
        if (ok) {
            return "Gasolinera id: " +id+ " Eliminada";
        } else {
            return "Gasolinera id: " +id+ " No fue Eliminada"; 
        }
    }
}
