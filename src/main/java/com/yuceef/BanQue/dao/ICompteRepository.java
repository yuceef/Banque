package com.yuceef.BanQue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuceef.BanQue.entities.Compte;

public interface ICompteRepository extends JpaRepository<Compte, String> {

}
