package com.example.computadorapi.dtos.computador;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComputadorRequestDTO {
    String modelo;
    String marca;
}
