package com.hospital.GestorCitas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hospital.GestorCitas.model.Cita;
import com.hospital.GestorCitas.model.Consultorio;
import com.hospital.GestorCitas.model.Medico;
import com.hospital.GestorCitas.repository.CitaRepository;
import com.hospital.GestorCitas.repository.ConsultorioRepository;
import com.hospital.GestorCitas.repository.MedicoRepository;

@Controller
public class CitaController {
	
	@Autowired 
	MedicoRepository mR;
	
	@Autowired 
	ConsultorioRepository cR;
	
	@Autowired 
	CitaRepository citaRepository;

	@GetMapping("")
	public String index(Model model) {
		List<Cita> citas = citaRepository.findAll();
		model.addAttribute("citas", citas);
		return "index";
	}
	
	@GetMapping("/agendar")
	public String agenda(Model model) {
		List<Medico> listaMedicos = mR.findAll();
		List<Consultorio> listaConsultorios = cR.findAll();
		model.addAttribute("cita", new Cita());
		model.addAttribute("medicos", listaMedicos);
		model.addAttribute("consultorios", listaConsultorios);
		
		return "agenda";
	}
	
	@PostMapping("/agendar")
	public String crearCita(Cita cita, Model model, RedirectAttributes re) {
		Optional<List<Cita>> tmpCitas = citaRepository.findByConsultorioAndHorarioAndHoras(cita.getConsultorio(), cita.getHorario(), cita.getHoras()); 
		if(tmpCitas.isPresent()) {
			System.out.println(tmpCitas.get());
			citaRepository.save(cita);
			re.addFlashAttribute("agregado", "Se ha agendado con exito");
			return "redirect:/";			
		}
		else {
			re.addFlashAttribute("errorMsg", "El Consultorio ya esta ocupado en la fecha y hora seleccionada");
			return"";
		}
	}
	
}
