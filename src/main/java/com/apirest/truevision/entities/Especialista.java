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
@Table(name = "especialista")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Especialista {

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
    @JsonProperty(value = "especialidad")
    private String especialidad;

    @Column(nullable = false)
    @JsonProperty(value = "año_graduacion")
    private int año_graduacion;

    private int años_experiencia;

    @Column(nullable = false)
    @JsonProperty(value = "fecha_inic_lab_centro")
    private Date fecha_inic_lab_centro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_usuario")
    @JsonProperty(value = "cuenta")
    private Cuenta cuenta;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "especialista_pacientes", joinColumns = @JoinColumn(name = "especialista_ci"), inverseJoinColumns = @JoinColumn(name = "paciente_ci"))
    @JsonProperty(value = "pacientes")
    private List<Paciente> pacientes;

    public Especialista(String ci, String nombre, String apellidos, String sexo, int año_nacimiento, int edad,
            String direccion, String especialidad, int año_graduacion, int años_experiencia, Date fecha_inic_lab_centro,
            Cuenta cuenta, List<Paciente> pacientes) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.año_nacimiento = año_nacimiento;
        this.edad = edad;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.año_graduacion = año_graduacion;
        this.años_experiencia = años_experiencia;
        this.fecha_inic_lab_centro = fecha_inic_lab_centro;
        this.cuenta = cuenta;
        this.pacientes = pacientes;
    }

    public Especialista(String ci, String nombre, String apellidos, String sexo, int año_nacimiento, String direccion,
            String especialidad, int año_graduacion, Date fecha_inic_lab_centro, Cuenta cuenta,
            List<Paciente> pacientes) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.año_nacimiento = año_nacimiento;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.año_graduacion = año_graduacion;
        this.fecha_inic_lab_centro = fecha_inic_lab_centro;
        this.cuenta = cuenta;
        this.pacientes = pacientes;
    }

    public Especialista(String ci, String nombre, String apellidos, String sexo, int año_nacimiento, String direccion,
            String especialidad, int año_graduacion, Date fecha_inic_lab_centro, Cuenta cuenta) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.año_nacimiento = año_nacimiento;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.año_graduacion = año_graduacion;
        this.fecha_inic_lab_centro = fecha_inic_lab_centro;
        this.cuenta = cuenta;
        this.pacientes = new ArrayList<Paciente>();
    }

    public Especialista() {
    }

}