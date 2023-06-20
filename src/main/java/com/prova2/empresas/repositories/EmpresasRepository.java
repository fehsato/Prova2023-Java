package com.prova2.empresas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prova2.empresas.entities.Empresas;

public interface EmpresasRepository extends JpaRepository <Empresas, Integer> {
    
}
