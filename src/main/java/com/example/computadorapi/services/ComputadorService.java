package com.example.computadorapi.services;

import com.example.computadorapi.models.Computador;
import com.example.computadorapi.repositories.ComputadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputadorService {

    ComputadorRepository repository;

    public ComputadorService(ComputadorRepository repository) {
        this.repository = repository;
    }

    public Computador create(Computador c){
        return repository.save(c);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Computador update(Computador c){
        return repository.saveAndFlush(c);
    }

    public Optional<Computador> findById(Long id){
        return repository.findById(id);
    }

    public List<Computador> findAll(){
        return repository.findAll();
    }
}
