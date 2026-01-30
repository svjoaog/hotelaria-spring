package br.com.hospital.hotelaria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hospital.hotelaria.dto.SalaRequest;
import br.com.hospital.hotelaria.dto.SalaResponse;
import br.com.hospital.hotelaria.entity.Sala;
import br.com.hospital.hotelaria.entity.Setor;
import br.com.hospital.hotelaria.repository.SalaRepository;
import br.com.hospital.hotelaria.repository.SetorRepository;
import lombok.Data;

@Service
@Data
public class SalaService {
    private final SalaRepository salaRepository;
    private final SetorRepository setorRepository;

    public SalaResponse criar(SalaRequest request){
        Setor setor = setorRepository.findById(request.getId_setor())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
        
        Sala sala = new Sala();
        sala.setName(request.getName());
        sala.setSetor(setor);

        Sala save = salaRepository.save(sala);

        return toResponse(save);
    }

    public List<SalaResponse> listar(){
        return salaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public SalaResponse editar (Long id, SalaRequest request){
        Sala sala = salaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Sala não encontrada"));
        Setor setor = setorRepository.findById(request.getId_setor())
                    .orElseThrow(() -> new RuntimeException("Setor não encontrado"));

        sala.setName(request.getName());
        sala.setSetor(setor);

        Sala att = salaRepository.save(sala);

        return toResponse(att);
    }

    public SalaResponse buscar(Long id){
        Sala sala = salaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Sala não encontrada!"));

        return toResponse(sala);
    }

    public void excluir(Long id){
        Sala sala = salaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Sala não encontrada!"));
        
        salaRepository.delete(sala);
    }

    private SalaResponse toResponse(Sala sala){
        SalaResponse response = new SalaResponse();
        response.setId(sala.getId());
        response.setName(sala.getName());
        response.setSetor_id(sala.getSetor().getId());
        response.setSetor_nome(sala.getSetor().getName());

        return response;
    }

}
