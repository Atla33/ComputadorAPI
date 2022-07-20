package com.example.computadorapi.repositories;

import com.example.computadorapi.models.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
}
