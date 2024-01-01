package com.apirest.truevision.services;

import java.util.List;

import com.apirest.truevision.entities.Cuenta;

public interface CuentaService {

    public List<Cuenta> findAll() throws Exception;

    public Cuenta findById(String usuario) throws Exception;

    public Cuenta save(Cuenta entity) throws Exception;

    public Cuenta update(String usuario, Cuenta entity) throws Exception;

    public boolean delete(String usuario) throws Exception;

    public String findRol(String usuario) throws Exception;

    public boolean existsByID(String usuario) throws Exception;
}