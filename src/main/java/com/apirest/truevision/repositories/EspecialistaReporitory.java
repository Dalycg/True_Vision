package com.apirest.truevision.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apirest.truevision.entities.Especialista;
import com.apirest.truevision.entities.Paciente;

@Repository
public interface EspecialistaReporitory extends JpaRepository<Especialista, String> {

    // Query para obtener todos los pacientes de un especialista
    @Query(value = "Select e.pacientes From Especialista e Where e.ci = :ci")
    List<Paciente> findPacientesByEspecialista(@Param("ci") String ci);

    // @Query(value = "Select e From Especialista e Where e.usuario = :usuario")
    // Especialista findEspecialistaByUsuario(@Param("usuario") String usuario);
}