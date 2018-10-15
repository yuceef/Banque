package com.yuceef.BanQue.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employe implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmploye;
	private String nomEmploye;
	
	@OneToMany(mappedBy="employe")
	private Collection<Operation> operations;
	
	@OneToMany(mappedBy="employe")
	private Collection<Compte> comptes;
	
	@ManyToMany
	@JoinTable(name="employe_groupe")
	private Collection<Groupe> groupes;

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	@JsonIgnore
	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	@JsonIgnore
	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	@JsonIgnore
	public Collection<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroups(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Long getCodeEmploye() {
		return codeEmploye;
	}

	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}

}
