/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirest.truevision.controllers;

import com.apirest.truevision.entities.Audio;
import com.apirest.truevision.entities.Imagen;
import com.apirest.truevision.services.AudioServiceImp;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daly
 */
@RestController
//@CrossOrigin(value = "*")
public class AudioController {
    
    private AudioServiceImp audioServiceImp;

    public AudioController(AudioServiceImp audioServiceImp) {
        this.audioServiceImp = audioServiceImp;
    }

    public AudioController() {
    }
    
    
    @DeleteMapping("/true_vision_api/audio/delete/{nombre}")
    public boolean delete(@PathVariable String nombre) throws Exception {
        try {
            return audioServiceImp.delete(nombre);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/true_vision_api/audio")
    public List<Audio> getAll() throws Exception {
        try {
            return audioServiceImp.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/true_vision_api/audio/{nombre}")
    public Audio getOne(@PathVariable String nombre) throws Exception {
        try {
            return audioServiceImp.findById(nombre);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @PutMapping("/true_vision_api/audio/{nombre}")
    public Audio update(@PathVariable String nombre, @RequestBody Audio entity)
            throws Exception {
        try {
            return audioServiceImp.update(nombre, entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
