
package com.yuceef.BanQue.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuceef.BanQue.entities.Employe;
import com.yuceef.BanQue.metier.EmployeMetier;

@RestController
public class EmployeRestService {
	@Autowired
	private EmployeMetier employeMetier;

	@PostMapping(value="/api/employes")
	public Employe saveEmploye(@RequestBody @Valid Employe employe) {
		return employeMetier.saveEmploye(employe);
	}	
	@PutMapping(value="/api/employes")
	public Employe updateEmploye(@RequestBody @Valid Employe employe) {
		return employeMetier.saveEmploye(employe);
	}
	@DeleteMapping(value="/api/employes/{codeEmploye}")
	public boolean deleteEmploye(@PathVariable Long codeEmploye) {
		employeMetier.deleteEmploye(codeEmploye);
		return true;
	}
	@GetMapping(value="/api/employes/{codeEmploye}")
	public Employe getEmploye(@PathVariable Long codeEmploye) {
		return employeMetier.getEmploye(codeEmploye);
	}
	@GetMapping(value="/api/employes")
	public List<Employe> listEmployes() {
		return employeMetier.listEmployes();
	}
	
	
}
