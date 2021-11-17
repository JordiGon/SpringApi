package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.DiasConsumoModel;
import com.example.demo.services.DiasConsumoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DiasConsumo")
public class DiasConsumoController {
    @Autowired
    DiasConsumoService diasConsumoService;
    //get
    @GetMapping()
    public ArrayList<DiasConsumoModel> getAll(){
        return diasConsumoService.getDiasConsumo();
    }
    //getById
    @GetMapping("/{id}")
    public Optional<DiasConsumoModel> getByid(@PathVariable("id") Integer id){
        return this.diasConsumoService.getPorId(id);
    }
    //post
    @PostMapping()
    public DiasConsumoModel guardarDia(@RequestBody DiasConsumoModel aux){
        return this.diasConsumoService.saveDias(aux);
    }
    //delete
    @DeleteMapping(path = "/{id}")
    public String eliminardia(@PathVariable("id") Integer id){
        boolean ok = this.diasConsumoService.eliminarPorId(id);
        if (ok) {
            return "Eliminado Dia de consumo id: " + id;
        } else {
            return "No pudo ser eliminado el dia de consumo id:" +id;
        }
    }
}
