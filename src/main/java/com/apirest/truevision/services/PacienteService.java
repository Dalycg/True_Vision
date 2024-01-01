package com.apirest.truevision.services;

import java.util.List;

import com.apirest.truevision.entities.Imagen;
import com.apirest.truevision.entities.Paciente;

public interface PacienteService {
    public List<Paciente> findAll() throws Exception;

    public Paciente findById(String ci) throws Exception;

    public Paciente save(Paciente entity) throws Exception;

    public Paciente update(String ci, Paciente entity) throws Exception;

    public boolean delete(String ci) throws Exception;

    public List<Imagen> findImagenesByPaciente(String ci) throws Exception;
}