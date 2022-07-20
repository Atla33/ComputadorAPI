package com.example.computadorapi.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Peças {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String placa_mae;
    String memoria;
    String Placa_de_Vídeo;
    String Processador;


}
