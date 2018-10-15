package com.yuceef.BanQue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuceef.BanQue.entities.Compte;
import com.yuceef.BanQue.metier.CompteMetier;

@RestController
public class CompteRestService {
	@Autowired
	private CompteMetier compteMetier;

	@PostMapping(value="/api/comptes")
	public Compte saveCompte(@RequestBody Compte c) {
		return compteMetier.saveCompte(c);
	}
	
	@GetMapping(value="/api/comptes/{code}")
	public Compte getCompte(@PathVariable String code) {
		System.out.println(123);
		return compteMetier.getCompte(code);
	}	
	
	@PutMapping(value="/api/comptes/{code}")
	public Compte updateCompte(@RequestBody Compte c) {
		return compteMetier.saveCompte(c);
	}

	@DeleteMapping(value="/api/comptes/{code}")
	public void deleteCompte(@PathVariable String code) {
		compteMetier.deleteCompte(code);
	}

	@GetMapping(value="/api/comptes")
	public List<Compte> listComptes() {
		return compteMetier.listComptes();
	}
	
}
