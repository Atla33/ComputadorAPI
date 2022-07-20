package com.example.computadorapi.services;

import com.example.computadorapi.models.Peças;
import com.example.computadorapi.repositories.PeçasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeçasService {

    PeçasRepository repository;

    public PeçasService(PeçasRepository repository) {
        this.repository = repository;
    }

    public Peças create(Peças p){
        return repository.save(p);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Peças update(Peças p){
        return repository.saveAndFlush(p);
    }

    public Optional<Peças> findById(Long id){
        return repository.findById(id);
    }

    public List<Peças> findAll(){
        return repository.findAll();
    }

}
