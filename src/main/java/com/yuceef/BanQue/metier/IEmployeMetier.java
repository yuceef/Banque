package com.yuceef.BanQue.metier;

import java.util.List;

import com.yuceef.BanQue.entities.Employe;

public interface IEmployeMetier {
	public Employe saveEmploye(Employe e);
	public Employe getEmploye(Long code);
	public void deleteEmploye(Long code);
	public List<Employe> listEmployes();
}
