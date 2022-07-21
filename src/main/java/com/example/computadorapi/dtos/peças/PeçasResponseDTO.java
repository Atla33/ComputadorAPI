package com.example.computadorapi.dtos.peças;

import com.example.computadorapi.controllers.EtiquetaController;
import com.example.computadorapi.dtos.etiqueta.EtiquetaResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class PeçasResponseDTO extends RepresentationModel<PeçasResponseDTO> {

    String placa_mae;
    String memoria;
    String Placa_de_Vídeo;
    String Processador;

    public void addHateoasLinks(Long serial ){
        this.add(linkTo(EtiquetaController.class).slash(serial).withSelfRel());
        this.add(linkTo(EtiquetaController.class).withRel("GET"));
        this.add(linkTo(EtiquetaController.class).slash(serial).withRel("DELETE"));
        this.add(linkTo(EtiquetaController.class).slash(serial).withRel("PUT"));
        this.add(linkTo(EtiquetaController.class).withRel("POST"));

    }


}
