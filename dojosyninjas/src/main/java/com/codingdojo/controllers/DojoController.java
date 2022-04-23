package com.codingdojo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.models.Dojo;
import com.codingdojo.models.Ninja;
import com.codingdojo.services.DojoService;
import com.codingdojo.services.NinjaService;



@Controller
public class DojoController {
	
	private final DojoService dojoService;

	private final NinjaService ninjaService;

    public DojoController(DojoService dojoService,  NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }
	
	@GetMapping("/")
	public String index(Model model ) {
        return "redirect:dojo/new";
    }
	
	@GetMapping("dojo/new")
    public String dojos(Model model, @ModelAttribute("dojo") Dojo dojo) {
        return "creardojo";
    }

    @PostMapping("/dojo/new")
    public String createDojo(@ModelAttribute("dojo") @Valid Dojo dojo, BindingResult result) {
        if (!result.hasErrors()) {
            dojoService.guardarDojo(dojo);
        }
        return "redirect:/dojo/new";
    }

    @GetMapping("ninja/new")
    public String ninjas(Model model, @ModelAttribute("ninja") Ninja ninja) {
    	List<Dojo> dojos = dojoService.mostrarDojo();
    	
    	List<String> dojoNames = new ArrayList<>();
    	for(int i=0; i<dojos.size(); i++) {
    		dojoNames.add(dojos.get(i).getName());
    	}
    	
    	//List<String> dojoNames = dojos.stream().map(dojo -> dojo.getName()).collect(Collectors.toList());
        model.addAttribute("dojos", dojoNames);
        
        return "crearNinja";
    }

    @PostMapping("/ninja/new")
    public String createNinja(@ModelAttribute("ninja") @Valid Ninja ninja, BindingResult result) {
    	System.out.println("ninja: " + ninja);
    	System.out.println("dojo: " + ninja.getDojo());
        if (!result.hasErrors()) {
            ninjaService.guardarNinja(ninja);
        }
        return "redirect:/ninja/new";
    }
    
    @GetMapping("/dojos/{id}")
    public String mostrarNinjas(@PathVariable("id") Long id, Model model) {
    	Dojo dojo = dojoService.buscarPorId(id);
        model.addAttribute("ninjas", dojo.getNinjas());
        return "mostrarNinjas";
    }

    

}
