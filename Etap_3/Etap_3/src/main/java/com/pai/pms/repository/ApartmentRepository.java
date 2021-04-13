package com.pai.pms.repository;

import com.pai.pms.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ApartmentRepository  extends JpaRepository<Apartment,Integer> {
}
