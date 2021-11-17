package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.GasolinerasAutorizadasModel;
import com.example.demo.services.GasolinerasAutorizadasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/autorizadas")
public class GasolinerasAutorizadasController {
    @Autowired
    GasolinerasAutorizadasService gasolinerasAutorizadasService;

    //get
    @GetMapping()
    public ArrayList<GasolinerasAutorizadasModel> mostrarTodo(){
        return gasolinerasAutorizadasService.getAll();
    }
    //get by id
    @GetMapping(path = "/{id}")
    public Optional<GasolinerasAutorizadasModel> obtenerPorId(@PathVariable("id") Integer id){
        return this.gasolinerasAutorizadasService.getById(id);
    }
    //post
    @PostMapping()
    public GasolinerasAutorizadasModel guardar(@RequestBody GasolinerasAutorizadasModel aux){
        return this.gasolinerasAutorizadasService.postNew(aux);
    }
    //delete
    @DeleteMapping(path="/{id}")
    public String eliminar(@PathVariable Integer id){
        boolean ok = this.gasolinerasAutorizadasService.deleteNow(id);
        if (ok) {
            return "Se ha eliminado id: " + id;
        } else {
            return "No se pudo eliminar id: " + id;
        }
    }
}

