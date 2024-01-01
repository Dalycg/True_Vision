package com.apirest.truevision.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.truevision.entities.Especialista;
import com.apirest.truevision.entities.Paciente;
import com.apirest.truevision.repositories.EspecialistaReporitory;

@Service
public class EspecialistaServiceImp implements EspecialistaService {

    @Autowired
    private EspecialistaReporitory especialistaReporitory;

    @Override
    public List<Especialista> findAll() throws Exception {
        try {
            List<Especialista> entities = especialistaReporitory.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Especialista findById(String ci) throws Exception {
        try {
            Optional<Especialista> entityOptional = especialistaReporitory.findById(ci);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Especialista save(Especialista entity) throws Exception {
        try {
            Especialista e = new Especialista();
            e = especialistaReporitory.save(entity);
            return e;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Especialista update(String ci, Paciente paciente) throws Exception {
        try {
            Optional<Especialista> entityOptional = especialistaReporitory.findById(ci);
            Especialista entityUpdate = entityOptional.get();
            entityUpdate.getPacientes().add(paciente);
            return especialistaReporitory.save(entityUpdate);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(String ci) throws Exception {
        try {
            if (especialistaReporitory.existsById(ci)) {
                especialistaReporitory.deleteById(ci);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Paciente> findPacientesByEspecialista(String ci) throws Exception {
        try {
            return especialistaReporitory.findPacientesByEspecialista(ci);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // @Override
    // public Especialista findEspecialistaByUsuario(String usuario) throws
    // Exception {
    // try {
    // return especialistaReporitory.findEspecialistaByUsuario(usuario);
    // } catch (Exception e) {
    // throw new Exception(e.getMessage());
    // }
    // }

}