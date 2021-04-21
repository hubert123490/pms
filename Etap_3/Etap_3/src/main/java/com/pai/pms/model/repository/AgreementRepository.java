package com.pai.pms.model.repository;

import com.pai.pms.model.entities.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgreementRepository  extends JpaRepository<Agreement,Integer> {
}
