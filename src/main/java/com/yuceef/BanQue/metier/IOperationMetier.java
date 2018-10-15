package com.yuceef.BanQue.metier;

public interface IOperationMetier {
	public boolean verser(String code,double montant,Long codeEmpl);
	public boolean retirer(String code,double montant,Long codeEmpl);
	public boolean virement(String code1,String code2,double montant,Long codeEmpl);
	public PageOperation getOperations(String codeCompte,int page,int size);
}
