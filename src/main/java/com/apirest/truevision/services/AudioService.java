/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.apirest.truevision.services;

import com.apirest.truevision.entities.Audio;
import com.apirest.truevision.entities.Imagen;
import java.util.List;

/**
 *
 * @author Daly
 */
public interface AudioService {
    public List<Audio> findAll() throws Exception;

    public Audio findById(String nombre) throws Exception;

    public Audio save(String nombre, byte[] contenido, String emocion) throws Exception;
    
     public Audio update(String nombre, Audio entity) throws Exception;

    public boolean delete(String nombre) throws Exception;
    
    
}
