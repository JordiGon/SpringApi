package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.RestriccionHorarioModel;
import com.example.demo.services.RestriccionHorarioService;

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
@RequestMapping("/restriccioneshorario")
public class RestriccionHorarioController {
    @Autowired
    RestriccionHorarioService restriccionHorarioService;

    @GetMapping()
    public ArrayList<RestriccionHorarioModel> obtenerRestricciones(){
        return restriccionHorarioService.obtenerRestricciones();
    }

    @GetMapping(path = "/{id}")
    public Optional<RestriccionHorarioModel> obtenerRestriccion(@PathVariable("id") Integer id){
        return this.restriccionHorarioService.ObtenerPorId(id);
    }

    @PostMapping()
    public RestriccionHorarioModel guardarRestriccion(@RequestBody RestriccionHorarioModel aux){
        return this.restriccionHorarioService.InsertarRestriccion(aux);
    }

    @PutMapping(path = "/{id}")
    public RestriccionHorarioModel Actualizar(@PathVariable("id") Integer id, @RequestBody RestriccionHorarioModel aux){
        return this.restriccionHorarioService.Actualizar(aux, id);
    }

    @DeleteMapping(path ="/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok= this.restriccionHorarioService.eliminarRestriccion(id);
        if(ok){
            return "Se elimino la restriccion id:" + id;
        }else{
            return "No se pudo eliminar la restriccion id:" +id;
        }
    }
}

