package com.hospital.GestorCitas.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Consultorio consultorio;
	
	@ManyToOne
	private Medico medico;
	
	private String paciente;
	private LocalDateTime horario;
}
