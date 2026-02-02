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

import br.com.hospital.hotelaria.dto.SetorRequest;
import br.com.hospital.hotelaria.dto.SetorResponse;
import br.com.hospital.hotelaria.service.SetorService;
import lombok.Data;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/setores")
@Data
public class SetorController {
    private final SetorService setorService;

    @PostMapping
    public ResponseEntity<SetorResponse> criar (@RequestBody SetorRequest request){
        SetorResponse response = setorService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public List<SetorResponse> listar(){
        return setorService.listar();
    }

    @GetMapping("/{id}")
    public SetorResponse buscar(@PathVariable Long id){
        return setorService.buscarSetor(id);
    }

    @PutMapping("/{id}")
    public SetorResponse atualizar(@PathVariable Long id, @RequestBody SetorRequest request){
        return setorService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        setorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
