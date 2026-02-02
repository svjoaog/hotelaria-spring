package br.com.hospital.hotelaria.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RegistroFaxinaRequest {
    private Long salaId;
    private Long tipoFaxinaId;
    private LocalDate data;
}
