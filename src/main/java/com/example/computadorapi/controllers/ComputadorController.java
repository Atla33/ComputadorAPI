package com.example.computadorapi.controllers;

import com.example.computadorapi.dtos.computador.ComputadorRequestDTO;
import com.example.computadorapi.dtos.computador.ComputadorResponseDTO;
import com.example.computadorapi.models.Computador;
import com.example.computadorapi.services.ComputadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/computador")
@CrossOrigin(origins = "*")

public class ComputadorController {


        ComputadorService service;
        ModelMapper modelMapper = new ModelMapper();


        public ComputadorController(ComputadorService service) {
            this.service = service;
        }

        @GetMapping
        public List<Computador> findAll(){
            return service.findAll();
        }

        @GetMapping(path = {"/{id}"})
        public ResponseEntity<ComputadorResponseDTO> findById(@PathVariable Long id){
            Optional<Computador> c  = service.findById(id);
            if (c.isPresent()){
                Computador computador = c.get();
                ComputadorResponseDTO computadorResponseDto = modelMapper.map(computador, ComputadorResponseDTO.class);
                computadorResponseDto.addHateoasLinks(computador.getId());
                return ResponseEntity.ok().body(computadorResponseDto);
            }else{
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping
        public ResponseEntity<Computador> insert(@RequestBody ComputadorRequestDTO c) throws URISyntaxException {


            Computador novo = modelMapper.map(c, Computador.class);

            service.create(novo);

            URI uri = new URI("/computador/" + novo.getId());
            return ResponseEntity.created(uri).build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<Computador> update (@PathVariable Long id, @RequestBody Computador c){
            if (service.findById(id).isPresent()){
                Computador atualizado = service.update(c);
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
