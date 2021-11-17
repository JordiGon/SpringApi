package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.TransaccionModel;
import com.example.demo.services.TransaccionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    @Autowired
    TransaccionService transaccionService;
    @GetMapping()
    public ArrayList<TransaccionModel> mostrarTodo(){
        return transaccionService.getAll();
    }
    //get by id
    @GetMapping(path = "/{id}")
    public Optional<TransaccionModel> obtenerPorId(@PathVariable("id") Integer id){
        return this.transaccionService.getById(id);
    }
    //post
    @PostMapping()
    public TransaccionModel guardar(@RequestBody TransaccionModel aux){
        return this.transaccionService.postNew(aux);
    }
    //delete
    @DeleteMapping(path="/{id}")
    public String eliminar(@PathVariable Integer id){
        boolean ok = this.transaccionService.deleteNow(id);
        if (ok) {
            return "Se ha eliminado id: " + id;
        } else {
            return "No se pudo eliminar id: " + id;
        }
    }
}
