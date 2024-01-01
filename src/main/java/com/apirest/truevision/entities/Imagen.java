package com.apirest.truevision.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "imagen")
@Getter
@Setter
public class Imagen {

    @Id
    private String ruta;

    private String emocion;

    public Imagen() {
    }

    public Imagen(String ruta, String emocion) {
        this.ruta = ruta;
        this.emocion = emocion;
    }

}