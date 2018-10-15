package com.yuceef.BanQue.metier;

import java.util.List;

import com.yuceef.BanQue.entities.Groupe;

public interface IGroupeMetier {
	public Groupe saveGroupe(Groupe g);
	public Groupe getGroupe(Long code);
	public void deleteGroupe(Long code);
	public List<Groupe> listGroupes(); 
}
