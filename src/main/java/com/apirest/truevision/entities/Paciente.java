package com.apirest.truevision.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Paciente {

    @Id
    @JsonProperty(value = "ci")
    private String ci;

    @Column(nullable = false)
    @JsonProperty(value = "nombre")
    private String nombre;

    @Column(nullable = false)
    @JsonProperty(value = "apellidos")
    private String apellidos;

    @Column(nullable = false)
    @JsonProperty(value = "sexo")
    private String sexo;

    @Column(nullable = false)
    @JsonProperty(value = "año_nacimiento")
    private int año_nacimiento;

    private int edad;

    @Column(nullable = false)
    @JsonProperty(value = "direccion")
    private String direccion;

    @Column(nullable = false)
    @JsonProperty(value = "fecha_inicio_tratamiento")
    private Date fecha_inicio_tratamiento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_usuario")
    @JsonProperty(value = "cuenta")
    private Cuenta cuenta;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "paciente_imagenes", joinColumns = @JoinColumn(name = "paciente_ci"), inverseJoinColumns = @JoinColumn(name = "imagen_id"))
    @JsonProperty(value = "imagenes")
    private List<Imagen> imagenes;

    public Paciente(String ci, String nombre, String apellidos, String sexo, int año_nacimiento, int edad,
            String direccion, Date fecha_inicio_tratamiento, Cuenta cuenta, List<Imagen> imagenes) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.año_nacimiento = año_nacimiento;
        this.edad = edad;
        this.direccion = direccion;
        this.fecha_inicio_tratamiento = fecha_inicio_tratamiento;
        this.cuenta = cuenta;
        this.imagenes = imagenes;
    }

    public Paciente() {
    }

    public Paciente(String ci, String nombre, String apellidos, String sexo, int año_nacimiento, String direccion,
            Date fecha_inicio_tratamiento, Cuenta cuenta) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.año_nacimiento = año_nacimiento;
        this.direccion = direccion;
        this.fecha_inicio_tratamiento = fecha_inicio_tratamiento;
        this.cuenta = cuenta;
        this.imagenes = new ArrayList<Imagen>();
    }

}