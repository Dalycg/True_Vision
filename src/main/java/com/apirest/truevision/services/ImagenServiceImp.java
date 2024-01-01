package com.apirest.truevision.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.apirest.truevision.entities.Imagen;
import com.apirest.truevision.object.Imagen_Emocion;
import com.apirest.truevision.repositories.ImagenRepository;

@Service
public class ImagenServiceImp implements ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    @Override
    @Transactional
    public List<Imagen> findAll() throws Exception {
        try {
            List<Imagen> entities = imagenRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Imagen findById(String ruta) throws Exception {
        try {
            Optional<Imagen> entityOptional = imagenRepository.findById(ruta);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Imagen save(String uri, String ruta) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();

            Imagen_Emocion img_em = restTemplate.getForObject(uri, Imagen_Emocion.class);

            String em = img_em.getEmotion();

            Imagen img = new Imagen(ruta, em);

            return imagenRepository.save(img);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Imagen update(String ruta, Imagen entity) throws Exception {
        try {
            Optional<Imagen> entityOptional = imagenRepository.findById(ruta);
            Imagen entityUpdate = entityOptional.get();
            entityUpdate = imagenRepository.save(entity);
            return entityUpdate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(String ruta) throws Exception {
        try {
            if (imagenRepository.existsById(ruta)) {
                imagenRepository.deleteById(ruta);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}