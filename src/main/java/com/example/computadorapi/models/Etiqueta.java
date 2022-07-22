package com.example.computadorapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Etiqueta extends RepresentationModel<Etiqueta> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serial;

    private Long design_code;
    private Long mfr_code;
    private String fabricante;


}
