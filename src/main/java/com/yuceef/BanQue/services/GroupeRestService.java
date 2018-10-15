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

import com.yuceef.BanQue.entities.Groupe;
import com.yuceef.BanQue.metier.GroupeMetier;

@RestController
public class GroupeRestService {
	@Autowired
	private GroupeMetier compteMetier;

	@PostMapping(value="/api/groupes")
	public Groupe saveGroupe(@RequestBody Groupe g) {
		return compteMetier.saveGroupe(g);
	}
	
	@GetMapping(value="/api/groupes/{code}")
	public Groupe getGroupe(@PathVariable Long code) {
		return compteMetier.getGroupe(code);
	}	
	
	@PutMapping(value="/api/groupes/{code}")
	public Groupe updateGroupe(@RequestBody Groupe g) {
		return compteMetier.saveGroupe(g);
	}

	@DeleteMapping(value="/api/groupes/{code}")
	public void deleteGroupe(@PathVariable Long code) {
		compteMetier.deleteGroupe(code);
	}

	@GetMapping(value="/api/groupes")
	public List<Groupe> listGroupes() {
		return compteMetier.listGroupes();
	}
	
}
