package br.com.hospital.hotelaria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hospital.hotelaria.dto.RegistroFaxinaRequest;
import br.com.hospital.hotelaria.entity.RegistroFaxina;
import br.com.hospital.hotelaria.service.RegistroFaxinaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/registro-faxinas")
@RequiredArgsConstructor
public class RegistroFaxinaController {
    private final RegistroFaxinaService registroFaxinaService;

    @PostMapping
    public ResponseEntity<RegistroFaxina> registrarFaxina(
            @RequestBody RegistroFaxinaRequest request){
        RegistroFaxina registro = registroFaxinaService.registrar(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @GetMapping
    public String teste(){
        return "Controller funcionando...";
    }
}
