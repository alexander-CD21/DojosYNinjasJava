package com.codingdojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Dojo;
import com.codingdojo.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public Dojo guardarDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public List<Dojo> mostrarDojo() {
		return dojoRepository.findAll();
	}
	
	public Dojo buscarPorId(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}


}
