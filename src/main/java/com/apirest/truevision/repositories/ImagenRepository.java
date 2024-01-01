package com.apirest.truevision.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.truevision.entities.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, String> {

}