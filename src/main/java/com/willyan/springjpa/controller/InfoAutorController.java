package com.willyan.springjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.willyan.springjpa.entity.InfoAutor;
import com.willyan.springjpa.service.InfoAutorService;

@RestController
@RequestMapping("/info")
public class InfoAutorController {
	
	@Autowired
	private InfoAutorService service;
	
	@GetMapping("{id}")
	public InfoAutor getById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping("cargo/{cargo}")
	public List<InfoAutor> getByContainsCargo(@PathVariable String cargo) {
		return service.findAllContainsCargo(cargo);
	}
	
	@GetMapping("cargo/{cargo}/empresa/{empresa}")
	public List<InfoAutor> getByContainsCargoAndEmpresa(@PathVariable String cargo, 
			@PathVariable String empresa) {
		return service.findAllCargoAndEmpresa(cargo, empresa);
	}
	
	@GetMapping("bio/{bio}")
	public InfoAutor getFromBio(@PathVariable String bio) {
		return service.findFromBio(bio);
	}
}
