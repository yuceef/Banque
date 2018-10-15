package com.yuceef.BanQue.metier;

import java.util.List;

import com.yuceef.BanQue.entities.Client;

public interface IClientMetier {
	public Client saveClient(Client c);
	public Client getClient(Long code);
	public void deleteClient(Long code);
	public List<Client> listClients();
}
