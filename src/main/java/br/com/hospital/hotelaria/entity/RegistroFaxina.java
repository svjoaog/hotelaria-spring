package br.com.hospital.hotelaria.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class RegistroFaxina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "tipo_faxina_id")
    private TipoFaxina tipoFaxina;

    private LocalDate date;
}
