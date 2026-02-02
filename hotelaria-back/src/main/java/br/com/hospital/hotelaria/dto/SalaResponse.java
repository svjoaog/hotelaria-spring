package br.com.hospital.hotelaria.dto;

import lombok.Data;

@Data
public class SalaResponse {
    private Long id;
    private String name;
    private Long setor_id;
    private String setor_nome;
}
