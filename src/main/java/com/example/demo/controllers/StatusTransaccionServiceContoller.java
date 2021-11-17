package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.StatusTransaccionModel;
import com.example.demo.services.StatusTransaccionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusTransaccionServiceContoller {
    @Autowired
    StatusTransaccionService statusTransaccionService;
    //get
    @GetMapping()
    public ArrayList<StatusTransaccionModel> mostrarTodo(){
        return statusTransaccionService.getAll();
    }
    //get by id
    @GetMapping(path = "/{id}")
    public Optional<StatusTransaccionModel> obtenerPorId(@PathVariable("id") Integer id){
        return this.statusTransaccionService.getById(id);
    }
    //post
    @PostMapping()
    public StatusTransaccionModel guardar(@RequestBody StatusTransaccionModel aux){
        return this.statusTransaccionService.postNew(aux);
    }
    //delete
    @DeleteMapping(path="/{id}")
    public String eliminar(@PathVariable Integer id){
        boolean ok = this.statusTransaccionService.deleteNow(id);
        if (ok) {
            return "Se ha eliminado id: " + id;
        } else {
            return "No se pudo eliminar id: " + id;
        }
    }
}
