/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirest.truevision.services;

import com.apirest.truevision.entities.Audio;
import com.apirest.truevision.entities.Imagen;
import com.apirest.truevision.object.Imagen_Emocion;
import com.apirest.truevision.repositories.AudioRepository;
import com.apirest.truevision.repositories.ImagenRepository;
import com.apirest.truevision.repositories.PacienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Daly
 */
@Service
public class AudioServiceImp implements AudioService{
    
    @Autowired
    private AudioRepository audioRepository;
    private PacienteRepository pacienteRepository;
    
    @Override
    @Transactional
    public List<Audio> findAll() throws Exception {
        try {
            List<Audio> entities = audioRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Audio findById(String nombre) throws Exception {
        try {
            Optional<Audio> entityOptional = audioRepository.findById(nombre);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Audio save(String nombre, byte[] contenido, String emocion) throws Exception {
        try {
            Audio aud= new Audio(nombre,contenido,emocion);
            return audioRepository.save(aud);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    

    @Override
    @Transactional
    public boolean delete(String nombre) throws Exception {
        try {
            if (audioRepository.existsById(nombre)) {
                audioRepository.deleteById(nombre);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    
}
