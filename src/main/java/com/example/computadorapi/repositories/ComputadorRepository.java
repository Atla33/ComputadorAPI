package com.example.computadorapi.repositories;

import com.example.computadorapi.models.Computador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputadorRepository extends JpaRepository<Computador, Long>{
}
