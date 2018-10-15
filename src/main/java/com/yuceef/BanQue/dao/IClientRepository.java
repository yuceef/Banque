package com.yuceef.BanQue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuceef.BanQue.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {

}
