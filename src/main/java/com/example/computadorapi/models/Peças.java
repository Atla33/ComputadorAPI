package com.example.computadorapi.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Peças  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String placa_mae;
    String memoria;
    String Placa_de_Vídeo;
    String Processador;

    @ManyToOne
    @JoinColumn(name = "computador_id")
    private Computador computador;


}
