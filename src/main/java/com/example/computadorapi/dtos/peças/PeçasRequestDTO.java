package com.example.computadorapi.dtos.peças;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeçasRequestDTO {
    String placa_mae;
    String memoria;
}
