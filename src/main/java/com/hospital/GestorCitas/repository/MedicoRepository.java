package com.hospital.GestorCitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.GestorCitas.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
