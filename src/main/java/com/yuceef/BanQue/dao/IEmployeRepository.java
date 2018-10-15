package com.yuceef.BanQue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuceef.BanQue.entities.Employe;

public interface IEmployeRepository extends JpaRepository<Employe, Long> {

}
