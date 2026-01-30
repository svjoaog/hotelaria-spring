package br.com.hospital.hotelaria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.hospital.hotelaria.dto.SetorRequest;
import br.com.hospital.hotelaria.dto.SetorResponse;
import br.com.hospital.hotelaria.entity.Setor;
import br.com.hospital.hotelaria.repository.SetorRepository;
import lombok.Data;

@Service
@Data
public class SetorService {
    private final SetorRepository setorRepository;

    public SetorResponse criar(SetorRequest request){
        Setor setor = new Setor();
        setor.setName(request.getName());
        Setor salvo = setorRepository.save(setor);
        return toResponse(salvo);
    }

    public List<SetorResponse> listar(){
        return setorRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public SetorResponse buscarSetor(Long id){
        Setor setor = setorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Área não encontrada"));

        return toResponse(setor);
    }

    public SetorResponse atualizar(Long id, SetorRequest request){
        Setor setor = setorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Área não encontrada"));

        setor.setName(request.getName());
        Setor att = setorRepository.save(setor);

        return toResponse(att);
    }

    public void deletar(Long id){
        Setor setor = setorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Setor não encontrado!"));

        setorRepository.delete(setor);
    }


    private SetorResponse toResponse(Setor setor){
        SetorResponse response = new SetorResponse();
        response.setId(setor.getId());
        response.setName(setor.getName());

        return response;    
    }
}
