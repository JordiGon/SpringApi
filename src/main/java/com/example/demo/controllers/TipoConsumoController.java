package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.TipoConsumoModel;
import com.example.demo.services.TipoConsumoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipoconsumo")
public class TipoConsumoController {
    @Autowired
    TipoConsumoService tipoConsumoService;

    @GetMapping()
    public ArrayList<TipoConsumoModel> mostrarTodo(){
        return tipoConsumoService.getAll();
    }
    //get by id
    @GetMapping(path = "/{id}")
    public Optional<TipoConsumoModel> obtenerPorId(@PathVariable("id") Integer id){
        return this.tipoConsumoService.getById(id);
    }
    //post
    @PostMapping()
    public TipoConsumoModel guardar(@RequestBody TipoConsumoModel aux){
        return this.tipoConsumoService.postNew(aux);
    }
    //delete
    @DeleteMapping(path="/{id}")
    public String eliminar(@PathVariable Integer id){
        boolean ok = this.tipoConsumoService.deleteNow(id);
        if (ok) {
            return "Se ha eliminado id: " + id;
        } else {
            return "No se pudo eliminar id: " + id;
        }
    }
}
