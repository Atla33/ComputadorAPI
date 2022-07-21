package com.example.computadorapi.dtos.etiqueta;

import com.example.computadorapi.controllers.ComputadorController;
import com.example.computadorapi.controllers.EtiquetaController;
import com.example.computadorapi.dtos.computador.ComputadorResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class EtiquetaResponseDTO extends RepresentationModel<EtiquetaResponseDTO> {
     Long design_code;
     Long mfr_code;
     String fabricante;

    public void addHateoasLinks(Long id ){
        this.add(linkTo(EtiquetaController.class).slash(id).withSelfRel());
        this.add(linkTo(EtiquetaController.class).withRel("GET"));
        this.add(linkTo(EtiquetaController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(EtiquetaController.class).slash(id).withRel("PUT"));
        this.add(linkTo(EtiquetaController.class).withRel("POST"));

    }
}
