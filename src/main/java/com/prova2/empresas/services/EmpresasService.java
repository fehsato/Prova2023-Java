package com.prova2.empresas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova2.empresas.entities.Empresas;
import com.prova2.empresas.repositories.EmpresasRepository;

@Service
public class EmpresasService {
    
    @Autowired
    private EmpresasRepository empresasRepository;
    
    
    public Empresas save(Empresas empresa) {
        return empresasRepository.save(empresa);
    }


}
