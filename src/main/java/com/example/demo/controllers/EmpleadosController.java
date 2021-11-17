package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.EmpleadosModel;
import com.example.demo.services.EmpleadosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadosController {
    @Autowired
    EmpleadosService empleadosService;
    //get
    @GetMapping
    public ArrayList<EmpleadosModel> empleadosget(){
        return empleadosService.getAll();
    }
    //get b id
    @GetMapping(path = "/{id}")
    public Optional<EmpleadosModel> empleadoGet(@PathVariable("id") Integer id){
        return this.empleadosService.getEmpleado(id);
    }
    // post
    @PostMapping()
    public EmpleadosModel empleadoPost(@RequestBody EmpleadosModel aux){
        return this.empleadosService.newEmpleado(aux);
    }
    // delete
    @DeleteMapping(path = "/{id}")
    public String empleadoDelete(@PathVariable("id") Integer id){
        boolean ok = this.empleadosService.deleteEmpleado(id);
        if (ok) {
            return "El empleado se elimino correctamente id: " + id;
        } else {
            return "El empleado no pudo ser eliminado id: "+id;
        }
    }
}
