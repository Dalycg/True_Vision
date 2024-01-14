package com.apirest.truevision.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.truevision.entities.Cuenta;
import com.apirest.truevision.services.CuentaServiceImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
//@CrossOrigin(value = "*")
@Api(tags = "Nombre de la API", description = "Descripción de la API")
public class CuentaController {

    private CuentaServiceImp cuentaServiceImp;

    public CuentaController(CuentaServiceImp cuentaServiceImp) {
        this.cuentaServiceImp = cuentaServiceImp;
    }
    
    @ApiOperation("Descripción del endpoint")
    @DeleteMapping("/true_vision_api/cuenta/{usuario}")
    public boolean delete(@PathVariable String usuario) throws Exception {
        try {
            return cuentaServiceImp.delete(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @ApiOperation("Descripción del endpoint")
    @GetMapping("/true_vision_api/cuenta")
    public List<Cuenta> getAll() throws Exception {
        try {
            return cuentaServiceImp.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @ApiOperation("Descripción del endpoint")
    @GetMapping("/true_vision_api/cuenta/{usuario}")
    public Cuenta getOne(@PathVariable String usuario) throws Exception {
        try {
            return cuentaServiceImp.findById(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @ApiOperation("Descripción del endpoint")
    @PostMapping("/true_vision_api/cuenta")
    public Cuenta save(@RequestBody Cuenta entity) throws Exception {
        try {
            return cuentaServiceImp.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @ApiOperation("Descripción del endpoint")
    @PutMapping("/true_vision_api/cuenta/{usuario}")
    public Cuenta update(@PathVariable String usuario, @RequestBody Cuenta entity)
            throws Exception {
        try {
            return cuentaServiceImp.update(usuario, entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @ApiOperation("Descripción del endpoint")
    @GetMapping("/true_vision_api/cuenta/{usuario}/rol")
    public String getRolByUsuario(@PathVariable String usuario) throws Exception {
        try {
            return cuentaServiceImp.findRol(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @ApiOperation("Descripción del endpoint")
    @GetMapping("/true_vision_api/cuenta/exists/{usuario}")
    public boolean usuarioExists(@PathVariable String usuario) throws Exception {
        try {
            return cuentaServiceImp.existsByID(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}