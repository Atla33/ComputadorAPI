package com.example.computadorapi.dtos.etiqueta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EtiquetaRequestDTO {
    Long mfr_code;
    String fabricante;
}
