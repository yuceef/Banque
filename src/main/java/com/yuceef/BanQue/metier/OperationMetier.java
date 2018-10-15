package com.yuceef.BanQue.metier;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuceef.BanQue.dao.ICompteRepository;
import com.yuceef.BanQue.dao.IEmployeRepository;
import com.yuceef.BanQue.dao.IOperationRepository;
import com.yuceef.BanQue.entities.Compte;
import com.yuceef.BanQue.entities.Employe;
import com.yuceef.BanQue.entities.Operation;
import com.yuceef.BanQue.entities.Retrait;
import com.yuceef.BanQue.entities.Versment;

@Service
@Transactional
public class OperationMetier implements IOperationMetier {
	@Autowired
	private IOperationRepository operationRepository;
	@Autowired
	private ICompteRepository compteRepository;	
	@Autowired
	private IEmployeRepository employeRepository;
	
	@Override
	public boolean verser(String code, double montant, Long codeEmpl) {
		// TODO Auto-generated method stub
		Compte compte = compteRepository.getOne(code);
		Employe employe = employeRepository.getOne(codeEmpl);
		Operation versement = new Versment();
		versement.setCompte(compte);
		versement.setEmploye(employe);
		versement.setMontant(montant);
		versement.setDateOperation(new Date());
		operationRepository.save(versement);
		compte.setSolde(compte.getSolde()+montant);
		return true;
	}

	@Override
	public boolean retirer(String code, double montant, Long codeEmpl) {
		// TODO Auto-generated method stub
		Compte compte = compteRepository.getOne(code);
		if(compte.getSolde()<montant) throw new RuntimeException("Solde insuffisant");
		Employe employe = employeRepository.getOne(codeEmpl);
		Operation retrait = new Retrait();
		retrait.setCompte(compte);
		retrait.setEmploye(employe);
		retrait.setMontant(montant);
		retrait.setDateOperation(new Date());
		operationRepository.save(retrait);
		compte.setSolde(compte.getSolde()-montant);
		return true;
	}

	@Override
	public boolean virement(String code1, String code2, double montant, Long codeEmpl) {
		// TODO Auto-generated method stub
		retirer(code1,montant,codeEmpl);
		verser(code2,montant,codeEmpl);
		return true;
	}

	@Override
	public PageOperation getOperations(String codeCompte, int page, int size) {
		// TODO Auto-generated method stub
		PageOperation pageOperation = new PageOperation();
		Page<Operation> ops = operationRepository.getOperations(codeCompte,new PageRequest(page, size));
		pageOperation.setOperations(ops.getContent());
		pageOperation.setSizePage(ops.getSize());
		pageOperation.setNumberPage(ops.getNumber());
		pageOperation.setTotalOperations((int)ops.getTotalElements());
		pageOperation.setTotalPages(ops.getTotalPages());
		return pageOperation;
	}
}
