package com.pai.pms.model.repository;

import com.pai.pms.model.entities.AdditionalField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalFieldsRepository extends JpaRepository<AdditionalField,Integer> {
}
