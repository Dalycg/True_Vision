package com.apirest.truevision.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cuenta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cuenta {

    @Id
    @JsonProperty(value = "usuario")
    private String usuario;

    @Column(nullable = false)
    @JsonProperty(value = "contraseña")
    private String contraseña;

    @Column(nullable = false)
    @JsonProperty(value = "rol")
    private String rol;

}