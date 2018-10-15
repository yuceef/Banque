package com.yuceef.BanQue.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Inheritance
@DiscriminatorColumn(name="type_operation",discriminatorType=DiscriminatorType.STRING, length=1)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type_operation")
@JsonSubTypes({
	@Type(name="V",value=Versment.class),
	@Type(name="R",value=Retrait.class)
})
public class Operation implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numOperation;
	
	private Date dateOperation;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="codeCompte")
	private Compte compte;
	
	@ManyToOne
	@JoinColumn(name="codeEmplye")
	private Employe employe;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date dateOperation, double montant) {
		super();
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	public Date getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	@JsonIgnore
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Long getNumOperation() {
		return numOperation;
	}
	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}
	
}
