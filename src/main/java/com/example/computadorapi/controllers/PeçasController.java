package com.example.computadorapi.controllers;



import com.example.computadorapi.dtos.peças.PeçasRequestDTO;
import com.example.computadorapi.dtos.peças.PeçasResponseDTO;
import com.example.computadorapi.models.Computador;
import com.example.computadorapi.models.Peças;
import com.example.computadorapi.services.PeçasService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/peças")
@CrossOrigin(origins = "*")
public class PeçasController {

    PeçasService service;
    ModelMapper modelMapper = new ModelMapper();

    public PeçasController(PeçasService service) {
        this.service = service;
    }

    @GetMapping
    public List<Peças> findAll(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<PeçasResponseDTO> findById(@PathVariable Long id){
        Optional<Peças> p  = service.findById(id);
        if (p.isPresent()){
            Peças peças = p.get();
            PeçasResponseDTO peçasResponseDto = modelMapper.map(peças, PeçasResponseDTO.class);
            peçasResponseDto.addHateoasLinks(peças.getId());
            return ResponseEntity.ok().body(peçasResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Peças> insert(@RequestBody PeçasRequestDTO p) throws URISyntaxException {


        Peças novo = modelMapper.map(p, Peças.class);

        service.create(novo);

        URI uri = new URI("/peças/" + novo.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Peças> update (@PathVariable Long id, @RequestBody Peças p){
        if (service.findById(id).isPresent()){
            Peças atualizado = service.update(p);
            return ResponseEntity.ok().body(atualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id ){
        if (service.findById(id).isPresent()){
            service.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
