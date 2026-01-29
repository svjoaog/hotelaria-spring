package br.com.hospital.hotelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hospital.hotelaria.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long>{
}
