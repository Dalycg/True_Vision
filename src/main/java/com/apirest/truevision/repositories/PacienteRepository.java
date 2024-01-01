package com.apirest.truevision.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apirest.truevision.entities.Imagen;
import com.apirest.truevision.entities.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String> {

    // Query para obtener todas las imagenes de un paciente ordenas por la fecha de
    // captura
    @Query(value = "Select p.imagenes From Paciente p, Imagen i Where p.ci = :ci")
    List<Imagen> findImagenesByPaciente(@Param("ci") String ci);
}