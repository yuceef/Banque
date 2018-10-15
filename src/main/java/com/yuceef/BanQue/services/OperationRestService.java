package com.yuceef.BanQue.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuceef.BanQue.metier.OperationMetier;
import com.yuceef.BanQue.metier.PageOperation;

@RestController
public class OperationRestService {
	@Autowired
	private OperationMetier operationMetier;
	
	@GetMapping(value="/api/getOperation")
	public PageOperation getOperations(@RequestParam String codeCompte, @RequestParam int page, @RequestParam int size) {
		return operationMetier.getOperations(codeCompte, page, size);
	}

	@PutMapping(value="/api/versement")
	public boolean verser(@RequestParam String code, @RequestParam double montant, @RequestParam Long codeEmpl) {
		return operationMetier.verser(code, montant, codeEmpl);
	}

	@PutMapping(value="/api/retrait")
	public boolean retirer(@RequestParam String code, @RequestParam double montant, @RequestParam Long codeEmpl) {
		return operationMetier.retirer(code, montant, codeEmpl);
	}

	@PutMapping(value="/api/virement")
	public boolean virement(@RequestParam String code1, @RequestParam String code2, @RequestParam double montant, @RequestParam Long codeEmpl) {
		return operationMetier.virement(code1, code2, montant, codeEmpl);
	}
	
}
