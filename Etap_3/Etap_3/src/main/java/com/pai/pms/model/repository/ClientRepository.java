package com.pai.pms.model.repository;

import com.pai.pms.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository  extends JpaRepository<Client,Integer> {
}
