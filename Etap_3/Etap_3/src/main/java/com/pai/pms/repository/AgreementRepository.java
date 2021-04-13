package com.pai.pms.repository;

import com.pai.pms.model.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AgreementRepository  extends JpaRepository<Agreement,Integer> {
}
