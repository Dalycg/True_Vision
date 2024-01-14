/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirest.truevision.repositories;

import com.apirest.truevision.entities.Audio;
import com.apirest.truevision.entities.Especialista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daly
 */
@Repository
public interface AudioRepository extends JpaRepository<Audio, String>{
    
}
