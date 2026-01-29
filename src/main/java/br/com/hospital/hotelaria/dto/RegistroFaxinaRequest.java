package br.com.hospital.hotelaria.dto;

import java.time.LocalDate;

public class RegistroFaxinaRequest {
    private Long salaId;
    private Long tipoFaxinaId;
    private LocalDate data;

    void setSalaId(Long id){
        this.salaId = id;
    }
    Long getSalaId(){
        return this.salaId;
    }

    void setTipoFaxinaId(Long id){
        this.tipoFaxinaId = id;
    }
    Long getTipoFaxinaId(){
        return this.tipoFaxinaId;
    }

    void setData(LocalDate data){
        this.data = data;
    }
    LocalDate getData(){
        return this.data;
    }
}
