package com.pai.pms.repository;

import com.pai.pms.model.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LandlordRepository  extends JpaRepository<Landlord,Integer> {
}
