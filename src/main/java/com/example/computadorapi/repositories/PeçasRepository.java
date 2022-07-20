package com.example.computadorapi.repositories;

import com.example.computadorapi.models.Peças;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeçasRepository extends JpaRepository<Peças, Long> {
}
