package com.yuceef.BanQue.entities;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("CE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CompteEpargne extends Compte {
	private double taux;

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(String codeCompte, double solde) {
		super(codeCompte, solde);
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(String codeCompte, double solde, double taux) {
		super(codeCompte, solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	

}
