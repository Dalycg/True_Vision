package com.apirest.truevision.services;

import java.util.List;

import com.apirest.truevision.entities.Especialista;
import com.apirest.truevision.entities.Paciente;

public interface EspecialistaService {
    public List<Especialista> findAll() throws Exception;

    public Especialista findById(String ci) throws Exception;

    public Especialista save(Especialista entity) throws Exception;

    public Especialista update(String ci, Paciente paciente) throws Exception;

    public boolean delete(String ci) throws Exception;

    public List<Paciente> findPacientesByEspecialista(String ci) throws Exception;

    // public Especialista findEspecialistaByUsuario(String usuario) throws
    // Exception;
}