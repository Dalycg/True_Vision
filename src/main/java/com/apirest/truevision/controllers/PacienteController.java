package com.apirest.truevision.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.truevision.entities.Especialista;
import com.apirest.truevision.entities.Imagen;
import com.apirest.truevision.entities.Paciente;
import com.apirest.truevision.services.EspecialistaServiceImp;
import com.apirest.truevision.services.ImagenServiceImp;
import com.apirest.truevision.services.PacienteServiceImp;

@RestController
@CrossOrigin(value = "*")
public class PacienteController {

    private PacienteServiceImp pacienteServiceImp;
    private EspecialistaServiceImp especialistaServiceImp;
    private ImagenServiceImp imagenServiceImp;

    public PacienteController(PacienteServiceImp pacienteServiceImp, EspecialistaServiceImp especialistaServiceImp,
            ImagenServiceImp imagenServiceImp) {
        this.pacienteServiceImp = pacienteServiceImp;
        this.especialistaServiceImp = especialistaServiceImp;
        this.imagenServiceImp = imagenServiceImp;
    }

    @DeleteMapping("/true_vision_api/paciente/{ci}")
    public boolean delete(@PathVariable String ci) throws Exception {
        try {
            return pacienteServiceImp.delete(ci);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/true_vision_api/paciente")
    public List<Paciente> getAll() throws Exception {
        try {
            return pacienteServiceImp.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/true_vision_api/paciente/{ci}")
    public Paciente getOne(@PathVariable String ci) throws Exception {
        try {
            return pacienteServiceImp.findById(ci);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/true_vision_api/paciente/{esp_ci}")
    public Especialista save(@PathVariable String esp_ci, @RequestBody Paciente entity) throws Exception {
        try {
            pacienteServiceImp.save(entity);
            return especialistaServiceImp.update(esp_ci, entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/true_vision_api/paciente/**")
    public Paciente updateImagenes(@RequestBody Paciente p, HttpServletRequest request) throws Exception {
        try {

            // File f = new File("D:/TrueVisionImagenes/k.jpg");
            // FileInputStream fis = new FileInputStream(f);
            // byte[] imgBytes = new byte[(int) f.length()];
            // fis.read(imgBytes);
            // String encodeImage = Base64.getEncoder().encodeToString(imgBytes);

            // String encodeString = encodeImage.getEncode_string();

            // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            // LocalDateTime now = LocalDateTime.now();

            // String name = dtf.format(now) + ".jpg";

            // String ruta = "D:/TrueVisionImagenes/" + name;

            // byte[] imgBytes = Base64.getDecoder().decode(encodeString);

            // FileOutputStream imgFile = new FileOutputStream(ruta);

            // imgFile.write(imgBytes);

            // System.out.println(imgBytes);

            String[] ruta = request.getRequestURI().split(request.getContextPath() +
                    "/true_vision_api/paciente/");

            String ruta_img = ruta[1];

            System.out.println("Ruta: " + ruta_img);

            String uri = "http://localhost:8000/predict?imgPath=" + ruta[1] +
                    "&classifier=SVM";

            Imagen img = new Imagen();
            img = imagenServiceImp.save(uri, ruta_img);

            List<Imagen> listimg = new ArrayList<Imagen>();
            listimg = p.getImagenes();

            System.out.println(listimg);

            listimg.add(img);

            p.setImagenes(listimg);

            return pacienteServiceImp.update(p.getCi(), p);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/true_vision_api/paciente/{ci}/imagenes")
    public List<Imagen> getImagenes(@PathVariable String ci) throws Exception {
        try {
            return pacienteServiceImp.findImagenesByPaciente(ci);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}