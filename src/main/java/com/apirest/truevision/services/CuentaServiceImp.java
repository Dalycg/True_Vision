package com.apirest.truevision.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apirest.truevision.entities.Cuenta;
import com.apirest.truevision.repositories.CuentaRepository;

@Service
public class CuentaServiceImp implements CuentaService {

    private CuentaRepository cuentaRepository;

    public CuentaServiceImp(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public List<Cuenta> findAll() throws Exception {
        try {
            List<Cuenta> entities = cuentaRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cuenta findById(String ci) throws Exception {
        try {
            Optional<Cuenta> entityOptional = cuentaRepository.findById(ci);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cuenta save(Cuenta entity) throws Exception {
        try {
            Cuenta c = new Cuenta();
            c = cuentaRepository.save(entity);
            return c;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Cuenta update(String ci, Cuenta entity) throws Exception {
        try {
            Optional<Cuenta> entityOptional = cuentaRepository.findById(ci);
            Cuenta entityUpdate = entityOptional.get();
            entityUpdate = cuentaRepository.save(entity);
            return entityUpdate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(String ci) throws Exception {
        try {
            if (cuentaRepository.existsById(ci)) {
                cuentaRepository.deleteById(ci);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String findRol(String usuario) throws Exception {
        try {
            Cuenta c = findById(usuario);
            return c.getRol();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean existsByID(String usuario) throws Exception {
        try {
            return cuentaRepository.existsById(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}