package com.prova2.empresas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova2.empresas.entities.Empresas;
import com.prova2.empresas.repositories.EmpresasRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresasService {
    
    @Autowired
    private EmpresasRepository empresasRepository;


    public Empresas getEmpresaById(int id){
        return empresasRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Erro 404: Fornecedor não encontrado")
        );
    }
    

    public List<Empresas> getEmpresas(){
        return empresasRepository.findAll();
    }
    
    public void delete(int id) {
        Empresas empresa = getEmpresaById(id);
        empresasRepository.delete(empresa);
    }

    public Empresas save(Empresas empresa) {
        return empresasRepository.save(empresa);
    }


}
