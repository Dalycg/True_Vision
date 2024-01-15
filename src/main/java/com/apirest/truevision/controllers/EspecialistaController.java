package com.apirest.truevision.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.truevision.entities.Especialista;
import com.apirest.truevision.entities.Paciente;
import com.apirest.truevision.repositories.EspecialistaReporitory;
import com.apirest.truevision.services.EspecialistaServiceImp;
import io.swagger.annotations.Api;

@RestController
//@CrossOrigin(value = "*")

public class EspecialistaController {

    private EspecialistaServiceImp especialistaServiceImp;

    public EspecialistaController(EspecialistaServiceImp especialistaServiceImp) {
        this.especialistaServiceImp = especialistaServiceImp;
    }

    @DeleteMapping("/true_vision_api/especialista/{ci}")
    public boolean delete(@PathVariable String ci) throws Exception {
        try {
            return especialistaServiceImp.delete(ci);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/true_vision_api/especialista")
    public List<Especialista> getAll() throws Exception {
        try {
            return especialistaServiceImp.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/true_vision_api/especialista/{ci}")
    public Especialista getOne(@PathVariable String ci) throws Exception {
        try {
            return especialistaServiceImp.findById(ci);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/true_vision_api/especialista")
    public Especialista save(@RequestBody Especialista entity) throws Exception {
        try {
            return especialistaServiceImp.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/true_vision_api/especialista/{ci}/pacientes")
    public List<Paciente> getPacientes(@PathVariable String ci) throws Exception {
        try {
            return especialistaServiceImp.findPacientesByEspecialista(ci);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // @GetMapping("/true_vision_api/especialista/getByUser/{usuario}")
    // public Especialista getEspecialistaByUsuario(@PathVariable String usuario)
    // throws Exception {
    // try {
    // return especialistaServiceImp.findEspecialistaByUsuario(usuario);
    // } catch (Exception e) {
    // throw new Exception(e.getMessage());
    // }
    // }

}