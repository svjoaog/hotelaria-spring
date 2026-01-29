package br.com.hospital.hotelaria.service;

import org.springframework.stereotype.Service;

import br.com.hospital.hotelaria.repository.RegistroFaxinaRepository;
import br.com.hospital.hotelaria.repository.SalaRepository;
import br.com.hospital.hotelaria.repository.TipoFaxinaRepository;

@Service
public class RegistroFaxinaService {
    private final RegistroFaxinaRepository registroFaxinaRepository;
    private final SalaRepository salaRepository;
    private final TipoFaxinaRepository tipoFaxinaRepository;

    public RegistroFaxinaService(
            RegistroFaxinaRepository registroFaxinaRepository,
            SalaRepository salaRepository,
            TipoFaxinaRepository tipoFaxinaRepository){

        this.registroFaxinaRepository = registroFaxinaRepository;
        this.salaRepository = salaRepository;
        this.tipoFaxinaRepository = tipoFaxinaRepository;
    }

    


}
