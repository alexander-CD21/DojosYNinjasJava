package com.codingdojo.services;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Dojo;
import com.codingdojo.models.Ninja;
import com.codingdojo.repositories.DojoRepository;
import com.codingdojo.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	private final DojoRepository dojoRepository;
	
	public NinjaService(NinjaRepository ninjaRepository, DojoRepository dojoRepository) {
		this.ninjaRepository = ninjaRepository;
		this.dojoRepository = dojoRepository;
	}
	
	public Ninja guardarNinja(Ninja ninja) {
		Dojo dojo = dojoRepository.findByName(ninja.getDojo().getName());
		ninja.setDojo(dojo);
		return ninjaRepository.save(ninja);
	}
}
