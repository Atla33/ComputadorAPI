package com.example.computadorapi.dtos.computador;

import com.example.computadorapi.controllers.ComputadorController;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class ComputadorResponseDTO extends RepresentationModel<ComputadorResponseDTO> {

    String modelo;
    String marca;
    String preco;
    String descricao;

    public void addHateoasLinks(Long id ){
        this.add(linkTo(ComputadorController.class).slash(id).withSelfRel());
        this.add(linkTo(ComputadorController.class).withRel("GET"));
        this.add(linkTo(ComputadorController.class).slash(id).withRel("DELETE"));
        this.add(linkTo(ComputadorController.class).slash(id).withRel("PUT"));
        this.add(linkTo(ComputadorController.class).withRel("POST"));

    }
}
