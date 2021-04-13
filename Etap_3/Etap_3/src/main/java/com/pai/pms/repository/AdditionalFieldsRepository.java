package com.pai.pms.repository;

import com.pai.pms.model.AdditionalFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdditionalFieldsRepository extends JpaRepository<AdditionalFields,Integer> {
}
