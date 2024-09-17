package com.hospital.GestorCitas.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.GestorCitas.model.Cita;
import com.hospital.GestorCitas.model.Consultorio;
import com.hospital.GestorCitas.model.Medico;

@Repository
public interface CitaRepository  extends JpaRepository<Cita, Long>{
	Optional<List<Cita>> findByConsultorioAndHorarioAndHoras(Consultorio consultorio , LocalDate fecha, Integer horas);
    List<Cita> findByMedicoAndHorario(Medico medico, LocalDate fecha);
    List<Cita> findByHorario(LocalDate fecha);
}
