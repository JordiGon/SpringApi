package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.DiasModel;
import com.example.demo.services.DiasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dias")
public class DiasController {
    @Autowired
    DiasService diasService;
    //get
    @GetMapping()
    public ArrayList<DiasModel> getDias(){
        return diasService.obtenerDias();
    }
    //get by id
    @GetMapping(path = "/{id}")
    public Optional<DiasModel> getDiasId(@PathVariable("id") Integer id){
        return this.diasService.obtenerPorId(id);
    }
    // post
    @PostMapping()
    public DiasModel saveDia(@RequestBody DiasModel dia){
        return this.diasService.guardarDia(dia);
    }
    // delete
    @DeleteMapping(path = "/{id}")
    public String eliminarDia(@PathVariable("id") Integer id){
        boolean ok = this.diasService.eliminarDia(id);
        if (ok) {
            return "El dia id: " + id + " fue eliminado";
        }else{
            return "El dia id: " + id + " no pudo ser eliminado"; 
        }
    }
    // update
    @PutMapping(path = "/{id}")
    public DiasModel actualizar(@RequestBody DiasModel dia, @PathVariable Integer id){
        return this.diasService.ActualizarDia(dia, id);
    }
}
