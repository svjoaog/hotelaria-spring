package br.com.hospital.hotelaria.service;

import org.springframework.stereotype.Service;

import br.com.hospital.hotelaria.dto.RegistroFaxinaRequest;
import br.com.hospital.hotelaria.entity.RegistroFaxina;
import br.com.hospital.hotelaria.entity.Sala;
import br.com.hospital.hotelaria.entity.TipoFaxina;
import br.com.hospital.hotelaria.repository.RegistroFaxinaRepository;
import br.com.hospital.hotelaria.repository.SalaRepository;
import br.com.hospital.hotelaria.repository.TipoFaxinaRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RegistroFaxinaService {
    private final RegistroFaxinaRepository registroFaxinaRepository;
    private final SalaRepository salaRepository;
    private final TipoFaxinaRepository tipoFaxinaRepository;


    public RegistroFaxina registrar(RegistroFaxinaRequest request){
        Sala sala = salaRepository.findById(request.getSalaId())
            .orElseThrow( () -> new RuntimeException("Sala não encontrada"));

        TipoFaxina tipoFaxina = tipoFaxinaRepository.findById(request.getTipoFaxinaId())
            .orElseThrow(() -> new RuntimeException("Tipo de faxina não encontrada."));

        RegistroFaxina registro = new RegistroFaxina();
        
        registro.setSala(sala);
        registro.setTipoFaxina(tipoFaxina);
        registro.setDate(request.getData());

        return registroFaxinaRepository.save(registro);
    }
}
