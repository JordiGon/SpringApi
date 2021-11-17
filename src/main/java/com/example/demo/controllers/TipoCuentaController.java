package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.TipoCuentaModel;
import com.example.demo.services.TipoCuentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tipo_cuentas")
public class TipoCuentaController {
    @Autowired
    TipoCuentaService tipoCuentaService;

    @GetMapping()
    public ArrayList<TipoCuentaModel> obtenerTiposCuenta(){
        return tipoCuentaService.obtenerTipoCuentas();
    }

    @PostMapping()
    public TipoCuentaModel guardarTipoCuenta(@RequestBody TipoCuentaModel tipocuenta) {
        return this.tipoCuentaService.guardarTipoCuenta(tipocuenta);
    }
    
    @GetMapping(path = "/{id}")
    public Optional<TipoCuentaModel> obtenerTipoCuenta(@PathVariable("id") Integer id){
        return this.tipoCuentaService.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarTipoCuenta (@PathVariable("id") Integer id){
        boolean ok = this.tipoCuentaService.eliminarTipoCuenta(id);
        if(ok){
            return "Se elimino el tipo de cuenta con id: " + id;
        }else{
            return "No pudo eliminarse el tipo de cuenta con id: " + id;
        }
    }

}
