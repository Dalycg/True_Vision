package com.apirest.truevision.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apirest.truevision.entities.Imagen;
import com.apirest.truevision.object.Imagen_Emocion;
import com.apirest.truevision.services.ImagenServiceImp;
import io.swagger.annotations.Api;

@RestController
//@CrossOrigin(value = "*")
@Api(tags = "Nombre de la API", description = "Descripción de la API")
public class ImagenController {

    private ImagenServiceImp imagenServiceImp;

    public ImagenController(ImagenServiceImp imagenServiceImp) {
        this.imagenServiceImp = imagenServiceImp;
    }

    @DeleteMapping("/true_vision_api/imagen/delete/{ruta}")
    public boolean delete(@PathVariable String ruta) throws Exception {
        try {
            return imagenServiceImp.delete(ruta);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/true_vision_api/imagen")
    public List<Imagen> getAll() throws Exception {
        try {
            return imagenServiceImp.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/true_vision_api/imagen/{id}")
    public Imagen getOne(@PathVariable String ruta) throws Exception {
        try {
            return imagenServiceImp.findById(ruta);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ImagenController() {
    }

    // @GetMapping("/true_vision_api/imagen/**")
    // public Imagen save(HttpServletRequest request) throws Exception {
    // try {
    // String[] ruta = request.getRequestURI().split(request.getContextPath() +
    // "/true_vision_api/imagen/");

    // String ruta_img = ruta[1];

    // String uri = "http://localhost:8000/predict?imgPath=" + ruta[1] +
    // "&classifier=SVM";

    // RestTemplate restTemplate = new RestTemplate();

    // Imagen_Emocion img_em = restTemplate.getForObject(uri, Imagen_Emocion.class);

    // String em = img_em.getEmotion();

    // Imagen img = new Imagen(ruta_img, em);

    // return imagenServiceImp.save(img);

    // } catch (Exception e) {
    // throw new Exception(e.getMessage());
    // }
    // }

    @PutMapping("/true_vision_api/imagen/{id}")
    public Imagen update(@PathVariable String ruta, @RequestBody Imagen entity)
            throws Exception {
        try {
            return imagenServiceImp.update(ruta, entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}