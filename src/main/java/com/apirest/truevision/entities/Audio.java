/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apirest.truevision.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/**
 *
 * @author Daly
 */
@Entity
@Table(name = "audio")
@Getter
@Setter

public class Audio {
    @Id
    private String nombre;  // Nombre del archivo, si es relevante para tu aplicación

    
    @Column(nullable = false, columnDefinition = "bytea")
    private byte[] contenido;
    
    
    private String emocion;

    public Audio(String nombre, byte[] contenido, String emocion) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.emocion = emocion;
    }

    public Audio() {
    }
    
    
    
}
