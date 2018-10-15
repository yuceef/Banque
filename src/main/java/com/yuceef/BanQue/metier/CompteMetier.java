package com.yuceef.BanQue.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuceef.BanQue.dao.ICompteRepository;
import com.yuceef.BanQue.entities.Compte;
@Service
public class CompteMetier implements ICompteMetier{
	@Autowired
	private ICompteRepository compteRepository;
	@Override
	public Compte saveCompte(Compte c) {
		// TODO Auto-generated method stub
		c.setDateCreation(new Date());
		return compteRepository.save(c);
	}

	@Override
	public Compte getCompte(String code) {
		// TODO Auto-generated method stub
		return compteRepository.getOne(code);
	}

	@Override
	public void deleteCompte(String code) {
		compteRepository.deleteById(code);
	}

	@Override
	public List<Compte> listComptes() {
		// TODO Auto-generated method stub
		return compteRepository.findAll();
	}

}
