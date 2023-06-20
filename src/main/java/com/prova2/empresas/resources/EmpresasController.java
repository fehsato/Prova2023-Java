package com.prova2.empresas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova2.empresas.entities.Empresas;
import com.prova2.empresas.services.EmpresasService;

@RestController
@RequestMapping
@CrossOrigin
public class EmpresasController {

    @Autowired
    private EmpresasService empresasService;

    @GetMapping("{id}")
    public ResponseEntity<Empresas> getEmpresa(@PathVariable int id){
        Empresas empresa = empresasService.getEmpresaById(id);
        return ResponseEntity.ok().body(empresa);
    }

    @GetMapping
    public ResponseEntity<List<Empresas>> getEmpresas(){
        List<Empresas> empresa = empresasService.getEmpresas();
        return ResponseEntity.ok().body(empresa);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable int id){
        empresasService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping
    public ResponseEntity<Empresas> saveEmpresas(@RequestBody Empresas empresa ){
        Empresas newEmpresas = empresasService.save(empresa);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(empresa.getId())

        .toUri();
        return ResponseEntity.created(location).body(newEmpresas);

    
}
}