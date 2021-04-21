package com.pai.pms.model.repository;

import com.pai.pms.model.entities.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LandlordRepository  extends JpaRepository<Landlord,Integer> {
}
