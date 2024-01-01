package com.apirest.truevision.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.truevision.entities.Imagen;
import com.apirest.truevision.entities.Paciente;
import com.apirest.truevision.repositories.PacienteRepository;

@Service
public class PacienteServiceImp implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> findAll() throws Exception {
        try {
            List<Paciente> entities = pacienteRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Paciente findById(String ci) throws Exception {
        try {
            Optional<Paciente> entityOptional = pacienteRepository.findById(ci);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Paciente save(Paciente entity) throws Exception {
        try {
            entity = pacienteRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Paciente update(String ci, Paciente entity) throws Exception {
        try {
            Optional<Paciente> entityOptional = pacienteRepository.findById(ci);
            Paciente entityUpdate = entityOptional.get();
            entityUpdate = pacienteRepository.save(entity);
            return entityUpdate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(String ci) throws Exception {
        try {
            if (pacienteRepository.existsById(ci)) {
                pacienteRepository.deleteById(ci);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Imagen> findImagenesByPaciente(String ci) throws Exception {
        try {
            List<Imagen> listImagenes = pacienteRepository.findImagenesByPaciente(ci);
            return listImagenes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}