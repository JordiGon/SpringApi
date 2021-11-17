package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.BitacoraDeCambiosModel;
import com.example.demo.services.BitacoraDeCambiosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bitacora")
public class BitacoraDeCambiosController {
    @Autowired
    BitacoraDeCambiosService bitacoraDeCambiosService;
    @GetMapping()
    public ArrayList<BitacoraDeCambiosModel> mostrarTodo(){
        return bitacoraDeCambiosService.getAll();
    }
    //get by id
    @GetMapping(path = "/{id}")
    public Optional<BitacoraDeCambiosModel> obtenerPorId(@PathVariable("id") Integer id){
        return this.bitacoraDeCambiosService.getById(id);
    }
    //post
    @PostMapping()
    public BitacoraDeCambiosModel guardar(@RequestBody BitacoraDeCambiosModel aux){
        return this.bitacoraDeCambiosService.postNew(aux);
    }
    //delete
    @DeleteMapping(path="/{id}")
    public String eliminar(@PathVariable Integer id){
        boolean ok = this.bitacoraDeCambiosService.deleteNow(id);
        if (ok) {
            return "Se ha eliminado id: " + id;
        } else {
            return "No se pudo eliminar id: " + id;
        }
    }
}
