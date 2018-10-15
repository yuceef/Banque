package com.yuceef.BanQue.metier;

import java.util.List;

import com.yuceef.BanQue.entities.Compte;

public interface ICompteMetier {
	public Compte saveCompte(Compte c);
	public Compte getCompte(String code);
	public void deleteCompte(String code);
	public List<Compte> listComptes();
}
