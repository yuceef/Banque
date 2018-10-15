package com.yuceef.BanQue.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("CC")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class CompteCourant extends Compte {
	private double decouvert;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompteCourant(double decouvert) {
		super();
		this.decouvert = decouvert;
	}
	public CompteCourant(String codeCompte, double solde, double decouvert) {
		super(codeCompte, solde);
		this.decouvert = decouvert;
	}
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	
}
