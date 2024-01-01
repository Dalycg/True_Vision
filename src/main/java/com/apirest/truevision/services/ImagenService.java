package com.apirest.truevision.services;

import java.util.List;

import com.apirest.truevision.entities.Imagen;

public interface ImagenService {
    public List<Imagen> findAll() throws Exception;

    public Imagen findById(String ruta) throws Exception;

    public Imagen save(String uri, String ruta) throws Exception;

    public Imagen update(String ruta, Imagen entity) throws Exception;

    public boolean delete(String ruta) throws Exception;
}