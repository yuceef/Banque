package com.yuceef.BanQue.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Inheritance
@DiscriminatorColumn(name="type_compte",discriminatorType=DiscriminatorType.STRING, length=2)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include=JsonTypeInfo.As.PROPERTY,property="type_compte")
@JsonSubTypes({
	@Type(name="CC",value=CompteCourant.class),
	@Type(name="CE",value=CompteEpargne.class)
})
public abstract class Compte implements Serializable {
	@Id
	private String codeCompte;
	private Date dateCreation;
	
	private double solde;
	
	@ManyToOne
	@JoinColumn(name="codeClient")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="codeEmplye")
	private Employe employe;
	
	@OneToMany(mappedBy="compte")
	private Collection<Operation> operations;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Compte(String codeCompte, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.solde = solde;
	}
	
	public String getCodeCompte() {
		return codeCompte;
	}
	
	public void setCodeCompte(String codeCompte) {
		this.codeCompte = codeCompte;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public double getSolde() {
		return solde;
	}
	
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Employe getEmploye() {
		return employe;
	}
	
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	@JsonIgnore
	public Collection<Operation> getOperations() {
		return operations;
	}
	
	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}
	
}
