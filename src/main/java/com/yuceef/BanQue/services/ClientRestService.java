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

import com.yuceef.BanQue.entities.Client;
import com.yuceef.BanQue.metier.ClientMetier;

@RestController
public class ClientRestService {
	@Autowired
	private ClientMetier clientMetier;
	
	@GetMapping(value="/api/clients")
	public List<Client> listClients() {
		return clientMetier.listClients();
	}
		
	@GetMapping(value="/api/clients/{codeClient}")
	public Client getClient(@PathVariable Long codeClient) {
		return  clientMetier.getClient(codeClient);
	}

	@PostMapping(value="/api/clients")
	public Client saveClient(@RequestBody @Valid Client c) {
		return clientMetier.saveClient(c);
	}	
	
	@PutMapping(value="/api/clients")
	public Client updateClient(@RequestBody @Valid Client c) {
		return clientMetier.saveClient(c);
	}
	
	@DeleteMapping(value="/api/clients/{codeClient}")
	public boolean deleteClient(@PathVariable Long codeClient) {
		clientMetier.deleteClient(codeClient);
		return true;
	}
	
}
