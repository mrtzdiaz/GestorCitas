package com.hospital.GestorCitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.GestorCitas.model.Consultorio;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Long>{

}
