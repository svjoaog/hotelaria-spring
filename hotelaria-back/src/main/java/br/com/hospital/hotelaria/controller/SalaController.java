package br.com.hospital.hotelaria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospital.hotelaria.dto.SalaRequest;
import br.com.hospital.hotelaria.dto.SalaResponse;
import br.com.hospital.hotelaria.service.SalaService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/salas")
public class SalaController {
    private final SalaService salaService;

    @PostMapping
    public ResponseEntity<SalaResponse> criar (@RequestBody SalaRequest request){
        SalaResponse response = salaService.criar(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<SalaResponse> listar (){
        return salaService.listar();
    }

    @GetMapping("/{id}")
    public SalaResponse buscar(@PathVariable Long id){
        return salaService.buscar(id);
    }

    @PutMapping("/{id}")
    public SalaResponse editar(@PathVariable Long id, @RequestBody SalaRequest request){
        return salaService.editar(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id){
        salaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
