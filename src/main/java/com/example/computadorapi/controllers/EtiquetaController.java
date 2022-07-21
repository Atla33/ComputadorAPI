package com.example.computadorapi.controllers;

import com.example.computadorapi.dtos.computador.ComputadorRequestDTO;
import com.example.computadorapi.dtos.computador.ComputadorResponseDTO;
import com.example.computadorapi.dtos.etiqueta.EtiquetaRequestDTO;
import com.example.computadorapi.dtos.etiqueta.EtiquetaResponseDTO;
import com.example.computadorapi.models.Computador;
import com.example.computadorapi.models.Etiqueta;
import com.example.computadorapi.models.Peças;
import com.example.computadorapi.services.ComputadorService;
import com.example.computadorapi.services.EtiquetaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etiqueta")
@CrossOrigin(origins = "*")
public class EtiquetaController {

    EtiquetaService service;
    ModelMapper modelMapper = new ModelMapper();

    public EtiquetaController(EtiquetaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Etiqueta> findAll(){
        return service.findAll();
    }

    @GetMapping(path = {"/{serial}"})
    public ResponseEntity<EtiquetaResponseDTO> findById(@PathVariable Long serial){
        Optional<Etiqueta> e  = service.findById(serial);
        if (e.isPresent()){
            Etiqueta etiqueta = e.get();
            EtiquetaResponseDTO etiquetaResponseDto = modelMapper.map(etiqueta, EtiquetaResponseDTO.class);
            etiquetaResponseDto.addHateoasLinks(etiqueta.getSerial());
            return ResponseEntity.ok().body(etiquetaResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Etiqueta> insert(@RequestBody EtiquetaRequestDTO e) throws URISyntaxException {


        Etiqueta novo = modelMapper.map(e, Etiqueta.class);

        service.create(novo);

        URI uri = new URI("/etiqueta/" + novo.getSerial());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{serial}")
    public ResponseEntity<Etiqueta> update (@PathVariable Long serial, @RequestBody Etiqueta e){
        if (service.findById(serial).isPresent()){
            Etiqueta atualizado = service.update(e);
            return ResponseEntity.ok().body(atualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{serial}")
    public ResponseEntity<?> delete (@PathVariable Long serial ){
        if (service.findById(serial).isPresent()){
            service.deleteById(serial);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
