package com.example.computadorapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Computador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String modelo;
    String marca;
    String preco;
    String descricao;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "etiqueta_serial")
    Etiqueta etiqueta;

    @OneToMany(mappedBy = "computador", fetch = FetchType.LAZY)
    private Set<Peças> peças;

}
