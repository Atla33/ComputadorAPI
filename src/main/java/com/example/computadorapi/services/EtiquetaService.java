package com.example.computadorapi.services;

import com.example.computadorapi.models.Etiqueta;
import com.example.computadorapi.repositories.EtiquetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtiquetaService {

    EtiquetaRepository repository;

    public EtiquetaService(EtiquetaRepository repository) {
        this.repository = repository;
    }

    public Etiqueta create(Etiqueta e){
        return repository.save(e);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Etiqueta update(Etiqueta e){
        return repository.saveAndFlush(e);
    }

    public Optional<Etiqueta> findById(Long id){
        return repository.findById(id);
    }

    public List<Etiqueta> findAll(){
        return repository.findAll();
    }
}
