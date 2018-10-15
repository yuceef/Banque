package com.yuceef.BanQue.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuceef.BanQue.dao.IClientRepository;
import com.yuceef.BanQue.entities.Client;

@Service
public class ClientMetier implements IClientMetier {
	
	@Autowired
	private IClientRepository clientRepository;
	
	@Override
	public Client saveClient(Client c) {
		// TODO Auto-generated method stub
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client getClient(Long code) {
		// TODO Auto-generated method stub
		return clientRepository.getOne(code);
	}

	@Override
	public void deleteClient(Long code) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(code);
	}

}
