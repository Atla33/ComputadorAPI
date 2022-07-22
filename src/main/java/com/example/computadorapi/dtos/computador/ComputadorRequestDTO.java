package com.example.computadorapi.dtos.computador;


import com.example.computadorapi.models.Etiqueta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputadorRequestDTO {
    String modelo;
    String marca;
    String preco;
    String descricao;
    Etiqueta etiqueta;
}
