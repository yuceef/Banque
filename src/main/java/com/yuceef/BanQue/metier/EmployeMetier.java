package com.yuceef.BanQue.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuceef.BanQue.dao.IEmployeRepository;
import com.yuceef.BanQue.entities.Employe;

@Service
public class EmployeMetier implements IEmployeMetier {
	
	@Autowired
	private IEmployeRepository EmployeRepository;
	
	@Override
	public Employe saveEmploye(Employe e) {
		// TODO Auto-generated method stub
		return EmployeRepository.save(e);
	}

	@Override
	public List<Employe> listEmployes() {
		// TODO Auto-generated method stub
		return EmployeRepository.findAll();
	}

	@Override
	public Employe getEmploye(Long code) {
		// TODO Auto-generated method stub
		return EmployeRepository.getOne(code);
	}

	@Override
	public void deleteEmploye(Long code) {
		// TODO Auto-generated method stub
		EmployeRepository.deleteById(code);
	}

}
