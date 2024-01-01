package com.apirest.truevision.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.truevision.entities.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, String> {

}