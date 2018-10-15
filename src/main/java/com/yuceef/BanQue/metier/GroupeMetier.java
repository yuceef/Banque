package com.yuceef.BanQue.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuceef.BanQue.dao.IGroupeRepository;
import com.yuceef.BanQue.entities.Groupe;

@Service
public class GroupeMetier implements IGroupeMetier {
	
	@Autowired
	private IGroupeRepository groupeRepository;
	
	@Override
	public Groupe saveGroupe(Groupe g) {
		// TODO Auto-generated method stub
		return groupeRepository.save(g);
	}

	@Override
	public List<Groupe> listGroupes() {
		// TODO Auto-generated method stub
		return groupeRepository.findAll();
	}

	@Override
	public Groupe getGroupe(Long code) {
		// TODO Auto-generated method stub
		return groupeRepository.getOne(code);
	}

	@Override
	public void deleteGroupe(Long code) {
		// TODO Auto-generated method stub
		groupeRepository.deleteById(code);
	}

}
