package com.example.computadorapi.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Peças  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String placaMae;
    String memoria;
    String placaVídeo;
    String processador;

}
